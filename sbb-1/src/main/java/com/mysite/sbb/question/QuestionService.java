package com.mysite.sbb.question;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;



@RequiredArgsConstructor
@Service
// 생성 클래스를 서비스로 만들기 위해서는 애너테이션을 붙이면 
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	
	public Page<Question> getList(int page) {
		Pageable pageable = PageRequest.of(page, 10);
		return this.questionRepository.findAll(pageable);
	}

}
