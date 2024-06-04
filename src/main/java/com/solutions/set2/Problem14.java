package com.solutions.set2;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solutions.commons.GenericUtility;

public class Problem14 {

    public static void main(String[] args) throws JsonProcessingException {
        long chainNumber = 0;
        long chainStart = 0;
        Map<Long, Long> calculated = new HashMap<>();

        for (long i = 500000; i <= 1000000; i++) {

            System.out.println(i);

            long temp = i;
            long chainCtr = 1;

            while (true) {
                if (calculated.containsKey(temp)) {
                    chainCtr += calculated.get(temp) - 1;

                    if (chainCtr >= chainNumber) {
                        chainNumber = chainCtr;
                        chainStart = i;
                    }

                    calculated.put(i, chainCtr);

                    break;
                } else {
                    if (temp != 1) {
                        temp = GenericUtility.collatz(temp);
                        chainCtr++;
                    } else {
                        if (chainCtr >= chainNumber) {
                            chainNumber = chainCtr;
                            chainStart = i;
                        }

                        calculated.put(i, chainCtr);
    
                        break;
                    }
                }
            }

        }

        System.out.println(chainStart + " produces the longest Collatz Sequence with " + chainNumber + " chains!");


    }
    
}
