-- GENERAL INFORMATION RECORDS
INSERT INTO EVACOMUNA."TBL_GENERAL_INFORMATION" (
    "ID",
    "NAME",
    "EMAIL",
    "PHOTO",
    "HTMLTEMPLATE",
    "VERSION"
) VALUES (
    '1',
    'EvaComUNA',
    'evacomuna@gmail.com',
    EMPTY_BLOB(),
    '<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Registration Successful</title>
  </head>
  <body
    style="
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #f4f4f4;
    "
  >
    <div
      style="
        max-width: 600px;
        margin: 0 auto;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      "
    >
      <h1 style="color: #333">[title]</h1>
      <h2 style="color: #444">[header]</h2>
      <p style="color: #666">Dear [user_name],</p>
      <p style="color: #666">[body]</p>

      <p style="color: #666">[footer]</p>

      <p style="color: #666">Best regards,</p>
      <p style="color: #333"><strong>The [team] Team</strong></p>

      <p style="text-align: center; color: #999; font-size: 12px">
        This is an automated email. Please do not reply.
      </p>
    </div>
  </body>
</html>',
    '1'
);

-- POSITION RECORDS
INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    1,
    'System Administrator',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    2,
    'Database Administrator',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    3,
    'Backend Developer',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    4,
    'Frontend Developer',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    5,
    'Project Manager',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    6,
    'Quality Assurance',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    7,
    'Technical Leader',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    8,
    'Technical Support',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    9,
    'UX Designer',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    10,
    'UI Designer',
    'ACTIVE',
    1
);

-- SKILL RECORDS
INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    1,
    'Java',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    2,
    'Linux',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    3,
    'Docker',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    4,
    'SQL',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    5,
    'Team Work',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    6,
    'Leadership',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    7,
    'Communication',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    8,
    'Problem Solving',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    9,
    'Bug Fixing',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    10,
    'Creativity',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    11,
    'Proactivity',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    12,
    'Critical Thinking',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    13,
    'Time Management',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    14,
    'Adaptability',
    'ACTIVE',
    1
);

INSERT INTO EVACOMUNA."TBL_SKILL" (
    "ID",
    "NAME",
    "STATE",
    "VERSION"
) VALUES (
    15,
    'Hardware Knowledge',
    'ACTIVE',
    1
);

-- POSITION SKILL RECORDS
INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    1,
    2
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    1,
    3
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    1,
    8
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    1,
    9
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    2,
    3
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    2,
    4
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    3,
    4
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    3,
    5
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    3,
    7
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    3,
    9
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    4,
    4
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    4,
    5
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    4,
    7
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    4,
    9
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    4,
    10
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    5,
    5
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    5,
    6
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    5,
    7
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    5,
    8
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    6,
    9
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    6,
    10
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    6,
    7
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    7,
    7
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    7,
    8
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    7,
    11
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    7,
    12
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    8,
    14
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    8,
    15
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    8,
    13
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    9,
    11
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    9,
    12
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    9,
    8
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    10,
    1
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    10,
    5
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    10,
    6
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    10,
    7
);

INSERT INTO EVACOMUNA."TBL_POSITION_SKILL" (
    "POSITIONID",
    "SKILLID"
) VALUES (
    10,
    8
);

-- CHARACTERISTIC RECORDS
INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    1,
    'Streams knowledge',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    2,
    'API knowledge',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    3,
    'Predicates knowledge',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    4,
    'Java 17 knowledge',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    5,
    'Operative systems knowledge',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    6,
    'Kernel knowledge',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    7,
    'Proccesses knowledge',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    8,
    'Threads knowledge',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    9,
    'Memory management knowledge',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    10,
    'Linux',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    11,
    'Networking',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    12,
    'Containers',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    13,
    'Shell scripting',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    14,
    'Queries optimization',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    15,
    'Database design',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    16,
    'Database administration',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    17,
    'Database security',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    18,
    'Procedures and functions knowledge',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    19,
    'Easily adapts to new environments',
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    20,
    'Ease of working with others',
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    21,
    'Ease of dealing with conflicts',
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    22,
    'Delegation',
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    23,
    'Motivation',
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    24,
    'Communication',
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    25,
    'Conflict resolution',
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    26,
    'Influence',
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    27,
    'Verbal communication',
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    28,
    'Written communication',
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    29,
    'Presentation skills',
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    30,
    'Active listening',
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    31,
    'Creativity',
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    32,
    'Analytical thinking',
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    33,
    'Open-mindedness',
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    34,
    'Strategic thinking',
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    35,
    'Knowledge of the business',
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    36,
    'Knowledge of the product',
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    37,
    'Knowledge of the customer',
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    38,
    'Fast learner',
    11,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    39,
    'Self-taught',
    11,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    40,
    'Self-motivated',
    11,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    41,
    'Problem solving',
    12,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    42,
    'Decision making',
    12,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    43,
    'Attention to detail',
    12,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    44,
    'Prioritization',
    13,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    45,
    'Organization',
    13,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    46,
    'Multitasking',
    13,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    47,
    'Time control',
    13,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    48,
    'Flexibility',
    14,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    49,
    'Emotional intelligence',
    14,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    50,
    'Stress management',
    14,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    51,
    'Computer architecture',
    15,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    52,
    'Computer components',
    15,
    1
);

