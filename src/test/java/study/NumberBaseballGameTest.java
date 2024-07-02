package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class NumberBaseballGameTest {

    static final NumberBaseballGame nbg = new NumberBaseballGame();

    @DisplayName("스트라이크 검증")
    @CsvSource(value = {"123:321:false:1", "123:123:true:3", "123:456:false:0", "123:124:false:2"}, delimiter = ':')
    @ParameterizedTest(name = "[{index}] 추측 {0}과 목표 {1}에 대해: 스트라이크 개수는 {3}, 게임 성공 여부는 {2}")
    void strikeTest(int guess, int target, boolean expStrike, int expCnt) {

        boolean is3Strike = nbg.isStrike(guess, target);
        int strikeCnt = nbg.countStrike(guess, target);

        assertThat(is3Strike).isEqualTo(expStrike);

        assertThat(strikeCnt).isEqualTo(expCnt);
    }

    @DisplayName("볼 검증")
    @CsvSource(value = {"123:713:1", "145:713:1", "671:713:2"}, delimiter = ':')
    @ParameterizedTest(name = "[{index}] 추측 {0}과 목표 {1}에 대해: 볼의 개수는 {2}")
    public void ballTest(int guess, int target, int expCnt) {
        // when
        int ballCnt = nbg.countBall(guess, target);

        // then
        assertThat(ballCnt).isEqualTo(expCnt);
    }

}