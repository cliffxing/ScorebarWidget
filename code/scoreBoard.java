
;import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * scoreBoard is a Greenfoot Actor that displays text and values between two players. 
 * The default scoreBoard created is a 400 x 70 black box that displays score
 * between "Player1" and "Player2" using white text at font size 20. However,the player names, starting values, 
 * text, text size, background color, font color, border color and dimensions can all be customized depending on 
 * the constructor used. The scoreBoard actor is designed to be used in 1 vs 1 games, 
 * where values such as score, lives, money or other variables between two players need 
 * to be displayed on the screen. Because the dimensions of the scoreBoard actor is customizable, 
 * it can be implemented into any world dimensions (make sure the scoreBoard dimensions
 * are adjusted accordingly). 
 * <p>
 * There are also methods within the scoreBoard actor. The changeScore method allows for users
 * to change the values displayed on the screen for both players, and the winner method changes
 * the scoreboard so that it only displays the name of the winner and "wins!". Also, the changeBackground
 * method changes the background color to a color that is specified within the parameters.
 */

public class scoreBoard extends Actor
{  
    private GreenfootImage scoreBoard;

    private Color backgroundColor;
    private Color borderColor;
    private Color textColor;
    private Color animateColor;
    private Font textFont;

    private String text;
    private int theX;
    private int theY;
    private int heightScore;
    private int p1Score;
    private int p2Score;
    private int widthScore;
    private boolean isBorder;
    private String player1;
    private String player2;

    /**
     * Creates a scoreboard with starting score 0-0 between "Player 1" and "Player 2" that is 400x70 and has font size 20
     */
    public scoreBoard()
    {
        text="Score";
        theX=400/7;
        theY=70/2;
        player1="Player1";
        player2="Player2";
        isBorder=false;

        scoreBoard=new GreenfootImage(400, 70);
        textFont=new Font("Arial", true, false, 20);
        backgroundColor=new Color(0,0,0);
        textColor=new Color(255,255,255);

        update(0,0);
        this.setImage(scoreBoard);
    }

    /**
     * Creates a scoreboard with starting score 0-0 between "Player 1" and "Player 2" that has customizable width and height, as well as textsize
     * 
     * @param width the width of the scoreboard being displayed
     * @param height the height of the scoreboard being displayed
     * @param textSize the font size of the text being displayed
     * @param x the 'X' coordinate of the text displayed INSIDE of the scoreboard
     * @param y the 'y' coordinate of the text displayed INSIDE of the scoreboard
     */
    public scoreBoard( int width, int height, int textSize, int x, int y)
    {
        text="Score";
        theX=x;
        theY=y;
        player1="Player 1";
        player2="Player 2";
        isBorder=false;

        scoreBoard=new GreenfootImage(width, height);
        textFont=new Font("Arial", true, false, textSize);
        backgroundColor=new Color(0,0,0);
        textColor=new Color(255,255,255);

        update(0,0);
        this.setImage(scoreBoard);
    }

    /**
     * Creates a scoreboard that has customizable beginning scores, text, player names, width, height and font size
     * 
     * @param p1Start the starting score for player1 (on the left)
     * @param p2Start the starting score for player2 (on the right)
     * @param theText the text displayed between the two players (ex: score, lives, etc.)
     * @param p1 name of player1 that is displayed on the left side of the screen
     * @param p2 name of player2 that is displayed on the right side of the screen
     * @param width the width of the scoreboard being displayed
     * @param height the height of the scoreboard being displayed
     * @param textSize the font size of the text being displayed
     * @param x the 'X' coordinate of the text displayed INSIDE of the scoreboard
     * @param y the 'y' coordinate of the text displayed INSIDE of the scoreboard
     */
    public scoreBoard(int p1Start, int p2Start, String theText, String p1, String p2, int width, int height, int textSize, int x, int y)
    {
        text=theText;
        theX=x;
        theY=y;
        player1=p1;
        player2=p2;
        isBorder=false;

        scoreBoard=new GreenfootImage(width, height);
        textFont=new Font("Arial", true, false, textSize);
        backgroundColor=new Color(0,0,0);
        textColor=new Color(255,255,255);

        update(p1Start,p2Start);
        this.setImage(scoreBoard);
    }

