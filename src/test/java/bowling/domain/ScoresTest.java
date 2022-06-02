package bowling.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoresTest {

    @Test
    void construct() {
        assertThat(new Scores().getScores()).hasSize(10);
    }

}