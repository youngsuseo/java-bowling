package bowling;

import bowling.domain.Player;
import bowling.domain.Players;
import bowling.domain.frame.FrameLinkedList;
import bowling.domain.frame.Frames;
import bowling.domain.frame.AbstractFrame;
import bowling.view.InputView;
import bowling.view.ResultView;

import java.util.LinkedHashMap;
import java.util.Map;

public class BowlingMain {
    private static final int NUMBERS_OF_FRAMES = 10;
    private static final int INITIAL_INDEX = 0;

    public static void main(String[] args) {
        Players players = createPlayers();
        for (int frameIndex = INITIAL_INDEX; frameIndex < NUMBERS_OF_FRAMES; frameIndex++) {
            getPlayersScore(players, frameIndex);
        }
    }

    private static Players createPlayers() {
        // TODO Factory 로 변경하려고 했는데 view 단이 도메인, factory 클래스로 옮겨지는 것이 싫어 이렇게 구현
        //  controller 라고 생각시에 어떻게 진행하면 되는지?
        int numberOfPlayers = InputView.inputNumberOfPlayers();

        Map<Player, Frames> playerMap = new LinkedHashMap<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            playerMap.put(new Player(InputView.inputPlayerName()), new Frames());
        }
        return new Players(playerMap);
    }

    private static void getPlayersScore(Players players, int frameIndex) {
        Map<Player, Frames> playersMap = players.getPlayers();
        for (Player player : playersMap.keySet()) {
            getEachPlayersScore(frameIndex, player, playersMap.get(player));
        }
    }

    private static void getEachPlayersScore(int frameIndex, Player player, Frames frames) {
        FrameLinkedList frameLinkedList = frames.getFrames();
        AbstractFrame abstractFrame = frameLinkedList.get(frameIndex);

        abstractFrame.bowl(InputView.inputScore(player, frameIndex + 1));
        ResultView.printBowlingGame(player.getName(), frames, frameIndex);

        if (abstractFrame.capableOfAdditionalBowling()) {
            getEachPlayersScore(frameIndex, player, frames);
        }
    }
}
