/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd.practica1;

/**
 *
 * @author JordanO
 */
public class Validator {
    
    private int minValue,maxValue;
    
    public Validator(int minValue,int maxValue){
        this.minValue=minValue;
        this.maxValue=maxValue;
    }
     public void validateArguments(int arg1, int arg2){
        breakIfOverflow(arg1,"Primer argumento excede el limite numerico");
        breakIfOverflow(arg2,"Segundo argumento excede el limite numerico");
        
    }
    public void validateResult(int result){
        breakIfOverflow(result, "Resultado excede Limite.");
    }
    private void breakIfOverflow(int arg, String msj){
        if(valueExceedLimits(arg)){
          throw new OverflowException(msj);
        }
    }
    public boolean valueExceedLimits(int arg){
        if(arg>maxValue)return true;
        if(arg<minValue)return true;
        
        return false;
    }
    public void setUpperLimit(int maxValue){
        this.maxValue=maxValue;
    }
    public int getUpperLimit(){
        return maxValue;
    }
    public void setLowerLimit(int minValue){
        this.minValue=minValue;
    }
    public int getLowerLimit(){
        return minValue;
    }
}
