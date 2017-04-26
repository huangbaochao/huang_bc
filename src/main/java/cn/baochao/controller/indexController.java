package cn.baochao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class indexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getInfo() {
		return "redirect:/swagger-ui.html";
		//return "redirect:/index.html";
	}
}
