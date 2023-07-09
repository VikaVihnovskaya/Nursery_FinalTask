package com.vicky;

public class Counter implements AutoCloseable{


    private int count = 0;

    public void increment(){
        count++;
    }
    @Override
    public void close(){
        System.out.println("Closed counter");
    }

    public int getCount() {
        return count;
    }
}
