package spring.di.entity;
//�⺻������ �����͸� �����ִ�.
//1. 4���� ������ �����.
//2. �����ʹ� private���� �д�.
//3. ��ȯ�� total�� avg���� �����.
//4. total�� ��� avg�� �Ҽ������� ��ȯ�ؾ� �ϱ⶧���� float�Լ��� ����. 
//5. �̷��� Exam.java���� ����(���⼭ �ʱ⿡ int avg�� �������) �������̽��� �����ʾƼ�, �������̽��� float���� �ٲ���Ѵ�.

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
