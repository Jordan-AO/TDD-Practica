/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd.practica1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author JordanO
 */
public class CalcProxy {
    
     private Calculator _calculator;
     private Validator _validator;
     
     public CalcProxy(Calculator _calculator,Validator _validator){
         this._calculator = _calculator;
         this._validator = _validator;
     }
     
     public int binaryOperation(Method method,int arg1, int arg2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        _validator.validateArguments(arg1, arg2);
         int result = 0;
        Method[] allMethod = _calculator.getClass().getMethods();
        for(Method m : allMethod){
            if(m.equals(method)){
                result = (int)m.invoke(_calculator, arg1,arg2);   
            }
        }
        _validator.validateResult(result);
         return result;
     }
}
