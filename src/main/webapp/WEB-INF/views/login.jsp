<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- saved from url=(0041)http://testylivecounter.com/Account/Login -->
<html lang="en-us" id="extr-page"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

    <title>Log in - Testy Taste of Tradition</title>
    <meta name="description" content="">
    <meta name="author" content="">

    

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Basic Styles -->
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="resources/testy-login/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="resources/testy-login/font-awesome.min.css"/>">
    <!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="resources/testy-login/smartadmin-production.min.css"/>">
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="resources/testy-login/smartadmin-skins.min.css"/>">
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="resources/testy-login/Site.css"/>">

    <!-- SmartAdmin RTL Support is under construction
        <link rel="stylesheet" type="text/css" media="screen" href="~/Content/Template/css/smartadmin-rtl.css"> -->
    <!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp
    <link rel="stylesheet" type="text/css" media="screen" href="~/Content/Template/css/demo.css"> -->



    <!-- GOOGLE FONT -->
    <link rel="stylesheet" href="<c:url value="resources/testy-login/css"/>">
    
  
    <!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

<style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;padding: 5px;border: 1px solid white;z-index: 10000;}.jqsfield { color: white;font: 10px arial, san serif;text-align: left;}</style></head>
<body id="login" class="animated fadeInDown desktop-detected" style="background-image: url(<c:url value="resources/testy-login/logbg.jpg"/>); min-height: 577px;">
    <!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
    <header id="header">
        <!--<span id="logo"></span>-->

        <div id="logo-group">
            <span id="logo" style="margin-top: 5px;width:100%;">
                <a href="http://testylivecounter.com/">
                    <img src="<c:url value="resources/testy-login/new_logo.png"/>" alt=""></a>
                 
                                                   </span>
        </div>

        <span id="extr-page-header-space">  </span>

    </header>

    <div id="main" role="main">

        <!-- MAIN CONTENT -->
        <div id="content" class="container">

            
<div class="row" id="lobinbg">
    <div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
        
        <h1 class="txt-color-red login-header-big"></h1>
        <div class="hero">
            <div class="pull-left login-desc-box-l">

            </div>
        </div>



    </div>
    <div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
        <div class="well no-padding">
        <c:url var="loginUrl" value="/login" />
<form action="${loginUrl}" class="smart-form client-form" method="post" role="form" novalidate="novalidate">
				<input name="__RequestVerificationToken" type="hidden" value="Q_HcmI7X1r_dL5yhNk3hlKSyvSY36ea_c07HTy1s48fZxifm8OMPhe-d34Wl_d5i1HvxGH60VO6v4gOptsajPH3eDoeJLUoWGmZovjpyyJ41">                <header>
                    <i class="fa fa-lock">&nbsp;</i>Sign In
                </header>
                <fieldset>
                    <section style="color: red;">
                    	<c:if test="${param.error != null}">
				            <p>Invalid username and password.</p>
            			</c:if>
                    </section>
                    <section>
                        <label class="label" for="Email">Username</label>
                        <label class="input">
                            <i class="icon-append fa fa-user"></i>
                            <input data-val="true" data-val-required="The Username field is required." id="Email" name="username" type="text" value="">
                            <b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> Please enter email address/username</b>
                        </label>
                        <span class="field-validation-valid text-danger" data-valmsg-for="Email" data-valmsg-replace="true"></span>
                    </section>

                    <section>
                        <label class="label" for="Password">Password</label>
                        <label class="input">
                            <i class="icon-append fa fa-lock"></i>
                            <input data-val="true" data-val-required="The Password field is required." id="Password" name="password" type="password">
                            <b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> Enter your password</b>
                        </label>
                        <span class="field-validation-valid text-danger" data-valmsg-for="Password" data-valmsg-replace="true"></span>
                        
                    </section>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  />                    
                </fieldset>
                <footer>
                    <button type="submit" class="btn btn-primary">
                        <i class="fa fa-sign-in">&nbsp;</i>
                        Sign in
                    </button>
                </footer>
