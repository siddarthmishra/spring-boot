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