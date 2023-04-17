package spring.di.ui;

import spring.di.entity.Exam;

//1. 생성자를 통해서 물려받을 것은 Exam exam.
//2. 오버로드 생성자를 만들어준다.
//3. 우클릭/source/using fields 
public class InlineExamConsole implements ExamConsole {
	
	private Exam exam;
	
	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}
	
}
