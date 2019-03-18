public class Bishop extends ChessPiece {

    public Bishop(Player player) {
        super(player);
    }

    public String type() {
        return "Bishop";
    }

    public boolean isValidMove(Move move, IChessPiece[][] board) {

        boolean valid = false;

        if (move.toColumn > board.length || move.toRow > board.length) {
            valid = false;
        }

        if (move.toColumn < 0 || move.toRow < 0) {
            valid = false;
        }

        if (move.toColumn == move.fromColumn + 0 || move.toRow == move.fromRow + 0) {
                    valid = false;
                }
        for (int i = 1; i < board.length; i++){
            if(move.toColumn == move.fromColumn + i && move.toRow == move.fromRow + i){
                valid = true;
            }

            else if(move.toColumn == move.fromColumn - i && move.toRow == move.fromRow + i){
                valid = true;
            }

            else if(move.toColumn == move.fromColumn - i && move.toRow == move.fromRow - i){
                valid = true;
            }

            else if(move.toColumn == move.fromColumn + i && move.toRow == move.fromRow - i){
                valid = true;
            }

        }
        
        return valid;
    }

}
