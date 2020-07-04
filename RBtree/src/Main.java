import java.util.ArrayList;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/7/4 11:45
 * Description: 红黑树测试
 */

public class Main {
    private static void testRBTree(){
        System.out.println("Pride and Prejudice");

        String filename = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.isContained(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    private static double testRBTreeTime(){
        String filename = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";

        ArrayList<String> words = new ArrayList<>();
        RBTree<String, Integer> rbTree = new RBTree<>();

        long startTime = System.nanoTime();

        if (FileOperation.readFile(filename, words)) {
            for (String word : words) {
                if (rbTree.isContained(word)){
                    rbTree.set(word, rbTree.get(word) + 1);
                }
                else {
                    rbTree.add(word, 1);
                }
            }

            for (String word : words) {
                rbTree.isContained(word);
            }
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        testRBTree();
        System.out.println("It took time: " + testRBTreeTime() + 's');
    }
}
