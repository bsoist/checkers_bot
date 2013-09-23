public class SimPlayer extends Player {

	public SimPlayer() {
		//nothing
	}

	public SimPlayer (Robot startGameRobot) {
		super(startGameRobot);
	}

	public void takeTurn() {
		this.performMove(super.caluclateBestMove());
	}

	public void performMove(Move myMove) {
		Player.performMove(myMove,super.getBoard());
		//tests if game is using the robot
		if (this.gameRobot!=null) {
			//move arm over moving piece
			this.gameRobot.moveToXY(myMove.getSource());
			//pcks up the piece
			this.gameRobot.pickUpPiece();
			//moves piece to the destination
			this.gameRobot.moveToXY(myMove.getDestination());
			//drops the piece
			this.gameRobot.dropPiece();
			//tests if their are any pieces to jump
			if (myMove.calculatePiecesToJump()) {
				//iterates thorough all jumped pieces
				for (Piece deadPiece : myMove.calculatePiecesToJump()) {
					//move arm over the piece that was jumped
					this.gameRobot.moveToXY(deadPiece.getLocation());
					//picks up jumped piece
					this.gameRobot.pickUpPiece();
					//moves arm over drop point for dead pieces
					this.gameRobot.moveToXY();
					//drops the piece
					this.gameRobot.dropPiece();
				}
			}
			//resets arm after all pieces have been moved.
			this.gameRobot.resetPosition();
		}
	} 
}
