
MERGE INTO ATTR_TYPES USING DUAL ON (TYPE_ID = 1)
WHEN MATCHED THEN UPDATE  SET NAME = 'Text', DESCR = NULL
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(1, 'Text', NULL);
MERGE INTO ATTR_TYPES USING DUAL ON (TYPE_ID = 2)
WHEN MATCHED THEN UPDATE  SET NAME = 'Number', DESCR = NULL
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(2, 'Number', NULL);
MERGE INTO ATTR_TYPES USING DUAL ON (TYPE_ID = 3)
WHEN MATCHED THEN UPDATE  SET NAME = 'Reference', DESCR = NULL
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(3, 'Reference', NULL);
MERGE INTO ATTR_TYPES USING DUAL ON (TYPE_ID = 4)
WHEN MATCHED THEN UPDATE  SET NAME = 'Date', DESCR = NULL
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(4, 'Date', NULL);
MERGE INTO ATTR_TYPES USING DUAL ON (TYPE_ID = 5)
WHEN MATCHED THEN UPDATE  SET NAME = 'List', DESCR = NULL
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(5, 'List', NULL);

MERGE INTO ATTRIBUTES USING DUAL ON (ATTR_ID = 1)
WHEN MATCHED THEN UPDATE  SET NAME = 'Password', ATTR_TYPE_ID = 1, PROPERTIES = NULL, FLAGS = NULL
WHEN NOT MATCHED THEN INSERT (ATTR_ID, NAME, ATTR_TYPE_ID, PROPERTIES, FLAGS) VALUES
(1, 'Password', 1, NULL, NULL);
MERGE INTO ATTRIBUTES USING DUAL ON (ATTR_ID = 2)
WHEN MATCHED THEN UPDATE  SET NAME = 'E-mail', ATTR_TYPE_ID = 1, PROPERTIES = NULL, FLAGS = NULL
WHEN NOT MATCHED THEN INSERT (ATTR_ID, NAME, ATTR_TYPE_ID, PROPERTIES, FLAGS) VALUES
(2, 'E-mail', 1, NULL, NULL);
MERGE INTO OBJECT_TYPES USING DUAL ON (TYPE_ID = 1)
WHEN MATCHED THEN UPDATE  SET NAME = 'Project', DESCR = '������� �������. ���������� �� ����. ���������������. parent_id = null'
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(1, 'Project', '������� �������. ���������� �� ����. ���������������. parent_id = null');
MERGE INTO OBJECT_TYPES USING DUAL ON (TYPE_ID = 2)
WHEN MATCHED THEN UPDATE  SET NAME = 'User', DESCR = '������� ������ ������������'
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(2, 'User', '������� ������ ������������');
MERGE INTO ATTR_OBJECT_TYPES USING DUAL ON (OBJECT_TYPE_ID = 2 AND ATTR_ID = 1)
WHEN MATCHED THEN UPDATE  SET FLAGS = NULL
WHEN NOT MATCHED THEN INSERT (OBJECT_TYPE_ID, ATTR_ID, FLAGS) VALUES
(2, 1, NULL);
MERGE INTO ATTR_OBJECT_TYPES USING DUAL ON (OBJECT_TYPE_ID = 2 AND ATTR_ID = 2)
WHEN MATCHED THEN UPDATE  SET FLAGS = NULL
WHEN NOT MATCHED THEN INSERT (OBJECT_TYPE_ID, ATTR_ID, FLAGS) VALUES
(2, 2, NULL);
MERGE INTO OBJECTS USING DUAL ON (OBJECT_ID = 1)
WHEN MATCHED THEN UPDATE  SET OBJECT_TYPE_ID = 1, NAME = 'Container For Users', ORDER_NUMBER = NULL, PARENT_ID = NULL, DESCRIPTION = 'Contain all users in application'
WHEN NOT MATCHED THEN INSERT (OBJECT_ID, OBJECT_TYPE_ID, NAME, ORDER_NUMBER, PARENT_ID, DESCRIPTION) VALUES
(1, 1, 'Container For Users', NULL, NULL, 'Contain all users in application');
MERGE INTO OBJECTS USING DUAL ON (OBJECT_ID = 2)
WHEN MATCHED THEN UPDATE  SET OBJECT_TYPE_ID = 1, NAME = 'Inventory', ORDER_NUMBER = NULL, PARENT_ID = NULL, DESCRIPTION = 'Inventory project contain physical resources'
WHEN NOT MATCHED THEN INSERT (OBJECT_ID, OBJECT_TYPE_ID, NAME, ORDER_NUMBER, PARENT_ID, DESCRIPTION) VALUES
(2, 1, 'Inventory', NULL, NULL, 'Inventory project contain physical resources');