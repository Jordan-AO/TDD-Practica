package CalculadoraTDDTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tdd.practica1.CalcProxy;
import tdd.practica1.Calculator;
import tdd.practica1.OverflowException;
import tdd.practica1.Validator;

/**
 *
 * @author JordanO
 */
public class CalcProxyTest {
    
    private Calculator _calculator;
    private CalcProxy _calcProxy;
    private Validator _validator;
    public CalcProxyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       _validator = new Validator(-100,100);
       _calculator = new Calculator();
       _calcProxy = new CalcProxy(_calculator,_validator);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void add(){
       int result=0;
        try {
            result = _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("add", int.class,int.class),2,2);
        } catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("Error en test add: "+ex);
            System.out.println(ex.getCause());
        } 
       assertEquals(4,result);
    }
    @Test
    public void addWithDifferentArguments(){
          int result=0;
        try {
            result = _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("add", int.class,int.class),4,3);
        } catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("Error en test addWithDifferentArguments: "+ex);
        } 
       assertEquals(7,result);
    }
    @Test 
    public void substractTest(){
        int result=0;
        try{
        result = _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("substract", int.class,int.class),2,2);
        }catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("Error en test substract: "+ex);
        }
        assertEquals(0,result);
    }
    @Test
    public void substractReturningNegative(){
        int result=0;
        try{
        result = _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("substract", int.class,int.class),3,5);
        }catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("Error en test substractReturningNegative: "+ex);
        }
        assertEquals(-2 ,result);
    }
    
    @Test(expected = OverflowException.class)
    public void ArgumentsExceedLimits(){
        try{
        _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("add", int.class,int.class),120,110);
        }catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("ArgumentsExceedLimits: "+ex);
        }
    }
      @Test(expected = OverflowException.class)
    public void ArgumentsExceedLimitsInverse(){
        try{
        _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("add", int.class,int.class),-110,-105);
        }catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("ArgumentsExceedLimitsInverse: "+ex);
        }
    }
     @Test(expected = OverflowException.class)
     public void validateResultExceedingLowerLimit(){
        try{
        _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("add", int.class,int.class),-110,-105);
        }catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("validateResultExceedingLower: "+ex);
        }
    }

    @Test(expected = OverflowException.class) 
    public void validateResultExcendigUpperLimit(){
       try{
        _calcProxy.binaryOperation(_calculator.getClass().getDeclaredMethod("add", int.class,int.class),100,10);
        }catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            System.out.println("validateResultExceedingUpper: "+ex);
        }
    }
}