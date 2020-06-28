import java.util.Random;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/6/28 22:31
 * Description: 最大堆与优先队列测试
 */

public class Main {

    private static double testHeap(Integer[] testData, boolean isHeaped){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeaped){
            maxHeap = new MaxHeap<>(testData);
        }
        else {
            maxHeap = new MaxHeap<>();
            for (int number : testData) {
                maxHeap.add(number);
            }
        }

        int[] array = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            array[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < testData.length; i++){
            if (array[i - 1] < array[i]){
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("MaxHeap has completed.");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static void testHeapFirst(int n){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++){
            if (array[i - 1] < array[i]){
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("MaxHeap has completed.");
    }

    public static void main(String[] args) {
        int n = 10000000;
        System.out.println("The first time");
        testHeapFirst(n);

        System.out.println("The second time");
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time = testHeap(testData, false);
        System.out.println("Time without heapify: " + time + 's');

        time = testHeap(testData, true);
        System.out.println("Time with heapify: " + time + 's');
    }
}
