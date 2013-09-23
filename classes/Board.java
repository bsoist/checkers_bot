import java.util.ArrayList;

public class Board {

	private ArrayList<Piece> piecesOnBoard;

	public Board (Player[] players) {
		piecesOnBoard = new ArrayList<Piece>();
		for (byte i=0; i<3; i++) {
			for (byte j=0; j<4; j++) {
				piecesOnBoard.add(new Piece(new byte[] {(byte) (2*j+(i%2)), (byte) i}, players[0]));
				piecesOnBoard.add(new Piece(new byte[] {(byte) (7-2*j+(i%2)), (byte) (7-i)}, players[1]));
			}
		}
	}

	public Board (Board previousBoard, Move newMove) {
		this.piecesOnBoard = previousBoard.getPiecesOnBoard();
		Player.performMove(newMove, this);
	}

	public ArrayList<Piece> getPiecesOnBoard () {
		return this.piecesOnBoard;
	}

	public Piece getPieceAtLocation(byte[] location) {
		for (Piece piece : this.piecesOnBoard) {
			if (piece.getLocation() == location) {
				return piece;
			}
		}
	}

	public void removePiece (Piece pieceToRemove) {
		piecesOnBoard.remove(pieceToRemove);
	}

	public int totalPiecesLeft(Player p) {
		int count = 0;
		for (Piece piece : piecesOnBoard) {
			if (piece.getPlayer()==p) {
				count++;
			}
		}
		return count;
	}

	public int normalPiecesLeft(Player p) {
		int count = 0;
		for (Piece piece : piecesOnBoard) {
			if (piece.getPlayer()==p && !piece.getIsKing()) {
				count++;
			}
		}
		return count;
	}

	public int kingsLeft(Player p) {
		int count = 0;
		for (Piece piece : piecesOnBoard) {
			if (piece.getPlayer()==p && piece.getIsKing()) {
				count++;
			}
		}
		return count;
	}
}