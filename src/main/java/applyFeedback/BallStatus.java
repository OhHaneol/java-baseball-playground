package applyFeedback;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
