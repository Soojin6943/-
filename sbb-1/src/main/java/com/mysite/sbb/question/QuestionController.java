package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/question/list")
//	@ResponseBody
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		
		// 모델 객체는 자바 클래스와 템플릿 간의 연결고리 역할 (모델 객체에 값을 담아 두면 템플릿에서 그 값을 사용할 수 있음)	
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	@GetMapping(value = "/question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		// service에서 가져오고 controller에서 선언?하고 모델로 해서 템플릿 간 연결 후 사용?
		
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
}
