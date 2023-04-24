package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

//이것이 xml 설정파일과 완벽하게 일치한다.
@ComponentScan("spring.di.ui")
@Configuration
public class NewlecDIConfig {
	
	@Bean
	public Exam exam() {
		return new NewlecExam();
	}
}
