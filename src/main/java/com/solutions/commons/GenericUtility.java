package com.solutions.commons;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class GenericUtility {
	
	public static boolean isPrime(long n) {
		if (n <= 1) {
            return false;
        }
        for (long i = 2; i <= n / 2; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
	}

	public static List<Long> getFactors(long n) {
		List<Long> factors = new ArrayList<>();
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }

		return factors;
	}

	public static List<Long> getUniqueFactors(long n) {
		return new LinkedList<>(new LinkedHashSet<>(getFactors(n)));
	}

	public static List<Long> getPrimeFactors(long n) {
		List<Long> primeFactors = new LinkedList<>();
		List<Long> factors = getUniqueFactors(n);

		for (int i = 0; i < factors.size(); i++) {
			if (isPrime(factors.get(i))) {
				primeFactors.add(factors.get(i));
			}
		}

		return primeFactors;
	}

	public static boolean isPerfectSquare(int n) {
		
		for (int i = n/2; i > 0; i--) {
			int tempSquare = i * i;
			
			if (tempSquare == n) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isPythTriple(int a, int b, int c) {
		return raiseToThePower(a, 2).add(raiseToThePower(b, 2)) == raiseToThePower(c, 2);
	}
	
	public static BigInteger raiseToThePower(long base, long exp) {
		BigInteger a = BigInteger.valueOf(1);
		
		for (long i = 0; i < exp; i++) {
			a = a.multiply(BigInteger.valueOf(base));
		}
		
		return a;
	}

	public static long collatz(long temp) {
		long num = 1;

		if (temp % 2 == 0) { //even
			num = temp / 2;
		} else { //odd
			num = (3 * temp) + 1;
		}

		return num;
	}

	public static BigInteger factorial(long num) {
		BigInteger n = new BigInteger("1");

		for (long i = 1; i <= num; i++) {
			n = n.multiply(BigInteger.valueOf(i));
		}

		return n;
	}
}
