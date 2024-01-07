package hello.servlet.domain.movie;

//메인 클래스
public class Main {

    public static void main(String[] args) {

        //Thread 생성
        Movie movie = new Movie();
        //Thread 실행
        movie.start();

        for (int i=0; i< 10; i++){
            System.out.println("Main Thread 일 시작: "+ i);
        }

        System.out.println("모든 작업자 작업 종료");
    }

    // Join메소드는 스레드가 모든 일을 끝낼동안 다른 스레드가 기다려준다.
/*    public static void main(String[] args) {

        //Thread 생성
        Movie movie = new Movie();
        //Thread 실행
        movie.start();

        try {
            //Join 실행!!
            movie.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i< 10; i++){
            System.out.println("Main Thread 일 시작: "+ i);
        }

        System.out.println("모든 작업자 작업 종료~! 퇴근하자~!!");
    }*/
}
