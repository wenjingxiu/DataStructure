import java.util.ArrayList;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/7/2 17:54
 * Description: Tire 字典树测试
 */

public class Main {
    private static void testTrieSetAndAdd(){
        String filename = "C:\\Users\\Brave\\Desktop\\JavaExamples\\DataStructure\\Set\\pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)){
            long startTime = System.nanoTime();

            System.out.println(filename);
            Trie trie = new Trie();
            if (FileOperation.readFile(filename, words)) {
                System.out.println("Total words: " + words.size());

                for (String word : words) {
                    trie.add(word);
                }

                for (String word : words) {
                    trie.isContained(word);
                }
                System.out.println("Total different words: " + trie.getSize());
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("trie: " + time + 's');
        }
    }

    public static void main(String[] args) {
        testTrieSetAndAdd();


    }
}
