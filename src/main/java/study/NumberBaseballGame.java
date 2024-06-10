package study;

import java.util.Scanner;

public class NumberBaseballGame {
    public static void main(String[] args) {


        int i;
        do {
            numberBaseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
        } while (i != 2);
    }

    static void numberBaseballGame() {

    }
}
