package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

//1. 생성자를 통해서 물려받을 것은 Exam exam.
//2. 오버로드 생성자를 만들어준다.
//3. 우클릭/source/using fields 

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	@Autowired(required = true)
//	@Qualifier("exam2")
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}

	public InlineExamConsole(Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam == null)
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		else
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}
	
}
