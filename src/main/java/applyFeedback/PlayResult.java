package applyFeedback;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public int getNothing() {
        return 0;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike++;
        }
        if (status.isBall()) {
            this.ball++;
        }
    }

    public boolean isGameEnd() {
        return strike == 3;
    }
}
