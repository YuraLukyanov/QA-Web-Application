package main;

import org.hibernate.Session;
import orm.EntityObject;
import orm.ObjectType;
import orm.main.HibernateUtil;

import java.util.Locale;

public class Main
{
    public static void main(String...args) {
        Locale.setDefault(Locale.ENGLISH);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ObjectType user = (ObjectType) session.load(ObjectType.class, 1);
        EntityObject sysadm = new EntityObject();
        sysadm.setName("sysadm");
        sysadm.setObjectType(user);
        session.save(sysadm); //сохранили книгу, наш id сгенерировался и сразу заполнился
        session.getTransaction().commit();

        session.flush();
        session.close();

    }

}
