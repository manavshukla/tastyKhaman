package com.aone.config.security.util;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aone.commons.utils.PropertyUtil;
import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.config.security.annotation.SecurityMethodRole;
import com.aone.config.security.constant.RoleMatcher;
import com.aone.corelibrary.controller.IBaseMasterController;

@Component
public class SecurityUtil {
	
	

	public static void setSecurityRolesPathWise(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry) {
		// System.out.println(findAllMatchingTypes(AbstractBaseMasterRestController.class));
		Reflections reflections = new Reflections("com.aone.module");
		Set<Class<? extends IBaseMasterController>> classes = reflections.getSubTypesOf(IBaseMasterController.class);
		System.out.println("-----------------------------------------------");
		System.out.println(classes);
		for (Class<? extends IBaseMasterController> baseController : classes) {
			if (baseController.isAnnotationPresent(RequestMapping.class) && baseController.isAnnotationPresent(SecurityClassRole.class)) {
				RequestMapping classLevelRequestMapping = (RequestMapping) baseController.getAnnotation(RequestMapping.class);
				if(classLevelRequestMapping == null) {
					continue;
				}
				
				SecurityClassRole securityClassRole = (SecurityClassRole) baseController.getAnnotation(SecurityClassRole.class);
				if(securityClassRole == null) {
					continue;
				}

				//final List<Method> baseControllerMethods = Arrays.asList(baseController.getDeclaredMethods());
				final Set<Method> allMethods = getAllMethods(baseController);
				
				System.out.println("allMethods => " + allMethods);
				
				for (final Method method : allMethods) {
					if (method.isAnnotationPresent(RequestMapping.class)) {
						
						RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
						if (requestMapping == null) {
							continue;
						}
						
						String[] methodPathsArray = requestMapping.value();
						if(methodPathsArray == null) {
							continue;
						}

						SecurityMethodRole securityMethodRole = method.getAnnotation(SecurityMethodRole.class);
						if(securityMethodRole == null) {
							continue;
						}
						
						String roleExprData = null;
						RoleMatcher roleMatcher = securityMethodRole.roleMatcher();
						if(RoleMatcher.ALL == roleMatcher || RoleMatcher.ANY == roleMatcher) {
							StringBuilder roleExpression = new StringBuilder();
							String[] roleList = securityMethodRole.roleList();
							for (String role : roleList) {
								roleExpression.append("hasRole('" + securityClassRole.baseRoleName() + role +"')");
								roleExpression.append(" " + roleMatcher.getValue()+ " ");
							}
							int lastIndexOfRoleMatcher = roleExpression.lastIndexOf(roleMatcher.getValue());
							roleExpression = roleExpression.replace(lastIndexOfRoleMatcher, lastIndexOfRoleMatcher + roleMatcher.getValue().length(), "");
							roleExprData = roleExpression.toString();
						}
						
						if(RoleMatcher.CUSTOM == roleMatcher) {
							roleExprData = securityMethodRole.customRoleExpr();
						}
						
						String[] classLevelPathsArray = classLevelRequestMapping.value();
						for(String classLevelPaths :  classLevelPathsArray) {
							for (String methodPath : methodPathsArray) {
								System.out.println("==============================================");
								System.out.println("Adding mapping for follwing path and role");
								System.out.println("full path => " + classLevelPaths + methodPath);
								System.out.println("full role expression=> " + roleExprData);
								if(PropertyUtil.checkProdEnv()) {
									expressionInterceptUrlRegistry.antMatchers(classLevelPaths + methodPath).access(roleExprData);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static Set<Method> getAllMethods(Class<? extends IBaseMasterController> clazz) {
	    Set<Method> methods=new LinkedHashSet<>();
	    Collections.addAll(methods, clazz.getMethods());
	    Map<Object,Set<Package>> types=new HashMap<>();
	    final Set<Package> pkgIndependent = Collections.emptySet();
	    for(Method m: methods) types.put(methodKey(m), pkgIndependent);
	    for(Class<?> current=clazz; current!=null; current=current.getSuperclass()) {
	        for(Method m: current.getDeclaredMethods()) {
	            final int mod = m.getModifiers(),
	                access=Modifier.PUBLIC|Modifier.PROTECTED|Modifier.PRIVATE;
	            if(!Modifier.isStatic(mod)) switch(mod&access) {
	                case Modifier.PUBLIC: continue;
	                default:
	                    Set<Package> pkg=
	                        types.computeIfAbsent(methodKey(m), key -> new HashSet<>());
	                    if(pkg!=pkgIndependent && pkg.add(current.getPackage())) break;
	                    else continue;
	                case Modifier.PROTECTED:
	                    //if(types.putIfAbsent(methodKey(m), pkgIndependent)!=null) continue;
	                    // otherwise fall-through
	                case Modifier.PRIVATE:
	            }
	            methods.add(m);
	        }
	    }
	    return methods;
	}

	private static Object methodKey(Method m) {
	    return Arrays.asList(m.getName(),
	        MethodType.methodType(m.getReturnType(), m.getParameterTypes()));
	}
	
	public static void main(String[] args) {
		setSecurityRolesPathWise(null);
	}
	
	

}
