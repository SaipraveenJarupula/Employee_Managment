package com.SpringBoot.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller	
@RestController
public class HomeController {
	
	@RequestMapping("home")
	public String Home()
	{
	
	return ("index.jsp");
}

}
