package sumy.qa.courses.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sumy.qa.courses.beans.EntityObjectBean;
import sumy.qa.courses.dao.EntityObjectDAO;
import sumy.qa.courses.orm.EntityObject;

/**
 * Created with IntelliJ IDEA.
 * User: Юра
 * Date: 25/08/13
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
@Service("EntityObjectBean")
public class EntityObjectBeanImpl implements EntityObjectBean {

    @Autowired
    private EntityObjectDAO entityObjectDAO;

    @Transactional
    public EntityObject getEntityObjectByID(Integer id) {
        return entityObjectDAO.getEntityObjectByID(id);
    }
}
