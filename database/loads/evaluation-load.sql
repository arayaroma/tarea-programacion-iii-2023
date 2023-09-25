INSERT INTO EVACOMUNA."TBL_EVALUATION" (
    "ID",
    "NAME",
    "APPLICATIONDATE",
    "INITIALPERIOD",
    "FINALPERIOD",
    "STATE",
    "VERSION"
) VALUES (
    1,
    'EVALUATION 1',
    TO_TIMESTAMP('2021-02-01 01:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2021-01-01 01:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2022-01-01 01:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    'UNDER REVIEW',
    1
);