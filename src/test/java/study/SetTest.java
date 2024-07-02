package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1 - 크기 확인")
    void sizeOfSet() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest(name = "[{index}] 테스트 인자 {0}")   // 메서드 파라미터의 인덱스를 이용한
    @ValueSource(ints = {1, 1, 2, 3})   // 여기에 대해서 테스트, i 에 넣을 값들?
    @DisplayName("요구사항 2 - 값의 존재 여부 확인")
    void isContaining(Integer integer) {    // int 가 아니라, 객체인 Integer 타입으로.
        assertThat(numbers.contains(integer)).isTrue();
    }

    @ParameterizedTest(name = "[{index}] 테스트 인자 {0}에 대한 결과 {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3 - 입력 값에 따른 결과 값 확인")
    void isContaining(Integer integer, boolean result) {
        assertThat(numbers.contains(integer)).isEqualTo(result);
    }
}
