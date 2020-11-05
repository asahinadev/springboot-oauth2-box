package jp.mirageworld.spring.oauth2.box.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {

	public IndexController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("")
	@ResponseBody
	public String get() {
		return "OK";
	}

}
