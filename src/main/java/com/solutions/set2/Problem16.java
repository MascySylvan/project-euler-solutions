package com.solutions.set2;

import java.math.BigInteger;

import com.solutions.commons.GenericUtility;

public class Problem16 {

    public static void main(String[] args) {
		long exp = 1000;

        BigInteger totalValue = GenericUtility.raiseToThePower(2, exp);

        System.out.println("Total Value: " + totalValue);

        String totalValueString = totalValue.toString();
        long totalSum = 0;
        for (int i = 0; i < totalValueString.length(); i++) {
            totalSum += Character.getNumericValue(totalValueString.charAt(i));
        }

        System.out.println("Total Sum: " + totalSum);
    }
    
}
