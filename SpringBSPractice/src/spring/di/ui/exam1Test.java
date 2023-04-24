package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component
public class exam1Test implements ExamConsole {
	
	@Autowired
	private Exam exam;
	
	public exam1Test() {
		// TODO Auto-generated constructor stub
	}
	
	public exam1Test(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n",exam.total(), exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
