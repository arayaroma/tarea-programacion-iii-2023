-- Usage
CALL EVACOMUNA.GENERATE_RANDOM_PASSWORD(:USER_ID);

-- Procedure
CREATE OR REPLACE PROCEDURE EVACOMUNA.GENERATE_RANDOM_PASSWORD(
    USER_ID IN NUMBER,
    NEW_PASSWORD OUT VARCHAR2
) AS
BEGIN
    NEW_PASSWORD := DBMS_RANDOM.STRING( 'x', 10 );
    UPDATE TBL_USER
    SET
        PASSWORD = NEW_PASSWORD
    WHERE
        ID = USER_ID;
    COMMIT;
END GENERATE_RANDOM_PASSWORD;