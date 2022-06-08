package bowling.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Frames {
    private static final int NUMBERS_OF_NORMAL_FRAME = 9;

    private FrameLinkedList frames;

    public Frames() {
        initial();
    }

    Frames(FrameLinkedList frameLinkedList) {
        this.frames = frameLinkedList;
    }

    private void initial() {
        frames =  new FrameLinkedList();
        for (int frameIndex = 0; frameIndex < NUMBERS_OF_NORMAL_FRAME - 1; frameIndex++) {
            frames.add(new NormalFrame());
        }
        frames.add(new FinalFrame());
    }

    public int getScore(int frameIndex) {
        int result = 0;
//        for (int i = 0; i <= frameIndex; i++) {
//            if (i == 8) {
//                Frame thisFrame = frames.get(i);
//                FinalFrame nextFrame = (FinalFrame) frames.get(i + 1);
//
//                if (thisFrame.firstState instanceof Strike) {
//                    Score score = new Score(thisFrame.getScore(), 2);
//                    Score bowl = score.bowl(nextFrame.firstState.countOfPins);
//                    Score totalScore = bowl.bowl(nextFrame.secondState.countOfPins);
//                    result += totalScore.getScore();
//                    continue;
//                }
//
//                if (thisFrame.secondState instanceof Spare) {
//                    Score score = new Score(thisFrame.getScore(), 1);
//                    Score bowl = score.bowl(nextFrame.firstState.countOfPins);
//                    result += bowl.getScore();
//                    continue;
//                }
//                result += thisFrame.getScore();
//                continue;
//            }
//
//            if (i == 9) {
//                FinalFrame thisFrame = (FinalFrame) frames.get(i);
//                if (!(thisFrame.secondState instanceof Miss) && (thisFrame.getBonusState() instanceof Ready)) {
//                    return 0;
//                }
//                result += thisFrame.getScore();
//                continue;
//            }
//
//            Frame thisFrame = frames.get(i);
//            Frame nextFrame = frames.get(i + 1);
//            Frame afterNextFrame = frames.get(i + 2);
//
//            if (thisFrame.firstState instanceof Strike) {
//                Score score = new Score(thisFrame.getScore(), 2);
//                Score bowl = score.bowl(nextFrame.firstState.countOfPins);
//
//                if (nextFrame.getFirstState() instanceof Ready) {
//                    return 0;
//                }
//
//                Score totalScore;
//                if (nextFrame.firstState instanceof Strike) {
//                    if (afterNextFrame.getFirstState() instanceof Ready) {
//                        return 0;
//                    }
//
//                    totalScore = bowl.bowl(afterNextFrame.firstState.countOfPins);
//                } else {
//                    if (nextFrame.getSecondState() instanceof Ready) {
//                        return 0;
//                    }
//
//                    totalScore = bowl.bowl(nextFrame.secondState.countOfPins);
//                }
//
//                result += totalScore.getScore();
//                continue;
//            }
//
//            if (thisFrame.secondState instanceof Spare) {
//                Score score = new Score(thisFrame.getScore(), 1);
//                if (nextFrame.getFirstState() instanceof Ready) {
//                    return 0;
//                }
//
//                Score bowl = score.bowl(nextFrame.firstState.countOfPins);
//                result += bowl.getScore();
//                continue;
//            }
//
//            if (thisFrame.getSecondState() instanceof Ready) {
//                return 0;
//            }
//            result += thisFrame.getScore();
//        }
        return result;
    }

    public Frame get() {
        return frames.get();
    }

    public FrameLinkedList getFrames() {
        return frames;
    }
}
