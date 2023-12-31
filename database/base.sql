-- TABLES

-- TABLE TBL_GENERAL_INFORMATION
CREATE TABLE EVACOMUNA."TBL_GENERAL_INFORMATION" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(32) NOT NULL ENABLE,
    "EMAIL" VARCHAR2(64) NOT NULL ENABLE,
    "PHOTO" BLOB NOT NULL ENABLE,
    "HTMLTEMPLATE" CLOB,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_GENERAL_INFORMATION_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS" LOB (
    "PHOTO"
) STORE AS SECUREFILE (
    TABLESPACE "USERS" ENABLE STORAGE IN ROW 4000 CHUNK 8192 NOCACHE LOGGING NOCOMPRESS KEEP_DUPLICATES
) LOB (
    "HTMLTEMPLATE"
) STORE AS SECUREFILE (
    TABLESPACE "USERS" ENABLE STORAGE IN ROW 4000 CHUNK 8192 NOCACHE LOGGING NOCOMPRESS KEEP_DUPLICATES
);

-- TABLE TBL_USER
CREATE TABLE EVACOMUNA."TBL_USER" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "USERNAME" VARCHAR2(20) NOT NULL ENABLE,
    "PASSWORD" VARCHAR2(16) NOT NULL ENABLE,
    "NAME" VARCHAR2(16) NOT NULL ENABLE,
    "LASTNAME" VARCHAR2(16) NOT NULL ENABLE,
    "SECONDLASTNAME" VARCHAR2(16) NOT NULL ENABLE,
    "IDENTIFICATION" VARCHAR2(9) NOT NULL ENABLE,
    "EMAIL" VARCHAR2(64) NOT NULL ENABLE,
    "LANDLINENUMBER" VARCHAR2(8) NOT NULL ENABLE,
    "PHONENUMBER" VARCHAR2(8) NOT NULL ENABLE,
    "ISACTIVE" CHAR(1) DEFAULT 'N' NOT NULL ENABLE,
    "ISADMIN" CHAR(1) DEFAULT 'N' NOT NULL ENABLE,
    "PASSWORDCHANGED" CHAR(1) DEFAULT 'N' NOT NULL ENABLE,
    "ACTIVATIONCODE" VARCHAR2(100),
    "USERPOSITIONID" NUMBER(38, 0),
    "PROFILEPHOTO" BLOB,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_USER_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_USER_USERNAME_UK" UNIQUE ("USERNAME") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_USER_IDENTIFICATION_UK" UNIQUE ("IDENTIFICATION") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_USER_ISADMIN_CHECK" CHECK (ISADMIN IN ('N', 'Y')) ENABLE,
    CONSTRAINT "TBL_USER_ISACTIVE_CHECK" CHECK (ISACTIVE IN ('N', 'Y')) ENABLE,
    CONSTRAINT "TBL_USER_PASSWORDCHANGED_CHECK" CHECK (ISACTIVE IN ('N', 'Y')) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS" LOB (
    "PROFILEPHOTO"
) STORE AS SECUREFILE (
    TABLESPACE "USERS" ENABLE STORAGE IN ROW 4000 CHUNK 8192 NOCACHE LOGGING NOCOMPRESS KEEP_DUPLICATES
);

