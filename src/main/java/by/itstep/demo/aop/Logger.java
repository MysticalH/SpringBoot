package by.itstep.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Logger {

    @Around("execution(* *(..)) && within (by.itstep..*)")

    public Object test (ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(joinPoint.getSignature().getName());
        for (Object o: joinPoint.getArgs())
            System.out.println(o);
        Object result = joinPoint.proceed(joinPoint.getArgs());
        System.out.println("result:" + result);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
        return result;

    }


}

//логирование
//проверка прав доступа
