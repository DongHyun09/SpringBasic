package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlectureExam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
	}
}