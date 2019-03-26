package Source;

/**********************************************************************
 * Class for the bishop piece. Determines valid moves and
 * identifiers.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class Bishop extends ChessPiece {

    /******************************************************************
     * Constructor for the Bishop class. Creates a new white or black
     * bishop piece.
     *
     * @param player Either black or white, determines piece color
     *****************************************************************/
    public Bishop(Player player) {
        super(player);
    }

    /******************************************************************
     * Sets the type / name of the bishop object "Bishop"
     *
     * @return "Bishop"
     *****************************************************************/
    public String type() {
        return "Bishop";
    }


    /******************************************************************
     * Method for determining if the player's move choice is valid.
     *
     * @param move the player's move
     * @param board the game board array
     * @return true or false depending on validity of move
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {

        boolean valid = false;

        if ((move.fromRow == move.toRow) && (move.fromColumn == move.toColumn))
            return false;

        if (board[move.toRow][move.toColumn] != null)
            if (board[move.toRow][move.toColumn].player().equals(player()))
                return false;

        if (move.toColumn > board.length || move.toRow > board.length) {
            valid = false;
        }

        if (move.toColumn < 0 || move.toRow < 0) {
            valid = false;
        }

        if (move.toColumn == move.fromColumn + 0 || move.toRow == move.fromRow + 0) {
            valid = false;
        }
        for (int i = 1; i < board.length; i++) {
            if (move.toColumn == move.fromColumn + i && move.toRow == move.fromRow + i) {
                valid = true;
            } else if (move.toColumn == move.fromColumn - i && move.toRow == move.fromRow + i) {
                valid = true;
            } else if (move.toColumn == move.fromColumn - i && move.toRow == move.fromRow - i) {
                valid = true;
            } else if (move.toColumn == move.fromColumn + i && move.toRow == move.fromRow - i) {
                valid = true;
            }
        }
        return valid;
    }

}
