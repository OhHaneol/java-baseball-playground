package applyFeedback;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> answer) {
        this.answers = mapBall(answer);
    }

    private List<Ball> mapBall(List<Integer> answer) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answer.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))   // ball.play 는 BallStatus 를 반환한다. 따라서 컴퓨터의 ball 3개에 대해 userBall 을 play 한 BallStatus 3개를 반환한다.
//                .filter(status -> status != BallStatus.NOTHING)
//                .filter(status -> status.isNotNothing())
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }
        return result;
    }
}
