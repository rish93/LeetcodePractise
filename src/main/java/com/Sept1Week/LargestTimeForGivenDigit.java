package com.Sept1Week;

import java.util.Arrays;
import java.util.Collections;

public class LargestTimeForGivenDigit {

    public static void main(String []args){
        Solution solution= new Solution();
        Integer arr[]= new Integer[]{1,2,3,4};
        int arr1[]= new int[]{0,0,1,0};
        int arr2[]= new int[]{5,5,5,5};

        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        //   String result =getLargest(arr);

//         System.out.println(solution.largestTimeFromDigits(arr));
//         System.out.println(solution.largestTimeFromDigits(arr1));
//         System.out.println(solution.largestTimeFromDigits(arr2));
//        solution.largestTimeFromDigits(arr);
    }


    public static String getLargest(Integer []A){
        Arrays.sort(A,Collections.reverseOrder());
       // System.out.println( Arrays.asList(arr).toArray());
        String result = null;
        if(A.length==4) {
            int hh=-1 ,h=-1 ,mm =-1,m=-1;


            for(int i=0;i< A.length;i++)
            {
                //setting hh
                if(hh==-1) {
                    if (A[i] == 2) {
                        hh = 2;
                    } else if (A[i] == 1) {
                        hh = 1;
                    } else if (A[i] == 0) {
                        hh = 0;
                    }
                }
            }
            //setting h

            for(int i=0;i< A.length;i++)
            {
                if(h==-1 && hh!=A[i]) {
                    if (A[i] == 3) {
                        h = 3;
                    }
                    else if (A[i] == 2) {
                        h = 2;
                    } else if (A[i] == 1) {
                        hh = 1;
                    } else if (A[i] == 0) {
                        hh = 0;
                    }
                }

            }

            for(int i=0;i< A.length;i++) {
                if (mm == -1 && hh != A[i] && h != A[i]) {
                    if (A[i] == 5) {
                        mm = 5;
                    } else if (A[i] == 4) {
                        mm = 4;
                    } else if (A[i] == 3) {
                        mm = 3;
                    } else if (A[i] == 2) {
                        mm = 2;
                    } else if (A[i] == 1) {
                        mm = 1;
                    } else if (A[i] == 0) {
                        mm = 0;
                    }
                }
            }


            //setting m
            for(int i=0;i< A.length;i++) {
                if (m == -1 && hh != A[i] && h != A[i] && mm != A[i]) {
                    if (A[i] == 9) {
                        m = 9;
                    } else if (A[i] == 8) {
                        m = 8;
                    } else if (A[i] == 7) {
                        m = 7;
                    } else if (A[i] == 6) {
                        m = 5;
                    } else if (A[i] == 5) {
                        m = 5;
                    } else if (A[i] == 4) {
                        m = 4;
                    } else if (A[i] == 3) {
                        m = 3;
                    } else if (A[i] == 2) {
                        m = 2;
                    } else if (A[i] == 1) {
                        m = 1;
                    } else if (A[i] == 0) {
                        m = 0;
                    }
                }
            }






            result= hh+""+h+":"+mm+""+m;
        }

        return result;
    }

}

class Solution {
    String temp ="";
    public String largestTimeFromDigits(int[] A) {
     String temp;
      temp=this.temp;

        if(A[0]==2 || A[1]==2 || A[2]==2 || A[3]==2) {
            temp=temp+"2";
        }
        else if(A[0]==1 || A[1]==1 || A[2]==1 || A[3]==1) {
            temp=temp+"1";
        }
        else if(A[0]==5 && A[1]==5 || A[2]==5 || A[3]==5)
            return "";
        else if(A[0] == A[1] && A[1] == A[2] &&  A[1] == A[3])
            return A[0]+""+ A[1]+":"+A[2]+""+A[3];


        if((A[0]==3 || A[1]==3 || A[2]==3 || A[3]==3) )//&& 3!=Integer.parseInt(temp)
            temp=temp+"3";
        else if((A[0]==2 || A[1]==2 || A[2]==2 || A[3]==2) )//&& 2!=Integer.parseInt(temp)
            temp=temp+"2";
        else if ( (A[0]==1 || A[1]==1 || A[2]==1 || A[3]==1))// && 1!=Integer.parseInt(temp)
            temp=temp+"1";
        else if (A[0]==0 || A[1]==0 || A[2]==0 || A[3]==0 )//&& 0!=Integer.parseInt(temp)
            temp=temp+"0";




        String arr[]=  temp.split("");
try {
    for (int i = 0; i < A.length; i++) {

        for (int j = 0; j < arr.length; j++) {
            if (A[i] == Integer.parseInt(arr[j]))
                A[i] = -1;
        }
    }
}
catch (Exception e){

}

        temp+=":";
        int max=-1;int min=-1;
        for(int i=0;i< A.length;i++){
            if(A[i]!=-1)
            {
                if(A[i]>max)
                    max= A[i];
            }
        }

        for(int i=0;i< A.length;i++){
            if(A[i]!=-1)
            {
                if(A[i]<max)
                    min= A[i];
            }
        }

        temp+=max+""+min;

        //System.out.println(temp);

        return temp;

    }
}
