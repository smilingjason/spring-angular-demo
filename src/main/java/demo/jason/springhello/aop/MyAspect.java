package demo.jason.springhello.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect

public class MyAspect {
	
	@Before("execution(* demo.jason.springhello.ArrayController.*(..))")
	public void aopBefore() {
		System.out.println("---- before called");
	}
}
