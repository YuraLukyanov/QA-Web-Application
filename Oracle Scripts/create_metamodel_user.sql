--по дефолту оракловый юзер видит много разного говна :)
--этот юзер видит только то что надо)
CREATE USER metamodel_user IDENTIFIED BY metamodel_user;
GRANT ALL ON objects TO metamodel_user;
GRANT ALL ON attributes TO metamodel_user;
GRANT ALL ON params TO metamodel_user;
GRANT ALL ON attr_types TO metamodel_user;
GRANT ALL ON references TO metamodel_user;
GRANT ALL ON attr_object_types TO metamodel_user;
GRANT ALL ON grants TO metamodel_user;
GRANT connect TO metamodel_user;