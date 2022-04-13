package ss8_cleancode_and_refactoring.bai_tap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest{
    TennisGame tennisGame = new TennisGame("Binh Phan", "Roger Federer");
    @Test
    public void testNewGameShouldReturnLoveAll()
    {
        String score = tennisGame.getScore();

        assertEquals("Loveall", score);
    }
    @Test
    public void testPlayerOneWinsFirstBall()
    {
        tennisGame.setPlayerOneScore();

        String score = tennisGame.getScore();
        assertEquals("15, Love", score);
    }
    @Test
    public void testFifteenAll(){
        tennisGame.setPlayerOneScore();
        tennisGame.setPlayerTwoScore();

        String score = tennisGame.getScore();
        assertEquals("15all", score);
    }
    @Test
    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);

        String score = tennisGame.getScore();
        assertEquals("Love, 30", score);
    }

    @Test
    public void testPlayerOneWinsFirstThreeBalls(){
        createScore(3, 0);
        String score = tennisGame.getScore();
        assertEquals("40, Love", score);
    }
    @Test
    public void testPlayersAreDeuce() {
        createScore(3, 3);

        String score = tennisGame.getScore();
        assertEquals("Deuce", score);
    }
    @Test
    public void testPlayerOneWinsGame()
    {
        createScore(4, 0);

        String score = tennisGame.getScore();
        assertEquals("Binh Phan wins", score);
    }
    @Test
    public void testPlayerTwoWinsGame(){
        createScore(1,4);

        String score = tennisGame.getScore();
        assertEquals("Roger Federer wins", score);
    }
    @Test
    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = tennisGame.getScore();
        assertEquals("Deuce", score);
    }
    @Test
    public void testPlayerTwoAdvantage(){
        createScore(4, 5);

        String score = tennisGame.getScore();
        assertEquals("Advantage Roger Federer", score);
    }
    @Test
    public void testPlayerOneAdvantage(){
        createScore(5, 4);

        String score = tennisGame.getScore();
        assertEquals("Advantage Binh Phan", score);
    }
    @Test
    public void testPlayerTwoWins(){
        createScore(2, 4);
        String score = tennisGame.getScore();
        assertEquals("Roger Federer wins", score);
    }

    @Test
    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = tennisGame.getScore();
        assertEquals("Roger Federer wins", score);
    }


    @Test
    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = tennisGame.getScore();
        assertEquals("Binh Phan wins", score);
    }
    @Test
    private void createScore(int playerOneBalls, int playerTwoBalls ) {
        for (int i = 0; i < playerOneBalls; i++) {
            tennisGame.setPlayerOneScore();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            tennisGame.setPlayerTwoScore();
        }
    }
}
