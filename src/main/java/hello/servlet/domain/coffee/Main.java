package hello.servlet.domain.coffee;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// https://any-ting.tistory.com/154
public class Main {

    public static void main(String[] args) throws InterruptedException {

        String str1 = "test";
        String str2 = "test";
        String str3 = new String("test");
        String str4 = new String("test");

        System.out.println(str1==str3); // false
        System.out.println(str1.equals(str3)); // true
        // equals는 데이터값만 비교 == 는 참조주소값도 비교

        Coffee amerikano = new Coffee(1L, "아메리카노", 1500, 30); // 수량 30개 아메리카노 커피 생성

        int numberOfThreads = 5;
        ExecutorService service = Executors.newFixedThreadPool(2); //Thread Pool을 사용해서 2개의 Thread 생성
        CountDownLatch latch = new CountDownLatch(numberOfThreads); //Thread 등록

        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                Integer choiceQuantity = 5;

                //현재 남아있는 커피 수량 조회
                Integer quantity = amerikano.getQuantity();
                System.out.println("현재 남아있는 커피 수량 = " + quantity);
                if(quantity <= 0) {
                    throw new RuntimeException("현재 수량이 모두 소진 됐습니다.");
                }

                //커피 수량 감소
                amerikano.minusCoffeeQuantity(choiceQuantity);
                Integer minusQuantity = amerikano.getQuantity();
                System.out.println("커피 수량 감소 후 커피 수량 = " + minusQuantity);

                latch.countDown();
            });
        }

        latch.await();
    }
}