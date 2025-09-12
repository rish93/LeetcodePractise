package com.Practise.MongoDB;

import java.util.*;
import java.util.stream.Collectors;

public class LeetcodeCompanyWise {

    public static void main(String[] args) {


        /*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence
        of one or more dictionary words.
        Note that the same word in the dictionary may be reused multiple times in the segmentation.
        Example 1:

        Input: s = "leetcode", wordDict = ["leet","code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".
        Example 2:

        Input: s = "applepenapple", wordDict = ["apple","pen"]
        Output: true
        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        Note that you are allowed to reuse a dictionary word.
        Example 3:

        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        Output: false
        */
        //Test case1
        String s="leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(s+" - "+wordDict);
        System.out.println("LEETCODE 139. Word break o/p:   "+wordBreak(s, wordDict));

        //Test case2
        String s2="catsandog";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("cats");
        wordDict2.add("dog");
        wordDict2.add("sand");
        wordDict2.add("and");
        wordDict2.add("cat");
        System.out.println(s2+" - "+wordDict2);
        System.out.println("LEETCODE 139. Word break o/p:   "+wordBreak(s2, wordDict2));
        System.out.println(wordBreakTest(s2, wordDict2));
        //Test case3
        String s3="aaaaaaa";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("aaaa");
        wordDict3.add("aaa");
        System.out.println(s3+" - "+wordDict3);
        System.out.println("LEETCODE 139. Word break o/p:   "+wordBreak(s3, wordDict3));


        TreeNode root=new TreeNode(3);
        root.left =new TreeNode(5);
        root.left.left =new TreeNode(6);
        root.left.right =new TreeNode(2);
        root.left.right.left =new TreeNode(7);
        root.left.right.right =new TreeNode(4);
        root.left.right.left.left =null;
        root.left.right.left.right =null;

        root.right =new TreeNode(1);
        root.right.left =new TreeNode(0);
        root.right.left.left =null;
        root.right.left.right =null;
        root.right.right =new TreeNode(8);
        root.right.right.left =null;
        root.right.right.right =null;


        TreeNode p=new TreeNode(6);
//        p.left=new TreeNode(6);
//        p.left.left=null;
//        p.left.right=null;

//        p.right=new TreeNode(2);
//        p.right.left=new TreeNode(7);
//        p.right.left.left=null;
//        p.right.left.right=null;
//
//        p.right.right=new TreeNode(4);;
//        p.right.right.right=null;
//        p.right.right.left=null;



        TreeNode q=new TreeNode(4);
//        q.left =null;
//        q.right=null;

      System.out.println( "Ancestor LCA:  "+ lowestCommonAncestor(root,p,q).val);


      //hit counter
        HitCounter hitCounter= new HitCounter();

        hitCounter.hit(1);//hit at timestamp 1
        hitCounter.hit(2);//hit at timestamp 2
        hitCounter.hit(3); //hit at timestamp 3
        hitCounter.hit(4);
        System.out.println(hitCounter.getHits(7));//4
        hitCounter.hit(7);
        hitCounter.hit(9);
        hitCounter.hit(12);
        hitCounter.hit(15);
       System.out.println( hitCounter.getHits(16));//get hit at timestamp 4. return 7
        hitCounter.hit(20);
        System.out.println( hitCounter.getHits(20));//4
        System.out.println( hitCounter.getHits(21));//hit at timestamp 300//3
        //System.out.println(  hitCounter.getHits(300));//get hit at timestamp 300, return 4
        //System.out.println(   hitCounter.getHits(301));//get hit at timestamp 301, return 3



        //146. LRU Cache
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4



        //57. Insert Interval

        int intervals[][] = {{1,3},{6,9}};
        int newInterval[] = {2,5};
      // System.out.println( insert(intervals, newInterval));



       // 349. Intersection of Two Arrays
        int nums1[]=new int[]{1,3,6,33,22,25};
        int nums2[]=new int[]{9,54,3,33,22,21};
        intersection(nums1,nums2);




        MinHeap<Integer> minHeap=new MinHeap<>();
        minHeap.add(23);
        minHeap.add(12);
        minHeap.add(44);

        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());


    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set= new HashSet<Integer>();

