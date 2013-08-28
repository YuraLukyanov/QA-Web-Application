package sumy.qa.courses.dao;

import sumy.qa.courses.orm.EntityObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Юра
 * Date: 25/08/13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public interface EntityObjectDAO {

    EntityObject getEntityObjectByID(Integer id);

}
