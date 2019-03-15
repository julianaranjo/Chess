package Source;

public class Rook extends ChessPiece {

	public Rook(Player player) {
		
		super(player);
		
	}

	public String type() {
		
		return "Rook";
		
	}
	
	// determines if the move is valid for a rook piece
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		boolean valid = true;
		if (move.fromColumn != move.toColumn && move.fromRow != move.toRow) {
			valid = false;
		}
		return valid;

	}
}
