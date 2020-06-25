import java.util.ArrayList;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/6/25 17:02
 * Description: Set测试
 */

public class Main {
    public static void main(String[] args) {
        String filename1 = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";
        BSTSetTest(filename1);
        LinkedListSetTest(filename1);

        System.out.println();

        String filename2 = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\a-tale-of-two-cities.txt";
        BSTSetTest(filename2);
        LinkedListSetTest(filename2);

        System.out.println();
        System.out.println();

        BSTSet<String> bstSet = new BSTSet<>();
        double time = setTest(bstSet, filename1);
        System.out.println("BSTSet: " + time + 's');

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        time = setTest(linkedListSet, filename1);
        System.out.println("LinkedListSet: " + time + 's');

        System.out.println();
        System.out.println();

        time = setTest(bstSet, filename2);
        System.out.println("BSTSet: " + time + 's');

        System.out.println();

        time = setTest(linkedListSet, filename2);
        System.out.println("LinkedListSet: " + time + 's');
    }

    private static void BSTSetTest(String filename) {
        System.out.println(" BSTSet " + filename);
        ArrayList<String> wordsPP = new ArrayList<>();
        if (FileOperation.readFile(filename, wordsPP)) {
            System.out.println("Total words: " + wordsPP.size());

            BSTSet<String> bstSet = new BSTSet<>();
            for (String word : wordsPP) {
                bstSet.add(word);
            }
            System.out.println("Total different words: " + bstSet.getSize());
        }
    }

    private static void LinkedListSetTest(String filename) {
        System.out.println("LinkedListSet " + filename);
        ArrayList<String> wordsPP = new ArrayList<>();
        if (FileOperation.readFile(filename, wordsPP)) {
            System.out.println("Total words: " + wordsPP.size());

            LinkedListSet<String> bstSet = new LinkedListSet<>();
            for (String word : wordsPP) {
                bstSet.add(word);
            }
            System.out.println("Total different words: " + bstSet.getSize());
        }
    }

    private static double setTest(Set<String> set, String filename){
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> wordsPP = new ArrayList<>();
        if (FileOperation.readFile(filename, wordsPP)) {
            System.out.println("Total words: " + wordsPP.size());

            for (String word : wordsPP) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
