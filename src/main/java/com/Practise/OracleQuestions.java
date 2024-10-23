package com.Practise;

import java.util.*;

public class OracleQuestions {
    public static void main(String[] args) {
        //asked before
        //*****************************************
        //Delete Kth node From End
        new OracleQuestions().deleteKthNodeFromEnd();

        new OracleQuestions().findMaxSubsequenceForSameElement();
        //*****************************************

        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int left = 0;
        int right = 3;
        int endIndex = arr.length - 1;
        while (right <= endIndex) {
            Set<Integer> newSet = new HashSet<>();
            for (int i = left; i <= right; i++) {
                newSet.add(arr[i]);
            }
            System.out.println(newSet.size());
            left++;
            right++;
        }
        // 2nd question
        //gfg = charvalue of (g+f+g)= 6+5+6 = 17 elemnt which is in 17 r
        int sum = 0;
        String input = "gfg";
        Character[] dict = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        List al = Arrays.asList(dict);
        for(char elemnt :input.toCharArray())
            sum +=al.indexOf(elemnt);
        System.out.println((char) sum);
    }

    class Node{
        int element;
        Node next;
        Node(int n){
            element = n;
            next =null;
        }
        Node(Node node,int n){
            element = n;
            next =node;
        }

    }

    public void findMaxSubsequenceForSameElement(){
        /* * *
        * Subsequence pair from given Array having all unique and all same elements respectively
        *
        * Input: arr[] = {1, 2, 3, 1, 2, 3, 3, 3}
        * Output: 3
        * Explanation:
        * The first subsequence consists of elements {1, 2, 3}.
        * The second subsequence consists of elements {3, 3, 3}.
        *
        * Input: arr[] = {2, 2, 2, 3}
        * Output: 2
        * Explanation:
        * The first subsequence consists of elements {2, 3}.
        * The second subsequence consists of elements {2, 2}.
        * * */

        int arr[]=new int[] {1, 2, 3, 1, 2, 3, 3, 3};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            if(map.get(i)!=null){
               map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

       Optional<Map.Entry<Integer,Integer>> optionalMap=
               map.entrySet()
               .stream()
               .max(Map.Entry.comparingByValue());
        System.out.println(optionalMap.get());

    }

    public void deleteKthNodeFromEnd(){
        int k=3;
        Node last= new Node(5);
        Node llast = new Node(last,4);
        Node lllast = new Node(llast,65);
        Node llllast = new Node(lllast,3);
        Node lllllast = new Node(llllast,45);
        Node llllllast = new Node(lllllast,87);

        Node head =llllllast;
//        while(head!=null){
//           System.out.print( head.element+",");
//            head = head.next;
//        }
        Node left=null, right=null;

        Node dummy=new Node(-1);
        dummy.next=llllllast;
        left = dummy;
        int i=0;
        while(i<k){
            head=head.next;
            i++;
        }
        right = head;
        while(right.next!=null){
            left= left.next;
            right=right.next;
        }

        left.next = right.next;

        while(dummy.next!=null){
            System.out.print( dummy.element+",");
            dummy = dummy.next;
        }

    }
}
/*
//asked before



 check local db
if (!exist in local)
{
generate token();
result token =call POST end point();   -> if(!user has a token already){save token}else{get token}
if(token!=null or emplty)
{
write in sql();
}
}*/


/* WHAT IS STACK OVERFLOW EXCEPTION
 * When we call recusrively. stack memory exceeds
 */

/*
 *How dowe call HTTP2 using rest
 *
 *Because the HTTP/2 wire format is more efficient (in particular due to multiplexing and compression), REST APIs on top of HTTP/2 will also benefit of this.

The other major improvement present in HTTP/2, HTTP/2 Push, targets efficient download of correlated resources, and it's probably not useful in the REST usecase.
 */

