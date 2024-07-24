package com.alpha.carController;

public class ArmstrongNumber {

    public static int power(int m, int n) {
        int power = 1;
        for (int i = 1; i <= n; i++) {
            power *= m;
        }
        return power;
    }

    public static int count(int c) {
        int digit = 0;
        while (c != 0) {
            digit++;
            c = c / 10;
        }
        return digit;
    }

    public static void main(String[] args) {
        int n = 1634;

        int temp = n;

        int sum = 0;

        int digit = count(n);

        while (temp != 0) {
            int last = temp % 10; 
            sum = sum + power(last, digit);
            temp = temp / 10;
        }

        if (sum == n) {
            System.out.println("This is an Armstrong number");
        } else {
            System.out.println("This is not an Armstrong number");
        }
    }
}
