package ohtu;

public class TennisGame {
    
    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;
    private boolean deuce = false;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            player1score += 1;
        } else {
            player2score += 1;
        }
        
        if(player1score >= 3 && player2score >=3) deuce = true;
    }

    public String getScore() {        
        if(gameHasEnded()) return announceWinner();
        if (gameTied()) return getTiedScore();       
        if (playerHasAdvantage()) return getAdvantageString();
        else return getCurrentScore();

    }

    private boolean playerHasAdvantage() {
        return player1score>=4 || player2score>=4;
    }
    
    private boolean gameHasEnded() {
        if(!deuce && (playerHasAdvantage())) {
            return true;
        } else if (deuce && ((player1score - player2score >= 2) || (player2score - player1score >= 2))){
            return true;
        }
        return false;
    }
    
    private boolean gameTied() {
        return player1score == player2score;
    }

    private String announceWinner() {
        String winnerString = "Win for ";
        if(player1score > player2score) {
            winnerString += player1Name;
        } else {
            winnerString += player2Name;
        }
        return winnerString;
    }
    
    private String getTiedScore() {
        if(deuce && player1score > 3) return "Deuce";
        
        String score = "";
        if(player1score == 0) {
            score += "Love-";
        } else if(player1score == 1) {
            score +=  "Fifteen-";
        } else if(player1score == 2) {
            score += "Thirty-";
        } else if(player1score == 3) {
            score += "Forty-";
        }
        score += "All";
        
        return score;
    }
    
    private String getAdvantageString() {
        String advantageString = "Advantage ";
        if(player1score > player2score) {
            advantageString += player1Name;
        } else {
            advantageString += player2Name;
        }
        
        return advantageString;
    }
    
    private String getCurrentScore() {
        String score = "";
        int tempScore=0;
        for (int i=1; i<3; i++) {
            if (i==1) tempScore = player1score;
            else { score+="-"; tempScore = player2score;}
            switch(tempScore) {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
                }
            }
        return score;
    }

}