</form>
        </div>

    </div>
</div>

        </div>
    </div>

    <!--================================================== -->
    <!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
    <!--<script src="~/Scripts/plugin/pace/pace.min.js"></script>-->
    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
    
    <script src="<c:url value="resources/testy-login/jquery-1.11.1.min.js.download"/>"></script>
    

    <script src="<c:url value="resources/testy-login/jquery-ui-1.10.4.min.js.download"/>"></script>
    

    <!-- JS TOUCH : include this plugin for mobile drag / drop touch events
    <script src="~/Scripts/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->
    <!-- BOOTSTRAP JS -->
    <script src="<c:url value="resources/testy-login/bootstrap.min.js.download"/>"></script>

    <!-- CUSTOM NOTIFICATION -->
    <script src="<c:url value="resources/testy-login/SmartNotification.min.js.download"/>"></script>

    <!-- JARVIS WIDGETS -->
    <script src="<c:url value="resources/testy-login/jarvis.widget.min.js.download"/>"></script>

    <!-- EASY PIE CHARTS -->
    <script src="<c:url value="resources/testy-login/jquery.easy-pie-chart.min.js.download"/>"></script>

    <!-- SPARKLINES -->
    <script src="<c:url value="resources/testy-login/jquery.sparkline.min.js.download"/>"></script>

    <!-- JQUERY VALIDATE -->
    <script src="<c:url value="resources/testy-login/jquery.validate.min.js.download"/>"></script>

    <!-- JQUERY MASKED INPUT -->
    <script src="<c:url value="resources/testy-login/jquery.maskedinput.min.js.download"/>"></script>

    <!-- JQUERY SELECT2 INPUT -->
    <script src="<c:url value="resources/testy-login/select2.min.js.download"/>"></script>

    <!-- JQUERY UI + Bootstrap Slider -->
    <script src="<c:url value="resources/testy-login/bootstrap-slider.min.js.download"/>"></script>

    <!-- browser msie issue fix -->
    <script src="<c:url value="resources/testy-login/jquery.mb.browser.min.js.download"/>"></script>

    <!-- FastClick: For mobile devices -->
    <script src="<c:url value="resources/testy-login/fastclick.min.js.download"/>"></script>
    
    <script src="<c:url value="resources/testy-login/jquery.validate.js.download"/>"></script>
    <script src="<c:url value="resources/testy-login/jquery.validate.unobtrusive.js.download"/>"></script>


    <!--[if IE 7]>

        <h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

    <![endif]-->
    <!-- MAIN APP JS FILE -->
    <script src="<c:url value="resources/testy-login/app.js.download"/>"></script>

    

    <script type="text/javascript">

        $.validator.setDefaults({
            highlight: function (element) {
                $(element).closest(".input").addClass("state-error");
                $(element).closest(".input").removeClass("state-success");
                $(element).addClass("invalid");
                $(element).removeClass("valid");
            },
            unhighlight: function (element) {
                $(element).closest(".input").removeClass("state-error");
                $(element).closest(".input").addClass("state-success");
                $(element).removeClass("invalid");
                $(element).addClass("valid");
            }
        });

    </script>
    <script type="text/javascript">
        runAllForms();

        $(function() {
            // Validation
            $("#login-form").validate({
                // Rules for form validation
                rules: {
                    email: {
                        required: true,
                        email: true
                    },
                    password: {
                        required: true,
                        minlength: 3,
                        maxlength: 20
                    }
                },

                // Messages for form validation
                messages: {
                    email: {
                        required: 'Please enter your email address',
                        email: 'Please enter a VALID email address'
                    },
                    password: {
                        required: 'Please enter your password'
                    }
                },

                // Do not change code below
                errorPlacement: function(error, element) {
                    error.insertAfter(element.parent());
                }
            });
        });
    </script>



<div id="divSmallBoxes"></div><div id="divMiniIcons"></div><div id="divbigBoxes"></div></body></html>