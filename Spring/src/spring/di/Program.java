package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.ui.ExamConsole;


//1.Exam exam = new NewlecExam(); 형식이 같아야되는데, 둘 사이 관계가 부모자식이면 상관없다.
//2.Exam exam은 단순 부모가 아닌, 인터페이스로서 등록한다. (Exam.java 생성)
//3.new NewlecExam()는 데이터 구현객체가 된다. (구현할 것)
//4.Exam이라는 녀석을 출력해주는 ExamConsole을 추가해준다.
//5. -> 데이터를 가지고 출력하기때문에 exam을 넘겨받는다.

//(Inline 방식)
//6. InlineExamConsole (exam이란 녀석을 콘솔로 출력하는데, 한줄로 출력하는 형태로 만든다.)
//7. 또 하나는 grid 형태로 출력하는것으로 준비한다.
//8. 어쨌거나, ExamConsole console은 print를 담당하는 녀석이라 interface를 추가해서 (ui패키지에 ExamConsole.java)
// void print를 작성.
//9. InlineExamConsole도 interface를 만들어준다.
//10. 자 이제 Inline 방식으로 만든 콘솔 출력을 확인 해보자 
//11. total is 0, avg is 0.000000 이런 결과가 뜬다.

//(Grid 방식)
//12. 위와 같은 방식으로 하되, 결과값만 grid형식으로 나오는 것이다.(격자 형식)
//13. 이 작업이 바로 DI라고 한다.


//14. 위와같은 inline방식에서 grid가 추가되었다고 가정하자,
//15. 여기서, grid방식을 외부설정으로 뺴야된다.
//16. xml을 사용할 때는 지시서 양식에 따라 지시를 해야한다.

//17.일반적으로 console이 setter를 갖고있다.
//18. 바뀌는 녀석은 설정으로 빼는 것이 바람직하다. (결합관계도 바꿔야 됨)
//19. 밑에 코드는 위에서 console.set 과 Exam Console console과의 관계를 분리하겠다는 코드.
//20. 위 코드를 환경설정 setting.xml파일로 빼야된다.
//21. xml 파일에서 class 이름은 패키지의 이름과 반드시 같이 써줘야 추후 작업 때 편하다.
//22. 저렇게 지시를 하게되면 Spring은 이것을 생성해준다.
//23. <property name="exam"></property>에서 exam은 setExam(exam)에서의 exam이 아닌 setExam이다.
//24. <property name="exam" value="" ref=""></property>
// 에서 value와 ref는 setter에 설정할 수 있는 두가지 타입이있다. exam을 설정할 수 있는 객체의 이름을 넣어준다. 
// 위에서의 타입은 reference이다. 따라서  <property name="exam" ref="exam"></property>
// 즉, setExam이라는 setter에 들어가는 형식으로 들어간다고 보면된다.
//25. 지시서로 만든 객체를 만들어서 활용한다.
//26. spring에서 di, 그 지시서를 읽어주고, 생성해주고 조립해주는 구체적인 객체이름은 ApplicationContext context이다. 
//27. ClassPathXmlApplicationContext는 경로를 설정해주는것.
//28. 프로젝트 우클릭 -> configure -> maven 설정 -> pom.xml이 생기는데, 
// dependencies 를 만든 후, maven Repository를 인터넷에 검색후, Spring Context를 검색. 
// 그곳에 있는 것을 복사 한 후, dependencies 안에 dependency를 넣어준다. (버전이 맞아야 돌아간다.)
//29. ApplicationContext 이 지시서를 읽는다. 이 지시서를 잘 읽었다면, 객체를 2개 만들고 , 보따리에 잘 담았을 것이다
//30. 그 보따리가 바로 IoC컨테이너이다.
//31. 컨테이너의 구체적인 이름이 ApplicationContext context의 context이다.
//32. console이라는 녀석을 지시했으니 안에 console을 넣어준다.
//33. 그냥 이름을 가지고 꺼내면 골치 아픈것이, 형식변환을 해야한다.
//34. 오브젝트형이니 ExamConsole이 받을 때 문제가된다. 따라서 
//35. ExamConsole console = (ExamConsole)context.getBean("console"); (ExamConsole)이 들어가야한다.
//36. (1) ExamConsole console = (ExamConsole)context.getBean("console");
//	  (2) ExamConsole console = context.getBean(ExamConsole.class); 2번이 더 선호된다.
public class Program {

	public static void main(String[] args) {
		
//		Exam exam = new NewlecExam();
////		ExamConsole console = new InlineExamConsole(exam);
//		ExamConsole console = new GridExamConsole(exam); //생성자를 통하는 방법
//		
//		console.setExam(exam); // setter를 통하는 방법
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		//이 녀석이 지시서를 읽는다. 이 녀석
		//test1
//		ExamConsole console = (ExamConsole)context.getBean("console");
		ExamConsole console = context.getBean(ExamConsole.class); 
		//이 방식이 더 선호된다.
		console.print();
	}
}