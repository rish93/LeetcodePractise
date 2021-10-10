package com.Practise;


import java.util.Stack;

public class InfostretchInterviewQuestion {

    public static void main(String[] args) {
/* print stars
//    *
//  *   *
//*        *
        for(int i=0;i<3;i++) {
            for(int j=3;j>0;j--){
                System.out.print("");
            }
            System.out.println();
        }

        for(int i=0;i<3;i++){
            for(int j=1;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
*/

//145
        int n=145;
       System.out.println(n+" krishnamurthy number"+ isKrishnamurthyNumber(n));


       /* String s1 = "ab(cde(fgg)frsx)";
        String s2 = "ab)(cde(fgg)frsx";

        char[] chars= s1.toCharArray();

        Stack<Character> characterStack = new Stack<>();

        for(char c: chars){
            if(c=='('){
                characterStack.push(')');
            }
            else if(!characterStack.empty() && c == characterStack.peek()){
                characterStack.pop();
            }
        }

        if(characterStack.size()==0)
            System.out.print("true");
        else
            System.out.print("false");

*/






//        int n=100;
//
//        int []arr = new int[]{1,2,5,6,7,10,11,12};
//
//        for(int i=0;i<n;i++){
//
//            if(i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0)
//                System.out.println(i);
//
//        }

    }


   static boolean isKrishnamurthyNumber(int n){
    //145
        int tempProduct=1;
       int tempSum=1;

       int m=n%10;
        while (m!=0){
            m=m%10;
            int i=m;

            for(int j=i;j>0;j--){
                tempProduct*=j;
            }

            tempSum+=tempProduct;
        }

        if(tempSum==n)
            return true;


        return false;
   }

}

//student {name subj marks}
//avg marks

//subj/name


//select AVG(e.marks,COUNT(e.subject)) from student e groupby e.marks
