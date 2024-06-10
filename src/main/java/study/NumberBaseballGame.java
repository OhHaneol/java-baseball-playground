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

            isBall(guess, target);
            is3strike = isStrike(guess, target);
            isNothing(guess, target);
        } while (!is3strike);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    static void isBall(int guess, int target) {
    }

    static boolean isStrike(int guess, int target) {
        int strikeCnt = countStrike(guess, target);

        if (strikeCnt == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        if (strikeCnt == 0) {
            return false;
        }

        System.out.println(strikeCnt + "스트라이크");
        return false;
    }

    static int countStrike(int guess, int target) {

        if (guess == 0) return 0;    // 끝나면 0을 반환

        if (guess % 10 == target % 10) return 1 + countStrike(guess / 10, target / 10);
        return countStrike(guess / 10, target / 10);
    }

    static void isNothing(int guess, int target) {
    }
}