        List<Integer> listNums2 = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> listNums1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());

        if(nums1.length<=nums2.length){
            for(int i=0;i<nums1.length;i++){
                if(java.util.Arrays.asList(nums2).indexOf(nums1[i])!=-1){
                    set.add(nums2[i]);
                }
            }
        }else{
            for(int i=0;i<nums2.length;i++){
                if(java.util.Arrays.asList(nums1).indexOf(Integer.valueOf(nums2[i]))!=-1){
                    set.add(nums1[i]);
                }
            }
        }
        return set.stream().mapToInt(Number::intValue).toArray();
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //interval          [1,3]|     |[6,9]
        //new interval            [2,5]
        //o/p               [1,5]    [6,9]
        /*
        * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
        * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
        * Return intervals after the insertion.
        * Note that you don't need to modify intervals in-place. You can make a new array and return it.
        *
        *    Example 1:

        *    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        *    Output: [[1,5],[6,9]]
        *    Example 2:

        *    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        *    Output: [[1,2],[3,10],[12,16]]
        *    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
        */
        int [][] result= new int [intervals.length+1][2]; //for test case where one element is inserted as it is.
        int i =0; int j=0;

        // for  every existing  second element range if is less than incoming start range
            //[1,2][3,5][6,7]    <---- [4,8]  here 2<4 hence add 1,2 as it is
        // first elment add to result as it is.

        //new interval start > exisitng interval last.. add as it is..
        while(i< intervals.length && newInterval[0]>intervals[i][1])
        {
            result[j++] = intervals[i++]; //add intervals as it is.
        }

        //merge overlapping intervals  (incoming intervals second element, greater than exisitngs
        // first element.)

        //new interval end > exisitng interval start .. merge
        while(i< intervals.length && newInterval[1]>=intervals[i][0]) {
           // result[j++] = intervals[i++]; //add intervals as it is.
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);//[_,0] or [[_,0]]
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
        }
        result[j++]=newInterval;

        //add remaining interval
        while (i< intervals.length){
            result[j++]=intervals[i++];
        }

        return java.util.Arrays.copyOf(result,j);
    }



    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */


    public static boolean wordBreak(String s, List<String> wordDict) {
        String output="";
        char[] dcharArray= s.toCharArray();
        for(char c: dcharArray){
            output+=c;
            if(wordDict.contains(output)){
                output="";
            }
        }
        return output.length() == 0;
    }

    public  static boolean wordBreakTest(String s, List<String> wordDict) {
        s="a";
        wordDict=List.of("b");
        for(int i=0;i<wordDict.size();i++){

                if(wordDict.get(i).length()==1){
                    s = s.replaceAll(wordDict.get(i),"");
                    if(s.equals(""))
                        return true;

                    return false;
                }

            if(s.contains(wordDict.get(i))){
                s.replaceAll(wordDict.get(i),"");
            }else{
                return false;
            }

        }
        return true;
    }
    //236. Lowest Common Ancestor of a Binary Tree java
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root== null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);

        if(left !=null && right != null){
            return root;
        }

        if(left != null){
            return left;
        }
        return right;
    }

    boolean findPath(TreeNode node, TreeNode target, List<TreeNode> pathLst){
        //List<Integer> pathLst = new ArrayList<>();
        if(node==null){
            return false;
        }
        pathLst.add(node);
        if(node.val==target.val){
            return true;
        }

        if(findPath(node.left, target, pathLst) || findPath(node.right, target, pathLst)){
            return true;
        }
        pathLst.remove(pathLst.size()-1);
        return false;
    }
}



class HitCounter {
    int indexStart=0;
    List<Integer> timestampList=new ArrayList<>();
    public void hit(int timestamp){
        timestampList.add(timestamp);
//        if(timestamp%300==0){
//
//        }
    }

    public int getHits(int timestamp){
        if(15-timestamp>=0){
          return timestampList.size();
        }else if(timestamp-15>=0){
          return timestampList.size()-timestampList.indexOf(timestampList.get(timestamp-15));
        }
        return -1;
    }
}


 // Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


class LRUCache {

    Deque<Integer> dequeAgeing;
    Map<Integer, Integer> mapCache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        mapCache= new LinkedHashMap<Integer, Integer>(capacity);
        dequeAgeing = new ArrayDeque<>(capacity);
    }

    public int get(int key) {
        if(dequeAgeing.contains(key)){
//            int element =  dequeAgeing.element();
            dequeAgeing.remove(key);
            dequeAgeing.addFirst(key);
        }
        if(mapCache.get(key)!=null){
            return mapCache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        mapCache.put(key, value); //adding to cache

        if(dequeAgeing.size()==0) {
            dequeAgeing.add(key);
        } else {
            if(dequeAgeing.size() == this.capacity){
                int elementRemoved =  dequeAgeing.removeLast();
                mapCache.remove(elementRemoved);
            }

            dequeAgeing.addFirst(key);
        }
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0;i<wordDict.size();i++){

            if(s.contains(wordDict.get(i))){
                s.replaceAll(wordDict.get(i),"");
            }else{
                return false;
            }

        }
        return true;
    }



}



