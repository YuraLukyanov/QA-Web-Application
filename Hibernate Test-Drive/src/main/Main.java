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

        session.flush();
        session.close();

    }

}
