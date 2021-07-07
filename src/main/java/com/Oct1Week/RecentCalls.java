package com.Oct1Week;


import java.util.*;

//class RecentCounter {
//
//    int counter;
//    int totalCounter;
//    boolean flag;
//    List<Integer> ls;
//    int i;
//    public RecentCounter() {
//        counter=0;
//        totalCounter=0;
//        flag=false;
//        ls= new ArrayList<>();
//        i=0;
//
//    }
//
//    public int ping(int t) {
//        ls.add(t);
//        if(1 <= t  && t <= 10000)
//        {
//            int range = t-ls.get(i);
//                    //findRange(t);
//
//
//            if( range <=3000)
//            {
//                counter=counter+1;
//                totalCounter =  counter;
//                return counter;
//            }
//
//            if(range > 3000){
//                i=counter;
//                // counter+=1;
//
//                totalCounter=counter;
//               // counter=1;
//                return totalCounter;
//            }
//            else{
//
//                return totalCounter;
//            }
//
//        }
//        else{
//
//            return 0;
//        }
//    }
//
//    int findRange(int t){
//        int temp = t-3000;
//
//        if(temp < 0)
//            return temp;
//         if(temp>0) {
//            return t - temp; //4054-1054  //4152-1152
//        }
//        return 1;
//    }
//
//
//
//}


//Using LinkedList
//class RecentCounter {
//
//    LinkedList<Integer> slideWindow;
//    public RecentCounter() {
//        this.slideWindow = new LinkedList<Integer>();
//
//    }
//
//    public int ping(int t) {
//        // step 1). append the current call
//        this.slideWindow.addLast(t);
//
//        // step 2). invalidate the outdated pings
//        while (this.slideWindow.getFirst() < t - 3000)
//            this.slideWindow.removeFirst();
//
//        return this.slideWindow.size();
//
//    }
//}


//Uisng QUeue
class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

public class RecentCalls{

    public static void main(String []args){

         RecentCounter obj = new RecentCounter();

      //  int arr[]= new int[]{1,100,3001,3002};
        //_1_2_3_3

//        int arr[]= new int[]{1178,1483,1563,4054,4152};

        int arr[]= new int[]{642,1849,4921,5936,5957};
        //[null,1,2,1,2,3]
        for(int i=0; i<arr.length;i++) {
             int param_1 = obj.ping(arr[i]);
             System.out.print("_"+param_1);
         }


    }

}
/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
