package ics111.sorazodia.pong;

/**
 * @author Edmund
 */
public class PongScore {

	//Stores the player scores
	static byte p1 = 0;
	static byte p2 = 0;

	/**
	 * Changes the score of specified player, so far it will only support two players.
	 * @param amountIncrease
	 * @param playerNumber
	 */
	public static void setPlayerScore(byte amountIncrease, int playerNumber){
		if(playerNumber == 1) p1 = amountIncrease;
		else if(playerNumber == 2) p2 = amountIncrease;
		else System.out.printf("Player %s does not exist \n", playerNumber);
	}

	/**
	 * Gets player one's current score
	 * @return p1
	 */
	public static byte getPlayer1Score(){
		return p1;
	}

	/**
	 * Gets player two's current score
	 * @return p2
	 */
	public static byte getPlayer2Score(){
		return p2;
	}

	/**
	 * Covert player one's current score to a String
	 * @return s
	 */
	public static String getP1StrScore(){
		String s = String.valueOf(p1);
		return s;
	}

	/**
	 * Covert player two's current score to a String
	 * @return s
	 */
	public static String getP2StrScore(){
		String s = String.valueOf(p2);
		return s;
	}

	/**
	 * Resets the values back to zero
	 */
	public static void resetScore(){
		p1 = 0;
		p2 = 0;		
	}

}
