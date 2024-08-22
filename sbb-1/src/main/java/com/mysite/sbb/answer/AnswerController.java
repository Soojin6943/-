package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
	private final QuestionService questionService;
	
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
		// @RequestParam(value="content") String content가 추가된 이유 -> 템플릿 question_detail.html에서 답변으로 입력한 내용(content)을 얻으려고 추가(textarea의 name 속성명이 content라서 변수명을 content로 설정)
		Question question = this.questionService.getQuestion(id);
		
		// TODO: 답볍을 저장한다.
		return String.format("redirect:/question/detail/%s", id);
	}
}

