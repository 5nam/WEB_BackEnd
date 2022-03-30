package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 꼭 적어줘야함.
public class HelloController {

    // index 에서 hello 링크를 클릭하게 되면 아래 메소드를 실행하는 것
    @GetMapping("hello") // get 은 getpost 할 때 get 임. http 의 get
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // templates 에 있는 hello.html 을 리턴하는 것
    }

    @GetMapping("hello-mvc") // 파라미터를 받을 것
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name); // key, name 순서
        return "hello-template";
    }

    @GetMapping("hello-string")
    // ResponseBody 의 의미는 http 에서 헤더부와 바디부가 있는데(통신 프로토콜 관점), 바디부에 이 데이터를 직접 넣어주겠다는 의미
    @ResponseBody // 매우 중요한 추가 코드!
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // spring 이라고 name 넣으면 : "hello spring" 이 될 것.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // 코드 완성할 때, ctrl+shift+enter 하면 채워질 수 있는 것이 자동으로 채워짐.
        hello.setName(name);
        return hello;
    }


    static class Hello { // 클래스 안에서 또 클래스 만들기 가능
        private String name;

        // ctrl+n 을 이용해서 getter, setter 을 만들기
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
