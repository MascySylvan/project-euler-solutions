package com.solutions.set2;

import java.math.BigInteger;

import com.solutions.commons.GenericUtility;

public class Problem15 {

    public static void main(String[] args) {
		long grid = 20;

        BigInteger ways = (GenericUtility.factorial(grid * 2)).divide(GenericUtility.factorial(grid).multiply(GenericUtility.factorial(grid)));

        System.out.println("For " + grid + " x " + grid + ", there are " + ways + " ways.");
    }
    
}
