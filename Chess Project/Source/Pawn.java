package Source;

public class Pawn extends ChessPiece {
    private boolean firstMove;
    private boolean enPassantOK; // can the piece be taken via en passant

    public Pawn(Player player) {
        super(player);
        this.firstMove = true;
    }

    public Pawn(Player player, boolean firstMove) {
        super(player);
        this.firstMove = firstMove;
    }

    public String type() {
        return "Pawn";
    }

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

    // determines if the move is valid for a pawn piece
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = true;

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
