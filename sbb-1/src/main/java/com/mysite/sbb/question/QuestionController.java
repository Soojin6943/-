package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	
	@GetMapping("/question/list")
//	@ResponseBody
	public String list(Model model) {
		List<Question> questionList = this.questionRepository.findAll();
		
		// 모델 객체는 자바 클래스와 템플릿 간의 연결고리 역할 (모델 객체에 값을 담아 두면 템플릿에서 그 값을 사용할 수 있음)	
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
}
