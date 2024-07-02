package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.String;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 분리() {
        // 요구사항 1
        String[] str1 = "1,2".split(",");
        assertThat(str1).contains("1");
        assertThat(str1).containsExactly("1", "2");
        assertThat(str1.length).isEqualTo(2);

        String[] str2 = "1".split(",");
        assertThat(str2).contains("1");
        assertThat(str2).containsExactly("1");
        assertThat(str2.length).isEqualTo(1);

        // 요구사항 2
        String[] str3 = "(1,2)".substring(1, 4).split(",");
        assertThat(str3).containsExactly("1", "2");
        assertThat(str3.length).isEqualTo(2);
    }

    // 요구사항 3
    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void 특정위치문자() {
        String str = "abc";

        // 올바른 문자 반환
        assertThat(str.charAt(0)).isEqualTo('a');

        // 인덱스 범위 초과 예외 발생
        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(str.length()));
    }
}
