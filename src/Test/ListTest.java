package Test;

import List.MyArrayList;
import List.MyDoubleLinkedList;
import List.MyLinkedList;
import List.MyList;
import Queue.MyArrayDeque;
import Queue.MyArrayQueue;
import Queue.MyQueue;
import Stack.MyStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ListTest{
    public static void print(String testName, MyList c) throws IOException {
        Object[] array = c.toArray();
        System.out.println(testName);
        System.out.printf("사이즈 : "+c.size());
        System.out.printf(", 요소 : ");
        for (Object o : array) {
            System.out.printf(o+" ");
        }
        System.out.println("\n");
    }

    public static void print(String testName, MyQueue c) throws IOException{
        Object[] array = c.toArray();

        System.out.println(testName);
        System.out.printf("사이즈 : "+c.size());
        System.out.printf(", 요소 : ");
        for (Object o : array) {
            System.out.printf(o+" ");
        }
        System.out.println("\n");
    }

    public static void arrayListTest() throws IOException{
        ArrayList<Integer> list = new ArrayList<>();

        MyArrayList myArrayList = new MyArrayList();
        int index = 0;
        int value = 0;
        for(int i = 1; i <= 10; i++)
            myArrayList.add(i);

        print("**************************************** ArrayList Test 초기 값 ****************************************", myArrayList);

        index = 1;
        value = 13;
        Object o = new Object();
        myArrayList.add(index, 13);
        print("add(index, value) Test. index = "+index+"value = "+value, myArrayList);

        myArrayList.remove(index);
        print("remove(index) Test. index = "+index, myArrayList);

        o = 10;
        myArrayList.remove(o);
        print("remove(Object o) Test, Object = "+o, myArrayList);

        MyArrayList clone = myArrayList.clone();
        System.out.println("clone HashCode = " + clone.toString());
        System.out.println("instance HashCode = " + myArrayList.toString());
        print("clone() Test.", clone);

        index = 3;
        print("get(index) Test. index = "+index+" return value = "+  myArrayList.get(3), myArrayList);

        print("indexOf(index) Test. object = "+o+" return value = "+ myArrayList.indexOf(o), myArrayList);


        index = 3;
        o = 33;
        myArrayList.set(index, o);
        print("set(index, value) Test. index = "+index+" object = "+o, myArrayList);

        myArrayList.clear();
        print("clear() Test.", myArrayList);

        System.out.println("*************************************** Test Finish ****************************************\n");

    }

    public static void linkedListTest() throws IOException{
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for(int i = 1; i <= 10; i++)
            myLinkedList.add(i);

        Object o;
        print("**************************************** LinkedList Test 초기 값 ****************************************", myLinkedList);

        int index = 1;
        int value = 11;
        myLinkedList.add(index, value);
        print("add(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        value = 12;
        myLinkedList.addFirst(value);
        print("addFirst(value) Test. value = "+value, myLinkedList);

        value = 13;
        myLinkedList.addLast(value);
        print("addLast(value) Test. value = "+value, myLinkedList);

        print("get(index) Test. index = "+index+" return data = "+myLinkedList.get(index), myLinkedList);
        index = 8;
        value = 0;
        myLinkedList.set(index, value);
        print("set(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        o = 9;
        print("indexOf(Object) Test. Object = "+o+" return data = "+myLinkedList.indexOf(o), myLinkedList);


        print("remove() Test. return data = "+ myLinkedList.remove(), myLinkedList);
        int size = myLinkedList.size();

        for(int i = 0; i < size; i++){
            print("remove(index) Test. index = "+index+" return data = "+ myLinkedList.remove(0), myLinkedList);
        }

        print("remove(Object) Test. Object = "+o+ " return data = "+myLinkedList.remove(o), myLinkedList);
        System.out.println("**************************************** Test Finish ****************************************\n");
    }

    public static void doubleLinkedListTest() throws IOException{
        MyDoubleLinkedList<Integer> myLinkedList = new MyDoubleLinkedList<>();
        for(int i = 1; i <= 10; i++)
            myLinkedList.add(i);

        Object o;
        print("**************************************** DoubleLinkedList Test 초기 값 ****************************************", myLinkedList);

        int index = myLinkedList.size();
        int value = 11;
        myLinkedList.add(index, value);
        print("add(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        value = 12;
        myLinkedList.addFirst(value);
        print("addFirst(value) Test. value = "+value, myLinkedList);

        value = 13;
        myLinkedList.addLast(value);
        print("addLast(value) Test. value = "+value, myLinkedList);

        print("get(index) Test. index = "+index+" return data = "+myLinkedList.get(index), myLinkedList);
        index = 8;
        value = 0;
        myLinkedList.set(index, value);
        print("set(index, value) Test. index = "+index+" value = "+value, myLinkedList);

        o = 9;
        print("indexOf(Object) Test. Object = "+o+" return data = "+myLinkedList.indexOf(o), myLinkedList);


        print("remove() Test. return data = "+ myLinkedList.remove(), myLinkedList);
        print("remove(index) Test. index = "+index+" return data = "+ myLinkedList.remove(11), myLinkedList);
        print("remove(Object) Test. Object = "+o+ " return data = "+myLinkedList.remove(o), myLinkedList);
        System.out.println("**************************************** Test Finish ****************************************\n");
    }

    public static void arrayQueueTest() throws IOException{
        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>();
        for(int i = 0; i < 7; i++){
            myArrayQueue.offer(i);
        }
    print("**************************************** ArrayQueue Test 초기 값 ****************************************", myArrayQueue);

        print("element() Test. returnData : "+ myArrayQueue.element(), myArrayQueue);
        print("peek() Test. returnData : "+ myArrayQueue.peek(), myArrayQueue);
        print("poll() Test. returnData : "+ myArrayQueue.poll(), myArrayQueue);
        print("remove() Test. returnData : "+ myArrayQueue.remove() , myArrayQueue);

        int length = 4;
        Integer[] newArray1 = new Integer[length];
        for(int i = 0; i <newArray1.length; i++)
            newArray1[i] = 1;

        Integer[] array = myArrayQueue.toArray(newArray1);

        length = 10;
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();

        Integer[] newArray2 = new Integer[length];
        for(int i = 0; i <length; i++)
            newArray2[i] = 1;

        array = myArrayQueue.toArray(newArray2);

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");

        System.out.println();

        length = 15;
        Integer[] newArray3 = new Integer[length];
        for(int i = 0; i <newArray3.length; i++)
            newArray3[i] = 1;

        array = myArrayQueue.toArray(newArray3);

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();

        myArrayQueue.clear();
        print("clear() Test. " , myArrayQueue);
        System.out.println("rear < front로 바꾸기");
        for(int i = 0; i < 9; i++){
            myArrayQueue.offer(i);
        }
        for(int i = 0; i < 9; i++){
            myArrayQueue.poll();
        }
        for(int i = 0; i < 7; i++)
            myArrayQueue.offer(i);

        print("rear < front. currentArray : ", myArrayQueue);

        length = 4;
        Integer[] newArray4 = new Integer[length];
        for(int i = 0; i <newArray4.length; i++)
            newArray4[i] = 1;

        array = myArrayQueue.toArray(newArray4);


        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();

        length = 10;
        Integer[] newArray5 = new Integer[length];
        for(int i = 0; i <length; i++)
            newArray5[i] = 1;

        array = myArrayQueue.toArray(newArray5);

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");

        System.out.println();

        length = 15;
        Integer[] newArray6 = new Integer[length];
        for(int i = 0; i <newArray6.length; i++)
            newArray6[i] = 1;

        array = myArrayQueue.toArray(newArray6);

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
        System.out.println();

    }

    public static void arrayDequeTest() throws IOException{
        MyArrayDeque<Integer> myArrayDeque = new MyArrayDeque<>();
        for(int i = 0; i < 10; i++){
            myArrayDeque.offer(i);
        }
        print("**************************************** ArrayDeque Test 초기 값 ****************************************", myArrayDeque);
        print("contain() Test. Object = 9. returnData : "+Boolean.toString(myArrayDeque.contains(Integer.valueOf(9))), myArrayDeque);
    }

    public static void stackTest() throws IOException {
        MyStack<Integer> myStack = new MyStack<>();
        for(int i = 0; i < 10; i++){
            myStack.push(1);
        }

        for(int i = 0; i < 10; i++){
            System.out.println(myStack.pop());
        }
        myStack.clear();
        for(int i = 0; i < 10; i++){
            myStack.push(1);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(myStack.pop());
        }

    }

}