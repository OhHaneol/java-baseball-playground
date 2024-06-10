package study;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseballGame {
    public static void main(String[] args) {

        int choice;
        do {
            numberBaseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        } while (choice != 2);
    }

    static void numberBaseballGame() {
        Random random = new Random();
        int target = random.nextInt(899) + 100; // 100 ~ 999

        boolean is3strike;
        do {
            System.out.println("숫자를 입력해 주세요 : ");
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();

            is3strike = isStrike(guess, target);
            isBall(guess, target);
            isNothing(guess, target);
        } while (!is3strike);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static boolean isStrike(int guess, int target) {
    }

    static void isBall(int guess, int target) {
    }

    static void isNothing(int guess, int target) {
    }
}
