package com.Practise;

import java.util.Arrays;

public class Virtusa2025 {


    public static void main(String[] args) {

        /*
        *

        arr[]  = {1,2,3,4,5}
        outputArr[] = {5,1,2,3,4}
		0 %5 +1   1
		1 %5 +1
		2%5+1

	for(int i=0;i<arr.length;i++){

		int temp=arr[i];
		arr[i+1] = temp;
	}
        * */

        int arr[]  = {1,2,3,4,5};
        int temp=arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--) {
                arr[i] =arr[i-1];
//            System.out.println((i%arr.length-1)+1);
     //       int temp= (i%arr.length-1)+1;
//            arr[i-1]=arr[(i%arr.length-1)+1];
//            arr[(i%arr.length-1)+1] =temp;
        }
        arr[0] =temp;
        System.out.println(Arrays.toString(arr));
        //
        // outputArr[] = {5,1,2,3,4}

        /*
        *
        *
        *
        *
	String comparison, two parameter str11 str2



	return if equal without using inbuilt function


	@Test

	Service service;

	test(){
		boolean flag= service.compareString(“rish”,”rish”)
		Assert.equals(flag, true);


	}


	public  boolean compareString(String s1, String s2){
		if(s1==null && s2==null)
			return true;

		if(s1==null || s2==null)
			return false;

		char []  ch2= s2.toCharArray();
 		char []  ch1=  s1.toCharArray();

		if(ch2.length!=ch1.length)
			return false;
		else{
			for(int i=0;i<ch1.length;i++){
				if(ch1[i]!=ch2[i])
					return false;
			}
		}
		return true;
	} */
    }
}
