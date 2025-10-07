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


/*
*
⸻

🔹 The Problem
	•	Two users try to book the same seat at the same time.
	•	We want only one user to succeed and the other to fail gracefully.

This is about ensuring correctness under concurrent transactions.

⸻

🔹 DB Concepts That Apply
	1.	Transactions (ACID)
	•	A transaction ensures Atomicity, Consistency, Isolation, Durability.
	•	Here, Isolation is the key property: concurrent transactions must not interfere incorrectly.
	2.	Isolation Levels
	•	Databases provide different isolation levels:
	•	Read Uncommitted → dirty reads allowed (not safe).
	•	Read Committed → prevents dirty reads.
	•	Repeatable Read → prevents non-repeatable reads.
	•	Serializable → highest level, transactions behave as if executed one after another.
👉 For seat booking, you typically need Serializable (or a strong locking mechanism).
	3.	Pessimistic Locking (aka Row-level locks)
	•	First user locks the seat row (SELECT ... FOR UPDATE).
	•	Second user trying to book waits or fails until the lock is released.
	•	Ensures only one transaction modifies the row.
	4.	Optimistic Concurrency Control
	•	Instead of locking, you use a version field or check condition.
	•	Example: UPDATE seats SET status='booked' WHERE seat_id=123 AND status='available'.
	•	If row count = 0, means another transaction already booked it.
	•	This is lightweight and avoids lock contention.
	5.	Unique Constraints
	•	Another trick is to enforce unique constraints at DB level.
	•	Example: table bookings has (seat_id, show_id) as a unique key.
	•	Two inserts for the same seat will cause one to fail with a constraint violation.

⸻

🔹 What This Is Called in DB Terms?
	•	Concurrency Control ✅
	•	Ensuring correctness with multiple users is handled by Transaction Isolation and Concurrency Control mechanisms.
	•	In relational DBs, this usually falls under “Isolation in ACID” and is implemented with locking or optimistic control.

⸻

🔹 Example in SQL (Optimistic Approach)
* BEGIN;

UPDATE seats
SET status = 'BOOKED', booked_by = 101
WHERE seat_id = 123 AND status = 'AVAILABLE';

-- check how many rows were updated
-- if 0 → booking failed (someone else booked)
-- if 1 → success

COMMIT;
*
*
*
*
* 🔹 Example in SQL (Pessimistic Locking)
*
* BEGIN;

SELECT * FROM seats
WHERE seat_id = 123
FOR UPDATE;

-- if status = AVAILABLE → mark as BOOKED
UPDATE seats SET status = 'BOOKED', booked_by = 101
WHERE seat_id = 123;

COMMIT;
*
*
*
* ✅ Summary:
The concept is called Concurrency Control in databases, specifically using Transaction Isolation (ACID).
You can solve it via:
	•	Pessimistic Locking (SELECT FOR UPDATE)
	•	Optimistic Concurrency Control (update with condition/version check)
	•	Unique Constraints (force DB to reject duplicates)

⸻

*  */
