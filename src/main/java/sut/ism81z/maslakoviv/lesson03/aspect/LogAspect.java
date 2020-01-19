package sut.ism81z.maslakoviv.lesson03.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // ловим контекст метода
    @Pointcut("execution(public * sut.ism81z.maslakoviv.lesson03.SocialApplication.user(..))")
    public void catchedAuth() {

    }

    // навешиваем свой обработчик

    @After("catchedAuth()")
    public void afterAuth(JoinPoint jp) {
        System.out.println("\n === Call SocialApplication.user \n");
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        System.out.println("\nLOGGING: \t args: [" +  args + "]\n");

    }

}
