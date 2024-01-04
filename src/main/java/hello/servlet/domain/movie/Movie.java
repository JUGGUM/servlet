package hello.servlet.domain.movie;

//영화 스래드
public class Movie extends Thread {

    // 스레드는 하나의 작업자
    // 메인에서 출력해보았을때 스레드의 실행이 일정하지않음 그래서 어려운것이다!
    @Override
    public void run() {
        for (int i=0; i< 10; i++){
            System.out.println("Sub Thread 일 시작: "+ i);
        }
        System.out.println("NOT YET!");
    }
}

