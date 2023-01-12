/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pem.util;

import com.mycompany.pem.command.BudgetCommand;
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
