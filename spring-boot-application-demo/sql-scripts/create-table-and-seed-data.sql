--Oracle SQL scripts

CREATE TABLE INTRODUCER_DTLS (
	SPID          	VARCHAR2(40) NOT NULL,
	PARTY_ID		VARCHAR2(40) NOT NULL,
	EFFECTIVE_DATE	DATE NOT NULL,
    EXPIRY_DATE     DATE NOT NULL,
    CREATED_BY      VARCHAR2(254),
    CREATION_DATE   TIMESTAMP(6),
    CONSTRAINT INTRODUCER_DTLS_PK PRIMARY KEY ( SPID )
)
/

----------------------------------------------------------------------------------------------------------------------------

CREATE TABLE INTRODUCER_ACTIVITY_DTLS (
    SUBMISSION_ID          			VARCHAR2(50) NOT NULL,
    INTRODUCER_ID            		VARCHAR2(50) NOT NULL,
    STATUS                   		VARCHAR2(50),
    WORKACTIVED_CREATED_DATE        TIMESTAMP(6),
	WORKACTIVE_SUBMITTED_DATE		TIMESTAMP(6),
	WORKACTIVITY_SUBMITTED_USER		VARCHAR2(50),
	REPAIR_TASK_CREATED_DATE        TIMESTAMP(6),
    REPAIR_TASK_SUBMITTED_DATE      TIMESTAMP(6),
	REPAIR_TASK_SUBMITTED_USER      VARCHAR2(50),
	VALIDITY_DATE                   TIMESTAMP(6),
	CREATED_BY                      VARCHAR2(254),
    CREATION_DATE                   TIMESTAMP(6),
    LAST_UPDATED_BY                 VARCHAR2(254),
    LAST_UPDATE_DATE                TIMESTAMP(6),
    CONSTRAINT INTRODUCER_ACTIVITY_DTLS_PK PRIMARY KEY ( SUBMISSION_ID )
)
/

----------------------------------------------------------------------------------------------------------------------------

INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('145707','900048104',TO_DATE('08-08-23','DD-MM-RR'),TO_DATE('05-07-24','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('11-09-24 7:10:22.721000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('I8203411','200001076',TO_DATE('16-03-24','DD-MM-RR'),TO_DATE('16-03-25','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('13-11-24 2:29:42.422309000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('I8408211','000014688',TO_DATE('06-11-23','DD-MM-RR'),TO_DATE('09-10-24','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('09-10-24 5:30:16.794422000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('151380','900048158',TO_DATE('06-11-23','DD-MM-RR'),TO_DATE('09-10-24','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('09-10-24 5:31:54.492262000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('131833','900048265',TO_DATE('11-08-23','DD-MM-RR'),TO_DATE('12-08-24','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('11-08-23 1:10:22.721000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('151382','900048160',TO_DATE('10-08-23','DD-MM-RR'),TO_DATE('14-08-24','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('10-08-23 1:10:22.721000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('I8203408','200001074',TO_DATE('05-12-24','DD-MM-RR'),TO_DATE('05-12-25','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('06-12-24 3:04:45.753000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('I8408815','000014698',TO_DATE('05-12-24','DD-MM-RR'),TO_DATE('05-12-25','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('06-12-24 3:04:46.127000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('I8206468','900049783',TO_DATE('05-12-24','DD-MM-RR'),TO_DATE('05-12-25','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('06-12-24 4:55:24.115000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_DTLS (SPID,PARTY_ID,EFFECTIVE_DATE,EXPIRY_DATE,CREATED_BY,CREATION_DATE) VALUES ('153231','900049701',TO_DATE('06-11-23','DD-MM-RR'),TO_DATE('02-08-24','DD-MM-RR'),'adminuser1',TO_TIMESTAMP('09-10-24 5:28:27.203681000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/

----------------------------------------------------------------------------------------------------------------------------

INSERT INTO INTRODUCER_ACTIVITY_DTLS (SUBMISSION_ID,INTRODUCER_ID,STATUS,WORKACTIVED_CREATED_DATE,WORKACTIVE_SUBMITTED_DATE,WORKACTIVITY_SUBMITTED_USER,REPAIR_TASK_CREATED_DATE,REPAIR_TASK_SUBMITTED_DATE,REPAIR_TASK_SUBMITTED_USER,VALIDITY_DATE,CREATED_BY,CREATION_DATE,LAST_UPDATED_BY,LAST_UPDATE_DATE) VALUES ('SUB200620240085764','I8408211','DECLINED',TO_TIMESTAMP('10-10-24 3:51:43.639000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),TO_TIMESTAMP('10-10-24 3:52:32.886000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('10-10-24 3:52:32.886000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),TO_TIMESTAMP('10-10-24 3:53:16.000000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user8',TO_TIMESTAMP('09-10-24 5:30:09.000000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('10-10-24 3:51:43.640000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user8',TO_TIMESTAMP('10-10-24 3:53:16.897000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_ACTIVITY_DTLS (SUBMISSION_ID,INTRODUCER_ID,STATUS,WORKACTIVED_CREATED_DATE,WORKACTIVE_SUBMITTED_DATE,WORKACTIVITY_SUBMITTED_USER,REPAIR_TASK_CREATED_DATE,REPAIR_TASK_SUBMITTED_DATE,REPAIR_TASK_SUBMITTED_USER,VALIDITY_DATE,CREATED_BY,CREATION_DATE,LAST_UPDATED_BY,LAST_UPDATE_DATE) VALUES ('SUB200620240085800','I8408211','INITIATED',TO_TIMESTAMP('16-10-24 10:48:11.964000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),TO_TIMESTAMP('16-10-24 4:16:37.151000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',NULL,NULL,NULL,TO_TIMESTAMP('09-10-24 5:30:09.000000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('16-10-24 2:15:39.891000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('16-10-24 10:48:11.964000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_ACTIVITY_DTLS (SUBMISSION_ID,INTRODUCER_ID,STATUS,WORKACTIVED_CREATED_DATE,WORKACTIVE_SUBMITTED_DATE,WORKACTIVITY_SUBMITTED_USER,REPAIR_TASK_CREATED_DATE,REPAIR_TASK_SUBMITTED_DATE,REPAIR_TASK_SUBMITTED_USER,VALIDITY_DATE,CREATED_BY,CREATION_DATE,LAST_UPDATED_BY,LAST_UPDATE_DATE) VALUES ('SUB200620240085774','I8408211','APPROVED',TO_TIMESTAMP('10-10-24 8:10:49.191000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),TO_TIMESTAMP('10-10-24 8:11:48.727000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('10-10-24 8:11:48.727000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),TO_TIMESTAMP('10-10-24 8:12:35.000000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user8',TO_TIMESTAMP('09-10-24 5:30:09.000000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('10-10-24 8:10:49.191000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user8',TO_TIMESTAMP('10-10-24 8:12:35.596000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/
INSERT INTO INTRODUCER_ACTIVITY_DTLS (SUBMISSION_ID,INTRODUCER_ID,STATUS,WORKACTIVED_CREATED_DATE,WORKACTIVE_SUBMITTED_DATE,WORKACTIVITY_SUBMITTED_USER,REPAIR_TASK_CREATED_DATE,REPAIR_TASK_SUBMITTED_DATE,REPAIR_TASK_SUBMITTED_USER,VALIDITY_DATE,CREATED_BY,CREATION_DATE,LAST_UPDATED_BY,LAST_UPDATE_DATE) VALUES ('SUB200620240086051','I8203411','WORK_COMPLETED',TO_TIMESTAMP('13-11-24 5:33:53.302000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),TO_TIMESTAMP('13-11-24 5:36:18.159000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('13-11-24 5:36:18.159000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),NULL,NULL,TO_TIMESTAMP('16-03-25 12:00:00.000000000 AM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'user1',TO_TIMESTAMP('13-11-24 5:33:53.302000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'),'OfflineUser',TO_TIMESTAMP('13-11-24 5:36:18.159000000 PM','DD-MM-RR fmHH12:fmMI:SSXFF AM'))
/

----------------------------------------------------------------------------------------------------------------------------

CREATE TABLE USER_DTLS (
    USER_ID       NUMBER(10) NOT NULL,
    EMAIL_ID      VARCHAR2(100) NOT NULL,
    FIRST_NAME    VARCHAR2(40) NOT NULL,
    LAST_NAME     VARCHAR2(40) NOT NULL,
    CREATION_DATE TIMESTAMP(6),
    CONSTRAINT EMAIL_ID_PK PRIMARY KEY ( EMAIL_ID )
)
/

----------------------------------------------------------------------------------------------------------------------------

INSERT INTO USER_DTLS (USER_ID,EMAIL_ID,FIRST_NAME,LAST_NAME,CREATION_DATE) VALUES (0,'myemailid@somehost.com','First','Last',CURRENT_TIMESTAMP)
/

----------------------------------------------------------------------------------------------------------------------------

CREATE SEQUENCE user_id_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE
/

----------------------------------------------------------------------------------------------------------------------------

COMMIT
/

----------------------------------------------------------------------------------------------------------------------------