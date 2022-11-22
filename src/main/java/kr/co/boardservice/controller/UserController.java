package kr.co.boardservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.boardservice.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes			// 모델(Model)정보를 HTTP세션에 저장해주는 어노테이션
public class UserController {

	private UserService userService;
	
	//@GetMapping(path="/register")
	
}
