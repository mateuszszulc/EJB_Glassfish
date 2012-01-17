create table BIDDERS
(username varchar2(10) primary key,
first_name varchar2(30),
credit_card_type varchar2(20))
/

create table BIDS(
BID_ID                                    NUMBER(19) primary key,
BID_DATE                                           DATE,
BID_STATUS                                         VARCHAR2(20),
BID_PRICE                                          NUMBER(19,4),
BID_ITEM_ID                                        NUMBER(19),
BID_BIDDER                                         VARCHAR2(45))
/
