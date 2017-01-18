/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraTDDTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tdd.practica1.OverflowException;
import tdd.practica1.Validator;

/**
 *
 * @author JordanO
 */
public class ValidatorTest {
    private Validator _validator;
    public ValidatorTest() {
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
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
    public void setAndGetUpperLimit(){
        
        assertEquals(100,_validator.getUpperLimit());
        assertEquals(-100,_validator.getLowerLimit());
    }
        @Test(expected = OverflowException.class)
    public void ArgumentsExceedLimits(){
        _validator.validateArguments(_validator.getLowerLimit()-1, _validator.getUpperLimit()+1);
    }
    @Test(expected = OverflowException.class)
    public void ArgumentsExceedLimitsInverse(){
        _validator.validateArguments(_validator.getUpperLimit()+1, _validator.getLowerLimit()-1);
    }
}
