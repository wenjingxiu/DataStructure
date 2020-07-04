import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/7/4 15:03
 * Description: hash 测试
 */

public class Main {

    private static void testInlineHashTable(){
        int a = 23;
        int b = -23;
        System.out.println(((Integer)a).hashCode());
        System.out.println(((Integer)b).hashCode());

        double c = 3.1515926;
        System.out.println(((Double)c).hashCode());

        String d = "HelloWorld";
        System.out.println((d).hashCode());

        Student student = new Student(3, 2, "wen", "xiu");
        System.out.println(student.hashCode());

        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);

    }

    private static void testMyHashTable(){
        String filename = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            long startTime = System.nanoTime();

            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.isContained(word)) {
                    hashTable.set(word, hashTable.get(word) + 1);
                } else {
                    hashTable.add(word, 1);
                }
            }

            for (String word : words) {
                hashTable.isContained(word);
            }

            long endTime = System.nanoTime();
            System.out.println("It took time: " + (endTime - startTime) / 1000000000.0 + 's');
        }
    }

    public static void main(String[] args) {
        testInlineHashTable();
        testMyHashTable();
    }
}
