package bowling.domain.state;

import bowling.domain.Score;
import bowling.domain.frame.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FullFrameStateTest {

    @DisplayName("볼링 점수 상태 (스트라이크, 스페어, 미스, 거터)에 따라 Score 객체 생성")
    @Test
    void createScore_strike() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.delivery(10);
        FullFrameState fullFrameState = normalFrame.getFullFrameState();
        Score score = fullFrameState.createScore();
        assertThat(score).isEqualTo(new Score(10, 2));
    }

    @DisplayName("볼링 점수 상태 (스트라이크, 스페어, 미스, 거터)에 따라 Score 객체 생성")
    @Test
    void createScore_spare() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.delivery(9);
        normalFrame.delivery(1);
        FullFrameState fullFrameState = normalFrame.getFullFrameState();
        Score score = fullFrameState.createScore();
        assertThat(score).isEqualTo(new Score(10, 1));
    }

    @DisplayName("볼링 점수 상태 (스트라이크, 스페어, 미스, 거터)에 따라 Score 객체 생성")
    @Test
    void createScore_miss() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.delivery(3);
        normalFrame.delivery(3);
        FullFrameState fullFrameState = normalFrame.getFullFrameState();
        Score score = fullFrameState.createScore();
        assertThat(score).isEqualTo(new Score(6, 0));
    }
}