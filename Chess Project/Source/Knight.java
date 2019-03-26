package Source;

/**********************************************************************
 * Class for the Knight piece. Determines valid moves and
 * identifiers.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class Knight extends ChessPiece {

    /******************************************************************
     * Constructor for the Queen class. Creates a new white or
     * black Knight piece.
     *
     * @param player Either black or white, determines piece color
     *****************************************************************/
    public Knight(Player player) {
        super(player);
    }

    /******************************************************************
     * Sets the type / name of the Knight object "Knight"
     *
     * @return "Knight"
     *****************************************************************/
    public String type() {
        return "Knight";
    }

    /******************************************************************
     * Determines whether the Rook move is valid or not.
     *
     * @param move the move being validated
     * @param board the chess board array
     ******************************************************************/
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

        if (move.toColumn == move.fromColumn + 1) {
            if (move.toRow == move.fromRow + 2) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 2) {
                valid = true;
            }
        }

        if (move.toColumn == move.fromColumn - 1) {
            if (move.toRow == move.fromRow + 2) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 2) {
                valid = true;
            }
        }

        if (move.toColumn == move.fromColumn + 2) {
            if (move.toRow == move.fromRow + 1) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 1) {
                valid = true;
            }
        }

        if (move.toColumn == move.fromColumn - 2) {
            if (move.toRow == move.fromRow + 1) {
                valid = true;
            }

            else if (move.toRow == move.fromRow - 1) {
                valid = true;
            }
        }

        return valid;
    }

}
