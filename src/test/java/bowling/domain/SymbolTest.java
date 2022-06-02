package bowling.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolTest {

    @DisplayName("점수를 입력 받았을 때 strike, spare, gutter 문자로 변환 확인")
    @Test
    void value() {
        assertThat(Symbol.value(10, true)).isEqualTo("/");
        assertThat(Symbol.value(10, false)).isEqualTo("X");
        assertThat(Symbol.value(0, false)).isEqualTo("-");
    }
}