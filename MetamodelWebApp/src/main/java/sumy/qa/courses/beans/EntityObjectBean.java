package sumy.qa.courses.beans;

import sumy.qa.courses.orm.EntityObject;

/**
 * Created with IntelliJ IDEA.
 * User: Юра
 * Date: 25/08/13
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */
public interface EntityObjectBean {

    EntityObject getEntityObjectByID(Integer id);

}
