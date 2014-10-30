package ics111.sorazodia.pong;

import java.awt.Color;
import java.util.Random;

/**
 * @author Edmund
 */
public class PongBall {

	private Random rand = new Random();
	private int dir = rand.nextInt(4);

	private static int defaultXSpeed = PongPad.getPongSpeed();
	private static int defaultYSpeed = PongPad.getPongSpeed();
	private static final short boarder = 15;
	private static int speedX = defaultXSpeed;
	private static int speedY = defaultYSpeed;
	private static int posXDefault = EZ.getWindowWidth()/2;
	private static int posYDefault = EZ.getWindowHeight()/2;
	private static int posX = posXDefault;
	private static int posY = posYDefault;
	private short pongW = 25;
	private short pongH = pongW;
	private static EZRectangle pongBall;

	private static byte player1Score = 0;
    private static byte player2Score = 0;

	/**
	 * Add the ball into the game 
	 * @param color
	 * @param rectFill
	 */
	public PongBall(Color color, boolean rectFill){
		pongBall = EZ.addRectangle(posX, posY, pongW, pongH, color, rectFill);
		randDir();
	}

	/**
	 * Determinate how the ball will bounce and to where
	 */
	public void ballBounce(){

		checkBoarder();
		posX+=speedX; 
		posY+=speedY;
		pongBall.translateTo(posX, posY);

	}

	/**
	 *Changes how the ball moves in the X direction
	 */
	public static void setXSpeed(int speed){
		speedX = speed;
	}

	/**
	 * Checks to see if the ball is about to go out of the window or hit the paddle, 
	 * will cause the ball to go the other way. It will add one point to one of the 
	 * players' score when the ball beyond thier paddle and reset the ball back to 
	 */
	private void checkBoarder(){

		if(posX > EZ.getWindowWidth()){
			reset();
			speedX = -defaultXSpeed;
			player1Score++;
			PongScore.setPlayerScore(player1Score, 1);
			PongSound.playSound("peep");
			//System.out.println(PongScore.getPlayer2Score());
		}

		if(posX <= 0){
			reset();
			speedX = defaultXSpeed;
			player2Score++;
			PongScore.setPlayerScore(player2Score, 2);
			PongSound.playSound("peep");
			//System.out.println("q");
		}

		if(posY >= EZ.getWindowHeight()){
			speedY = -speedY;
			PongSound.playSound("beep");
		}

		if(posY <= boarder){
			speedY = defaultYSpeed;
			PongSound.playSound("beep");
		}
	}

	/**
	 * Get the X value of the ball
	 * @return posX
	 */
	public static int getBallX(){
		return posX;
	}

	/**
	 * Get the Y value of the ball
	 * @return posY
	 */
	public static  int getBallY(){
		return posY;
	}

	/**
	 * Get the ball's speed without the changes
	 * @return  defaultXSpeed
	 */
	public static int getDefaultBallX(){
		return defaultXSpeed;
	}

	/**
	 * Get the ball's speed without the changes
	 * @return  defaultYSpeed
	 */
	public static int getDefaultBallY(){
		return defaultYSpeed;
	}

	/**
	 * Get the ball's current speed
	 * @return speedY
	 */
	public static int getBallYSpeed(){
		return speedY;
	}

	/**
	 * Changes the ball's current speed
	 */
	public static  void setBallYSpeed(int speed){
		speedY = speed;
	}

	/**
	 * Changes the ball postion back to center
	 */
	public void reset(){
		posX = posXDefault;
		posY = posYDefault;
	}

	/**
	 * Helps determine where the actual boarder is
	 */
	public static int getBoarder(){
		return boarder;
	}

	private void randDir(){
		switch(dir){
		case 0:
			speedX = defaultXSpeed;
			speedY = defaultYSpeed;
			break;

		case 1:
			speedX = defaultXSpeed;
			speedY = -defaultYSpeed;
			break;

		case 2:
			speedX = -defaultXSpeed;
			speedY = defaultYSpeed;
			break;

		case 3:
			speedX = -defaultXSpeed;
			speedY = -defaultYSpeed;
			break;

		default:
			break;
		}
	}

}
