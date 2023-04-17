package spring.di.entity;
//기본적으로 데이터를 갖고있다.
//1. 4개의 과목을 만든다.
//2. 데이터는 private으로 둔다.
//3. 반환은 total과 avg별로 만든다.
//4. total의 평균 avg는 소수점으로 반환해야 하기때문에 float함수를 쓴다. 
//5. 이러면 Exam.java에서 만든(여기서 초기에 int avg로 만들었음) 인터페이스가 맞지않아서, 인터페이스도 float으로 바꿔야한다.

public class NewlecExam implements Exam {
	
	private int kor; 
	private int eng;
	private int math;
	private int com;
	
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

}
