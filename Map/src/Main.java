import java.util.ArrayList;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/6/25 21:23
 * Description: 映射测试
 */

public class Main {

    public static void main(String[] args) {
        test();
        System.out.println();
        System.out.println();

        String filename1 = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";
        testMap(filename1);

        System.out.println();
        System.out.println();

        String filename2 = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\a-tale-of-two-cities.txt";
        testMap(filename2);
    }

    private static void testMap(String filename) {
        BSTMap<String, Integer> bstMap1 = new BSTMap<>();
        double time = mapTest(bstMap1, filename);
        System.out.println("BSTMap: " + time + 's');

        LinkedListMap<String, Integer> linkedListMap1 = new LinkedListMap<>();
        time = mapTest(linkedListMap1, filename);
        System.out.println("LinkedListMap: " + time + 's');
    }

    private static double mapTest(Map<String, Integer> map, String filename){
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.isContained(word)){
                    map.set(word, map.get(word) + 1);
                }
                else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different word: " + map.getSize());
            System.out.println("Frequency of \"pride\" : " + map.get("pride"));
            System.out.println("Frequency of \"prejudice\" : " + map.get("prejudice"));

        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static void test(){
        ArrayList<String> words = new ArrayList<>();

        String filename1 = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";
        String filename2 = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\a-tale-of-two-cities.txt";

        if (FileOperation.readFile(filename1, words)){
            System.out.println("Total word: " + words.size());
            LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
            for (String word : words){
                if (linkedListMap.isContained(word)){
                    linkedListMap.set(word, linkedListMap.get(word) + 1);
                }
                else {
                    linkedListMap.add(word, 1);
                }
            }

            System.out.println("Total different word: " + linkedListMap.getSize());
            System.out.println("Frequency of \"pride\" : " + linkedListMap.get("pride"));
            System.out.println("Frequency of \"prejudice\" : " + linkedListMap.get("prejudice"));
        }

        System.out.println();

        if (FileOperation.readFile(filename2, words)){
            System.out.println("Total word: " + words.size());
            BSTMap<String, Integer> bstMap = new BSTMap<>();
            for (String word : words){
                if (bstMap.isContained(word)){
                    bstMap.set(word, bstMap.get(word) + 1);
                }
                else {
                    bstMap.add(word, 1);
                }
            }

            System.out.println("Total different word: " + bstMap.getSize());
            System.out.println("Frequency of \"pride\" : " + bstMap.get("pride"));
            System.out.println("Frequency of \"prejudice\" : " + bstMap.get("prejudice"));
        }
    }
}
