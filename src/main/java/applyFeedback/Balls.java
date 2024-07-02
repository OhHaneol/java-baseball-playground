package applyFeedback;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> answer) {
        this.balls = mapBall(answer);
    }

    private List<Ball> mapBall(List<Integer> answer) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answer.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(answer -> answer.play(userBall))   // ball.play 는 BallStatus 를 반환한다. 따라서 컴퓨터의 ball 3개에 대해 userBall 을 play 한 BallStatus 3개를 반환한다.
//                .filter(status -> status != BallStatus.NOTHING)
//                .filter(status -> status.isNotNothing())
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

}
