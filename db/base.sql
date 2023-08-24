-- TABLES
CREATE TABLE EVACOMUNA."TBL_COMPANY" (
    "NAME" VARCHAR2(32) NOT NULL ENABLE,
    "EMAIL" VARCHAR2(64) NOT NULL ENABLE,
    "PHOTO" BLOB NOT NULL ENABLE,
    CONSTRAINT "TBL_COMPANY_PK" PRIMARY KEY ("NAME") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS" LOB (
    "PHOTO"
) STORE AS SECUREFILE (
    TABLESPACE "USERS" ENABLE STORAGE IN ROW 4000 CHUNK 8192 NOCACHE LOGGING NOCOMPRESS KEEP_DUPLICATES
);

CREATE TABLE EVACOMUNA."TBL_EVALUATION" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(24) NOT NULL ENABLE,
    "INITIALPERIOD" DATE NOT NULL ENABLE,
    "FINALPERIOD" DATE NOT NULL ENABLE,
    "APPLICATIONDATE" DATE NOT NULL ENABLE,
    "STATE" VARCHAR2(24) DEFAULT 'under construction' NOT NULL ENABLE,
    CONSTRAINT "TBL_EVALUATION_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_EVALUATION_CHECK" CHECK ( STATE IN ( 'under construction', 'in application', 'under review', 'completed' ) ) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

