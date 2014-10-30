package ics111.sorazodia.pong;

public class PongSound {
	
	//EZSound variables
	private static EZSound plop;
	private static EZSound tetris;
	private static EZSound peep;
	private static EZSound beep;
	
	private static long startTime;
	private static long timePassed;
	
	/**
	 * Initialize the EZSound variable, needs to be called before any other
	 * functions in this class
	 */
	public static void initSounds(){
		plop = EZ.addSound("resources/plop.wav");
		tetris = EZ.addSound("resources/Tetris.wav");
		peep = EZ.addSound("resources/peep.wav");
		beep = EZ.addSound("resources/beep.wav");
	}
	
	/**
	 * Play the sound
	 */
	public static void playSound(String str){
		if(str.equalsIgnoreCase("plop"))plop.loop();
		if(str.equalsIgnoreCase("peep"))peep.loop();
		if(str.equalsIgnoreCase("beep"))beep.loop();
	}
	
	/**
	 * Loop the sound until your computer dies
	 */
	public static void loopSound(String str){
		if(str.equalsIgnoreCase("plop")) plop.loop();
		if(str.equalsIgnoreCase("peep")) peep.loop();
		if(str.equalsIgnoreCase("tetris")) tetris.loop();
		if(str.equalsIgnoreCase("beep")) beep.loop();
	}
	
	/**
	 * Stop the sound(s) called by loopSound()
	 */
    public static void stopSound(String str){
		if(str.equalsIgnoreCase("plop")) plop.stop();
		if(str.equalsIgnoreCase("tetris")) tetris.stop();
		if(str.equalsIgnoreCase("peep")) peep.stop();
		if(str.equalsIgnoreCase("beep")) beep.stop();
		if(str.equalsIgnoreCase("all")){
			plop.stop();
			tetris.stop();
			peep.stop();
			beep.stop();
		}
	}
    
	/**
	 * Stop the sound called by playSound()
	 */
    public static void stopSound(){
		if(timer() > 1) plop.stop();
		if(timer() > 100) peep.stop();
		if(timer() > 1) beep.stop();
    }
   
    private static long timer(){
    	startTime = System.nanoTime();
    	timePassed = System.nanoTime() - startTime;
    	
    	return timePassed;
    }
}
