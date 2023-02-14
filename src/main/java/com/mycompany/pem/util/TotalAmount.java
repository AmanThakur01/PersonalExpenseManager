package com.mycompany.pem.util;
import com.mycompany.pem.domain.Budget;

/**
 * @author amanm
 */
public class TotalAmount {
    public static Budget addAmount(Budget b){
        Integer sum = b.getBills()+b.getFood()+b.getMiscellaneous()+b.getPersonalCare()+b.getRent()+b.getTransportational();
        b.setAmount(sum);
        return b;
    }
}
