package bowling.domain;

import bowling.domain.frame.Frames;

import java.util.Map;

public class Players {
    private Map<Player, Frames> players;

    public Players(Map<Player, Frames> players) {
        this.players = players;
    }

    public Map<Player, Frames> getPlayers() {
        return players;
    }
}