package Source;

/**********************************************************************
 * Class for the Pawn piece. Determines valid moves and
 * identifiers.
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class Pawn extends ChessPiece {
    private boolean firstMove;
    private boolean enPassantOK; // can the piece be taken via en passant

    /******************************************************************
     * Constructor for the Pawn class. Creates a new white or
     * black Pawn piece.
     *
     * @param player Either black or white, determines piece color
     *****************************************************************/
    public Pawn(Player player) {
        super(player);
        this.firstMove = true;
    }

    /******************************************************************
     * Constructor for the Pawn class. Creates a new white or black
     * Pawn piece with an ability to change whether it is on its first
     * move.
     *
     * @param player Either black or white, determines piece color
     * @param firstMove is it the pawns first move
     *****************************************************************/
    public Pawn(Player player, boolean firstMove) {
        super(player);
        this.firstMove = firstMove;
    }

    /******************************************************************
     * Sets the type / name of the Pawn object "Pawn"
     *
     * @return "Pawn"
     *****************************************************************/
    public String type() {
        return "Pawn";
    }

    /******************************************************************
     * Creates a copy of a piece at a given location to see if it
     * can be taken via en passant
     *
     * @param row the row
     * @param col the column
     * @param board the Chess board array
     *****************************************************************/
    private boolean canCaptureEnPassant(int row, int col, IChessPiece[][] board) {
        if (board[row][col] != null) {
            IChessPiece temp = board[row][col];
            if (temp != null)
                if (temp instanceof Pawn && temp.player() != this.player())
                    if (((Pawn) temp).enPassantOK)
                        return true;
        }
        return false;
    }

    /******************************************************************
     * Determines whether the pawns move is valid or not, also checks
     * to see if it can be taken via en passant.
     *
     * @param move the move being validated
     * @param board the chess board array
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = true;

        if ((move.fromRow == move.toRow) && (move.fromColumn == move.toColumn))
            return false;

        if (board[move.toRow][move.toColumn] != null)
            if (board[move.toRow][move.toColumn].player().equals(player()))
                return false;

        // Prevents the piece from gowing backward
        if (player().equals(Player.WHITE)) {
            if (move.toRow > move.fromRow)
                valid = false;
        } else {
            if (move.toRow < move.fromRow)
                valid = false;
        }


        if (move.toColumn == move.fromColumn) {
            // Not taking a piece
            if (player().equals(Player.WHITE)) {
                if (board[move.fromRow - 1][move.fromColumn] != null)
                    valid = false;
            } else {
                if (board[move.fromRow + 1][move.fromColumn] != null)
                    valid = false;
            }

            if (Math.abs(move.toRow - move.fromRow) > 2)
                valid = false;
            else if (Math.abs(move.toRow - move.fromRow) == 2) {
                //Advancing two spaces at beginning
                if (!firstMove)
                    valid = false;

                if (player().equals(Player.WHITE)) {
                    if (board[move.fromRow - 2][move.fromColumn] != null)
                        valid = false;
                } else {
                    if (board[move.fromRow + 2][move.fromColumn] != null)
                        valid = false;
                }

                // piece is en passant-able
                if (move.toColumn + 1 < 8) {
                    if (board[move.toRow][move.toColumn + 1] != null) {
                        if (board[move.toRow][move.toColumn + 1].type().equals("Pawn")) {
                            enPassantOK = true;
                        }
                    }
                }
                if (move.toColumn - 1 > 0) {
                    if (board[move.toRow][move.toColumn - 1] != null) {
                        if (board[move.toRow][move.toColumn - 1].type().equals("Pawn")) {
                            enPassantOK = true;
                        }
                    }
                }
            }
        } else {
            //Taking a piece
            if (Math.abs(move.toColumn - move.fromColumn) != 1 || Math.abs(move.toRow - move.fromRow) != 1)
                valid = false;

            if (board[move.toRow][move.toColumn] == null) {
                valid = false;
            }
        }
        // Checking to see if the player can perform an en passant
        if (player() == Player.WHITE && move.fromRow == 3){
            if (canCaptureEnPassant(move.toRow + 1, move.toColumn, board)) {
                valid = true;
                ChessModel.setEnPassantW();
            }
        }
        else if (player() == Player.BLACK && move.fromRow == 4){
            if (canCaptureEnPassant(move.toRow - 1, move.toColumn, board)) {
                valid = true;
                ChessModel.setEnPassantB();
            }
        }
        if (valid)
            firstMove = false;
        return valid;
    }
}
