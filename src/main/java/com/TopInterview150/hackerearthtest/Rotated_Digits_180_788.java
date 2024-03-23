package com.TopInterview150.hackerearthtest;

public class Rotated_Digits_180_788 {
    public static void main(String[] args) {
    //   System.out.println( new Rotated_Digits_180_788().rotatedDigits(20));
        System.out.println(  new Rotated_Digits_180_788().rotatedDigit(10));
    }
    public int rotatedDigits(int n) {
        int[] arr=new int[n+1];
        int count=0;

        for(int i=0;i<=n;i++) {
            if (i <= 9) {
                if ((i == 0) || (i == 1) || (i == 8)) {
                    arr[i] = 0;
                } else if ((i == 2) || (i == 5) || (i == 6) || (i == 9)) {
                    arr[i] = 1;
                    count++;
                } else {
                    arr[i] = -1;
                }

            } else {
                int u = i % 10;
                int t = i / 10;

                if ((arr[u] == 0 && arr[t] == 1) || (arr[u] == 1 && arr[t] == 0)) {
                    arr[i] = 1;
                    count++;
                } else if (arr[u] == -1 || arr[t] == -1) {
                    arr[i] = -1;
                } else if (arr[u] == 0 && arr[t] == 0) {
                    arr[i] = 0;
                } else {
                    arr[i] = 1;
                    count++;
                }
            }

        }


        return count;
    }

    //-----------------------------------------------------------------------------
    //https://github.com/awangdev/leet-code/blob/master/Java/788.%20Rotated%20Digits.java
    public int rotatedDigit(int N) {

        int start = 1;
        int count = 0;
        while (start++ < N) {
            count += validate(freq(start)) ? 1 : 0;
        }
        return count;
    }

    private int[] freq(int num) {
        int[] count = new int[10];
        while (num != 0) {
            count[num%10]++;
            num /= 10;
        }
        return count;
    }
    private boolean validate(int[] count) {
        int failure = count[3] + + count[4] + count[7];
        if (failure != 0) return false;
        int success = count[2] + + count[5] + count[6] + count[9];
        return success != 0;
    }


}
