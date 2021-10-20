package com.Practise;

public class WallmartInterview {

/*
*



//in framework where compile time polymorphism is used
findById(String s)
findById(Integer s)

//in framework where runtime polymorphism is used
APllication context = BeanContext
APllication context = ApplicationPathContext


* in collection where polymorphism is used
List list = ArrayList   get()
		  LinkedList  get()
Set set = new HashSet()
	  new LinkedHashset()


what is weak hashmap

// implementing hashmap custom
List<int[]> hashStore = new LinkedList<int[]>(16);
    void insertValue(int n){
	//5 =n
    int temp=     hashCode(hashCode(5, 16))
    int s[]=	hasstore.indexOf(temp);
	Arrays.stream(s).filter()
}

int hashCode(int n, int bucketSize){
//n=5
//16 range

return 	31*n+new Random().nextInt(n-3)/bucketSize

}*/

//using binary search find character
    /*
    * ['a',”b”,”c”,”d”....."z"]




  int search(Character arr[], char s){
    int leftPointer=0;

    int length= arr.length;
int rightPointer=length -1;
	char ouput='';

       while(leftPointer<length){

                int mid= leftPointer+(rightPointer-leftPointer)/2

                if((int)s == (int)arr[mid])
			   mid;

		if((int)s < (int)arr[mid-1])
			rightPointer = mid;

		if((int)s > (int)arr[mid+1])
			leftPointer = mid;
     }

return -1;

}

    * */

    /*Merge two linkdlist
    *
    * L1 = [1,3,5], L2 = [2,4,6]



	Node mergeLinkedList( Node l1, Node l2 ){
		Node head;
		Node outputHead;
		int l2Size=0;
		int l1Size=0;
		while(l1!=null){
			l1Size++;
			l1= l1.next;
		}
		while(l2!=null){
			l2Size++;
			l2= l2.next;
		}
		int size = Math.max(l1Size,l2Size);
                int i=0;
                while(i<size ){

		if(l1.value<l2.value)
		        outputHead =	new Node( l1.value)

		if(l1.value>l2.value)
                        outputHead =	new Node( l2.value)

		}

		head.next = outputHead ;
              }
		return head;

             }
    * */



}
