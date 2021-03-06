
DROP TABLE CATEGORIES CASCADE CONSTRAINTS
/
DROP TABLE BILLING_DETAILS CASCADE CONSTRAINTS
/
DROP TABLE USERS CASCADE CONSTRAINTS
/
DROP TABLE CONTACT_DETAILS CASCADE CONSTRAINTS
/
DROP TABLE ITEMS CASCADE CONSTRAINTS
/
DROP TABLE CATEGORIES_ITEMS CASCADE CONSTRAINTS
/
DROP TABLE BIDS
/
DROP TABLE SEQUENCE
/
DROP TABLE ORDERS
/
DROP TABLE SHIPPING_INFO
/
CREATE TABLE BILLING_DETAILS (
BILLING_ID NUMBER(19) NOT NULL,
 ACCOUNT_NO VARCHAR2(20) NULL, 
 CARD_TYPE VARCHAR2(10) NULL, 
SECRET_CODE VARCHAR2(5) NULL, 
EXPIRY_DATE VARCHAR2(4) NULL, 
STREETNAME1 VARCHAR2(50) NULL, 
STREETNAME2 VARCHAR2(50) NULL, 
COUNTRY VARCHAR2(50) NULL, 
CITY VARCHAR2(50) NULL, 
STATE_CD VARCHAR2(10) NULL, 
ZIP_CD VARCHAR2(10) NULL, 
PRIMARY KEY (BILLING_ID))
/
CREATE TABLE CATEGORIES (
CATEGORY_ID NUMBER(19) NOT NULL, 
CATEGORY_NAME VARCHAR2(255) NULL, 
CREATE_DATE VARCHAR2(255) NULL, 
CREATED_BY VARCHAR2(255) NULL, 
PARENT_ID NUMBER(19) NULL, PRIMARY KEY (CATEGORY_ID))
/

CREATE TABLE USERS (
USER_ID VARCHAR2(40) NOT NULL, 
USER_TYPE VARCHAR2(10) NULL, 
BIRTH_DATE DATE NULL, 
FIRST_NAME VARCHAR2(255) NOT NULL, 
LAST_NAME VARCHAR2(255) NOT NULL, 
USER_BILLING_ID NUMBER(19) NULL, 
MAX_ITEMS NUMBER(19) NULL, 
COMM_RATE NUMBER(19,4) NULL, 
CREDIT_RATING NUMBER(19) NULL, 
BIDDER_STATUS VARCHAR2(10) NULL, 
PRIMARY KEY (USER_ID))
/     
CREATE TABLE CONTACT_DETAILS (
CONTACT_USER_ID VARCHAR2(40) NOT NULL, 
EMAIL VARCHAR2(255) NULL, 
PHONE VARCHAR2(10) NULL, 
STREETNAME1 VARCHAR2(255) NULL, 
STREETNAME2 VARCHAR2(255) NULL, 
COUNTRY VARCHAR2(255) NULL, 
CITY VARCHAR2(255) NULL, 
STATE_CODE VARCHAR2(255) NULL, 
ZIP_CODE VARCHAR2(255) NULL, 
PRIMARY KEY (CONTACT_USER_ID))
/
CREATE TABLE ITEMS (
ITEM_ID NUMBER(19) NOT NULL, 
INITIAL_PRICE NUMBER(19,4) NULL, 
ITEM_NAME VARCHAR2(255) NULL,
BID_START_DATE TIMESTAMP NULL, 
BID_END_DATE TIMESTAMP NULL, 
CREATED_DATE TIMESTAMP NULL, 
SELLER_ID VARCHAR2(40) NULL,
ORDER_ID NUMBER(10) NULL,
OPT_LOCK NUMBER(19),  
PRIMARY KEY (ITEM_ID))
/ 
CREATE TABLE BIDS (BID_ID NUMBER(19) NOT NULL, 
BID_PRICE NUMBER(19,4) NULL, 
BID_STATUS VARCHAR2(10) NULL, 
BID_DATE DATE NULL, 
BID_ITEM_ID NUMBER(19) NULL, 
BID_BIDDER VARCHAR2(40) NULL, 
PRIMARY KEY (BID_ID))
/
CREATE TABLE ORDERS(
ORDER_ID                                           NUMBER(10) PRIMARY KEY,
ORDER_STATUS                                       VARCHAR2(10),
ORDER_BIDDER_ID                                    VARCHAR2(20),
ORDER_SHIPPING_ID                                  NUMBER(10),
ORDER_BILLING_ID                                   NUMBER(10))
/
CREATE TABLE SHIPPING_INFO(
SHIPPING_ID                                        NUMBER(10) PRIMARY KEY,
STREET                                             VARCHAR2(30),
CITY                                               VARCHAR2(30),
STATE                                              VARCHAR2(30)
)
/
CREATE TABLE CATEGORIES_ITEMS (
CI_CATEGORY_ID NUMBER(19) NOT NULL, 
CI_ITEM_ID NUMBER(19) NOT NULL, 
PRIMARY KEY
(CI_CATEGORY_ID, CI_ITEM_ID))
/
CREATE TABLE SEQUENCE (
SEQ_NAME VARCHAR2(50) NOT NULL, 
SEQ_COUNT NUMBER(38) NULL, 
PRIMARY KEY (SEQ_NAME))
/
CREATE SEQUENCE BILLING_SEQUENCE START WITH 1 INCREMENT BY 1
/

CREATE SEQUENCE CATEGORY_SEQ START WITH 1 INCREMENT BY 1
/
INSERT INTO SEQUENCE VALUES ('ITEM_SEQ', 3)
/
INSERT INTO SEQUENCE VALUES ('SEQ_GEN', 1)
/
commit
/

insert into users values ('idiot','B',null, 'Serious', 'Bidder', null,null, null, 40, 'NEW')
/
insert into users values ('idiot2','B',null, 'Very', 'Serious', null,null, null, 40, 'NEW')
/
insert into users values ('junkseller','S',null, 'Junk', 'Seller', null,null, 10, 20, null)
/
insert into users values ('viper','S',null, 'Viper', 'Admin', null,null, null, null, null)
/

insert into categories values (1000, 'Junk Cars', sysdate, 'viper', null)
/
insert into categories values (1001, 'House Hold Junks', sysdate, 'viper', null)
/
insert into items values (1, 100.50, 'Vintage Car', sysdate, sysdate+10, sysdate, 'junkseller', null,1)
/
insert into items values (2, 200.50, 'Cars junked', sysdate, sysdate+10, sysdate, 'junkseller',null, 1)
/
insert into categories_items values (1000, 1)
/
insert into categories_items values (1000, 2)
/
commit
/