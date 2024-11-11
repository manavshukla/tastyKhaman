ALTER TABLE user_role ADD CONSTRAINT unique_user_role_name UNIQUE (`role`);

-- item
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_SAVE','ITEM','ITEM SAVE','ITEM SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_UPDATE','ITEM','ITEM UPDATE','ITEM UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_DELETE','ITEM','ITEM DELETE','ITEM DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_VIEW','ITEM','ITEM VIEW','ITEM VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_VIEW_DELETED','ITEM','ITEM VIEW DELETED','ITEM VIEW DELETED');

-- item category
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_CATEGORY_SAVE','ITEM_CATEGORY','ITEM CATEGORY SAVE','ITEM CATEGORY SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_CATEGORY_UPDATE','ITEM_CATEGORY','ITEM CATEGORY UPDATE','ITEM CATEGORY UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_CATEGORY_DELETE','ITEM_CATEGORY','ITEM CATEGORY DELETE','ITEM CATEGORY DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_CATEGORY_VIEW','ITEM_CATEGORY','ITEM CATEGORY VIEW','ITEM CATEGORY VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('ITEM_CATEGORY_VIEW_DELETED','ITEM_CATEGORY','ITEM CATEGORY VIEW DELETED','ITEM CATEGORY VIEW DELETED');


-- contact category 
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_CATEGORY_SAVE', 'CONTACT_CATEGORY','CONTACT CATEGORY SAVE','CONTACT CATEGORY SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_CATEGORY_UPDATE', 'CONTACT_CATEGORY','CONTACT CATEGORY UPDATE','CONTACT CATEGORY UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_CATEGORY_DELETE', 'CONTACT_CATEGORY','CONTACT CATEGORY DELETE','CONTACT CATEGORY DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_CATEGORY_VIEW', 'CONTACT_CATEGORY','CONTACT CATEGORY VIEW','CONTACT CATEGORY VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_CATEGORY_VIEW_DELETED', 'CONTACT_CATEGORY','CONTACT CATEGORY VIEW DELETED','CONTACT CATEGORY VIEW DELETED');

-- contact
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_SAVE','CONTACT','CONTACT SAVE','CONTACT SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_UPDATE','CONTACT','CONTACT UPDATE','CONTACT UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_DELETE','CONTACT','CONTACT DELETE','CONTACT DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_VIEW','CONTACT','CONTACT VIEW','CONTACT VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('CONTACT_VIEW_DELETED','CONTACT','CONTACT VIEW DELETED','CONTACT VIEW DELETED');

-- users
INSERT INTO user_role(role, module_name, display_name, description) VALUES('USERS_SAVE','USERS','USERS SAVE','USERS SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('USERS_UPDATE','USERS','USERS UPDATE','USERS UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('USERS_DELETE','USERS','USERS DELETE','USERS DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('USERS_VIEW','USERS','USERS VIEW','USERS VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('USERS_VIEW_DELETED','USERS','USERS VIEW DELETED','USERS VIEW DELETED');


-- RAW MATERIAL
INSERT INTO user_role(role, module_name, display_name, description) VALUES('RAW_MATERIAL_SAVE','RAW MATERIAL','RAW MATERIAL SAVE','RAW MATERIAL SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('RAW_MATERIAL_UPDATE','RAW MATERIAL','RAW MATERIAL UPDATE','RAW MATERIAL UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('RAW_MATERIAL_DELETE','RAW MATERIAL','RAW MATERIAL DELETE','RAW MATERIAL DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('RAW_MATERIAL_VIEW','RAW MATERIAL','RAW MATERIAL VIEW','RAW MATERIAL VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('RAW_MATERIAL_VIEW_DELETED','RAW MATERIAL','RAW MATERIAL VIEW DELETED','RAW MATERIAL VIEW DELETED');


-- LIVEFOOD ORDERS
INSERT INTO user_role(role, module_name, display_name, description) VALUES('LIVEFOOD_ORDERS_SAVE','LIVEFOOD ORDERS','LIVEFOOD ORDERS SAVE','LIVEFOOD ORDERS SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('LIVEFOOD_ORDERS_UPDATE','LIVEFOOD ORDERS','LIVEFOOD ORDERS UPDATE','LIVEFOOD ORDERS UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('LIVEFOOD_ORDERS_DELETE','LIVEFOOD ORDERS','LIVEFOOD ORDERS DELETE','LIVEFOOD ORDERS DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('LIVEFOOD_ORDERS_VIEW','LIVEFOOD ORDERS','LIVEFOOD ORDERS VIEW','LIVEFOOD ORDERS VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('LIVEFOOD_ORDERS_VIEW_DELETED','LIVEFOOD ORDERS','LIVEFOOD ORDERS VIEW DELETED','LIVEFOOD ORDERS VIEW DELETED');


-- WHOLE SALE
INSERT INTO user_role(role, module_name, display_name, description) VALUES('WHOLE_SALE_COUNTER_SAVE','WHOLE SALE','WHOLE SALE SAVE','WHOLE SALE SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('WHOLE_SALE_COUNTER_UPDATE','WHOLE SALE','WHOLE SALE UPDATE','WHOLE SALE UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('WHOLE_SALE_COUNTER_DELETE','WHOLE SALE','WHOLE SALE DELETE','WHOLE SALE DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('WHOLE_SALE_COUNTER_VIEW','WHOLE SALE','WHOLE SALE VIEW','WHOLE SALE VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('WHOLE_SALE_COUNTER_VIEW_DELETED','WHOLE SALE','WHOLE SALE VIEW DELETED','WHOLE SALE VIEW DELETED');


-- DAILY LIVE COUNTER
INSERT INTO user_role(role, module_name, display_name, description) VALUES('DAILY_LIVE_COUNTER_SAVE','DAILY LIVE COUNTER','DAILY LIVE COUNTER SAVE','DAILY LIVE COUNTER SAVE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('DAILY_LIVE_COUNTER_UPDATE','DAILY LIVE COUNTER','DAILY LIVE COUNTER UPDATE','DAILY LIVE COUNTER UPDATE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('DAILY_LIVE_COUNTER_DELETE','DAILY LIVE COUNTER','DAILY LIVE COUNTER DELETE','DAILY LIVE COUNTER DELETE');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('DAILY_LIVE_COUNTER_VIEW','DAILY LIVE COUNTER','DAILY LIVE COUNTER VIEW','DAILY LIVE COUNTER VIEW');
INSERT INTO user_role(role, module_name, display_name, description) VALUES('DAILY_LIVE_COUNTER_VIEW_DELETED','DAILY LIVE COUNTER','DAILY LIVE COUNTER VIEW DELETED','DAILY LIVE COUNTER VIEW DELETED');


-- UPDATE USER ROLE TABLE
UPDATE user_role SET deleted = 0, IsActive = 1, createdby = 0, deletedby = 0, financialYear = 0, updatedBy = 0;
