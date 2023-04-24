package spring.di.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//기본적으로 데이터를 갖고있다.
//1. 4개의 과목을 만든다.
//2. 데이터는 private으로 둔다.
//3. 반환은 total과 avg별로 만든다.
//4. total의 평균 avg는 소수점으로 반환해야 하기때문에 float함수를 쓴다. 
//5. 이러면 Exam.java에서 만든(여기서 초기에 int avg로 만들었음) 인터페이스가 맞지않아서, 인터페이스도 float으로 바꿔야한다.


//@Component
//@Service도 된다.
public class NewlecExam implements Exam {
	
	@Value("20")
	private int kor;
	@Value("30")
	private int eng;
	private int math;
	private int com;
	
	public NewlecExam() {
		// TODO Auto-generated constructor stub
	}
	
	public NewlecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}


	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
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

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return kor+eng+math+com;
	}

	@Override
	public float avg() {
		// TODO Auto-generated method stub
		return total() / 4.0f;
	}

	@Override
	public String toString() {
		return "NewlecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}

	
}
