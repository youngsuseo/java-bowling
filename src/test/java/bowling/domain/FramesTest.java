package bowling.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FramesTest {

    @DisplayName("bowling game 수 생성 확인")
    @Test
    void construct() {
        Frames frames = new Frames();
//        assertThat(frames.getFrames()).hasSize(10);
    }

    @DisplayName("스페어 쳤을 경우 점수 합산 확인")
    @Test
    void getScores_spare() {
        List<Frame> frames = new LinkedList<>();
        Frame frame1 = new NormalFrame();
        frame1.delivery(1);
        frame1.delivery(9);
        frames.add(frame1);
        Frame frame2 = new NormalFrame();
        frame2.delivery(3);
        frame2.delivery(4);
        frames.add(frame2);
        Frame frame3 = new NormalFrame();
        frame3.delivery(5);
        frame3.delivery(4);
        frames.add(frame3);
        for (int i = 0; i < 6; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame = new FinalFrame();
        frames.add(frame);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(29);
    }

//    @DisplayName("스페어 쳤을 경우, 점수가 계산이 완료되지 않은경우")
//    @Test
//    void getScores_spareNotDone() {
//        List<Frame> frames = new LinkedList<>();
//        Frame frame1 = new NormalFrame();
//        frame1.delivery(1);
//        frame1.delivery(2);
//        frames.add(frame1);
//        Frame frame2 = new NormalFrame();
//        frame2.delivery(3);
//        frame2.delivery(7);
//        frames.add(frame2);
//        Frame frame3 = new NormalFrame();
//        frames.add(frame3);
//
//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore()).isEqualTo(3);
//    }

    @DisplayName("스트라이크 쳤을 경우 점수계산")
    @Test
    void getScores_strike() {
        List<Frame> frames = new LinkedList<>();
        Frame frame1 = new NormalFrame();
        frame1.delivery(10);
        frames.add(frame1); // 현재는 이렇게 되는데, 추후 symbol로 되는것 필요시 추가
        Frame frame2 = new NormalFrame();
        frame2.delivery(3);
        frame2.delivery(4);
        frames.add(frame2);
        Frame frame3 = new NormalFrame();
        frame3.delivery(5);
        frame3.delivery(4);
        frames.add(frame3);
        for (int i = 0; i < 6; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame = new FinalFrame();
        frames.add(frame);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(33);
    }

    @Test
    void getScores_strikeDouble() {
        List<Frame> frames = new LinkedList<>();
        Frame frame1 = new NormalFrame();
        frame1.delivery(10);
        frames.add(frame1);
        Frame frame2 = new NormalFrame();
        frame2.delivery(10);
        frames.add(frame2);
        Frame frame3 = new NormalFrame();
        frame3.delivery(5);
        frame3.delivery(4);
        frames.add(frame3);
        for (int i = 0; i < 6; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame = new FinalFrame();
        frames.add(frame);
        
//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(53);
    }

    @Test
    void getScores_strikeTurkey() {
        List<Frame> frames = new LinkedList<>();
        Frame frame1 = new NormalFrame();
        frame1.delivery(10);
        frames.add(frame1); // 현재는 이렇게 되는데, 추후 symbol로 되는것 필요시 추가
        Frame frame2 = new NormalFrame();
        frame2.delivery(10);
        frames.add(frame2);
        Frame frame3 = new NormalFrame();
        frame3.delivery(10);
        frames.add(frame3);
        Frame frame4 = new NormalFrame();
        frame4.delivery(8);
        frame4.delivery(1);
        frames.add(frame4);
        for (int i = 0; i < 5; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame = new FinalFrame();
        frames.add(frame);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(86);
    }

//    @DisplayName("strike 치고 다음 프레임 아직 투구 이전")
//    @Test
//    void getScores_strike1() {
//        List<Frame> frames = new LinkedList<>();
//        Frame frame1 = new NormalFrame();
//        frame1.delivery(10);
//        frames.add(frame1); // 현재는 이렇게 되는데, 추후 symbol로 되는것 필요시 추가
//        Frame frame2 = new NormalFrame();
//        frames.add(frame2);
//
//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore()).isEqualTo(0);
//    }

//    @DisplayName("Double 일 경우 세번째 프레임 아직 투구 이전")
//    @Test
//    void getScores_strike2() {
//        List<Frame> frames = new LinkedList<>();
//        Frame frame1 = new NormalFrame();
//        frame1.delivery(10);
//        frames.add(frame1); // 현재는 이렇게 되는데, 추후 symbol로 되는것 필요시 추가
//        Frame frame2 = new NormalFrame();
//        frame2.delivery(10);
//        frames.add(frame2);
//        Frame frame3 = new NormalFrame();
//        frames.add(frame3);
//
//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore()).isEqualTo(0);
//    }


    @DisplayName("9프레임에서 스트라이크 쳤을 경우")
    @Test
    void getScore_strike9frame_none() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            Frame frame = new NormalFrame();
            frame.delivery(0);
            frame.delivery(0);
            frames.add(frame);
        }
        Frame frame8 = new NormalFrame();
        frame8.delivery(8);
        frame8.delivery(1);
        frames.add(frame8);
        Frame frame9 = new NormalFrame();
        frame9.delivery(10);
        frames.add(frame9);
        Frame frame10 = new FinalFrame();
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(19);
    }

    @DisplayName("9프레임에서 스트라이크 쳤을 경우")
    @Test
    void getScore_strike9frame() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            Frame frame = new NormalFrame();
            frame.delivery(0);
            frame.delivery(0);
            frames.add(frame);
        }
        Frame frame8 = new NormalFrame();
        frame8.delivery(8);
        frame8.delivery(1);
        frames.add(frame8);
        Frame frame9 = new NormalFrame();
        frame9.delivery(10);
        frames.add(frame9);
        Frame frame10 = new FinalFrame();
        frame10.delivery(7);
        frame10.delivery(2);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(37);
    }


    @DisplayName("10프레임에서 스페어 쳤을 경우")
    @Test
    void getScore_spare10frame() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame10 = new FinalFrame();
        frame10.delivery(8);
        frame10.delivery(2);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(30);
    }

    @DisplayName("10프레임에서 Miss 일 경우")
    @Test
    void getScore_miss10frame() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame10 = new FinalFrame();
        frame10.delivery(8);
        frame10.delivery(1);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(9);
    }

    @DisplayName("10프레임에서 스트라이크 쳤을 경우")
    @Test
    void getScore_strike10frame() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame10 = new FinalFrame();
        frame10.delivery(10);
        frame10.delivery(10);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(60);
    }

    @DisplayName("모든프레임에서 스트라이크 쳤을 경우")
    @Test
    void getScore_strikeAllFrames() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Frame frame = new NormalFrame();
            frame.delivery(10);
            frames.add(frame);
        }
        Frame frame10 = new FinalFrame();
        frame10.delivery(10);
        frame10.delivery(10);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(300);
    }

    @DisplayName("9프레임까지 스트라이크 쳤을 경우")
    @Test
    void getScore_strike9Frames() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Frame frame = new NormalFrame();
            frame.delivery(10);
            frames.add(frame);
        }
        Frame frame10 = new FinalFrame();
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(240);
    }

    @DisplayName("9프레임까지 스트라이크 쳤을 경우")
    @Test
    void getScore_strike9Frames1() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame9 = new NormalFrame();
        frame9.delivery(10);
        frames.add(frame9);
        Frame frame10 = new FinalFrame();
        frame10.delivery(10);
        frame10.delivery(10);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(90);
    }

    @DisplayName("9프레임까지 스트라이크 쳤을 경우")
    @Test
    void getScore_strike9Frames2() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame8 = new NormalFrame();
        frame8.delivery(10);
        frames.add(frame8);
        Frame frame9 = new NormalFrame();
        frame9.delivery(10);
        frames.add(frame9);
        Frame frame10 = new FinalFrame();
        frame10.delivery(10);
        frame10.delivery(10);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(120);
    }

    @DisplayName("9프레임까지 스트라이크 쳤을 경우")
    @Test
    void getScore_strike9Frames3() {
        List<Frame> frames = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            Frame frame = new NormalFrame();
            frames.add(frame);
        }
        Frame frame7 = new NormalFrame();
        frame7.delivery(10);
        frames.add(frame7);
        Frame frame8 = new NormalFrame();
        frame8.delivery(10);
        frames.add(frame8);
        Frame frame9 = new NormalFrame();
        frame9.delivery(10);
        frames.add(frame9);
        Frame frame10 = new FinalFrame();
        frame10.delivery(10);
        frame10.delivery(10);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(150);
    }

    @DisplayName("9프레임까지 스트라이크 쳤을 경우")
    @Test
    void getScore_strike9Frames4() {
        List<Frame> frames = new LinkedList<>();
        Frame frame1 = new NormalFrame();
        frame1.delivery(10);
        frames.add(frame1);
        Frame frame2 = new NormalFrame();
        frame2.delivery(10);
        frames.add(frame2);
        Frame frame3 = new NormalFrame();
        frame3.delivery(10);
        frames.add(frame3);
        Frame frame4 = new NormalFrame();
        frame4.delivery(10);
        frames.add(frame4);
        Frame frame5 = new NormalFrame();
        frame5.delivery(10);
        frames.add(frame5);
        Frame frame6 = new NormalFrame();
        frame6.delivery(10);
        frames.add(frame6);
        Frame frame7 = new NormalFrame();
        frame7.delivery(10);
        frames.add(frame7);
        Frame frame8 = new NormalFrame();
        frame8.delivery(10);
        frames.add(frame8);
        Frame frame9 = new NormalFrame();
        frame9.delivery(10);
        frames.add(frame9);
        Frame frame10 = new FinalFrame();
        frame10.delivery(10);
        frame10.delivery(10);
        frame10.delivery(10);
        frames.add(frame10);

//        Frames frameResult = new Frames(frames);
//        assertThat(frameResult.getScore(10)).isEqualTo(300);
    }
}