    /**
     * Creates a scoreboard that has customizable beginning scores, text, player names, width, height, font size, background color and text color
     * 
     * @param p1Start the starting score for player1 (on the left)
     * @param p2Start the starting score for player2 (on the right)
     * @param theText the text displayed between the two players (ex: score, lives, etc.)
     * @param p1 name of player1 that is displayed on the left side of the screen
     * @param p2 name of player2 that is displayed on the right side of the screen
     * @param width the width of the scoreboard being displayed
     * @param height the height of the scoreboard being displayed
     * @param textSize the font size of the text being displayed
     * @param x the 'X' coordinate of the text displayed INSIDE of the scoreboard
     * @param y the 'y' coordinate of the text displayed INSIDE of the scoreboard
     * @param r1 The 'r' value for the background color
     * @param g1 The 'g' value for the background color
     * @param b1 The 'b' value for the background color
     * @param r2 The 'r' value for the text color
     * @param g2 The 'g' value for the text color
     * @param b2 The 'b' value for the text color
     * 
     */
    public scoreBoard(int p1Start, int p2Start, String theText, String p1, String p2, int width, int height, int textSize, int x, int y, int r1, int g1, int b1, int r2, int g2, int b2)
    {
        text=theText;
        theX=x;
        theY=y;
        player1=p1;
        player2=p2;
        isBorder=false;

        scoreBoard=new GreenfootImage(width, height);
        textFont=new Font("Arial", true, false, textSize);

        backgroundColor=new Color(r1,g1,b1);
        textColor=new Color(r2,g2,b2);

        update(p1Start,p2Start);
        this.setImage(scoreBoard);
    }

    /**
     * Creates a scoreboard with a border that has customizable beginning scores, text, player names, width, height, font size, background color, text color and border color 
     * 
     * @param p1Start the starting score for player1 (on the left)
     * @param p2Start the starting score for player2 (on the right)
     * @param theText the text displayed between the two players (ex: score, lives, etc.)
     * @param p1 name of player1 that is displayed on the left side of the screen
     * @param p2 name of player2 that is displayed on the right side of the screen
     * @param width the width of the scoreboard being displayed
     * @param height the height of the scoreboard being displayed
     * @param textSize the font size of the text being displayed
     * @param x the 'X' coordinate of the text displayed INSIDE of the scoreboard
     * @param y the 'y' coordinate of the text displayed INSIDE of the scoreboard
     * @param r1 The 'r' value for the background color
     * @param g1 The 'g' value for the background color
     * @param b1 The 'b' value for the background color
     * @param r2 The 'r' value for the text color
     * @param g2 The 'g' value for the text color
     * @param b2 The 'b' value for the text color
     * @param r3 The 'r' value for the border color
     * @param g3 The 'g' value for the border color
     * @param b3 The 'b' value for the border color
     * 
     */
    public scoreBoard(int p1Start, int p2Start, String theText, String p1, String p2, int width, int height, int textSize, int x, int y, int r1, int g1, int b1, int r2, int g2, int b2, int r3, int g3, int b3)
    {
        text=theText;
        theX=x;
        theY=y;
        player1=p1;
        player2=p2;
        heightScore=height;
        widthScore=width;
        isBorder=true;

        scoreBoard=new GreenfootImage(width, height);
        textFont=new Font("Arial", true, false, textSize);
        scoreBoard.setFont(textFont);

        backgroundColor=new Color(r1,g1,b1);
        textColor=new Color(r2,g2,b2);
        borderColor=new Color(r3, g3, b3);

        update(p1Start,p2Start, 6);
        this.setImage(scoreBoard);
    }

