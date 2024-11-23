package com.Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OracleTest {
    //conditional bean
    //how to handle multiple configuration
    //usage of final (variable, method , class)
    //if one user booking, other also try same seat, how to handle (one users sucess others failure)

    //design movie booking

    //user {id , name , email,   }
    //transaction {id, type, mode_ofPayemt, booking_id, time}
    // booking  {id, name,  booking_type, time_of_booked , showId_fk, transaction_id, user_id, timestamp}
   // 1  - 3(seats)
    // seating {static} {id ,  seatNumber, additional_stuff_id_fk , audiotrium,show_timeFrame, }, 1-50
    //1

    // addiotnal_booking { id, name, item }

    // show{static} {id, name, duration_show, relaseDate, licenceExpiry, timing_show,
            // 1
    // }


    //Show_seating {id_booking, id_show, seating_id_fk, mark_booked_seating }
                 //     1          1         1
                //1  1 2

                // 1 1  3

    //*  seating, show , showSeating
    //  select  seat.number, show.name, show.timing_show from
    //Seating seat Show show  showSeating showseatign where show.id=showseatign.id_show and showseatign.mark_booked_seating =false
    // where seat.number IN (2,3,4)
    // *//
   /*//transavciton  boookig , show_seating
   *   insert s.booke Seat
   *
   * * * */


    private static int testMajorityNumber(){
        //number's occurance greater than length of array
                            // i,j    ij
        int arr[] = new int[]{1,2,2,2,2,2,6,7}; //n > length/2
        int mojorityLength= arr.length/2;

        int indFind=1;//{2};
        int left=0, right=arr.length-1;


        while(left<right) {
            int mid= left + (left-right)/2;
            if(arr[mid] == arr[indFind]){
                return mid;
            }
           if(arr[indFind]> arr[mid]){
               left = mid;
           }else if(arr[indFind]< arr[mid])
           {
              right = mid;
           }
            left++;
            right--;
        }
        //Arrays.stream(arr).filter()
        return 3;

    }
    public static void main(String[] args) {

         System.out.println(testMajorityNumber());














        int arr[] =  new int[]{2,4,1,24,5};
        List<Integer> ls = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int max=Integer.MIN_VALUE;
        for(int i: arr){
            max= Math.max(max, i);
        }

        int count=0;
        for(int i=0;i<=max;i++){
           if(!(ls.contains(i)) && count!=5){
               System.out.println(i);
               count++;
           }
        }

    }
}
