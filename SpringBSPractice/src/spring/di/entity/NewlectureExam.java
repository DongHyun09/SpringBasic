package spring.di.entity;

import org.springframework.beans.factory.annotation.Value;

public class NewlectureExam implements Exam {
	
	@Value("10")
	public int kor;
	@Value("20")
	public int math;
	public int com;
	public int eng;
	
	
	public NewlectureExam() {

	}
	
	public NewlectureExam(int kor, int math, int com, int eng) {
		this.kor = kor;
		this.math = math;
		this.com = com;
		this.eng = eng;
	}


	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}


	@Override
	public int total() {
		return kor+math+com+eng;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}

	@Override
	public String toString() {
		return "NewlectureExam [kor=" + kor + ", math=" + math + ", com=" + com + ", eng=" + eng + "]";
	}

}
