package ics111.sorazodia.pong;

import java.awt.Color;

public class PongMessage {

	// X and Y Variables for the Scores
	private static int textLX = 200;
	private static int textRX = EZ.getWindowWidth()-200;
	private static int textY = 50;

	//Setting the score up
	private static int textSize = 70;
	private static EZText p1Score = EZ.addText(textLX, textY, PongScore.getP1StrScore(), Color.WHITE, textSize);
	private static EZText p2Score = EZ.addText(textRX, textY, PongScore.getP2StrScore(), Color.WHITE, textSize);
	private static EZText startMessage = EZ.addText(EZ.getWindowWidth()/2, (EZ.getWindowHeight()/2)+30, "Press Y when Ready", Color.WHITE, 20);
	private static EZText resetMessage = EZ.addText(EZ.getWindowWidth()/2, (EZ.getWindowHeight()/2)+60, "Press V to Reset", Color.WHITE, 20);
	private static EZText quitMessage = EZ.addText(EZ.getWindowWidth()/2, (EZ.getWindowHeight()/2)+90, "Press B To Quit", Color.WHITE, 20);
	
	/**
	 * Displays the messages
	 */
	public static void showMessage(){
		startMessage.show();
		resetMessage.show();
		quitMessage.show();
	}
	
	/**
	 * Stop displaying the message
	 */
    public static void hideMessage(){
    	startMessage.hide();
		resetMessage.hide();
		quitMessage.hide();
	}
    
    /**
	 * Set the player's current score
	 */
    public static void scoreMessage(){
    	p1Score.setMsg(PongScore.getP1StrScore());
		p2Score.setMsg(PongScore.getP2StrScore());
   	}
}