-- TABLE TBL_POSITION
CREATE TABLE EVACOMUNA."TBL_POSITION" (
    "ID" NUMBER(*, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(24) NOT NULL ENABLE,
    "STATE" VARCHAR2(20) DEFAULT 'INACTIVE' NOT NULL ENABLE,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_POSITION_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_POSITION_STATE_CHECK" CHECK (STATE IN ('INACTIVE', 'ACTIVE')) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- TABLE TBL_POSITION_SKILL
CREATE TABLE EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID" NUMBER(38, 0) NOT NULL ENABLE,
    "SKILLID" NUMBER(38, 0) NOT NULL ENABLE
);

-- TABLE TBL_SKILL
CREATE TABLE EVACOMUNA."TBL_SKILL" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(24) NOT NULL ENABLE,
    "STATE" CHAR(8) DEFAULT 'INACTIVE' NOT NULL ENABLE,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_SKILL_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_SKILL_STATE_CHECK" CHECK (STATE IN ('INACTIVE', 'ACTIVE')) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- TABLE TBL_CHARACTERISTIC
CREATE TABLE EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(100) NOT NULL ENABLE,
    "SKILLID" NUMBER(38, 0),
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_CHARACTERISTIC_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 TABLESPACE "USERS" ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- TABLE EVALUATION
CREATE TABLE EVACOMUNA."TBL_EVALUATION" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(128) NOT NULL ENABLE,
    "APPLICATIONDATE" DATE NOT NULL ENABLE,
    "INITIALPERIOD" DATE NOT NULL ENABLE,
    "FINALPERIOD" DATE NOT NULL ENABLE,
    "STATE" VARCHAR2(24) DEFAULT 'UNDER CONSTRUCTION' NOT NULL ENABLE,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_EVALUATION_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_EVALUATION_CHECK" CHECK ( STATE IN ( 'UNDER CONSTRUCTION', 'IN APPLICATION', 'UNDER REVIEW', 'COMPLETED' ) ) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- TABLE TBL_EVALUATED
CREATE TABLE EVACOMUNA."TBL_EVALUATED" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "EVALUATEDID" NUMBER(38, 0) NOT NULL ENABLE,
    "FINALNOTE" VARCHAR2(100),
    "EVALUATIONID" NUMBER(38, 0) NOT NULL ENABLE,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_EVALUATED_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- TABLE TBL_EVALUATOR
CREATE TABLE EVACOMUNA."TBL_EVALUATOR" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "EVALUATORID" NUMBER(38, 0) NOT NULL ENABLE,
    "ROLE" VARCHAR2(24) NOT NULL ENABLE,
    "FEEDBACK" VARCHAR2(100),
    "EVALUATEDID" NUMBER(38, 0) NOT NULL ENABLE,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_EVALUATOR_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_EVALUATOR_ROLE_CHECK" CHECK (ROLE IN ('SELF', 'SUPERVISOR', 'PEER', 'CLIENT')) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- TABLE TBL_CALIFICATION
CREATE TABLE EVACOMUNA."TBL_CALIFICATION" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "CALIFICATION" NUMBER(38, 0) NOT NULL ENABLE,
    "SKILLID" NUMBER(38, 0) NOT NULL ENABLE,
    "EVALUATORID" NUMBER(38, 0) NOT NULL ENABLE,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_CALIFICATION_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 TABLESPACE "USERS" ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- TABLE TBL_AVERAGE_CALIFICATION
CREATE TABLE EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "FINALNOTE" NUMBER(38, 0) NOT NULL ENABLE,
    "AVERAGE" NUMBER(38, 0) NOT NULL ENABLE,
    "EVALUATEDID" NUMBER(38, 0) NOT NULL ENABLE,
    "SKILLID" NUMBER(38, 0) NOT NULL ENABLE,
    "VERSION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_AVERAGE_CALIFICATION_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 TABLESPACE "USERS" ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

-- SEQUENCES

-- SEQ_COMPANY
CREATE SEQUENCE EVACOMUNA.SEQ_GENERAL_INFORMATION INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_USER
CREATE SEQUENCE EVACOMUNA.SEQ_USER INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_POSITION
CREATE SEQUENCE EVACOMUNA.SEQ_POSITION INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_SKILL
CREATE SEQUENCE EVACOMUNA.SEQ_SKILL INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

--SEQ_CHARACTERISTIC
CREATE SEQUENCE EVACOMUNA.SEQ_CHARACTERISTIC INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_EVALUATION
CREATE SEQUENCE EVACOMUNA.SEQ_EVALUATION INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_EVALUATED
CREATE SEQUENCE EVACOMUNA.SEQ_EVALUATED INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_EVALUATOR
CREATE SEQUENCE EVACOMUNA.SEQ_EVALUATOR INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_CALIFICATION
CREATE SEQUENCE EVACOMUNA.SEQ_CALIFICATION INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- SEQ_FINAL_CALIFICATION
CREATE SEQUENCE EVACOMUNA.SEQ_FINAL_CALIFICATION INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- TRIGGERS

-- TGR_GENERAL_INFORMATION
CREATE OR REPLACE TRIGGER TGR_GENERAL_INFORMATION BEFORE
    INSERT ON TBL_GENERAL_INFORMATION FOR EACH ROW
BEGIN
    IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN
        :NEW.ID := SEQ_GENERAL_INFORMATION.NEXTVAL;
    END IF;
END;
 -- TGR_USER
 CREATE OR REPLACE TRIGGER TGR_USER BEFORE INSERT ON TBL_USER FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_USER.NEXTVAL;
END IF;
END;
 -- TGR_POSITION
 CREATE OR REPLACE TRIGGER TGR_POSITION BEFORE INSERT ON TBL_POSITION FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_POSITION.NEXTVAL;
END IF;
END;
 -- TGR_SKILL
 CREATE OR REPLACE TRIGGER TGR_SKILL BEFORE INSERT ON TBL_SKILL FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_SKILL.NEXTVAL;
END IF;
END;
 -- TGR_CHARACTERISTIC
 CREATE OR REPLACE TRIGGER TGR_CHARACTERISTIC BEFORE INSERT ON TBL_CHARACTERISTIC FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_CHARACTERISTIC.NEXTVAL;
END IF;
END;
 -- TGR_EVALUATION
 CREATE OR REPLACE TRIGGER TGR_EVALUATION BEFORE INSERT ON TBL_EVALUATION FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_EVALUATION.NEXTVAL;
END IF;
END;
 -- TGR_EVALUATED
 CREATE OR REPLACE TRIGGER TGR_EVALUATED BEFORE INSERT ON TBL_EVALUATED FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_EVALUATED.NEXTVAL;
END IF;
END;
 -- TGR_EVALUATOR
 CREATE OR REPLACE TRIGGER TGR_EVALUATOR BEFORE INSERT ON TBL_EVALUATOR FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_EVALUATOR.NEXTVAL;
END IF;
END;
 -- TGR_CALIFICATION
 CREATE OR REPLACE TRIGGER TGR_CALIFICATION BEFORE INSERT ON TBL_CALIFICATION FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_CALIFICATION.NEXTVAL;
END IF;
END;
 -- TGR_FINAL_CALIFICATION
 CREATE OR REPLACE TRIGGER TGR_FINAL_CALIFICATION BEFORE INSERT ON TBL_FINAL_CALIFICATION FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_FINAL_CALIFICATION.NEXTVAL;
END IF;
END;
 -- COMMENTS
 COMMENT ON COLUMN EVACOMUNA.TBL_POSITION.STATE IS 'STATES(INACTIVE, ACTIVE)';
COMMENT ON COLUMN EVACOMUNA.TBL_SKILL.STATE IS 'STATES(INACTIVE, ACTIVE)';
COMMENT ON COLUMN EVACOMUNA.TBL_USER.ISACTIVE IS 'N FOR FALSE, Y FOR TRUE';
COMMENT ON COLUMN EVACOMUNA.TBL_USER.ISADMIN IS 'N FOR FALSE, Y FOR TRUE';
COMMENT ON COLUMN EVACOMUNA.TBL_USER.PASSWORDCHANGED IS 'N FOR FALSE, Y FOR TRUE';
COMMENT ON COLUMN EVACOMUNA.TBL_EVALUATION.STATE IS 'STATES(UNDER CONSTRUCTION, IN APPLICATION, UNDER REVIEW, COMPLETED)';
COMMENT ON COLUMN EVACOMUNA.TBL_EVALUATOR.ROLE IS 'ROLES(SELF, SUPERVISOR, PEER, CLIENT)';
 -- ALTER TABLES
 -- FK TBL_EVALUATOR -> TBL_USER
 ALTER TABLE EVACOMUNA."TBL_EVALUATOR" ADD CONSTRAINT "FK_TBL_EVALUATOR_TO_USER" FOREIGN KEY ("EVALUATORID") REFERENCES EVACOMUNA."TBL_USER" ("ID") ENABLE;
 -- FK TBL_EVALUATED -> TBL_USER
 ALTER TABLE EVACOMUNA."TBL_EVALUATED" ADD CONSTRAINT "FK_TBL_EVALUATED_TO_USER" FOREIGN KEY ("EVALUATEDID") REFERENCES EVACOMUNA."TBL_USER" ("ID") ENABLE;
 -- FK TBL_USER -> TBL_POSITION
 ALTER TABLE EVACOMUNA."TBL_USER" ADD CONSTRAINT "FK_TBL_USER_TO_POSITION" FOREIGN KEY ("USERPOSITIONID") REFERENCES EVACOMUNA."TBL_POSITION" ("ID") ENABLE;
 -- FK TBL_POSITION_SKILL -> TBL_SKILL
 ALTER TABLE EVACOMUNA."TBL_POSITION_SKILL" ADD CONSTRAINT "FK_TBL_SKILL_TO_POSITION_SKILL" FOREIGN KEY ("SKILLID") REFERENCES EVACOMUNA."TBL_SKILL" ("ID") ENABLE;
 -- FK TBL_POSITION_SKILL -> TBL_POSITION
 ALTER TABLE EVACOMUNA."TBL_POSITION_SKILL" ADD CONSTRAINT "FK_TBL_POSITION_TO_POSITION_SKILL" FOREIGN KEY ("POSITIONID") REFERENCES EVACOMUNA."TBL_POSITION" ("ID") ENABLE;
 -- FK TBL_SKILL -> TBL_CHARACTERISTIC
 ALTER TABLE EVACOMUNA."TBL_CHARACTERISTIC" ADD CONSTRAINT "FK_TBL_SKILL_TO_CHARACTERISTIC" FOREIGN KEY ("SKILLID") REFERENCES EVACOMUNA."TBL_SKILL" ("ID") ENABLE;
 --FK TBL_EVALUATED -> TBL_EVALUATION
 ALTER TABLE EVACOMUNA."TBL_EVALUATED" ADD CONSTRAINT "FK_TBL_EVALUATED_TO_EVALUATION" FOREIGN KEY ("EVALUATIONID") REFERENCES EVACOMUNA."TBL_EVALUATION" ("ID") ENABLE;
 -- FK TBL_EVALUATOR -> TBL_EVALUATED
 ALTER TABLE EVACOMUNA."TBL_EVALUATOR" ADD CONSTRAINT "FK_TBL_EVALUATED_EVALUATOR" FOREIGN KEY ("EVALUATEDID") REFERENCES EVACOMUNA."TBL_EVALUATED" ("ID") ENABLE;
 -- FK TBL_CALIFICATION -> TBL_SKILL
 ALTER TABLE EVACOMUNA."TBL_CALIFICATION" ADD CONSTRAINT "FK_TBL_SKILL_TO_CALIFICATION" FOREIGN KEY ("SKILLID") REFERENCES EVACOMUNA."TBL_SKILL" ("ID") ENABLE;
 -- FK TBL_CALIFICATION -> TBL_EVALUATOR
 ALTER TABLE EVACOMUNA."TBL_CALIFICATION" ADD CONSTRAINT "FK_TBL_EVALUATOR_TO_CALIFICATION" FOREIGN KEY ("EVALUATORID") REFERENCES EVACOMUNA."TBL_EVALUATOR" ("ID") ENABLE;
 -- FK TBL_FINAL_CALIFICATION -> TBL_SKILL
 ALTER TABLE EVACOMUNA."TBL_FINAL_CALIFICATION" ADD CONSTRAINT "FK_TBL_SKILL_TO_FINAL_CALIFICATION" FOREIGN KEY ("SKILLID") REFERENCES EVACOMUNA."TBL_SKILL" ("ID") ENABLE;
 -- FK TBL_FINAL_CALIFICATION -> TBL_EVALUATED
 ALTER TABLE EVACOMUNA."TBL_FINAL_CALIFICATION" ADD CONSTRAINT "FK_TBL_EVALUATED_TO_FINAL_CALIFICATION" FOREIGN KEY ("EVALUATEDID") REFERENCES EVACOMUNA."TBL_EVALUATED" ("ID") ENABLE;
 -- ALTER TRIGGERS
 ALTER TRIGGER EVACOMUNA."TGR_GENERAL_INFORMATION" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_USER" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_POSITION" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_SKILL" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_CHARACTERISTIC" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_EVALUATION" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_EVALUATED" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_EVALUATOR" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_CALIFICATION" ENABLE;
ALTER TRIGGER EVACOMUNA."TGR_FINAL_CALIFICATION" ENABLE;
 -- PROCEDURES
 -- Activate the user
 CREATE OR REPLACE PROCEDURE ACTIVATE_USER ( USER_ID IN NUMBER ) AS
BEGIN
    UPDATE TBL_USER
    SET
        ISACTIVE = 'Y'
    WHERE
        ID = USER_ID;
    COMMIT;
END ACTIVATE_USER;
 -- Change the password
 CREATE OR REPLACE PROCEDURE CHANGE_PASSWORD ( USER_ID IN NUMBER, NEW_PASSWORD IN VARCHAR2, CHANGED_PASSWORD OUT VARCHAR2 ) AS
BEGIN
    UPDATE TBL_USER
    SET
        PASSWORD = NEW_PASSWORD,
        PASSWORDCHANGED = 'Y'
    WHERE
        ID = USER_ID;
    COMMIT;
END CHANGE_PASSWORD;
 -- Generate Random Password
 CREATE OR REPLACE PROCEDURE EVACOMUNA.GENERATE_RANDOM_PASSWORD( USER_ID IN NUMBER, NEW_PASSWORD OUT VARCHAR2 ) AS
BEGIN
    NEW_PASSWORD := DBMS_RANDOM.STRING( 'x', 10 );
    UPDATE TBL_USER
    SET
        PASSWORD = NEW_PASSWORD
    WHERE
        ID = USER_ID;
    COMMIT;
END GENERATE_RANDOM_PASSWORD;