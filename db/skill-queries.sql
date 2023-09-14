-- Skill with Characteristics - to fix
SELECT s.*, c.*
FROM TBL_SKILL s 
JOIN TBL_CHARACTERISTIC c 
ON s.ID = c.SKILLID