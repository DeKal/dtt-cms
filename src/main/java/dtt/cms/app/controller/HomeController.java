package dtt.cms.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dtt.cms.app.common.ResourceMapping;

@Controller
public class HomeController {

    @GetMapping(ResourceMapping.HOME_PAGE_URL)
    public String renderHome(Model model) {
        return ResourceMapping.HOME_PAGE_RESOURCE;
    }

}