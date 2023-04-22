package spring.di.ui;

import spring.di.entity.Exam;

//setter는 interface가 추가됐다.
public interface ExamConsole {
	void print();

	void setExam(Exam exam);
}
