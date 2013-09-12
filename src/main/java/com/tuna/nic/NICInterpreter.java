package com.tuna.nic;

import com.tuna.nic.exception.InvalidNICException;
import org.joda.time.DateTime;

/**
 * given the NIC number, returns personal details in a NICDetails wrapper
 */
public class NICInterpreter {
    public NICDetails interpret(String nicNumber) {
        try {
            int year = Integer.parseInt(nicNumber.substring(0, 2)) + 1900;
            NICDetails.Gender gender;
            if(year > 2013 || year < 1900)
                throw new InvalidNICException("Please re-check the first 2 digits.");
            
            int birthDate = Integer.parseInt(nicNumber.substring(2, 5));
            if(birthDate >= 500) {   //female
                gender = NICDetails.Gender.FEMALE;
                birthDate -= 500;
            }
            else
                gender = NICDetails.Gender.MALE;
            
            DateTime birthday = new DateTime(year, 1, 1, 0, 0);
            birthday = birthday.plusDays(birthDate - 2);
            
            if(birthday.getYear() > year)  //date field exceeds max limit
                throw new InvalidNICException("Please re-check digits 3 to 5." + birthday.getYear() + " " + birthDate);
            
            DateTime backwards = new DateTime();
            backwards.minusYears(-18);
            //age >= 18 years iff backwards >= birthday
            boolean voter = (backwards.compareTo(birthday) >= 0);
            
            NICDetails result = new NICDetails(birthday, gender, voter);
            return result;
        }
        catch(InvalidNICException ine) {
            throw ine;
        }
        catch(RuntimeException re) {
            throw new InvalidNICException("Please re-check your NIC number.");
        }
    }
}
