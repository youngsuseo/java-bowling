package bowling;

import bowling.domain.Player;
import bowling.domain.Players;
import bowling.domain.frame.FrameLinkedList;
import bowling.domain.frame.Frames;
import bowling.domain.frame.Frame;
import bowling.view.InputView;
import bowling.view.ResultView;

import java.util.LinkedHashMap;
import java.util.Map;

public class BowlingMain {
    private static final int NUMBERS_OF_NORMAL_FRAMES = 9;
    private static final int INITIAL_INDEX = 0;

    public static void main(String[] args) {
//        int numberOfPlayers = InputView.inputNumberOfPlayers(); // FIXME 해당 내용 수정
        Map<Player, Frames> playerMap = new LinkedHashMap<>();
        for (int i = 0; i < 2; i++) {
            playerMap.put(new Player(InputView.inputPlayerName()), new Frames());
        }
        Players players = new Players(playerMap);

        int frameIndex = INITIAL_INDEX;

        while (frameIndex <= NUMBERS_OF_NORMAL_FRAMES) {
            for (Player player : players.getPlayers().keySet()) {
                Frames frames = playerMap.get(player);
                FrameLinkedList frameLinkedList = frames.getFrames();
                Frame frame = frameLinkedList.get(frameIndex);
                frame.delivery(InputView.inputScore(player, frameIndex + 1));
                ResultView.printBowlingGame(player.getName(), frames, frameIndex);

                if (frame.additionallyDeliverable()) {
                    continue;
                }
                frameIndex++;
            }
        }
    }
}
