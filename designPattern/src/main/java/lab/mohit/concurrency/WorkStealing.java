package lab.mohit.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class WorkStealing {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        int ARR_SIZE = 100000;
        int[] numbers = new int[ARR_SIZE];
        for (int i=0; i<ARR_SIZE; i++) {
            numbers[i] = i+1;
        }
        SumTask task = new SumTask(numbers, 0, ARR_SIZE);
        Integer result = forkJoinPool.invoke(task);
        System.out.println("Sum: " + result);
    }

    static class SumTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 100;
        private int[] array;
        private int start;
        private int end;

        SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end-start <= THRESHOLD) {
                int sum = 0;
                for(int i=start; i<end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);
                leftTask.fork(); // Fork the left task to run it asynchronously
                int rightResult = rightTask.compute(); // Compute the right task synchronously
                int leftResult = leftTask.join(); // Wait for the left task to finish and get the result
                return leftResult + rightResult;
            }
        }
    }
}
