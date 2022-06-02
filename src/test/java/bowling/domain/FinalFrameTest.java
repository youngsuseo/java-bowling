package bowling.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinalFrameTest {

    @DisplayName("두번째 프레임에 스페어를 처리하는 경우 보너스 프레임 입력 가능")
    @Test
    void delivery_possibilityBonus() {
        FinalFrame finalFrame = new FinalFrame();
        finalFrame.delivery(3);
        assertThat(finalFrame.getFirstDelivery()).isEqualTo("3");

        finalFrame.delivery(7);
        assertThat(finalFrame.getSecondDelivery()).isEqualTo("/");

        finalFrame.delivery(10);
        assertThat(finalFrame.getBonusDelivery()).isEqualTo("X");
    }

    @DisplayName("첫번째 또는 두번째 프레임에서 스트라이크를 친 경우 보너스 프레임 입력가능, 두번째 프레임 기준으로 스페어 처리도 가능")
    @Test
    void spare() {
        FinalFrame finalFrame = new FinalFrame();
        finalFrame.delivery(10);
        assertThat(finalFrame.getFirstDelivery()).isEqualTo("X");

        finalFrame.delivery(8);
        assertThat(finalFrame.getSecondDelivery()).isEqualTo("8");

        finalFrame.delivery(2);
        assertThat(finalFrame.getBonusDelivery()).isEqualTo("/");
    }

    @DisplayName("점수에 따라 보너스 점수를 입력할 수 있는지 (additionallyDeliverable) 확인")
    @Test
    void additionallyDeliverable() {
        FinalFrame finalFrame = new FinalFrame();
        finalFrame.delivery(10);
        assertThat(finalFrame.additionallyDeliverable()).isTrue();

        finalFrame.delivery(7);
        assertThat(finalFrame.additionallyDeliverable()).isTrue();

        finalFrame.delivery(3);
        assertThat(finalFrame.additionallyDeliverable()).isFalse();
    }
}