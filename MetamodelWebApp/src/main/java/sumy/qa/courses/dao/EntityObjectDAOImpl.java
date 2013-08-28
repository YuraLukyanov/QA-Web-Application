package sumy.qa.courses.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sumy.qa.courses.orm.EntityObject;

/**
 * Created with IntelliJ IDEA.
 * User: Юра
 * Date: 25/08/13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */

@Repository("EntityObjectDAO")
public class EntityObjectDAOImpl implements EntityObjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EntityObjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public EntityObject getEntityObjectByID(Integer id) {
       return (EntityObject) sessionFactory.getCurrentSession().load(EntityObject.class, id);
    }

}
