package com.Practise;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;
import java.util.stream.Collectors;

class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode(int val) {
        this.val = val;
    }

    LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class DeltaAirlines {

    public static void main(String[] args) {
        Stack s= new Stack();  //class
        Queue q= new LinkedList(); //interface queue
        /*
       LinkedListNode elem4 = new LinkedListNode(-4);
        LinkedListNode elem3 = new LinkedListNode(0, elem4);
        LinkedListNode elem2 = new LinkedListNode(2, elem3);
        LinkedListNode elem1 = new LinkedListNode(3, elem2);
        elem4.next = null;

      /*  while (elem1.next!=null)
        {
            System.out.println(elem1.val);
            elem1 = elem1.next;
        }*/
       LinkedListNode head=removeFromLastNNode(elem1, 3);

       while(head!=null){
           System.out.print(head.val+" ,");
           head= head.next;
       }

        //3, > 2 > 0 > -4

          Well, one reason is that there are variants of Queues that it is convenient to be able to swap in, like PriorityQueues. They fulfill the same interface but behave differently. I don't think there is anything like that for Stacks, or at least it isn't used nearly as often.
          You would not be able to simulate a Priority Queue using just an ArrayList.
          Additionally, regarding your second question, you should probably use a stack or queue when that is what you're using semantically. That is, if you are doing something like graph traversal, it helps to be very explicit about the sort of data structure you're using.
*/

        List<Integer> ls= List.of(1,2,3,45,5);

       // System.out.println(ls.stream().sorted(Comparator.comparing(value -> value>0)).collect(Collectors.toList()));


        //System.out.println(ls.stream().sorted(Comparator.comparing(value -> value>0)).collect(Collectors.toList()));












        //magnets with its intensity in array
        //find max group of magnets whose diff greater than k, Mettl test

        //ref. https://stackoverflow.com/questions/71267722/find-minimum-group-of-array-with-difference-less-than-k
        //if k =3
        int arr[] = {3,6,12,4,5,1,7,17};
        //grp1 {3,6,12,17}
        //grp2 {3,17,12, }
        int k =3;
        int n=8;
        int arr1[] = {3,6,12,4,5,1,7,17,42,8,59,100,2};
//        System.out.println(findMaxGroupFromMagnets(n, k, arr));
//        System.out.println(findMaxAllGroupFromMagnets(n, k, arr));


//        System.out.println("Answer for max group of magnet subset: "+Arrays.toString(arr)+" => "+findMaxFromMagnetsDPApproach(n, k, arr));

        //wrong answer expected 6, found 7
//        System.out.println("Answer for max group of magnet subset: "+Arrays.toString(arr1)+" => "+findMaxFromMagnetsDPApproach(arr1.length, k, arr1));

            //find max probability of winning match for player /*see line 103*/
            int scoreArr[][] =  new int[][]{{1,0,1,1},{2,0,2,1},{0,0,0,2}, {0,0,0,0}};
            int result []= findMaxProbability(scoreArr);
//            System.out.println(Arrays.toString(result));

//        calculateEvenAndOddFromArray();
        }

         private static int findMaxFromMagnetsDPApproach(int arrSize, int magnetDiff, int[] magnetArr) {
                  // int arr[] = {3,6,12,4,5,1,7,17};
                  // magnetDiff 3
                  // createDiff array


                  int dp[][] = new int[arrSize+1][magnetDiff+1];
                  //since for 0 diff, for all intensity diff value will be 0
                  // and for 0 intensity for all diff  , diff will be 0
                  //marking all 0 row and alll 0 columns as 0
                  for(int row=0;row<dp.length;row++) {
                    for(int column=0;column<dp[0].length;column++) {
                        if(row==0 || column==0){
                            dp[row][column] = 0;
                        }
                    }
                 }
              //  print2Dmatrix(dp);

             int [] diffArray= new int [magnetDiff+1];
             int count=0;
             for(int i=0;i<diffArray.length;i++){
                 diffArray[i] = count++;
             }
             System.out.println("diff array for  "+magnetDiff+" "+Arrays.toString(diffArray));
             for(int row=1;row<dp.length;row++) {
                 for(int column=1;column<dp[row].length;column++) {
                     if(magnetArr[row-1] - diffArray[column]>column) {
                         dp[row][column] = magnetArr[row-1];
                     } else {
                         dp[row][column] = -1;
                     }
                 }
             }
             print2Dmatrix(dp);

                int result= 0;
                for(int row=1;row<dp.length;row++) {
                 //for(int column=diffArray.length-1;column<=dp[row].length;column++) {

                     if(dp[row][diffArray.length-1]>0 ){
                         result++;
                     }

                // }
             }


                 return result;
         }


         private static void print2Dmatrix(int[][]dp){
             for(int row=0;row<dp.length;row++){
                 for(int column=0;column<dp[row].length;column++) {
                      System.out.print(dp[row][column]+", ");
                 }

                 System.out.println();
             }
         }


    private static int[] findMaxProbability(int[][] scoreArr) {
        int result[]= new int[scoreArr.length];
        int n=-1;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<scoreArr.length;i++){
            for(int j=0;j<scoreArr[i].length;j++){
                map.put(i, map.get(i)!=null ? map.get(i)+1  : 0);
                n= Math.max(n, map.get(i));
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){

            result[entry.getKey()] = entry.getValue()<n?0:1;
        }

        return result;
    }

    private static int findMaxAllGroupFromMagnets(int totalN, int diffK, int[] arr) {
        //not all test case  will be passed
        int count=0;
        int start=0;
        Arrays.sort(arr);
        Map<Integer, List<Integer>> map= new HashMap<>();
        for(int i=1;i<arr.length;i++ ){
            if(Math.abs(arr[i]-arr[start])>diffK) {

                    count++;
                    start = i;


            }
        }

        System.out.println(Arrays.toString(arr));

        return count;
    }

    public static int findMaxGroupFromMagnets(int totalN, int diffK, int []arr){
            //not all test case  will be passed
//        Arrays.sort( arr);  // this line is updated.
        int start = 0;
        if(arr.length == 0) return 0;
        // If arr has some value then at least can form 1 group
        int count = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - arr[start] > diffK) {
                count++;
                start = i;
            }
        }
        return count;


    }


     /* Sum of even & odd
        You are given an integer 'n'. Calculate the sum of even and odd digits of 'n', represented in decimals.
        Even and odd do not refer to the position of the digit but to the polarity of the digit.
        Return the answer in the form of an array of size 2, such that the 0th index represents the even sum and the 1st index represents the odd sum.
        Example:
        Input: 'n' = 1986.
        Output: [14, 10]
        Explanation: Even digits are 8 & 6, and odd digits are 1 & 9. The sum of even digits = 14, and the sum of odd digits = 10.
    */
    private static void calculateEvenAndOddFromArray(){
        int n = 1986;
        int[] resultEvenOdd = new int[2];
        int evenSum = 0;
        int oddSum = 0;
        while(n!=0) {
            int rem=n%10;
            if(rem % 2==0)
                evenSum+=rem;
            else
                oddSum+=rem;
            n = n / 10;
        }
        resultEvenOdd[0]=evenSum;
        resultEvenOdd[1]=oddSum;

        System.out.println(Arrays.toString(resultEvenOdd));
    }
    //Design an app like Practo


    /*
      *
    *
    *
    *
    * --------------------------* * * *
    *
    * Q2. Explain SDLC(Software Development Life Cycle)?
    View Answers (1)

    Q3. Name different Software Development Models You know about?
    View Answers (1)

    Q4. Explain Waterfall model.It's advantages and disadvantages?
    View Answers (1)

    Q5. What's Agile methodology and it's advantages over waterfall model?
    View Answers (1)

    Q6. Dicussions about my Project.Explain E-R diagram of your Project?Have you done any Project in C,C++?Which Software Development Model you used?
*
*write an api to accept list of object and process the list in multiple threads.
*public class WebsitesHandler {

    public static void main(String[] args) {
        BlockingQueue<Object> websites = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Worker[] workers = new Worker[3];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker(websites);
        }
        try {
            executorService.invokeAll(Arrays.asList(workers));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Worker implements Callable {

        private BlockingQueue<Object> websites;

        public Worker(BlockingQueue<Object> websites) {
            this.websites = websites;
        }

        public String call() {
            try {
                Object website;
                while ((website = websites.poll(1, TimeUnit.SECONDS)) != null) {
                    // execute the task
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "done";
        }
    }
}
*
*
* * * *
* Explain a SQL sub-select.

* *Explain the difference between inheritance and an interface, when should you use one over the other?
        an example, we all know what animals are. Like Lion is an animal, monkey is an animal, elephant is an animal, cow is an animal and so on. Now we know all animals do eat something and sleep. But the way each animal can eat something or sleep may differ. Like Lion eats by hunting other animals where as cow eats grass. But both eat. So we can have some pseudo code like this,
https://blog.technically.fun/post/opinions/inheritance-vs-composition
With subclasses, you

inherit state of the superclass (all instance variables, whether you see them or not)
inherit actual implementations (all non-abstract methods)
With interfaces, you fullfill a contract by implementing the declared methods.

That's the classical way to look at it. Now with Java 8 the interfaces become a mixture:

you still don't inherit state (as interfaces still don't have instance variables)
you now can inherit default implementations from the interface


interface Animal {
    public void eat();
    public void sleep();
}

class Lion implements Animal {
    public void eat() {
        // Lion's way to eat
    }

    public void sleep(){
         // Lion's way to sleep
    }
}

class Monkey implements Animal {
    public void eat() {
        // Monkey's way to eat
    }

    public void sleep() {
        // Monkey's way to sleep
    }
}
As per the pseudo code mentioned above, anything that is capable of eating or sleeping will be called an animal or we can say it is must for all animals to eat and sleep but the way to eat and sleep depends on the animal.

In case of interfaces we inherit only the behaviour, not the actual code as in case of classes' inheritance.

Q1. As interfaces are having only abstract methods (no code) so how can we say that if we are implementing any interface then it is inheritance ? We are not using its code.

Implementing interfaces is other kind of inheritance. It is not similar to the inheritance of classes as in that inheritance child class gets the real code to reuse from the base class.

Q2. If implementing an interface is not inheritance then How interfaces are used to achieve multiple inheritance ?

It is said because one class can implement more than one interfaces. But we need to understand that this inheritance is different than classes' inheritance.

Q3. Anyhow what is the benefit of using Interfaces ? They are not having any code. We need to write code again and again in all classes we implement it.

Implementing an interface puts compulsion on the class that it must override its all abstract methods.
*
*
* Default keyword in interface
* https://stackoverflow.com/questions/31578427/what-is-the-purpose-of-the-default-keyword-in-java
* * * *
*What is Aws lambda and how will you communicate to s3 in cross account ??
        * *A..
        * AWS Lambda is a serverless computing service that runs code in response to events and automatically manages the computing resources required.

        AWS Lambda is event-driven and allows you to run code without provisioning or managing servers.

        To communicate with S3 in a cross-account scenario, you can use IAM roles and policies to grant necessary permissions.

        Create a role in the account where the Lambda function resides with permissions to access the S3 bucket in the other account.

        Update the Lambda function's execution role to assume the cross-account role when accessing the S3 bucket.*

* Best approach to cost optimizaton AWS?
* https://bluexp.netapp.com/blog/3-ways-to-save-big-and-10-price-variations-to-know-aws-cvo-blg
*
*
*
* What is aws landing zones and control tower
        A..
        * AWS Landing Zones and Control Tower are AWS solutions for setting up and managing secure, multi-account AWS environments.

        AWS Landing Zones is a solution that helps customers set up a secure, multi-account AWS environment based on AWS best practices.

        AWS Control Tower is a service that provides the easiest way to set up and govern a secure, multi-account AWS environment based on AWS best practices.

        Both Landing Zones and Control Tower help organizations automate the setup of a baseline environment, enforce security and compliance policies, and provide ongoing monitoring and governance.

        They are designed to simplify the process of setting up and managing multiple AWS accounts, making it easier to scale and secure your AWS environment.

        Examples of use cases include setting up a new AWS environment for a company, ensuring compliance with industry regulations, and managing multiple AWS accounts for different departments within an organization.*

*
*
*  How to torubleshoot in AWS??
*           Troubleshooting skills in AWS involve identifying and resolving issues with cloud services and infrastructure.

            Ability to analyze logs and metrics to identify root causes of issues

            Experience with AWS monitoring tools like CloudWatch and X-Ray

            Knowledge of AWS service limits and best practices for optimizing performance

            Familiarity with AWS support options and escalation procedures*
    * */

    /*
        1 Mean won
        0 mean lost
        2 mean Match yet to be played
      return array [] with 1 and 0 such that 1 denote probability of win
      0 with no probability

      all with 1 have high probability and eg 3 (1 won 2 shceduled || 2 won 1 scheduled || 3 scheduled
      but for 0,0 it may have less probability than 3 like player 1, 2,3)
      eg [1,1,1,0,0]
                 Match 1  Match2 Match3 Match4 Match5
    *  Player 1    0          2       1   1       0        prob 3
    *  Player 2    1          2       1   0       0        prob 3
    *  Player 3    1          1       1   0       0        prob 3
    *  Player 4    0          1        0   0       0        prob 1
    *  Player 5    2           2       0   0       0        prob 2
    *  Player 6    1           0        0   0      0

    [1,1,1,0,0]  o/p as plyer 1,2,3, have high prbability
    *
    * */


    /*
    *   30July Delta
    *
    * How to handle our service is only down while payment
    *https://stackoverflow.com/questions/51320236/handle-payment-response-if-server-crashes
    *
    * Does MOngo handle transaction,
    * if while updating documents, interralted document one by one one of the
    * transaction fails how it will be referted, how to know which document failed.
    *
    *  @Transactional
        public void doSomething() {
         
        try {
         
        // update the DB table
        throw new Exception("exception");
         
        } catch(Exception e){
          System.out.println("exception "+ e);
        }
https://nikhilsukhani.medium.com/transactional-annotation-in-spring-boot-ae76307fcd26
* If you catch it @Transactional will not work. Because @Transactional generates a proxy which catches exceptions from the annotated method and the performs a rollback. If no exception is thrown by the annotated method no rollback will happen.
*https://www.reddit.com/r/SpringBoot/comments/16gubkp/if_transactional_throws_an_exception_can_this_try/
*
    *
    * public class MyClass {
  public static void main(String args[]) {
        Input: head = [1,2,3,4,5],
        n = 2
        Output: [1,2,3,5]

       // 5 fast pointer
       // 5-2

        // Node fast=head.next.next;

         Node slow=head.next;
        int i=0;
        while( i<n ){

            fast = fast.next;

        }

         while( fast.next!=null ){

            slow = slow.next;

           fast= fast.next
        }

        slow.prev = fast;


        //List ls= List.of(1,2,3,45,5);

        // ls.stream().Comparator.compare(i, j)=> i-j>0).collect(Collector.List);


     // System.out.print(  ls.stream().filter(i-> i>40).collect(Collector.List));* *

    *
    *   get cusotmer firstname whose order is >400
  select distinct c.first_name
  from Customers c ,Orders o where o.amount>=400;
  *
  *   select distinct c.first_name
  from Customers c ,Orders o where o.amount>=400 and o.customer_id=c.customer_id;
  * https://www.programiz.com/sql/online-compiler/

     */
}
