package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
		/*
		 class 를 넣어주면, springbootapplication 이 실행이 됨.
		 tomcat 이랑 웹 서버를 내장하고 있어서 같이 올라오는 것.
		*/
	}

}
