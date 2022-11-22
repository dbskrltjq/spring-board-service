package kr.co.boardservice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.boardservice.form.UserRegisterForm;
import kr.co.boardservice.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes			// 모델(Model)정보를 HTTP세션에 저장해주는 어노테이션
public class UserController {

	private UserService userService;
	
	@GetMapping(path = "/register")
	public String register(Model model) {
		model.addAttribute("userRegisterForm", new UserRegisterForm());
		return "user/registerform";
	}
	
	@PostMapping(path = "/register")
	public String register(@Valid UserRegisterForm userRegisterForm, BindingResult errors) throws Exception {
		
		if(errors.hasErrors()) {
			return "user/registerform";
		}
		
		try {
			userService.addNewUser(userRegisterForm);
		} catch (Exception e) {
			errors.rejectValue("id", null, e.getMessage());
			return "user/registerform";
		}
		
		return "home";
		
	}
	
}
