package com.Practise;

public class Harman2025 {


    public static void main(String[] args) {
        Vehicle twoWheeler= new TwoWheler();
        twoWheeler.drive(23);

        Vehicle vehicle = new Vehicle();
        vehicle.drive(34);



        //reverseString
        reverseString("Rishabh");


    }

    static void reverseString(String name){
        int start=0,end = name.length()-1;
        int mid = (start+end) /2;
        char []charArray=name.toCharArray();
        while(start<mid){
            char tempChar= charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tempChar;
            start++;
            end--;
        }
    System.out.println(new String(charArray));
    }
}




class Vehicle{
        void drive(int km){
            System.out.println(km+" vehicle run");
        }
}


class TwoWheler extends Vehicle{
    @Override
    void drive(int km){
        System.out.println(km+" two wheeler run");
    }
}


//cyclic inheritence a> b b> c c> a
//class c extends a{
//}
//class b extends c{
//}
//class a extends b{
//}


//diamond problem
//       A
//      / \
//     B   C
//      \ /
//       D