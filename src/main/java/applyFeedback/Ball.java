package applyFeedback;

public class Ball {
    private final int position;
    private final BallNumber ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = new BallNumber(ballNo);
    }

    public BallStatus play(Ball myBall) {
//        if (this.equals(myBall)) {          // myBall.equal(this) 는 nullPointException 이 발생할 수 있다.
        if (myBall.ballNo == this.ballNo && myBall.position == this.position) {          // myBall.equal(this) 는 nullPointException 이 발생할 수 있다.
            return BallStatus.STRIKE;
        }
        if (matchBallNo(myBall.ballNo)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(BallNumber ballNo) {
        return this.ballNo == ballNo;
    }
}
