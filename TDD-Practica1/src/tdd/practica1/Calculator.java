package tdd.practica1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JordanO
 */
    public class Calculator implements BasicCalculator{
    
 
    
    public Calculator(){
        
    }
    
    @Override
    public int add(int arg1, int arg2){  
       int result =  arg1 + arg2;
       return result;
    }
    @Override
    public int substract (int arg1, int arg2){
        int result =  arg1 - arg2;
        return result;
    }
   
    
}
