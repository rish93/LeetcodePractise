package com.Practise.jpmorgan;

import com.corejava.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class JPmorgan3 {

    private static final int MAX = 10;
    private int count = 1;
    private int turn = 1; // 1 for Thread1, 2 for Thread2, 3 for Thread3

   static Integer i=0;
    public static void main(String[] args) {

//        Thread t1= new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(i!=10) {
//                    System.out.println("Thread 1 " + i++);
//
//                }
////                t1.wait();
////                t2.notify();
////                t3.wait();
//            }
//        });
//
//        Thread t2= new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println("Thread 2 "+i++);
////                t2.wait();
////                t1.wait();
////                        t3.notify();
//            }
//        });
//
//        Thread t3= new Thread(new Runnable() {
//            @Override
//            public void run() {
//             try {
//                 System.out.println("Thread 3 " + i++);
//             }catch (Exception e) {
////                 t1.notify();
////                t2.wait();
////                t3.wait();
//             }
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        while(i!=10){
//            if(t1.getState().equals("wait") &&t3.getState().equals("wait")){
//                t2.notify();
//
//            }
//            if(t2.getState().equals("wait") &&t1.getState().equals("wait")){
//                    t3.notify();
//
//            }
//            if(t2.getState().equals("wait") &&t3.getState().equals("wait")){
//                t1.notify();
//
//            }
//
//        }


        JPmorgan3 printer = new JPmorgan3();

        Thread t1 = new Thread(() -> printer.print(1), "Thread-1");
        Thread t2 = new Thread(() -> printer.print(2), "Thread-2");
        Thread t3 = new Thread(() -> printer.print(3), "Thread-3");

        t1.start();
        t2.start();
        t3.start();


       System.out.println(findRotatedArryTarget());

    }

    public synchronized void print(int threadId) {
        while (count <= MAX) {
            while (turn != threadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Check again, in case count exceeded while waiting
            if (count > MAX) break;

            System.out.println(Thread.currentThread().getName() + ": " + count++);
            turn = threadId % 3 + 1; // Cycle through 1 → 2 → 3 → 1
            notifyAll();
        }
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in left half
                } else {
                    left = mid + 1; // Target is in right half
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in right half
                } else {
                    right = mid - 1; // Target is in left half
                }
            }
        }

        return -1; // Not found
    }
    static int findRotatedArryTarget(){
        //rotated array, find index of target

        Integer target=1;
        Integer[]arr= new Integer[]{4,5,6,7,0,1,2};
        int start=0;
        int end= arr.length;
        int mid = (start+end) /2;


        while(start<end){

            if(target == arr[mid])
                return mid;

            if(arr[mid]>arr[end]){
                mid = (end+mid)/2;
                start = mid;

            }
            if(arr[start]< arr[mid] )
            {
                mid = (start+mid)/2;
                end = mid;
            }

            start++;
            end--;
        }

        return -1;
    }


//Employee
//    id,name, salary, department
//Department
    //id, name

    List ls= new ArrayList();

//    Map<String, List<Employee>> map =  ls.stream()
//            .sorted(Compa)

    List<Employee> employees = Arrays.asList(
            new Employee("",1,""),
            new Employee("",1,"")

    );

    Map<String, List<Employee>> groupedByDept = employees.stream()
            .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.collectingAndThen(
                            Collectors.toList(),
                            list -> list.stream()
                                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                    .collect(Collectors.toList())
                    )
            ));


}

