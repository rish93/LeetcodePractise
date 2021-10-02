package com.Practise;


public class MorganStanleyTest extends Thread {
    private static int x;

    public synchronized void todoThings() {
        int current = x;
        current++;
        x = current;

    }

    public void run() {
        todoThings();
    }

    public static void main(String[] args) throws Exception {


    }

}

/* class Base {
 *//*PriorityQueue<String>  pq = new PriorityQueue<>();
        pq.add("C");
        pq.add("A");
        pq.add("B");
        System.out.println(pq.poll()+":"+pq.peek());*//*

    Base() {
        this("1");
    }

    Base(String s)
    {
        System.out.println("super-"+s);
    }
}*/
/*Object[] myObject ={new Integer(12),
                new String("foo"),
                new Integer(5),
                new Boolean(true)};
        Arrays.sort(myObject);
        for(int  i=0; i<myObject.length;i++)
        {

            System.out.println(myObject[i]);
            System.out.println(" ");
        }*/


/* BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        deque.offer(10,5, TimeUnit.SECONDS);
        System.out.println(deque.pollLast(5, TimeUnit.SECONDS)+" ");
        System.out.println(deque.pollFirst(5, TimeUnit.SECONDS)+" ");*/