public class Human extends Player {

	private Robot gameRobot;

	public Human () {
		//nothing
	}
	
	public Human (Robot startGameRobot) {
		super(startGameRobot);
	}

	public void takeTurn() {
		super.performMove(this.inputMove());
	}

	public Move inputMove() {
		//implementation
	}
}