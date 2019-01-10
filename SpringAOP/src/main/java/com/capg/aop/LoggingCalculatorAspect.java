package com.capg.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingCalculatorAspect {
	private Logger logger = Logger.getLogger(LoggingCalculatorAspect.class.getName());

	@Before("execution(* com.capg.calculator.Calculator.*(..))")
	public void log1() {
		logger.info("Before-logging the method");
	}

	/*
	 * @After("execution(* com.capg.calculator.Calculator.*(..))") public void
	 * log2() { logger.info("After-logging the method"); }
	 */

	@Around("execution(* com.capg.calculator.Calculator.*(..))")
	public void log3(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before-logging the method");
		pjp.proceed();
		logger.info("FUNCTION: " + pjp.toString());
		Object args[] = pjp.getArgs();
		for (int i = 0; i < args.length; i++) {
			logger.info(+i + 1 + "ARGUMENT OF FUNCTION IS " + args[i]);
		}

		logger.info("After-logging the method");
	}

	@AfterReturning(pointcut = "execution(* com.capg.calculator.Calculator.*(..))", returning = "retVal")
	public void log4(JoinPoint jp, Object retVal) {
		{
			// System.out.println("Method Signature: " +jp.getSignature());
			System.out.println("Returning:" + retVal.toString());
		}
	}

}
