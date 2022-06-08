package bowling.view;

import bowling.domain.*;

import java.util.Optional;

public class ResultView {
    private static final int NUMBERS_OF_NORMAL_FRAMES = 10;

    public static void printBowlingGame(String playerName, Frames frames, int frameIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |   10   |\n");
        stringBuilder.append("| ").append(String.format("%4s", playerName)).append(" |");
        FrameLinkedList frameLinkedList = frames.getFrames();
        for (int i = 0; i <= frameLinkedList.size(); i++) {
            Frame frame = frameLinkedList.get(i);
            if (frame instanceof FinalFrame) {
                stringBuilder.append(printFinalScore((FinalFrame) frame));
                continue;
            }
            stringBuilder.append(printScore(frame));
        }

        stringBuilder.append("\n|      |");
        for (int i = 0; i < frameLinkedList.size(); i++) {
            Frame frame = frameLinkedList.get(i);
            int score = frame.getScore();
            if (frame instanceof FinalFrame) {
                stringBuilder.append(printCalculatedFinalScore(score, i <= frameIndex));
                continue;
            }
            stringBuilder.append(printCalculatedScore(score, i <= frameIndex));
        }

        System.out.println(stringBuilder.toString());
    }

    private static String printScore(Frame frame) {
        String other;
        if (frame.getFirstState().getCountOfPins() == 0) {
            other = "";
        } else {
            other = String.valueOf(frame.getFirstState().getCountOfPins());
        }

        String firstScore = Optional.ofNullable(frame.getFirstState().getSymbol()).orElse(other);
        String secondScore = Optional.ofNullable(frame.getSecondState().getSymbol()).orElse("");

        if (!"".equals(secondScore)) {
            secondScore = "|" + secondScore;
        }

        return String.format("%3s%2s%2s", firstScore, secondScore, "|");
    }

    private static String printFinalScore(FinalFrame finalFrame) {
        String firstScore = Optional.ofNullable(finalFrame.getFirstState().getSymbol()).orElse("");
        String secondScore = Optional.ofNullable(finalFrame.getSecondState().getSymbol()).orElse("");
        String bonusScore = Optional.ofNullable(finalFrame.getBonusState().getSymbol()).orElse("");

        if (!"".equals(secondScore)) {
            secondScore = "|" + secondScore;
        }

        if (!"".equals(bonusScore)) {
            bonusScore = "|" + bonusScore;
        }

        return String.format("%3s%2s%2s%2s", firstScore, secondScore, bonusScore, "|");
    }

    private static String printCalculatedScore(int score, boolean visible) {
        String stringScore;
        if (score == 0) {
            stringScore = "";
        } else {
            stringScore = String.valueOf(score);
        }

        return String.format("%4s%3s", visible ? stringScore : "", "|");
    }

    private static String printCalculatedFinalScore(int score, boolean visible) {
        String stringScore;
        if (score == 0) {
            stringScore = "";
        } else {
            stringScore = String.valueOf(score);
        }

        return String.format("%5s%4s", visible ? stringScore : "", "|");
    }
}
