package bowling.view;

import bowling.domain.frame.*;
import bowling.domain.frame.FinalFrame;
import bowling.domain.frame.AbstractFrame;

import java.util.Optional;

public class ResultView {
    private static final String PRINT_NORMAL_FRAME_FORMAT = "%4s%3s";
    private static final String PRINT_FINAL_FRAME_FORMAT = "%5s%4s";

    public static void printBowlingGame(String playerName, Frames frames, int frameIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |   10   |\n");
        stringBuilder.append("| ").append(String.format("%4s", playerName)).append(" |");
        FrameLinkedList frameLinkedList = frames.getFrames();
        for (int i = 0; i < frameLinkedList.size(); i++) {
            AbstractFrame abstractFrame = frameLinkedList.get(i);
            if (abstractFrame instanceof FinalFrame) {
                stringBuilder.append(printFinalScore((FinalFrame) abstractFrame));
                continue;
            }
            stringBuilder.append(printScore(abstractFrame));
        }

        stringBuilder.append("\n|      |");
        int resultScore = 0;
        for (int i = 0; i < frameLinkedList.size(); i++) {
            AbstractFrame abstractFrame = frameLinkedList.get(i);
            int score = abstractFrame.getScore();
            resultScore += score;
            if (abstractFrame instanceof FinalFrame) {
                stringBuilder.append(printCalculatedScore(PRINT_FINAL_FRAME_FORMAT, resultScore, isVisible(frameIndex, i, score)));
                continue;
            }
            stringBuilder.append(printCalculatedScore(PRINT_NORMAL_FRAME_FORMAT, resultScore, isVisible(frameIndex, i, score)));
        }

        System.out.println(stringBuilder.toString());
    }

    private static boolean isVisible(int frameIndex, int i, int score) {
        boolean visible = i <= frameIndex;
        if (score == 0) {
            visible = false;
        }
        return visible;
    }

    private static String printScore(AbstractFrame abstractFrame) {
        String other;
        if (abstractFrame.getFirstHalfFrameState().getFallenPins() == 0) {
            other = "";
        } else {
            other = String.valueOf(abstractFrame.getFirstHalfFrameState().getFallenPins());
        }

        String firstScore = Optional.ofNullable(abstractFrame.getFirstHalfFrameState().getSymbol()).orElse(other);
        String secondScore = Optional.ofNullable(abstractFrame.getSecondHalfFrameState().getSymbol()).orElse("");

        if (!"".equals(secondScore)) {
            secondScore = "|" + secondScore;
        }

        return String.format("%3s%2s%2s", firstScore, secondScore, "|");
    }

    private static String printFinalScore(FinalFrame finalFrame) {
        String firstScore = Optional.ofNullable(finalFrame.getFirstHalfFrameState().getSymbol()).orElse("");
        String secondScore = Optional.ofNullable(finalFrame.getSecondHalfFrameState().getSymbol()).orElse("");
        String bonusScore = Optional.ofNullable(finalFrame.getBonusState().getSymbol()).orElse("");

        if (!"".equals(secondScore)) {
            secondScore = "|" + secondScore;
        }

        if (!"".equals(bonusScore)) {
            bonusScore = "|" + bonusScore;
        }

        return String.format("%3s%2s%2s%2s", firstScore, secondScore, bonusScore, "|");
    }

    private static String printCalculatedScore(String format, int score, boolean visible) {
        return String.format(format, visible ? String.valueOf(score) : "", "|");
    }
}
