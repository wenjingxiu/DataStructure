public class originArray {
    // TODO: 其他可能的功能？或者提示？

    public originArray(){
    }

    public void show(){
        int[] arr = new int[10];
        System.out.println("The first array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

        int[] scores = new int[] {40, 60, 80};
        System.out.println("The second array");
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
