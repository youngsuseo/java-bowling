package bowling.factory;

import bowling.domain.Player;
import bowling.domain.Players;
import bowling.domain.frame.Frames;
import bowling.view.InputView;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerFactory {

    private PlayerFactory() {
        throw new AssertionError();
    }

//    public static Players createPlayers() {
//        int numberOfPlayers = InputView.inputNumberOfPlayers();
//        Map<Player, Frames> playerMap = new LinkedHashMap<>();
//
//        for (int i = 0; i < numberOfPlayers; i++) {
//            playerMap.put(new Player(InputView.inputPlayerName()), new Frames());
//        }
//        return new Players(playerMap);
//    }
}
