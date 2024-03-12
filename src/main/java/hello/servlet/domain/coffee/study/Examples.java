package hello.servlet.domain.coffee.study;

import java.util.*;

public class Examples {
    public static void main(String[] args) {
        int size;
        List<String> list = new ArrayList<>();


        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add(1, "J");

        size = list.size();
        System.out.println("저장된 객체 수 : " + size);

        for (int i = 0; i < size; i++) {
            //데이터를 인덱스로 관리
            System.out.print(i + "번째 : " + list.get(i));
            System.out.println();
        }


        System.out.println();
        System.out.println("----------------변경 후----------------");
        System.out.println();


        list.remove(1);
        list.remove(1);

        size = list.size();

        for (int i = 0; i < size; i++) {
            System.out.print(i + "번째 : " + list.get(i));
            System.out.println();
        }

    }
}
