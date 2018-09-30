package demo.aop.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
// 控制多个Aspect的执行顺序，越小越先执行
@Order(-99)
@Component
public class MoveAdvice {

    @Pointcut(value="execution(* demo.aop.spring.MoveService.run())")
    public void poincut(){

    }

    @Before("execution(* demo.aop.spring.MoveService.run())")
    public void beforeRun() {
        System.out.println("跑步之前要跳一跳");
    }

    @After("execution(* demo.aop.spring.MoveService.run())")
    public void afterRun() {
        System.out.println("跑步之后要休息了");
    }

    @Around("execution(* demo.aop.spring.MoveService.run())")
    public void aroudRun(JoinPoint joinPoint) {
        System.out.println("跑步过程中要专心");
        Object object=((ProceedingJoinPoint)joinPoint).proceed();
    }
    @AfterReturning("execution(* demo.aop.spring.MoveService.run())")
    public void afterReturningRun() {
        System.out.println("跑步要总结一下");
    }



    @AfterThrowing("execution(* demo.aop.spring.MoveService.run())")
    public void afterThrowingTest() {
        System.out.println("跑步出故障了");
    }



}




