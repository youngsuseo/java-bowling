package bowling;

import bowling.domain.Player;
import bowling.domain.frame.FrameLinkedList;
import bowling.domain.frame.Frames;
import bowling.domain.frame.Frame;
import bowling.view.InputView;
import bowling.view.ResultView;

import java.util.ArrayList;

public class BowlingMain {
    private static final int NUMBERS_OF_NORMAL_FRAMES = 9;
    private static final int INITIAL_INDEX = 0;

    public static void main(String[] args) {
        int numberOfPlayers = InputView.inputNumberOfPlayers();
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(InputView.inputPlayerName()));
        }


        Player player = new Player(InputView.inputPlayerName()); // FIXME 교체 필요

        Frames frames = new Frames();
        int frameIndex = INITIAL_INDEX;

        while (frameIndex <= NUMBERS_OF_NORMAL_FRAMES) {
            FrameLinkedList frameLinkedList = frames.getFrames();
            Frame frame = frameLinkedList.get(frameIndex);
            frame.delivery(InputView.inputScore(frameIndex + 1));
            ResultView.printBowlingGame(player.getName(), frames, frameIndex);

            if (frame.additionallyDeliverable()) {
                continue;
            }
            frameIndex++;
        }
    }
}