CREATE TABLE EVACOMUNA."TBL_POSITION" (
    "ID" NUMBER(*, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(24) NOT NULL ENABLE,
    "STATE" VARCHAR2(20) DEFAULT 'inactive' NOT NULL ENABLE,
    CONSTRAINT "TBL_POSITION_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_POSITION_CHECK" CHECK (STATE IN ('inactive', 'active')) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

CREATE TABLE EVACOMUNA."TBL_SKILL" (
    "ID" NUMBER(38, 0) NOT NULL ENABLE,
    "NAME" VARCHAR2(24) NOT NULL ENABLE,
    "STATE" CHAR(8) DEFAULT 'inactive' NOT NULL ENABLE,
    CONSTRAINT "TBL_SKILL_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_SKILL_CHECK" CHECK (STATE IN ('inactive', 'active')) ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS";

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
    "PROFILEPHOTO" BLOB,
    "ISACTIVE" CHAR(1) DEFAULT 'N' NOT NULL ENABLE,
    "ISADMIN" CHAR(1) DEFAULT 'N' NOT NULL ENABLE,
    "POSITION" NUMBER(38, 0) NOT NULL ENABLE,
    CONSTRAINT "TBL_USER_PK" PRIMARY KEY ("ID") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_USER_UK1" UNIQUE ("USERNAME") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE,
    CONSTRAINT "TBL_USER_UK2" UNIQUE ("IDENTIFICATION") USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS" ENABLE
) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE "USERS" LOB (
    "PROFILEPHOTO"
) STORE AS SECUREFILE (
    TABLESPACE "USERS" ENABLE STORAGE IN ROW 4000 CHUNK 8192 NOCACHE LOGGING NOCOMPRESS KEEP_DUPLICATES
);

-- SEQUENCES
CREATE SEQUENCE EVACOMUNA.SEQ_EVALUATION INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

CREATE SEQUENCE EVACOMUNA.SEQ_POSITION INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

CREATE SEQUENCE EVACOMUNA.SEQ_SKILL INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

CREATE SEQUENCE EVACOMUNA.SEQ_USER INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999999999999999999999999 NOCYCLE NOCACHE NOORDER;

-- TRIGGERS
CREATE OR REPLACE EDITIONABLE TRIGGER EVACOMUNA."TGR_EVALUATION" BEFORE
    INSERT ON TBL_EVALUATION FOR EACH ROW
BEGIN
    IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN
        :NEW.ID := SEQ_EVALUATION.NEXTVAL;
    END IF;
END;
CREATE OR REPLACE TRIGGER EVACOMUNA."TGR_POSITION" BEFORE INSERT ON TBL_POSITION FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_POSITION.NEXTVAL;
END IF;
END;
CREATE OR REPLACE EDITIONABLE TRIGGER EVACOMUNA."TGR_SKILL" BEFORE INSERT ON TBL_SKILL FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_SKILL.NEXTVAL;
END IF;
END;
CREATE OR REPLACE EDITIONABLE TRIGGER EVACOMUNA."TGR_USER" BEFORE INSERT ON TBL_USER FOR EACH ROW BEGIN IF :NEW.ID IS NULL OR :NEW.ID <= 0 THEN :NEW.ID := SEQ_USER.NEXTVAL;
END IF;
/

END;

-- INDEXES
-- CREATE UNIQUE INDEX EVACOMUNA."TBL_EVALUATION_PK" ON EVACOMUNA."TBL_EVALUATION" ("ID") PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS";
-- CREATE UNIQUE INDEX EVACOMUNA."TBL_POSITION_PK" ON EVACOMUNA."TBL_POSITION" ("ID") PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS";
-- CREATE UNIQUE INDEX EVACOMUNA."TBL_SKILL_PK" ON EVACOMUNA."TBL_SKILL" ("ID") PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS";
-- CREATE UNIQUE INDEX EVACOMUNA."TBL_USER_PK" ON EVACOMUNA."TBL_USER" ("ID") PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS";
-- CREATE UNIQUE INDEX EVACOMUNA."SYS_IL0000075851C00011$$" ON EVACOMUNA."TBL_USER" (
--     PCTFREE 10 INITRANS 2 MAXTRANS 255 STORAGE(
--         INITIAL 65536 NEXT 1048576 MAXEXTENTS 2147483645 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT
--     ) TABLESPACE "USERS" PARALLEL (DEGREE 0 INSTANCES 0);
-- CREATE UNIQUE INDEX EVACOMUNA."TBL_USER_UK1" ON EVACOMUNA."TBL_USER" ("USERNAME") PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS";
-- CREATE UNIQUE INDEX EVACOMUNA."TBL_USER_UK2" ON EVACOMUNA."TBL_USER" ("IDENTIFICATION") PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS TABLESPACE "USERS";
-- COMMENTS
COMMENT ON COLUMN EVACOMUNA.TBL_POSITION.STATE IS 'states(active, inactive)';
COMMENT ON COLUMN EVACOMUNA.TBL_SKILL.STATE IS 'States(inactive, active)';
COMMENT ON COLUMN EVACOMUNA.TBL_USER.ISACTIVE IS 'N for false, Y for true';
COMMENT ON COLUMN EVACOMUNA.TBL_USER.ISADMIN IS 'N for false, Y for true';
-- ALTERS
ALTER TABLE EVACOMUNA."TBL_EVALUATION" ADD CONSTRAINT "FK_TBL_USER" FOREIGN KEY ("ID") REFERENCES "EVACOMUNA"."TBL_USER" ("ID") ON DELETE CASCADE ENABLE;

ALTER TRIGGER EVACOMUNA."TGR_EVALUATION" ENABLE;

ALTER TRIGGER EVACOMUNA."TGR_POSITION" ENABLE;

ALTER TABLE EVACOMUNA."TBL_SKILL" ADD CONSTRAINT "FK_TBL_POSITION_TO_SKILL" FOREIGN KEY ("ID") REFERENCES EVACOMUNA."TBL_POSITION" ("ID") ENABLE;

ALTER TRIGGER EVACOMUNA."TGR_SKILL" ENABLE;

ALTER TABLE EVACOMUNA."TBL_USER" ADD CONSTRAINT "FK_TBL_POSITION" FOREIGN KEY ("POSITION") REFERENCES EVACOMUNA."TBL_POSITION" ("ID") ENABLE;

ALTER TRIGGER EVACOMUNA."TGR_USER" ENABLE;