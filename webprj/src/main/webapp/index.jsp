<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
---(4.22)---

1. 스프링이라는 놈은 MVC를 지원한다. Dispatcher는 중간매개의 역할을 한다.
사용자 입력을 쉽게 Controller에 준다면, Controller에서 Dispatcher에게 View를 언급하게 되면
Dispatcher에서 참조하여 정상적으로 View에 전달해준다.

2.Dispatcher에 모든 URL의 요청이 오게된다. 이를 알맞는 Controller에 배분을 해야된다.
이를 위해서는 설정파일이 필요하다. -servlet.xml <url-mapping> 
servlet관련은 다 Dispatcher.

3.Controller는 반환할때 model과 view를 Dispatcher에 전달하게 되면, 
  이를 Dispatcher가 요청하면서 view를 찾아 이곳에서, 관련 데이터를 요청하게 된다.

### 실습 환경설정 (1~3강)
1. maven prj 만들기
2. tomcat의 WEB-INF파일을 통째로 webapp에 복붙해넣자.
3. pom.xml에 컴파일러 1.8을 따라쓰니, project xmlns 첫번째 줄에서 오류가 남. 
4. tomcat dependency도 추가해주기 (버전에 맞게)
 
<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.2.2</version>
			</plugin>		
		</plugins>
	</build>
pom.xml에 이런 빌드를 추가.

했더니 이번엔 jsp에서 error가 난다.
server runtime enviroments에 톰캣을 추가해주고, java build path 라이브러리에 
tomcat 추가해주니 없어졌다.

이후로 포트 번호 변경.
web browser도 그냥 chrome으로 변경하는게 편하겠다. 


### Spring Dispatcher를 front 컨트롤러로 설정하기, Dispatcher-servlet.xml (4강~5강)

1. Spring mvc dependency를 불러온다.
2. prj 라이브러리의 maven dependencies -> springframework에서 DispatcherServlet.class
   -> 오른쪽 클릭 Copy Qualified name 클릭 -> web.xml로 이동
3. indexController class를 만들어준다. 
	 ->여기서 DispatcherServlet이 servlet역할을 할것이다.
4. 남이 만든 servlet을 설정할때는 xml을 이용해서 설정할수 밖에 없다.


<servlet>
	<servlet-name>dispatcher</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>dispatcher</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>

주의할점은, 패키지명과 클래스명을 복사하는데, 확장자까지 붙게되는데, class를 지워줘야 된다.
servlet-name은 어떻게 지어도 상관이없다.
servlet-mapping은 사용을 요청할수있는 주소이다. 
mapping하기 위한 url은 / 이놈이 받겠다고 설정하는 것.

이렇게하면 servlet 설정은 끝났다.

5. 이제 실행해보는데 HI가 출력되면 안된다. 
Front Controller는 모든 url을 받아들이는것이다. 
/ 이놈은 다 통과가 되는 것이다.
근데 여기서 Dipsatcher의 허락 하에 반환되도록 하게 설정해줘야 한다.
그것이 <url-pattern>/*</url-pattern>
mapping 정보를 갖고있어야만 반환이 된다.

자, 이 mapping 정보를 넣기 위해 servlet.xml을 만들어야 한다.
여기서 *-servlet.xml의 형태의 파일을 만든다.
*-servlet에서 *은 servlet-name이고, servlet은 정해진 이름이다.


### IndexController 작성하기 (6강)

1. servlet.xml에는 spring이 사용할수있는 설정들을 담는다.
어떤 구문으로, 어떻게, 무엇을 작성할 수 있는지 우리는 알수없다.
이 레퍼런스를 가봐야 알수있다.
사이트는 
https://docs.spring.io/spring-framework/docs/
버전에 맞게 들어가서, 스프링프레임워크 레퍼런스 들어가기 -> 홈페이지 좌측에 IoC컨테이너에서 xml ex 코드를 긁어서 복붙
그냥 기존 eclipse에서 쓰던거 가져옴
자, 이제 객체화 작업을 위해 bean을 써주는데, id에 url 요청을 위해 /index를 기입.
<bean id="/index" class="com.newlecture.web.controller.IndexController">

</bean>
	
bean이라는 형태로 만들어놓으면 컨테이너에 담긴다.
POJO형식으로 만들어놓은 컨테이너 안의 컨트롤러들이 있다고 예를 들어보자.
/index 요청을 했다고했을때, AController, BController와 같은 껍데기가 아닌, 
요청을 수반할수있는 함수를 갖고있어야되는데 그 함수명이 "handleRequest"이다.

그렇게 IndexController.java 생성.
아니 대체 왜 IndexController 오류가 ?@$@!$!#%#@$!@#!$#!$@#%$(^$_)(#$)_#@*($!_@)+
package 에서부터 죄 다 오류줄. 
jakarata는 쓰지도않는데 이게 왜 import가 되는지 ? 
왜 javax는 import가 안되는지 ? 


 --> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hi ${data }</h1>
</body>
</html>