INSERT INTO EVACOMUNA."TBL_CHARACTERISTIC" (
    "ID",
    "NAME",
    "SKILLID",
    "VERSION"
) VALUES (
    53,
    'Computer peripherals',
    15,
    1
);

-- USERS RECORDS
INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    1,
    'user1',
    'password1',
    'John',
    'Doe',
    'Smith',
    '111111111',
    'user1@email.com',
    '11112222',
    '11112222',
    'N',
    'N',
    'N',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    2,
    'user2',
    'password2',
    'Alex',
    'Williams',
    'Brown',
    '222222222',
    'user2@email.com',
    '22223333',
    '22223333',
    'N',
    'N',
    'N',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    3,
    'user3',
    'password3',
    'Michael',
    'Johnson',
    'Davis',
    '333333333',
    'user3@email.com',
    '33334444',
    '33334444',
    'N',
    'N',
    'N',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    4,
    'user4',
    'password4',
    'Tyrell',
    'Wellick',
    'Von',
    '444444444',
    'user4@email.com',
    '44445555',
    '44445555',
    'N',
    'N',
    'N',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    5,
    'user5',
    'password5',
    'Elliot',
    'Alderson',
    'Wick',
    '555555555',
    'elliot@ecorp.com',
    '55555555',
    '55556666',
    'Y',
    'N',
    'N',
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    6,
    'user6',
    'password6',
    'Angela',
    'Moss',
    'Wick',
    '666666666',
    'angela@allsafe.com',
    '66666666',
    '66667777',
    'Y',
    'N',
    'N',
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    7,
    'user7',
    'password7',
    'Darlene',
    'Alderson',
    'Wick',
    '777777777',
    'darlene@fsociety.com',
    '77777777',
    '77778888',
    'Y',
    'N',
    'N',
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    8,
    'user8',
    'password8',
    'Phillip',
    'Price',
    'Wick',
    '888888888',
    'phillip@ecorp.com',
    '88888888',
    '88889999',
    'N',
    'N',
    'N',
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    9,
    'user9',
    'password9',
    'Terry',
    'Colby',
    'Wick',
    '999999999',
    'terry@colby.com',
    '99999999',
    '99991111',
    'N',
    'N',
    'N',
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_USER" (
    "ID",
    "USERNAME",
    "PASSWORD",
    "NAME",
    "LASTNAME",
    "SECONDLASTNAME",
    "IDENTIFICATION",
    "EMAIL",
    "LANDLINENUMBER",
    "PHONENUMBER",
    "ISACTIVE",
    "ISADMIN",
    "PASSWORDCHANGED",
    "USERPOSITIONID",
    "VERSION"
) VALUES (
    10,
    'user10',
    'password10',
    'Gideon',
    'Goddard',
    'Wick',
    '101010101',
    'gideon@price.com',
    '10101010',
    '10101111',
    'N',
    'N',
    'N',
    10,
    1
);

