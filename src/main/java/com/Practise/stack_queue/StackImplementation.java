package com.Practise.stack_queue;

public class StackImplementation {


    int size = 5;   // size of stack  LIFO principle
    static int counter = -1;
    int[] arr = new int[size];

    public static void main(String[] args) throws Exception {

        StackImplementation stack = new StackImplementation();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.push(7);
        stack.push(8);
        stack.top();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);   stack.push(1);


    }

    public void push(int element) throws Exception{
        if (counter < size-1) {
            counter += 1;
            arr[counter] = element;
        } else new Exception("Stack Size Full");
    }

    public void pop() throws Exception{
        if (counter > 0) {
            arr[counter] = 0;
            counter -= 1;
        }
        else new Exception("No elements to POP");
    }

    public int top() {
      return arr[counter];
    }
    public int size() {
        return counter+1;
    }
}
