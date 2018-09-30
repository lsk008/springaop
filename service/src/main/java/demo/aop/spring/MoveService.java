package demo.aop.spring;

import org.springframework.stereotype.Service;

@Service
public class MoveService {
    public void run(){
        System.out.println("我在跑步");
    }
    public void swin(){
        System.out.println("我在游泳");
    }
}


