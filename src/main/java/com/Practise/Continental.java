package com.Practise;

//TODO all un-solved

public class Continental {

    //This is a Dibyendu@Kumar.
    //Ramuk@Dibyendu a is Siht.
    public static void main(String[] args) {
        //String input = "Input This is a Dibyendu@Kumar.";
        //reverse(input);
        toBinary(30.00);

    }

    private static void reverse(String input) {
       /* String[] str = input.split(" ");
        StringBuilder[] finalStr;
        int j=0;
        for(int i=str.length-1; i>0;i--)
        {
            finalStr[j]=" "+str[i];
            j++;
            System.out.println(finalStr[j]);
        }
*/
    }

    private static void toBinary(Double input) {
        int n =input.intValue();
        int[] binary = new int[1000];
        int i =0;
        while (n>0)
        {
            binary[i]= n%2;
            n = n/2;
            i++;
        }

        for(int j =i-1; j >0; j++)
        {
            System.out.println(binary[j]);
        }

    }


}
