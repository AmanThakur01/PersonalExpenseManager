package com.mycompany.pem.util;
import com.mycompany.pem.domain.Budget;

/**
 * This method return the sum of all category of expenses amount  
 * @author amanm return total amount of budget
 */
public class TotalAmount {
    public static Budget addAmount(Budget b){
        Integer sum = b.getBills()+b.getFood()+b.getMiscellaneous()+b.getPersonalCare()+b.getRent()+b.getTransportational();
        b.setAmount(sum);
        return b;
    }
}
