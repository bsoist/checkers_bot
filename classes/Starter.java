public class Starter {

	public static void main(String[] args) {
		Game theGame = new Game(new Human("x",true,new CorbinAI()), new SimPlayer("o",false,new CorbinAI()));
		Player winner = theGame.play();
		if (winner == null) {
			System.out.println("TIE");
		} else {
			System.out.println("WINNER:  " + winner.getXO());
		}
	}
}
