package ics111.sorazodia.pong;

public class PongPause {
	
    //PAUSE IT ALL PAUSE IT ALL
	static boolean pause = true;
	//Will the game still be running?
	static boolean pongRun = true;
	
    /**
     * Check to see if the player wants to pauses the game
     */
	public static void pause(){
		//Allow players to pause their game, thanks for the help - got it working
		if(EZInteraction.wasKeyPressed('y') || pause){
			if(EZInteraction.wasKeyPressed('y')) pause = !pause;
			if(EZInteraction.wasKeyPressed('b')) pongRun = !pongRun;
			if(EZInteraction.wasKeyPressed('v')){					
				//Reset the players' current score
				PongScore.resetScore();
				PongMessage.scoreMessage();
			}
			PongSound.stopSound("all");
			PongMessage.showMessage();
		}
	}
	
	/**
     * Tells if the game is still running
     */
	public static boolean isRunning(){
		return pongRun;
	}
	
	/**
     * Tells if the game is paused
     */
	public static boolean isPaused(){
		return pause;
	}
}
