﻿-- Скрипт сгенерирован Devart dbForge Studio for Oracle, Версия 3.1.206.1
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/oracle/studio
-- Дата скрипта: 16.08.2013 18:12:57
-- Версия сервера: Oracle Database 11g Express Edition Release 11.2.0.2.0 - Production
-- Версия клиента:
 
/*
DROP TABLE REFERENCEs;
DROP TABLE params;
DROP TABLE grants;
DROP TABLE objects;
DROP TABLE attr_object_types;
DROP TABLE attributes;
DROP TABLE object_types;
DROP TABLE attr_types;

DROP SEQUENCE ENTITY_OBJECTS_SEQ;
*/

--Все служебные объекты которые мы будем создавать руками ( такие как проекты ) будут иметь id < 1000
CREATE SEQUENCE ENTITY_OBJECTS_SEQ
  START WITH 1000
  INCREMENT BY 1;

CREATE TABLE ATTR_TYPES (
  TYPE_ID NUMBER(20),
  NAME VARCHAR2(255 BYTE) NOT NULL,
  DESCR VARCHAR2(255 BYTE),
  CONSTRAINT PK_ATTR_TYPES PRIMARY KEY (TYPE_ID))
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

CREATE TABLE OBJECT_TYPES (
  TYPE_ID NUMBER(20),
  NAME VARCHAR2(255 BYTE) NOT NULL,
  DESCR VARCHAR2(255 BYTE),
  CONSTRAINT PK_OBJECT_TYPES PRIMARY KEY (TYPE_ID))
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

CREATE TABLE ATTRIBUTES (
  ATTR_ID NUMBER(20),
  NAME VARCHAR2(255 BYTE) NOT NULL,
  ATTR_TYPE_ID NUMBER(2) NOT NULL,
  PROPERTIES VARCHAR2(1024 BYTE),
  FLAGS NUMBER(10),
  DESCRIPTION VARCHAR2(1000 BYTE),
  CONSTRAINT PK_ATTRIBUTES PRIMARY KEY (ATTR_ID))
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

CREATE TABLE ATTR_OBJECT_TYPES (
  OBJECT_TYPE_ID NUMBER(20) NOT NULL,
  ATTR_ID NUMBER(20) NOT NULL,
  FLAGS NUMBER(10),
  CONSTRAINT PK_ATTR_OBJECT_TYPES PRIMARY KEY (ATTR_ID, OBJECT_TYPE_ID),
  CONSTRAINT FK_ATTR_ID FOREIGN KEY (ATTR_ID)
    REFERENCES ATTRIBUTES(ATTR_ID) ON DELETE CASCADE,
  CONSTRAINT FK_TYPE FOREIGN KEY (OBJECT_TYPE_ID)
    REFERENCES OBJECT_TYPES(TYPE_ID) ON DELETE CASCADE)
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

CREATE TABLE GRANTS (
  OBJECT_ID NUMBER(20),
  ATTR_ID NUMBER(20),
  OBJECT_TYPE_ID NUMBER(20),
  GRANTS NUMBER(10) NOT NULL,
  USER_ID NUMBER(20) NOT NULL,
  CONSTRAINT PK_GRANTS PRIMARY KEY (ATTR_ID, GRANTS, OBJECT_ID, OBJECT_TYPE_ID, USER_ID))
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

CREATE TABLE OBJECTS (
  OBJECT_ID NUMBER(20),
  OBJECT_TYPE_ID NUMBER(20) NOT NULL,
  NAME VARCHAR2(255 BYTE) NOT NULL,
  ORDER_NUMBER NUMBER(10),
  PARENT_ID NUMBER(20),
  DESCRIPTION VARCHAR2(255 BYTE),
  CONSTRAINT PK_OBJECTS PRIMARY KEY(OBJECT_ID))
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

CREATE TABLE PARAMS (
  OBJECT_ID NUMBER(20) NOT NULL,
  ATTR_ID NUMBER(20) NOT NULL,
  VALUE VARCHAR2(4000 BYTE),
  DATE_VALUE DATE,
  SHOW_ORDER NUMBER(6),
  CONSTRAINT PK_PARAMS PRIMARY KEY (ATTR_ID, DATE_VALUE, OBJECT_ID, SHOW_ORDER, VALUE))
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

CREATE TABLE REFERENCES (
  OBJECT_ID NUMBER(20),
  ATTR_ID NUMBER(20),
  REFERENCE NUMBER(20),
  SHOW_ORDER NUMBER(6),
  CONSTRAINT PK_REFERENCES PRIMARY KEY (ATTR_ID, OBJECT_ID, REFERENCE, SHOW_ORDER))
TABLESPACE USERS
STORAGE (
  INITIAL 64K
  NEXT 1M
  MAXEXTENTS UNLIMITED
)
LOGGING;

ALTER TABLE GRANTS 
  ADD CONSTRAINT FK_GRANTS_ATTR FOREIGN KEY (ATTR_ID)
    REFERENCES ATTRIBUTES(ATTR_ID) ON DELETE CASCADE;

ALTER TABLE GRANTS 
  ADD CONSTRAINT FK_GRANTS_OBJECTS_OBJECT_ID FOREIGN KEY (OBJECT_ID)
    REFERENCES OBJECTS(OBJECT_ID) ON DELETE CASCADE;

ALTER TABLE GRANTS 
  ADD CONSTRAINT FK_GRANTS_OT FOREIGN KEY (OBJECT_TYPE_ID)
    REFERENCES OBJECT_TYPES(TYPE_ID) ON DELETE CASCADE;

ALTER TABLE GRANTS 
  ADD CONSTRAINT FK_GRANTS_USER_ID FOREIGN KEY (USER_ID)
    REFERENCES OBJECTS(OBJECT_ID) ON DELETE CASCADE;

ALTER TABLE OBJECTS 
  ADD CONSTRAINT FK_PARENT FOREIGN KEY (PARENT_ID)
    REFERENCES OBJECTS(OBJECT_ID) ON DELETE CASCADE;

ALTER TABLE OBJECTS 
  ADD CONSTRAINT FK_TYPE_ID FOREIGN KEY (OBJECT_TYPE_ID)
    REFERENCES OBJECT_TYPES(TYPE_ID) ON DELETE CASCADE;

ALTER TABLE PARAMS 
  ADD CONSTRAINT FK_PAR_ATTR_ID FOREIGN KEY (ATTR_ID)
    REFERENCES ATTRIBUTES(ATTR_ID) ON DELETE CASCADE;

ALTER TABLE PARAMS 
  ADD CONSTRAINT FK_PAR_OBJ_ID FOREIGN KEY (OBJECT_ID)
    REFERENCES OBJECTS(OBJECT_ID) ON DELETE CASCADE;

ALTER TABLE REFERENCES 
  ADD CONSTRAINT FK_REF_ATTR_ID FOREIGN KEY (ATTR_ID)
    REFERENCES ATTRIBUTES(ATTR_ID) ON DELETE CASCADE;

ALTER TABLE REFERENCES 
  ADD CONSTRAINT FK_REF_OBJ_ID FOREIGN KEY (OBJECT_ID)
    REFERENCES OBJECTS(OBJECT_ID) ON DELETE CASCADE;

ALTER TABLE REFERENCES 
  ADD CONSTRAINT FK_REF_OBJ_ID_REF FOREIGN KEY (REFERENCE)
    REFERENCES OBJECTS(OBJECT_ID) ON DELETE CASCADE;