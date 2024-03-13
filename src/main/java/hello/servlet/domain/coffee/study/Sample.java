package hello.servlet.domain.coffee.study;

import java.util.*;
class QueueExample{
    public void method(){
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //Queue에 삽입
        queue.offer(11);
        queue.offer(22);
        queue.offer(33);
        queue.offer(44);
        queue.offer(55);

        System.out.println(queue);
        System.out.println(queue.poll()); //Queue에서 맨 앞 요소 제거하며 읽기
        System.out.println(queue);
        System.out.println(queue.peek()); //Queue에서 제거하지 않고 맨 뒤 요소 읽기

        System.out.println();

        ListIterator<Integer> it = queue.listIterator();
        if(it.hasNext()){
            System.out.println(it.next());
            System.out.println(it.next());
            System.out.println(it.previous());
            System.out.println(it.previous());
        }

    }
}

public class Sample {
    public static void main(String[] args){
        QueueExample ex = new QueueExample();
        ex.method();
    }
}




/*
----------------------------------print----------------------------------
[11, 22, 33, 44, 55]
11
[22, 33, 44, 55]
22

22
33
33
22
-------------------------------------------------------------------------
 */