-- EVALUATION RECORDS
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
    TO_TIMESTAMP('2023-05-24 12:30:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2023-01-01 11:59:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2023-12-01 11:59:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    'UNDER CONSTRUCTION',
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATION" (
    "ID",
    "NAME",
    "APPLICATIONDATE",
    "INITIALPERIOD",
    "FINALPERIOD",
    "STATE",
    "VERSION"
) VALUES (
    2,
    'EVALUATION 2',
    TO_TIMESTAMP('2020-06-13 12:30:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2020-06-10 11:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2020-08-20 11:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    'IN APPLICATION',
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATION" (
    "ID",
    "NAME",
    "APPLICATIONDATE",
    "INITIALPERIOD",
    "FINALPERIOD",
    "STATE",
    "VERSION"
) VALUES (
    3,
    'EVALUATION 3',
    TO_TIMESTAMP('2021-12-24 10:30:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2021-03-23 03:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2022-05-26 05:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    'UNDER REVIEW',
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATION" (
    "ID",
    "NAME",
    "APPLICATIONDATE",
    "INITIALPERIOD",
    "FINALPERIOD",
    "STATE",
    "VERSION"
) VALUES (
    4,
    'EVALUATION 4',
    TO_TIMESTAMP('2021-08-13 08:30:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2021-08-16 10:10:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    TO_TIMESTAMP('2022-12-15 11:00:00.000', 'YYYY-MM-DD HH:MI:SS.FF3'),
    'COMPLETED',
    1
);

-- EVALUATED RECORDS
INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    1,
    1,
    '3',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    2,
    1,
    '4',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    3,
    1,
    '2',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    4,
    1,
    '3',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    5,
    2,
    '1',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    6,
    2,
    '2',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    7,
    3,
    '2',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    8,
    3,
    '4',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    9,
    3,
    '3',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    10,
    3,
    '3',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    11,
    3,
    '3',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    12,
    4,
    '1',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    13,
    4,
    '2',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    14,
    4,
    '3',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    15,
    4,
    '4',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    16,
    4,
    '2',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATED" (
    "ID",
    "EVALUATEDID",
    "FINALNOTE",
    "EVALUATIONID",
    "VERSION"
) VALUES (
    17,
    4,
    '3',
    4,
    1
);

-- EVALUATOR RECORDS
INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    1,
    2,
    'SUPERVISOR',
    'Tremendisimo',
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    2,
    2,
    'SUPERVISOR',
    'Piensa mucho',
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    3,
    2,
    'SUPERVISOR',
    'Se echó la base de datos con un DROP DATABASE',
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    4,
    2,
    'SUPERVISOR',
    'Si',
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    5,
    1,
    'PEER',
    'No',
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    6,
    1,
    'PEER',
    'Se echó el sistema con un rm -rf /',
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    7,
    4,
    'PEER',
    'Le sabe al backend',
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    8,
    4,
    'PEER',
    'Tremendisimo',
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    9,
    4,
    'PEER',
    'Se hecho el container de aplicaciones',
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    10,
    4,
    'PEER',
    'Sabe hacer los endpoints',
    10,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    11,
    4,
    'PEER',
    'No le sabe a los queries',
    11,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    12,
    5,
    'SUPERVISOR',
    'Tremendisimo este frontend',
    12,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    13,
    5,
    'SUPERVISOR',
    'Le sabe le sabe',
    13,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    14,
    5,
    'SUPERVISOR',
    'Buenas vistas',
    14,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    15,
    5,
    'SUPERVISOR',
    'Sisi',
    15,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    16,
    5,
    'SUPERVISOR',
    'no le sabe',
    16,
    1
);

INSERT INTO EVACOMUNA."TBL_EVALUATOR" (
    "ID",
    "EVALUATORID",
    "ROLE",
    "FEEDBACK",
    "EVALUATEDID",
    "VERSION"
) VALUES (
    17,
    5,
    'SUPERVISOR',
    'Tremendo',
    17,
    1
);

-- CALIFICATION RECORDS
INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    1,
    '3',
    2,
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    2,
    '4',
    3,
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    3,
    '2',
    8,
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    4,
    '3',
    9,
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    5,
    '1',
    3,
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    6,
    '2',
    4,
    6,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    7,
    '2',
    1,
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    8,
    '4',
    4,
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    9,
    '3',
    5,
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    10,
    '3',
    7,
    10,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    11,
    '3',
    9,
    11,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    12,
    '1',
    1,
    12,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    13,
    '2',
    4,
    13,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    14,
    '3',
    5,
    14,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    15,
    '4',
    7,
    15,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    16,
    '2',
    9,
    16,
    1
);

INSERT INTO EVACOMUNA."TBL_CALIFICATION" (
    "ID",
    "CALIFICATION",
    "SKILLID",
    "EVALUATORID",
    "VERSION"
) VALUES (
    17,
    '3',
    9,
    10,
    1
);

-- FINAL CALIFICATION RECORDS
INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    1,
    '3',
    '3',
    1,
    2,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    2,
    '4',
    '4',
    2,
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    3,
    '2',
    '2',
    3,
    8,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    4,
    '3',
    '3',
    4,
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    5,
    '1',
    '1',
    5,
    3,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    6,
    '2',
    '2',
    6,
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    7,
    '2',
    '2',
    7,
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    8,
    '4',
    '4',
    8,
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    9,
    '3',
    '3',
    9,
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    10,
    '3',
    '3',
    10,
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    11,
    '3',
    '3',
    11,
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    12,
    '1',
    '1',
    12,
    1,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    13,
    '2',
    '2',
    13,
    4,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    14,
    '3',
    '3',
    14,
    5,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    15,
    '4',
    '4',
    15,
    7,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    16,
    '2',
    '2',
    16,
    9,
    1
);

INSERT INTO EVACOMUNA."TBL_FINAL_CALIFICATION" (
    "ID",
    "FINALNOTE",
    "AVERAGE",
    "EVALUATEDID",
    "SKILLID",
    "VERSION"
) VALUES (
    17,
    '3',
    '3',
    17,
    9,
    1
);