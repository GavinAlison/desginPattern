/** 登录 */
/** drop and create table */
drop table V_LOGIN cascade constraints;
create table V_LOGIN (
	--表个性化字段：
	LOGIN_ID NUMBER NOT NULL,
	PASSWORD VARCHAR2(32),
	USER_NAME VARCHAR2(32),
	USER_TAPE VARCHAR2(1024),
	user_id VARCHAR2(1024),
	constraint PK_VLOGIN primary key (user_id)
);
alter table v_login add constraint unique_login_id unique (login_id);
/** create sequence */
drop sequence SEQ_VLOGIN;
create sequence SEQ_VLOGIN
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

