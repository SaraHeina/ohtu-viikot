package ohtu;

public class TennisGame {

    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            player1score += 1;
        } else {
            player2score += 1;
        }
    }

    public String getScore() {
        if (player1score == player2score) {
            return tie();
        } else if (player1score >= 4 || player2score >= 4) {
            return advantageOrWin();
        } else {
            return gameScore();
        }
    }

    private String tie() {
        if (player1score == 4) {
            return "Deuce";
        } else {
            return scoreNames(player1score) + "-All";
        }
    }

    private String advantageOrWin() {
        int difference = player1score - player2score;
        if (player1score > player2score) {
            return playerThatLeads(difference, player1Name);
        } else {
            return playerThatLeads(difference, player2Name);
        }
    }

    private String playerThatLeads(int difference, String playerName) {
        if (Math.abs(difference) == 1) {
            return "Advantage " + playerName;
        } else {
            return "Win for " + playerName;
        }
    }

    private String gameScore() {
        return scoreNames(player1score) + "-" + scoreNames(player2score);
    }

    private String scoreNames(int score) {
        switch (score) {
            default:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
    }
}
