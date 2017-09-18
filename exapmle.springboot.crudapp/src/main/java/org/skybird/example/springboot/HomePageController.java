package org.skybird.example.springboot;

import java.util.Map;

import org.skybird.example.springboot.service.TestService;
import org.skybird.example.springboot.vo.JpaTestTablePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * ClassName: HomePageController.java <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年9月15日下午4:02:38 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version 
 * @since 
 */
@Controller
@ComponentScan(basePackages={"org.skybird.example.springboot"}) 
public class HomePageController {

    @Autowired
    TestService service;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String toIndex(Map<String, Object> model) {
        model.put("pos", service.list());
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String toIndex2(JpaTestTablePO po, Map<String, Object> model) {
        model.put("pos", service.findByMessageContaining(po.getMessage()));
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(JpaTestTablePO po) {
        service.save(po);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id) {
        service.delete(Integer.parseInt(id));
        return new ModelAndView("redirect:/home");
    }
}
