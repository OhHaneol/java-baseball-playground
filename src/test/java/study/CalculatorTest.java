package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private List<String> values = new ArrayList<>();

    // input 값의 byte 배열을 스트림에 담아서 System.in 에 할당해주는 메서드
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void getCalcString() {
        systemIn("2 + 3 * 4 / 2");

        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        values.addAll(Arrays.asList(value.split(" ")));
    }

    int calculate(int n1, int n2, char operation) {
        int result;

        switch (operation) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }

    @Test
    @DisplayName("문자열 계산기")
    void calculator() {

        int result = 0;
        while (values.size() > 1) {
            result = calculate(
                    Integer.parseInt(values.get(0)),
                    Integer.parseInt(values.get(2)),
                    values.get(1).charAt(0));
            values.remove(0);
            values.remove(0);
            values.remove(0);
            values.add(0, String.valueOf(result));
        }

        assertThat(result).isEqualTo(10);
    }
}
