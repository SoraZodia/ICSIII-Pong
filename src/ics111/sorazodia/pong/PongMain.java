package ics111.sorazodia.pong;

import java.awt.Color;

/**
 * @author Edmund
 */
public class PongMain {
	
	//This is nothing...
	private static boolean troll = false; 
	
	//Main method
	public static void main (String str[]){

		//Ready Set Go!
		initialize();

		//Trololololol
		int kappaX = -100;
		final int kappaY = EZ.getWindowHeight()-550;
		EZImage kappa = EZ.addImage("resources/kappa.png", kappaX , kappaY);	

		//The object for the ball and paddle
		PongBall ball = new PongBall(Color.WHITE, PongPad.doFill());	
		PongPad pad = new PongPad();		

		//The Game Loop
		while(PongPause.isRunning()){			
			
			PongPause.pause();

			//This is nothing... Nothing too worrying
			if(EZInteraction.wasKeyPressed('t') && !troll){
				troll = true;
				kappaX = -100;
			}
			if(troll){
				kappa.show();
				kappa.translateTo(kappaX, kappaY);
				if(kappaX != 1550) kappaX+=3;
				if(kappaX >= 1550){
					kappa.hide();
					troll = false;
				}
			}

			//game logic, will activate when pause is false
			if(!PongPause.isPaused()){
				
				PongMessage.hideMessage();
				PongSound.loopSound("tetris");
				PongSound.stopSound();
				
				pad.padMove();
				pad.checkPad();
				ball.ballBounce();
				
				
				//Set the players' current score
				PongMessage.scoreMessage();

			}
			
			//Do awesome magic stuff that allows morals to see the animations and score changes
			EZ.refreshScreen();

		}//while loop end

		System.exit(0); // I think there's a better way...

	}//main() end
	
	/**
	 * Calls the different init methods and sets everything up
	 */
	private static void initialize(){
		EZ.initialize(1280,720);
		PongSound.initSounds();
		//Background color
		EZ.setBackgroundColor(Color.BLACK);	
		//Adds the background image
		@SuppressWarnings("unused")
		EZImage mario = EZ.addImage("resources/mario.jpg", EZ.getWindowWidth()/2, EZ.getWindowHeight()/2);
		//Not too sure of its effect but felt like adding it in will help
		EZ.setFrameRate(60);
	}

}
