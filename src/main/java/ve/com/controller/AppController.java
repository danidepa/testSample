package ve.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 893414 on 4/22/2015.
 */
@Controller
@RequestMapping("/")
public class AppController {
    @RequestMapping(method = RequestMethod.GET)
    public String viewApplication() {
        return "listusers";
    }
}
