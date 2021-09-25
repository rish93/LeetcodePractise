package com.Practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OracleQuestions {
    public static void main(String[] args) {
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

}
/*
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

