package bowling.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalFrameTest {

    @DisplayName("10점을 받았을 경우 스트라이크가 되며 X 라는 문자열로 치환된다.")
    @Test
    void delivery_strike() {
        Frame frame = new NormalFrame();
        frame.delivery(10);
        assertThat(frame.getFirstDelivery()).isEqualTo("X");
    }

    @DisplayName("첫번째 투구과 두번째 투구의 값을 합쳤을 때 10이 나오면 스페어 '/' 문자열로 치환된다.")
    @Test
    void delivery_spare() {
        Frame frame = new NormalFrame();
        frame.delivery(3);
        assertThat(frame.getFirstDelivery()).isEqualTo("3");

        frame.delivery(7);
        assertThat(frame.getSecondDelivery()).isEqualTo("/");
    }

    @DisplayName("첫번째 투구에서 스트라이크 치는 경우 두번째 투구 불가능 (additionallyDeliverable == false)")
    @Test
    void additionallyDeliverable_strike() {
        Frame frame = new NormalFrame();
        frame.delivery(10);
        assertThat(frame.additionallyDeliverable()).isFalse();
    }

    @DisplayName("첫번째 투구에서 스트라이크를 치지 않은 경우 두번째 투구까지 가능")
    @Test
    void additionallyDeliverable() {
        Frame frame = new NormalFrame();
        frame.delivery(3);
        assertThat(frame.additionallyDeliverable()).isTrue();

        frame.delivery(4);
        assertThat(frame.additionallyDeliverable()).isFalse();
    }
}
