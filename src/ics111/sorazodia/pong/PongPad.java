package ics111.sorazodia.pong;

import java.awt.Color;

public class PongPad {
	
	 //Makes the rectangle fully color or only shows its edge
	private static boolean rectFill = true;
		
	//Speed
	private static int speed = 5;
	private static int padSpeed = 10;
	
	//Variables for the Right rectangle
	private short rectRW = 30;
	private short rectRH = 100;
	private int rectRX = (EZ.getWindowWidth() - 100);
	private int rectRY = (EZ.getWindowHeight()/2);
	private int rectMinRH =  (rectRY - (rectRH/2));
	private int rectMaxRH = ((rectRH/2) + rectRY);

	//Variables for the left rectangle
	private short rectLW = rectRW;
	private short rectLH = rectRH;
	private int rectLX = EZ.getWindowWidth() - rectRX;
	private int rectLY = EZ.getWindowHeight()/2;
	private int rectMinLH =  rectLY - (rectLH/2);
	private int rectMaxLH = (rectLH/2) + rectLY;
			
	private EZRectangle pad1 = EZ.addRectangle(rectLX, rectLY, rectLW, rectLH, Color.WHITE, rectFill);
	private EZRectangle pad2 = EZ.addRectangle(rectRX, rectRY, rectRW, rectRH, Color.WHITE, rectFill);
	
	//The ball direction
	private static String dir;
	private boolean pad1move = false;
	private boolean pad2move = false;
			
	/**
	 * This tells the ball to bounce when it hits one of the paddle
	 * and if it gets a +4 boost
	 */
	public void checkPad(){
		//checks if during collision, that the ball and paddle is in the oppersite
		//direction. If is, then ball speed is set to 17
		if(pad2.isPointInElement(PongBall.getBallX() + PongBall.getBoarder(), PongBall.getBallY())
				||pad2.isPointInElement(PongBall.getBallX(), PongBall.getBallY()- PongBall.getBoarder())
				||pad2.isPointInElement(PongBall.getBallX(), PongBall.getBallY()+ PongBall.getBoarder())){				
			
			if(pad2move){
				if(dir.equalsIgnoreCase("up") && PongBall.getBallYSpeed() > 0) speed += 4;
				if(dir.equalsIgnoreCase("down") && PongBall.getBallYSpeed() < 0) speed += 4;
			}
			PongBall.setXSpeed(-speed);	
			PongSound.playSound("plop");
		}

		//I should read more... had no idea isPointInElement() existed
		if(pad1.isPointInElement(PongBall.getBallX() - PongBall.getBoarder(), PongBall.getBallY())
				||pad1.isPointInElement(PongBall.getBallX(), PongBall.getBallY()- PongBall.getBoarder())
				||pad1.isPointInElement(PongBall.getBallX(), PongBall.getBallY()+ PongBall.getBoarder())){        	 
			
			if(pad1move){
				if(dir.equalsIgnoreCase("up") && PongBall.getBallYSpeed() > 0) speed += 4;
				if(dir.equalsIgnoreCase("down") && PongBall.getBallYSpeed() < 0) speed += 4;
				else speed = PongBall.getDefaultBallX();
			}
			PongBall.setXSpeed(speed);
			PongSound.playSound("plop");
		}
	}
	
	/**
	 * Up! Down! This makes the paddles moves and determinte if the
	 * pong ball gets the speed boost
	 */
	public void padMove(){
		dir = "still";
		//if statements to for paddle movement, it will also set a value for dir - 
		//To be used later on to determine if the ball gets a speed boost
		if((EZInteraction.isKeyDown('a') || EZInteraction.isKeyDown('w')) && rectMinLH > 0){ 
			rectLY+= -padSpeed;
			rectMinLH+= -padSpeed;
			rectMaxLH += -padSpeed;
			dir = "up";
			pad1move = true;
			pad1.translateTo(rectLX, rectLY);
		}

		if((EZInteraction.isKeyDown('d') ||EZInteraction.isKeyDown('s')) && rectMaxLH <= EZ.getWindowHeight() + PongBall.getBoarder()){ 
			rectLY+= padSpeed;
			rectMaxLH+= padSpeed;
			rectMinLH += padSpeed;
			dir = "down";
			pad1move = true;
			pad1.translateTo(rectLX, rectLY);
		}

		if((EZInteraction.isKeyDown('j')||EZInteraction.isKeyDown('i')) && rectMinRH > 0){ 
			rectRY+= -padSpeed;
			rectMinRH+= -padSpeed;
			rectMaxRH += -padSpeed;
			dir = "up";
			pad2move = true;
			pad2.translateTo(rectRX, rectRY);
		}

		if((EZInteraction.isKeyDown('l')||EZInteraction.isKeyDown('k')) && rectMaxRH <= EZ.getWindowHeight() + PongBall.getBoarder()){ 
			rectRY+= padSpeed;
			rectMaxRH+= padSpeed;
			rectMinRH += padSpeed;
			dir = "down";
			pad2move = true;
			pad2.translateTo(rectRX, rectRY);
		}
	}
	
	/**
	 * Allow other classes to use int speed
	 */
	public static int getPongSpeed(){
		return speed;
	}
	
	/**
	 * Allow other classes to use rectFill
	 */
	public static boolean doFill(){
		return rectFill;
	}
}
