package com.song;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static double testHeap(Integer[] testData,boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify){
             maxHeap = new MaxHeap<Integer>(testData);
        }else{
            maxHeap = new MaxHeap<Integer>();
            for (int i = 0; i < testData.length; i++) {
                maxHeap.add(i);
            }
        }
        int n = testData.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
	   int n = 1000000;
	   Random random = new Random();
	   Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData,false);
        System.out.println("Without Heapify: " + time1 + "s");


        double time2 = testHeap(testData,true);
        System.out.println("With Heapify: " + time2 + "s");

    }
}
