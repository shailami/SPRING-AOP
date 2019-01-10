package com.capg.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.capg.calculator.Calculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    	ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
    	System.out.println("object");
    	Calculator calc=context.getBean(Calculator.class);
    	calc.add(100, 500);
    }
}