//create heap datastructure..
 class MinHeap<T extends Comparable<T>> {
    private List<T> heap = new ArrayList<>();

    // Insert an element
    public void add(T value) {
        heap.add(value);
        siftUp(heap.size() - 1);//child index
    }

    // Get min without removing
    public T peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    // Remove and return min element
    public T poll() {
        if (heap.isEmpty()) return null;
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {//take last element place it as top and shift down
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(1);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // should print in increasing order
        }
    }



    /*
    * 📌 1️⃣ Arrays & Strings

👉 Example:
Two Sum (LC #1)

Given an array, return indices of two numbers that sum to a target.   done
*  public int[] twoSum(int[] nums, int target) {

        int result[]=new int[2];
        Map<Integer, Integer> map= new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
                int num = nums[i];
                if( map.containsKey(target-num)){
                    result[0] = i;
                    result[1] = map.get(target-num);
                }
                map.put(nums[i], i);
            }
            return result;
    }
    *

✅ Why? Tests hash maps, lookup, time complexity.

⸻

👉 Example:
Subarray Sum Equals K (LC #560)

* *
Count number of continuous subarrays whose sum equals k.

✅ Tests prefix sums + hash map.

*   public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int count=0;
        int sum=0;
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(map.containsKey(sum-k)){
                count=count+map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        // int l=k;

        // for(int i=0;i<nums.length;i++){
        //         int num = nums[i];
        //         k=k-num;
        //         if(k==0){
        //             count++;
        //             k=l;
        //         }

        // }
        return count;
    }
    *
    * * * *
⸻

📌 2️⃣ Hashing

👉 Example:
Group Anagrams (LC #49)

Group strings that are anagrams.

✅ Classic for hash maps, string sorting.

*
*  public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map= new HashMap<Integer, List<String>>();
        List<List<String>> result= new ArrayList<>();
        List<String> tempResult= new ArrayList<String>();
        int asciiSum=0;
        for(int j=0; j<strs.length; j++){
                char[] charArr = strs[j].toCharArray();
                for(int i=0; i<charArr.length; i++){
                    asciiSum+=charArr[i];
                }

               if(map.containsKey(asciiSum)){
                    tempResult=map.get(asciiSum);
               }else{
                    tempResult=new ArrayList<>();
               }
            tempResult.add(strs[j]);
            map.put(asciiSum,tempResult);
            asciiSum=0;
        }

        for(Map.Entry entry: map.entrySet()){
                result.add(map.get(entry.getKey()));
        }


        return result;
    }* *
⸻

👉 Example:
Longest Consecutive Sequence (LC #128)

Find length of longest consecutive elements sequence.

✅ HashSet, linear scan.

⸻

📌 3️⃣ Sliding Window

👉 Example:
Longest Substring Without Repeating Characters (LC #3)

Return length of longest substring with no duplicate chars.

✅ Sliding window, hash map.

⸻

📌 4️⃣ LRU Cache / System Design

👉 Example:
LRU Cache (LC #146)

Design a data structure that supports get & put with LRU eviction.

✅ Class, doubly linked list, hash map.

⸻

👉 Example:
Insert Delete GetRandom O(1) (LC #380)

Design a structure with insert, delete, and get random in average O(1).

✅ Hash map + array list trick.

⸻

📌 5️⃣ Binary Trees

👉 Example:
Lowest Common Ancestor (LCA) (LC #236)

Find LCA of two nodes in a binary tree.

✅ DFS, recursion.

⸻

👉 Example:
Validate Binary Search Tree (LC #98)

Check if a tree is a valid BST.

✅ In-order traversal logic.

*  public boolean isValidBST(TreeNode root) {

        int size1=0;
        int size2=0;

        isValid(root.left,size1);
        isValid(root.right,size2);

        return size1==size2;
    }

    void isValid(TreeNode root, int size){

        if(root==null)
            return ;

        size++;
        if(root!=null){
            isValid(root.left, size);

        }

    }
    * * *
⸻

📌 6️⃣ Concurrency (sometimes)

👉 Example:
Print FooBar Alternately (LC #1115)

Threads must print “foo” and “bar” alternately.

✅ Tests basic thread sync — useful for backend/microservices roles.
📌 7️⃣ SQL-like

Sometimes they mix in a query design or a small aggregation problem, like:
	•	Count duplicate rows.
	*
	* SELECT
  email,
  COUNT(*) AS occurrences   FROM
  employees GROUP BY email  HAVING COUNT(*) > 1;
  *
  *
•	Find second highest salary.
	*
	*   SELECT DISTINCT salary
        FROM salaries
        ORDER BY salary DESC
        LIMIT 1 OFFSET 1;
        *
        *
        *
        * SELECT MAX(salary) AS SecondHighest
FROM salaries
WHERE salary < (SELECT MAX(salary) FROM salaries);
*
* * * * * *
	•	Classic window functions.

⸻

📌 Sample MongoDB Interview Combo

They often do:
	•	1 DSA round: arrays/hash/trees.
	•	1 System design: LRU Cache, Rate Limiter, Movie Booking.
	•	1 Practical: Aggregation pipeline, Indexing concept.
	•	Behavioral: Why MongoDB? Scaling? Tradeoffs.

*
* HashMap
Two Sum, Subarray Sum Equals K
LRU
LRU Cache design
Tree
LCA, Validate BST
String
Longest Substring Without Repeating
Concurrency
FooBar Alternately
* *
    * * */
}