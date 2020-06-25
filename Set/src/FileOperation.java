import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Copyright (C), 2019-2020
 * FileName: FileOperation
 * Author:   Brave
 * Date:     2020/6/25 16:44
 * Description: 文件操作
 */

public class FileOperation {
    public static boolean readFile(String filename, ArrayList<String> words){
        if (filename == null || words == null){
            System.out.println("filename is null or words is null");
            return false;
        }

        Scanner scanner;

        try {
            File file = new File(filename);
            if (file.exists()){
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else {
                return false;
            }
        } catch (IOException ioException) {
            System.out.println("Cannot open " + filename);
            return false;
        }

        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length();) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))){
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                }
                else {
                    i ++;
                }
            }
        }

        return true;
    }

    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))){
                return i;
            }
        }
        return s.length();
    }
}
