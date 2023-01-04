package lesson3;

import java.util.Random;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {              //создали пул потоков = 1
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // Поместили в future результат вернувшийся от потока
        //реализация потока через Callable<T>
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            int randomValue = random.nextInt(10);
            if (randomValue < 5) { // проверка числа, если выпало менее 5
                throw new Exception("Bad happened"); // можем поймать исключение
            }                                     // ниже при обработке future.get
            return randomValue;   // возвращаем значение, Runnable такое не умеет.
        });
        executorService.shutdown();

        try {
            int result = future.get(); // get дожидается окончания выполнения потока
            System.out.println(result); // выводим результат
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) { // ловим исключение если было
            Throwable ex = e.getCause();  // получаем исключение
            System.out.println(ex.getMessage()); // выводим содержимое исключения
        }
    }
}
