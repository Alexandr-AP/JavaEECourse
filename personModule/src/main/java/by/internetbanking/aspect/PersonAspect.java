package by.internetbanking.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class PersonAspect {
    final static Logger logger = Logger.getLogger(PersonAspect.class);

    public static void main(String[] args) {

//        logger.fatal("FATAL MESSAGE! FATALITI!!!!");
//        logger.error("Error MESSAGE! ERORITI!!!!");
//        logger.warn("warn MESSAGE! warn!!!!");
//        logger.info("info MESSAGE! info!!!!");
//        logger.debug("debug MESSAGE! debug!!!!");
//        logger.trace("trace MESSAGE! trace!!!!");

        try {
            int c = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        try {
            String s = null;
            if (s.length() > 0) {
                System.out.println("gggg");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("1" + e.toString() + "1");
            logger.error("2" + e.getMessage() + "2");
            logger.error("3" + Arrays.asList(e.getStackTrace()) + "3");
        }
    }


    //  ("execution(* *.*(..))")
    @Before("execution(* by.internetbanking.service.PersonService.createPerson(..))")
    public void doSomethingBefore(JoinPoint joinPoint) {
        try {
            Object[] args = joinPoint.getArgs();
            //int id = (int)args[0];
            String name = (String) args[0];
            int age = (int)args[1];

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Try to Create new Person");
    }

    @After("execution(* by.internetbanking.service.PersonService.createPerson(..))")
    public void doSomethingAfter() {
        logger.info("Person has been created successfully");
    }

    @After("execution(* by.internetbanking.service.PersonService.updatePerson(..))")
    public void doSomethingAfterUpdate() {
        logger.info("Person has been updated successfully");
    }

    @Around("execution(* by.internetbanking.service.PersonService.createPerson(..))")
    public void doSomethingAround(ProceedingJoinPoint joinPoint) {
        logger.info("BEGIN CREATE");
        try {
            System.out.println("gh");
            joinPoint.proceed();
            System.out.println("111");
            logger.info("FINISH CREATE");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error("FAIL CREATE");
        }
    }


}
