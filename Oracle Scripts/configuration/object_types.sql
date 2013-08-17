
MERGE INTO OBJECT_TYPES USING DUAL ON (TYPE_ID = 1)
WHEN MATCHED THEN UPDATE  SET NAME = 'Project', DESCR = 'Рутовые объекты. Контейнеры со спец. предназначением. parent_id = null'
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(1, 'Project', 'Рутовые объекты. Контейнеры со спец. предназначением. parent_id = null');
MERGE INTO OBJECT_TYPES USING DUAL ON (TYPE_ID = 2)
WHEN MATCHED THEN UPDATE  SET NAME = 'User', DESCR = 'Учетная запись пользователя'
WHEN NOT MATCHED THEN INSERT (TYPE_ID, NAME, DESCR) VALUES
(2, 'User', 'Учетная запись пользователя');