
package com.Practise;

public class Thread1 {


    public static void main(String[] args) {
        int rangeStart = 2253;
        int rangeLast = 2353;
        int isPrime = 2729;
        long start = System.currentTimeMillis();
        for (int i = rangeStart; i < rangeLast; i++) {

            if (i % 2 != 0 && i % 3 != 0 && i % 7 != 0 && i % 11 != 0) {
                isprime(i);
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void isprime(int element) {
        for (int i = 4; i * i < element; i++) {
            if (element % i != 0)
            System.out.println("not prime"+i);
            else
            System.out.println("prime" + element);


        }
    }

}
