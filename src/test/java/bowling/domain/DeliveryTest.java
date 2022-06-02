package bowling.domain;

import bowling.exception.InvalidDeliveryScoreException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DeliveryTest {

    @DisplayName("정상적으로 delivery 인스턴스 생성 확인")
    @Test
    void construct() {
        assertThat(new Delivery("5")).isNotNull();
    }

    @DisplayName("10이 넘는 숫자를 입력하는 경우 오류발생")
    @Test
    void construct_inputOver10() {
        assertThatThrownBy(() -> new Delivery("11"))
                .isInstanceOf(InvalidDeliveryScoreException.class)
                .hasMessageContaining("입력한 숫자는 10을 넘을 수 없습니다.");
    }
}