package com.Practise;

public class WalmartQuestion {

    public static void main(String[] args) throws IndexOutOfBoundsException{
        /*
        N= number of element
        A= Array
        X = element to replace
        {2,4,3,12,6,2}
        Replace element by one and place them in first of array
       eg X= 2;
       output {1,1,4,3,12,6};
        */
        int N = 6;
        int input[] = new int[]{2,4,3,12,6,2};
        int X = 2;
        int []output = new int[N];
        for(int i=0;i<N ;i++){
            if(input[i]==X)
                input[i]=1;
        }
       int left_pointer=0;
       int right_pointer=0;

        while(right_pointer<N){
            if(input[left_pointer]==1)
                left_pointer++;

            if(input[right_pointer]==1){

            }

            right_pointer++;
        }
    }



    private void ff(){
        int i=4;
    }

    //make insance and call static varibale private

}



  class Question{
        private static int hack;


      public static void main(String[] args) throws Exception {
          Question q = new Question();
          q.hack++;

          throw new Exception();
      }

        }

