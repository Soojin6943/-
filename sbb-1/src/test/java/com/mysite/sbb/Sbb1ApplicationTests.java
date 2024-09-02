package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

//import java.util.List;

//import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class Sbb1ApplicationTests {
	
//	@Autowired
//	private QuestionRepository questionRepository;
//
//	@Test
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
		
		// -------------------------------------
		
		// findAll() 메서드 : 모든 데이터 가져온다고 생각하면 
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?",q.getSubject());
		
		// ---------------------------------------
		
		// findById 메서드 : id의 값을 활용해 데이터를 조회
		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?",q.getSubject());
//		}
//		
//	}
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void testJpa() {
		for(int i=1; i<=300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.questionService.create(subject, content);
		}
	}

}
