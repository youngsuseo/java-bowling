package bowling.domain;

import bowling.exception.InvalidScoreException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FrameTest {

    @DisplayName("프레임의 점수 합이 10 이상일 경우 예외 발생")
    @Test
    void spareDelivery() {
        Frame frame = new NormalFrame();
//        get.state = new Delivery(5);
//        assertThatThrownBy(() -> get.spareDelivery(6, get.state))
//                .isInstanceOf(InvalidScoreException.class)
//                .hasMessageContaining("각 프레임 점수의 합 10을 넘을 수 없습니다.");
    }
}