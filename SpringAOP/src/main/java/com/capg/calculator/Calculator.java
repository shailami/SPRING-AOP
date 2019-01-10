package com.capg.calculator;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

	public Integer add(int num1,int num2)
	{
		return num1+num2;
	}
}
