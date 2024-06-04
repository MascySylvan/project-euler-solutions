package com.solutions.set2;

public class Problem17 {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        int i = 1000;
        
        int sum = 0;
        for (int k = 1; k <= i; k++) {
            sum += numberToWords(k).replace("_", "").length();
        }

        System.out.println("1 to " + i + " yields " + sum + " letters.");
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        if (num < 10) {
            return units[num];
        }

        if (num < 20) {
            return teens[num - 10];
        }

        if (num < 100) {
            return tens[num / 10] + (num % 10 == 0 ? "" : " " + units[num % 10]);
        }

        if (num < 1000) {
            return units[num / 100] + " Hundred" + (num % 100 == 0 ? "" : " " + numberToWords(num % 100));
        }

        if (num == 1000) {
            return "One Thousand";
        }

        return "Number out of range";
    }
    
}
