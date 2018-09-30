package demo.aop.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableRetry
public class ParentApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(ParentApplication.class, args);
        MoveService moveService =(MoveService) context.getBean("moveService");
        System.out.println();
        moveService.run();
    }
}
