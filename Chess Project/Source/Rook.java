package Source;

/**********************************************************************
 * Class for the Rook piece. Determines valid moves and
 * identifiers.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class Rook extends ChessPiece {

	/******************************************************************
	 * Constructor for the Rook class. Creates a new white or
	 * black Rook piece.
	 *
	 * @param player Either black or white, determines piece color
	 *****************************************************************/
	public Rook(Player player) {
		
		super(player);
		
	}

	/******************************************************************
	 * Sets the type / name of the Rook object "Rook"
	 *
	 * @return "Rook"
	 *****************************************************************/
	public String type() {
		
		return "Rook";
		
	}

	/******************************************************************
	 * Determines whether the Rook move is valid or not.
	 *
	 * @param move the move being validated
	 * @param board the chess board array
	 ******************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		if ((move.fromRow == move.toRow) && (move.fromColumn == move.toColumn))
			return false;

		if (board[move.toRow][move.toColumn] != null)
			if (board[move.toRow][move.toColumn].player().equals(player()))
				return false;

		boolean valid = true;
		if (move.fromColumn != move.toColumn && move.fromRow != move.toRow) {
			valid = false;
		}
		return valid;

	}
}
