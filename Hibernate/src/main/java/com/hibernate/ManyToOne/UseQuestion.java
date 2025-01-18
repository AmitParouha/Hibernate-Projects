package com.hibernate.ManyToOne;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseQuestion {

	public static void main(String... strings) {

		ApplicationContext context = new AnnotationConfigApplicationContext(config.class);

		QuestionService service = context.getBean("service", QuestionService.class);

//		Question question = context.getBean("question", Question.class);
//		question.setId(1);
//		question.setQuestion("What is Java ?");
//
//		Answer answer1 = context.getBean("answer", Answer.class);
//		answer1.setA_id(101);
//		answer1.setAnswer("Java is an Object oriented programming.");
//
//		Answer answer2 = context.getBean("answer", Answer.class);
//		answer2.setA_id(102);
//		answer2.setAnswer("Java is a multithreded language.");
//
//		Answer answer3 = context.getBean("answer", Answer.class);
//		answer3.setA_id(103);
//		answer3.setAnswer("Java is a Plateform independent language.");
//
//		List<Answer> answer = new ArrayList<Answer>();
//		answer.add(answer1);
//		answer.add(answer2);
//		answer.add(answer3);
//
//		question.setAnswer(answer);
//		answer1.setQuestion(question);
//		answer2.setQuestion(question);
//		answer3.setQuestion(question);
//
//		service.saveQuestion(question);
//		service.saveAnswer(answer1);
//		service.saveAnswer(answer2);
//		service.saveAnswer(answer3);

		// Note :- Question is an Parent table and Answer is a child table
		System.out.println("______________________________________________");

		Question question = service.getQuestion(1);
		System.out.println("Q. " + question.getId());
		System.out.println(question.getQuestion());
		List<Answer> answer = question.getAnswer();
		for (Answer ans : answer) {
			System.out.println(ans.getAnswer());
		}
	}
}
