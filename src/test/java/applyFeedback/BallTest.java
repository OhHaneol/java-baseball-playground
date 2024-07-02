package applyFeedback;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    @Test
    public void nothing() {
        Ball com = new Ball(1, 4);
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    public void ball() {
        Ball com = new Ball(1, 4);
        BallStatus status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void strike() {
        Ball com = new Ball(1, 4);
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
