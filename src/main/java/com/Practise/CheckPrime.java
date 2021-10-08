package com.Practise;

public class CheckPrime {
    public static void main(String[] args) {
        checkPrime(4);
        checkPrimeInRange(300);
    }

    // a number which has only 2 factors 1 and the number itself
    private static void checkPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i * i < num; i++) {  // since 2 is least prime number

            if (num % i == 0) {
                isPrime = false;
                break;
            }
            if (num < 2)
                isPrime = false;

        }
        System.out.println("Prime" + isPrime);
    }

    private static void checkPrimeInRange(int range) {
        boolean isPrime = true;
        for (int number = 1; number <= range; number++) {

            for (int j = 2; j * j < number; j++) {
                if (number % j == 0) {
                    isPrime = false;
                    continue;
                }
                if (number < 2)
                    isPrime = false;

            }
            if (isPrime) {
                System.out.println(number);
            }
        }


    }
}
