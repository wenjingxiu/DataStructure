import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> temp, int count){
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            temp.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            temp.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    private static double testStack(Stack<Integer> temp, int count){
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            temp.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            temp.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int testCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double timeArrayQueue = testQueue(arrayQueue, testCount);
        System.out.println("ArrayQueue time: " + timeArrayQueue + 's');

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double timeLoopQueue = testQueue(loopQueue, testCount);
        System.out.println("LoopQueue time: " + timeLoopQueue + 's');

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double timeLinkedListQueue = testQueue(linkedListQueue, testCount);
        System.out.println("LinkedListQueue time: " + timeLinkedListQueue + 's');

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double timeArrayStack = testStack(arrayStack, testCount);
        System.out.println("ArrayStack time: " + timeArrayStack + 's');

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double timeLinkedListStack = testStack(linkedListStack, testCount);
        System.out.println("LinkedListStack time: " + timeLinkedListStack + 's');
    }
}
