/** 登录类 */
/** drop and create table */
drop table USERLOGIN cascade constraints;
create table USERLOGIN (
	ID                NUMBER not null, /** pk */
	VERSION           NUMBER not null,
	ORDERBY           VARCHAR2(1024),
	REMARK            VARCHAR2(1024),
	HISTORY           CLOB,
	AUTHOR_ID         NUMBER,
	AUTHOR_NAME       VARCHAR2(1024),
	AUTHOR_TIME       DATE,
	MODIFYER_ID       NUMBER,
	MODIFYER_NAME     VARCHAR2(1024),
	MODIFY_TIME       DATE,
	DATA_SCOPE_ID     NUMBER default 0,
	RECORD_STATUS     NUMBER default 0,
	DISPLAY           NUMBER default 0,
	EXTEND_1          VARCHAR2(1024),
	EXTEND_2          VARCHAR2(1024),
	SHEET_ACCESSORIES VARCHAR2(4000),

	--表个性化字段：
	USERID NUMBER NOT NULL,   /** unique key  */
	PASSWORD NUMBER(22,0),
	ROLE VARCHAR2(32),
	IS_DELETE VARCHAR2(32),
	constraint PK_USERLOGIN primary key (ID)
);

/** create sequence */
drop sequence SEQ_USERLOGIN;
create sequence SEQ_USERLOGIN
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

