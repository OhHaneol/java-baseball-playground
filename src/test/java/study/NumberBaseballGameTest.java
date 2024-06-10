package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    static final NumberBaseballGame nbg = new NumberBaseballGame();

    @Test
    @DisplayName("스트라이크 검증")
    @CsvSource(value = {"123:321:false:1", "123:123:true:3", "123:456:false:0", "123:124:false:2"}, delimiter = ':')
    @ParameterizedTest(name = "[{index}] 추측 {0}과 목표 {1}에 대해: 스트라이크 개수는 {3}, 게임 성공 여부는 {2}")
    void strikeTest(int guess, int target, boolean expStrike, int expCnt) {

        boolean is3Strike = nbg.isStrike(guess, target);
        int strikeCnt = nbg.countStrike(guess, target);

        Assertions.assertThat(is3Strike).isEqualTo(expStrike);

        Assertions.assertThat(strikeCnt).isEqualTo(expCnt);
    }

}