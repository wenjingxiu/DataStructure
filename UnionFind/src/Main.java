import java.util.Random;

/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/7/2 23:03
 * Description: 并查集测试
 */

public class Main {
    private static double testUnionFind(UnionFind unionFind, int n){
        int size = unionFind.getSize();

        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.unionElements(a, b);
        }
        for (int i = 0; i < n; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int n = 10000000;

//        UnionFindFirst unionFindFirst = new UnionFindFirst(size);
//        System.out.println("UnionFindFirst: " + testUnionFind(unionFindFirst, n) + "s ");

        UnionFindSecond unionFindSecond = new UnionFindSecond(size);
        System.out.println("UnionFindSecond: " + testUnionFind(unionFindSecond, n) + "s ");

        UnionFindThird unionFindThird = new UnionFindThird(size);
        System.out.println("UnionFindThird: " + testUnionFind(unionFindThird, n) + "s ");

        UnionFindForth unionFindForth = new UnionFindForth(size);
        System.out.println("UnionFindForth: " + testUnionFind(unionFindForth, n) + "s ");

        UnionFindFifth unionFindFifth = new UnionFindFifth(size);
        System.out.println("UnionFindFifth: " + testUnionFind(unionFindFifth, n) + "s ");

        UnionFindSixth unionFindSixth = new UnionFindSixth(size);
        System.out.println("UnionFindSixth: " + testUnionFind(unionFindSixth, n) + "s ");

    }
}
