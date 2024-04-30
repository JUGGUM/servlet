package hello.servlet.domain.coffee.study;

import lombok.Getter;

import java.util.*;

/**
 * Map 실습
 */
@Getter
class Phone {

    private final String name;
    private final String address;
    private final String telephone;

    Phone(String name, String address, String telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

}


public class TelManagement {

    //삽입
    public static void insert(HashMap<String, Phone> map) {
        Phone phone;
        String name, address, telephone;
        Scanner s = new Scanner(System.in);

        System.out.print("이름 >> ");
        name = s.next();
        System.out.print("주소 >> ");
        address = s.next();
        System.out.print("전화번호 >> ");
        telephone = s.next();

        phone = new Phone(name, address, telephone);
        map.put(phone.getName(), phone);
    }

    //삭제
    public static void delete(HashMap<String, Phone> map) {
        String deletename;
        Scanner sc = new Scanner(System.in);

        System.out.print("이름>> ");
        deletename = sc.next();
        if (map.containsKey(deletename)) {
            map.remove(deletename);
            System.out.println("삭제가 정상적으로 완료되었습니다.");
        } else {
            System.out.println(deletename + "은 등록되지 않은 사람입니다.");
        }
    }

    //찾기
    public static void search(HashMap<String, Phone> map) {
        Scanner s = new Scanner(System.in);
        String searchname;

        System.out.print("이름 >> ");
        searchname = s.next();
        if (map.containsKey(searchname)) {
            System.out.println(
                    searchname + " " + map.get(searchname).getAddress() + " " + map.get(searchname)
                            .getTelephone());
        } else {
            System.out.println(searchname + "은 등록되지 않은 사람입니다. ");
        }
    }

    //전체보기
    public static void printall(HashMap<String, Phone> map) {
        Set<String> names = map.keySet();
        Iterator<String> it = names.iterator(); // 반복자는 객체지향적 프로그래밍에서 배열이나 자료구조의 내부요소를 순회하는 객체
        /**
         * for과 while을 써도되지만 set같이 인덱스가 없는 경우에 사용하기 좋음
         * Iterator의 장점
         * 1. 컬렉션에서 요소를 제어하는 기능
         * 2. next() 및 previous()를 써서 앞뒤로 이동하는 기능
         * 3. hasNext()를 써서 더 많은 요소가 있는지 확인하는 기능
         */

        while (it.hasNext()) {
            String name = it.next();
            Phone student = map.get(name);
            System.out.println(name + " " + student.getAddress() + " " + student.getTelephone());

        }
    }


    //main
    public static void main(String[] args) {
        int menu;
        HashMap<String, Phone> map = new HashMap<>();
        Scanner s = new Scanner(System.in);

        System.out.println("----------------------------------------------------");
        System.out.println(" 전화번호 관리 프로그램을 시작합니다. ");
        System.out.println("----------------------------------------------------");

        while (true) {
            System.out.print("삽입:0, 삭제:1, 찾기:2, 전체보기:3, 종료:4 >> ");
            menu = s.nextInt();

            switch (menu) {
                case 0:
                    insert(map);
                    break;
                case 1:
                    delete(map);
                    break;
                case 2:
                    search(map);
                    break;
                case 3:
                    printall(map);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }
}
