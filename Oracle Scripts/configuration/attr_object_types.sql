
MERGE INTO ATTR_OBJECT_TYPES USING DUAL ON (OBJECT_TYPE_ID = 2 AND ATTR_ID = 1)
WHEN MATCHED THEN UPDATE  SET FLAGS = NULL
WHEN NOT MATCHED THEN INSERT (OBJECT_TYPE_ID, ATTR_ID, FLAGS) VALUES
(2, 1, NULL);
MERGE INTO ATTR_OBJECT_TYPES USING DUAL ON (OBJECT_TYPE_ID = 2 AND ATTR_ID = 2)
WHEN MATCHED THEN UPDATE  SET FLAGS = NULL
WHEN NOT MATCHED THEN INSERT (OBJECT_TYPE_ID, ATTR_ID, FLAGS) VALUES
(2, 2, NULL);