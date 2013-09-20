public class Game {

	private Board gameBoard;
	private Robot gameRobot;
	private Player player1;
	private Player player2;

	public Game (Player p1, Player p2) {
		this.gameBoard = new Board();
		this.player1, this.player2 = p1, p2;
	}
	
	public Game (Player p1, Player p2, Robot startGameRobot) {
		this(p1,p2);
		this.gameRobot = startGameRobot;
	}

	public void play() {
		while (this.gameBoard.totalPiecesLeft(player1)>0 && this.gameBoard.totalPiecesLeft(player2)>0) {
			this.player1.takeTurn();
			this.player2.takeTurn();
		}
	}

	public Board getGameBoard () {
		return this.gameBoard;
	}

	public Player[] getPlayers () {
		return Player[2]{this.player1,this.player2};
	}
}