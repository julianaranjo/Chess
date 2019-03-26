package Source;

/**********************************************************************
 * Class for the Queen piece. Determines valid moves and
 * identifiers.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class Queen extends ChessPiece {

	/******************************************************************
	 * Constructor for the Queen class. Creates a new white or
	 * black Queen piece.
	 *
	 * @param player Either black or white, determines piece color
	 *****************************************************************/
	public Queen(Player player) {
		super(player);
	}

	/******************************************************************
	 * Sets the type / name of the Queen object "Queen"
	 *
	 * @return "Queen"
	 *****************************************************************/
	public String type() {
		return "Queen";
	}

	 /******************************************************************
	 * Determines whether the Queens move is valid or not.
 	 *
 	 * @param move the move being validated
 	 * @param board the chess board array
 	 ******************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		Bishop move1 = new Bishop(board[move.fromRow][move.fromColumn].player());
		Rook move2 = new Rook(board[move.fromRow][move.fromColumn].player());
		return (move1.isValidMove(move, board) || move2.isValidMove(move, board));
	}
}
