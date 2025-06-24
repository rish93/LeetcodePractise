package com.Practise;

import java.util.List;

public class Siemens {

    public static void main(String[] args) {



    }
}

interface ICollection{

   void addElement();
    Object getElement();

}

abstract class CustomSortCollection{
    List<String> s;
    abstract Object sortData();

}
class CustomListCollection<T> extends CustomSortCollection{
    Object[]inputArr;
    CustomListCollection(int i ){
        Object[]inputArr = new Object[i!=0?i:10];
    }
    CustomListCollection(){
        Object[]inputArr = new Object[1];
    }
    void addElement(T i){
//        if(i instanceof String){
//            inputArr = new String[];
//
//        }
       inputArr= new Object[inputArr.length+1];
//        for(int k=0;k<inputArr.length;k++){
//            inputArr[k]=inputArr[k];
//        }
        inputArr[inputArr.length+1] = i;

//        CustomCollection<T> c
//                if( T ==Integer)
//                {
//
//
//                }


//        Object []inputArr2= new Object[inputArr.length+1];
//        for(int k=0;k<inputArr.length;k++){
//            inputArr2[k]=inputArr[k];
//        }
//
//        inputArr2[inputArr.length+1] = i;
//        inputArr= inputArr2;
    }

    Object getElement(int index){

            return null;
    }


    void removeElement(){

    }

    @Override
    Object sortData() {
        return null;
    }
}


//can you share object from one thread to other
//why serialization
//wan tot ignore element in serialization
//how to make sgared resource, synchronised
//how to create artifacts in gitllab yml

