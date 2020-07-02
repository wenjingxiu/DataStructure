/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/7/2 15:00
 * Description: 线段树测试
 */

public class Main {

    public static void testSegmentTreeMerger(){
        Integer[] nums = {-2, 32, 6, 7, 12, 0, -43};

        // 匿名对象的方式创建 segmentTree
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
//            @Override
//            public Integer merge(Integer a, Integer b) {
//                 return a + b;
//            }
//        });

        // 使用 Lambda 表达式创建 segmentTree
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, ((a, b) -> a + b));

        // 使用 IDEA 推荐的方式： "Lambda can be replaced with method reference"
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (Integer::sum));
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(3, 5));
    }

    public static void main(String[] args) {
        testSegmentTreeMerger();
    }
}
