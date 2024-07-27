//package lab.mohit.concurrency;
//
//import java.util.concurrent.*;
//
//public class DivideAndConquerWithExecutorService {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        int ARR_SIZE = 500;
//        int[] numbers = new int[ARR_SIZE];
//        for (int i=0; i<ARR_SIZE; i++) {
//            numbers[i] = i+1;
//        }
//        Future<Integer> result = executorService.submit(new SumTask(numbers, 0, ARR_SIZE, executorService));
//        System.out.println("Sum: " + result.get());
//        executorService.shutdown();
//    }
//
//    static class SumTask implements Callable<Integer> {
//        private static final int THRESHOLD = 100;
//        private final int start;
//        private final int end;
//        private final int[] array;
//        ExecutorService executorService;
//        SumTask(int[] array, int start, int end, ExecutorService executorService) {
//            this.array = array;
//            this.start = start;
//            this.end = end;
//            this.executorService = executorService;
//        }
//
//        @Override
//        public Integer call() throws Exception {
//            if (end-start <= THRESHOLD) {
//                int sum = 0;
//                for(int i=start; i<end; i++) {
//                    sum += array[i];
//                }
//                return sum;
//            } else {
//                int mid = (start + end) / 2;
//                SumTask leftTask = new SumTask(array, start, mid, executorService);
//                SumTask rightTask = new SumTask(array, mid, end, executorService);
//                Future<Integer> leftResult = executorService.submit(leftTask);
//                Future<Integer> rightResult = executorService.submit(rightTask);
//                return leftResult.get() + rightResult.get();
//            }
//        }
//    }
//}
package lab.mohit.concurrency;

import java.util.concurrent.*;

public class DivideAndConquerWithExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numThreads = 12;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        int ARR_SIZE = 500;
        int[] numbers = new int[ARR_SIZE];
        for (int i = 0; i < ARR_SIZE; i++) {
            numbers[i] = i + 1;
        }

        // Use a CompletionService to manage the tasks
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        Future<Integer> result = completionService.submit(new SumTask(numbers, 0, ARR_SIZE, executorService, completionService));
        System.out.println("Sum: " + result.get());

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    static class SumTask implements Callable<Integer> {
        private static final int THRESHOLD = 100;
        private final int start;
        private final int end;
        private final int[] array;
        private final ExecutorService executorService;
        private final CompletionService<Integer> completionService;

        SumTask(int[] array, int start, int end, ExecutorService executorService, CompletionService<Integer> completionService) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.executorService = executorService;
            this.completionService = completionService;
        }

        @Override
        public Integer call() throws Exception {
            if (end - start <= THRESHOLD) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid, executorService, completionService);
                SumTask rightTask = new SumTask(array, mid, end, executorService, completionService);

                Future<Integer> leftFuture = completionService.submit(leftTask);
                Future<Integer> rightFuture = completionService.submit(rightTask);

                // Wait for the results of the subtasks
                int leftResult = leftFuture.get();
                int rightResult = rightFuture.get();

                return leftResult + rightResult;
            }
        }
    }
}