    /**
     * Draws the scoreboard and updates the score values that are displayed on the screen
     * 
     * @param score1 The value of the first player's score (player on the left)
     * @param score2 The value of the second player's score (player on the right)
     */
    private void update(int score1, int score2)
    {
        scoreBoard.setColor(backgroundColor);
        scoreBoard.setFont(textFont);
        scoreBoard.fill();

        scoreBoard.setColor(textColor);
        String score = player1+" "+score1+ " | "+text+" | "+score2+" "+player2;
        scoreBoard.drawString(score,theX,theY);    
    }

    /**
     * Draws the scoreboard with a border and updates the score values that are displayed on the screen
     * 
     * @param score1 The value of the first player's score (player on the left)
     * @param score2 The value of the second player's score (player on the right)
     * @param width The width of the border drawn around the scoreboard
     */
    private void update(int score1, int score2, int width)
    {
        scoreBoard.setFont(textFont);
        scoreBoard.setColor(borderColor);
        scoreBoard.fill();
        scoreBoard.setColor(backgroundColor);
        scoreBoard.fillRect(3, 3, widthScore-width, heightScore-width);
        this.setImage(scoreBoard);

        scoreBoard.setColor(textColor);
        String score = player1+" "+score1+ " | "+text+" | "+score2+" "+player2;
        scoreBoard.drawString(score,theX,theY);    
    }

    /**
     * Draws the winning display for when a player wins 
     * 
     * @param winningPlayer Name of the winning player being displayed
     * @param x 'X' coordinate of text being displayed in scoreboard
     * @param y 'Y' coordinate of text being displayed in scoreboard
     */
    private void update(String winningPlayer, int x, int y)
    {
        scoreBoard.setColor(backgroundColor);
        scoreBoard.fill();

        scoreBoard.setColor(textColor);
        String winner= winningPlayer+" wins!";
        scoreBoard.drawString(winner,x,y);     
    }

    /**
     * Changes the score value for both players displayed on the screen
     * 
     * @param score1 The value of the first player's score (player on the left)
     * @param score2 The value of the second player's score (player on the right)
     */
    public void changeScore(int score1, int score2)
    {
        if (isBorder==false)
        {
            update(score1,score2);
        }

        else
        {
            update(score1,score2, 6); 
        }

    }

    /**
     * Changes the color of the background displayed on the scoreboard
     * 
     * @param score1 The value of the first player's score (player on the left)
     * @param score2 The value of the second player's score (player on the right)
     * @param r1 The 'r' value for the new background color
     * @param g1 The 'g' value for the new background color
     * @param b1 The 'b' value for the new background color
     * 
     */
    public void changeBackgroundColor(int score1, int score2, int r1, int g1, int b1)
    {
        backgroundColor=new Color(r1,g1,b1);
        if (isBorder==false)
        {
            update(score1,score2);
        }

        else
        {
            update(score1,score2, 6); 
        }

    }
  

    
    /**
     * Changes the scoreboard so that it only displays the winning players name and "wins!" next to it (e.x: John wins!). The background color of 
     * the winning screen and the text color of the text is customizable to the user's choice (based on the parameters inputted)
     * 
     * @param winningPlayer the name of the winning player that is displayed on the screen
     * @param r1 The 'r' value for the background color
     * @param g1 The 'g' value for the background color
     * @param b1 The 'b' value for the background color
     * @param r2 The 'r' value for the text color
     * @param g2 The 'g' value for the text color
     * @param b2 The 'b' value for the text color
     * 
     */
    public void winner(String winningPlayer, int r1, int g1, int b1, int r2, int g2, int b2, int x, int y)
    {
        scoreBoard.setFont(textFont);
        backgroundColor=new Color(r1,g1,b1);
        textColor=new Color(r2,g2,b2);

        update(winningPlayer, x, y);

    }

}
