package applyFeedback;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    @Test
    public void play_nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void play_1strike_1ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    public void play_3strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
//        assertThat(result.getStrike() == 3).isTrue(); // 값을 꺼내는 게 아니라(상태에 직접 접근 X)
        assertThat(result.isGameEnd()).isTrue();        // 메시지를 보내는 것이 객체지향
    }

    @Test
    public void nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    public void ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
