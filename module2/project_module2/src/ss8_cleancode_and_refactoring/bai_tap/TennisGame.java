package ss8_cleancode_and_refactoring.bai_tap;

public class TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName){
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public void setPlayerOneScore(){
        playerOneScore++;
    }

    public void setPlayerTwoScore(){
        playerTwoScore++;
    }

    public String revertScore(int score){
        String str = "";
        switch (score){
            case 0 -> str = "Love";
            case 1 -> str = "15";
            case 2 -> str = "30";
            case 3 -> str = "40";
        }
        return str;
    }

    public boolean hasAdvantage(){
        if(playerOneScore >= 4 && playerTwoScore == playerOneScore + 1){
            return true;
        }

        if(playerTwoScore >= 4 && playerOneScore == playerTwoScore +1){
            return true;
        }
        return false;
    }

    public boolean isDeuce(){
        return playerOneScore >=3 && playerTwoScore == playerOneScore;
    }

    public String playerWithinHigherScore(){
        if(playerOneScore > playerTwoScore){
            return playerOneName;
        }
        else{
            return playerTwoName;
        }
    }

    public boolean hasWinner(){
        if(playerOneScore >= 4 && playerOneScore >= playerTwoScore+2){
            return true;
        }
        if(playerTwoScore >= 4 && playerTwoScore >= playerOneScore+2){
            return true;
        }
        return false;
    }

    public String getScore(){
        if(hasWinner()){
            return playerWithinHigherScore() + " wins";
        }
        if(isDeuce()){
            return "Deuce";
        }
        if(hasAdvantage()){
            return "Advantage " + playerWithinHigherScore();
        }
        if(playerOneScore == playerTwoScore){
            return revertScore(playerOneScore) + "all";
        }
        return revertScore(playerOneScore) + ", "+ revertScore(playerTwoScore);
    }
}
