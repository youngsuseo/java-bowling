package bowling.domain.frame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameFactoryTest {

    @Test
    void factoryTest() {

        AbstractFrame first = FrameFactory.first();

        assertThat(first).isInstanceOf(NormalFrame.class);
        assertThat(FrameFactory.last()).isInstanceOf(LastFrame.class);

        for (int i = 0; i < 9; i++) {
            assertThat(FrameFactory.next(i)).isInstanceOf(NormalFrame.class);
        }

        assertThat(FrameFactory.next(9)).isInstanceOf(LastFrame.class);
    }
}