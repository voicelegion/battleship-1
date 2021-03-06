package lv.ctco.battleship.model;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = 1;

    private Player player1;
    private Player player2;
    private boolean player1turn = true;
    private Player winner;
    private boolean cancelled;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getCurrentPlayer() {
        return player1turn ? player1 : player2;
    }

    public Player getOppositePlayer() {
        return player1turn ? player2 : player1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isComplete() {
        return player1 != null && player2 != null;
    }

    public boolean isStarted() {
        return player1 != null
                && player2 != null
                && player1.isPlacementComplete()
                && player2.isPlacementComplete();
    }


    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }

    public void fire(String addr) {
        Player current = getCurrentPlayer();
        Player opposite = getOppositePlayer();
        CellContent fired = opposite.getMyField().get(addr);
        if (fired == CellContent.SHIP) {
            current.getOpponentField().set(addr, CellContent.HIT);
            opposite.getMyField().set(addr, CellContent.HIT);
            checkWinner();
        } else if (fired == CellContent.EMPTY) {
            current.getOpponentField().set(addr, CellContent.MISS);
            opposite.getMyField().set(addr, CellContent.MISS);
            player1turn = !player1turn;
        } else {
            player1turn = !player1turn;
        }

    }

    private void checkWinner() {
        Player opposite = getOppositePlayer();
//        Collection<CellContent> cells = opposite.getMyField().getContent().values();
//        for (CellContent c : cells) {
//            if (c == CellContent.SHIP) {
//                return;
//            }
//        }
//        winner = getCurrentPlayer();

        if (!opposite.getMyField().getContent().containsValue(CellContent.SHIP)) {
            winner = getCurrentPlayer();
        }

    }
}
