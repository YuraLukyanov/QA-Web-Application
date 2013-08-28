package sumy.qa.courses.control;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sumy.qa.courses.beans.EntityObjectBean;

/**
 * Created with IntelliJ IDEA.
 * User: Юра
 * Date: 25/08/13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
@Controller//("objectEntity")
//@Scope("session")
public class ObjectEntityController {

    @Autowired
    private EntityObjectBean entityObjectBean;

    @RequestMapping("/index/{objectID}")
    public ModelAndView showObject(@PathVariable("objectID") Integer objectId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("result");
        mav.addObject("object", entityObjectBean.getEntityObjectByID(objectId));
        return mav;
    }
}
