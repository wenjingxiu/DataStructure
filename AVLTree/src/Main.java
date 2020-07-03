import java.util.ArrayList;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/7/3 0:46
 * Description: AVLTree 测试
 */

public class Main {
    private static void testAVLTree(String filename){
        System.out.println(" AVLTree ");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.isContained(word)){
                    avlTree.set(word, avlTree.get(word) + 1);
                }
                else {
                    avlTree.add(word, 1);
                }
            }
            System.out.println("Total different words: " + avlTree.getSize());
            System.out.println("Frequency of PRIDE: " + avlTree.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + avlTree.get("prejudice"));

            System.out.println("is BST: " + avlTree.isBST());
            System.out.println("is Balanced: " + avlTree.isBalanced());

            for (String word: words){
                avlTree.remove(word);
                if (!avlTree.isBST() || !avlTree.isBalanced()) {
                    throw new RuntimeException("Error");
                }
            }
        }
    }

    private static double testAVLTreeTime(String filename){
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            long startTime = System.nanoTime();

            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.isContained(word)){
                    avlTree.set(word, avlTree.get(word) + 1);
                }
                else {
                    avlTree.add(word, 1);
                }
            }

            for (String word : words){
                avlTree.isContained(word);
            }

            long endTime = System.nanoTime();
            return (endTime - startTime) / 1000000000.0;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        String filename = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";
        testAVLTree(filename);
        double time = testAVLTreeTime(filename);
        System.out.println("AVLTree took time: " + time + 's');
    }
}
