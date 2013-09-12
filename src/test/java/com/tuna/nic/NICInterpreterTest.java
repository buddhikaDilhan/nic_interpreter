package com.tuna.nic;

import static org.testng.Assert.*;
import org.joda.time.DateTime;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.tuna.nic.exception.InvalidNICException;
/**
 *
 * @author Janaka
 */
public class NICInterpreterTest {
    NICInterpreter instance;
    
    public NICInterpreterTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        instance = new NICInterpreter();
    }

    /**
     * Test of interpret method, of class NICInterpreter.
     */
    @Test
    public void testInterpret_1() {
        System.out.println("interpret_1");
        String nicNumber = "911260280V";
        DateTime birth = new DateTime(1991, 5, 5, 0, 0);
        
        NICDetails expResult = new NICDetails(birth, NICDetails.Gender.MALE, true);
        
        NICDetails result = instance.interpret(nicNumber);
        assertEquals(result, expResult);
    }

    /**
     * Check for handling invalid year input
     */
    @Test(expectedExceptions = InvalidNICException.class)
    public void testInterpret_2() {
        System.out.println("interpret_2");
        String nicNumber = "-31260280V";    // negative year
        DateTime birth = new DateTime(1991, 5, 5, 0, 0);
        
        NICDetails expResult = new NICDetails(birth, NICDetails.Gender.MALE, true);
        
        NICDetails result = instance.interpret(nicNumber);
        assertEquals(result, expResult);
    }

    /**
     * Check for handling invalid birth date input
     */
    @Test(expectedExceptions = InvalidNICException.class)
    public void testInterpret_3() {
        System.out.println("interpret_3");
        String nicNumber = "9112a0280V";    // invalid character in number of days
        DateTime birth = new DateTime(1991, 5, 5, 0, 0);
        
        NICDetails expResult = new NICDetails(birth, NICDetails.Gender.MALE, true);
        
        NICDetails result = instance.interpret(nicNumber);
        assertEquals(result, expResult);
    }
}