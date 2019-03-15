package Project3;

public class King extends ChessPiece {

	public King(Player player) {
		super(player);
	}

	public String type() {
		return "King";
	}
	
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = true;
        if (move.fromColumn - move.toColumn > 1 || move.fromColumn - move.toColumn < -1)
		{
			valid = false;
		}
		if (move.fromRow - move.toRow > 1 || move.fromRow - move.toRow < -1)
		{
			valid = false;
		}
		return valid;
	}
}