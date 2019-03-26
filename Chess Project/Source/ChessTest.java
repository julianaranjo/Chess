package Source;

import org.junit.Test;
import static org.junit.Assert.*;

/**********************************************************************
 * JUnit tests for all of the chess classes in the package
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class ChessTest
{
    /** the chessboard */
    private IChessPiece[][] board = new IChessPiece[8][8];

    private ChessModel model = new ChessModel();

    // rook stays in same spot
    @Test
    public void rookTest1()
    {
        Player p = Player.WHITE;
        Rook rook = new Rook(p);
        Move move = new Move(2, 2, 2, 2);
        assertFalse(rook.isValidMove(move, board));
    }

    // rook moves up on board
    @Test
    public void rookTest2()
    {
        Player p = Player.WHITE;
        Rook rook = new Rook(p);
        Move move = new Move(2, 2, 6, 2);
        assertTrue(rook.isValidMove(move, board));
    }

    // rook moves right on board
    @Test
    public void rookTest3()
    {
        Player p = Player.WHITE;
        Rook rook = new Rook(p);
        Move move = new Move(2, 2, 2, 6);
        assertTrue(rook.isValidMove(move, board));
    }

    // rook moves down on board
    @Test
    public void rookTest4()
    {
        Player p = Player.WHITE;
        Rook rook = new Rook(p);
        Move move = new Move(5, 5, 2, 5);
        assertTrue(rook.isValidMove(move, board));
    }

    // rook moves left on board
    @Test
    public void rookTest6()
    {
        Player p = Player.WHITE;
        Rook rook = new Rook(p);
        Move move = new Move(5, 5, 5, 2);
        assertTrue(rook.isValidMove(move, board));
    }

    // rook moves up and to the right board
    @Test
    public void rookTest7()
    {
        Player p = Player.WHITE;
        Rook rook = new Rook(p);
        Move move = new Move(5, 5, 7, 7);
        assertFalse(rook.isValidMove(move, board));
    }

    // rook moves down and to the left board
    @Test
    public void rookTest8()
    {
        Player p = Player.WHITE;
        Rook rook = new Rook(p);
        Move move = new Move(5, 5, 2, 2);
        assertFalse(rook.isValidMove(move, board));
    }

    // bishop moves onto itself on board
    @Test
    public void bishopTest1()
    {
        Player p = Player.WHITE;
        Bishop bishop = new Bishop(p);
        Move move = new Move(2, 2, 2, 2);
        assertFalse(bishop.isValidMove(move, board));
    }

    // bishop moves up and right on board
    @Test
    public void bishopTest2()
    {
        Player p = Player.WHITE;
        Bishop bishop = new Bishop(p);
        Move move = new Move(2, 2, 4, 4);
        assertTrue(bishop.isValidMove(move, board));
    }

    // bishop moves up and left on board
    @Test
    public void bishopTest3()
    {
        Player p = Player.WHITE;
        Bishop bishop = new Bishop(p);
        Move move = new Move(2, 2, 1, 1);
        assertTrue(bishop.isValidMove(move, board));
    }

    // bishop moves down and right on board
    @Test
    public void bishopTest4()
    {
        Player p = Player.WHITE;
        Bishop bishop = new Bishop(p);
        Move move = new Move(2, 2, 1, 3);
        assertTrue(bishop.isValidMove(move, board));
    }

    // bishop moves down and left on board
    @Test
    public void bishopTest5()
    {
        Player p = Player.WHITE;
        Bishop bishop = new Bishop(p);
        Move move = new Move(2, 2, 3, 1);
        assertTrue(bishop.isValidMove(move, board));
    }

    // bishop tries to go directly right
    @Test
    public void bishopTest6()
    {
        Player p = Player.WHITE;
        Bishop bishop = new Bishop(p);
        Move move = new Move(2, 2, 2, 4);
        assertFalse(bishop.isValidMove(move, board));
    }

    // bishop tries to go directly down
    @Test
    public void bishopTest7()
    {
        Player p = Player.WHITE;
        Bishop bishop = new Bishop(p);
        Move move = new Move(2, 2, 1, 2);
        assertFalse(bishop.isValidMove(move, board));
    }

    // knight tries to move onto itself
    @Test
    public void knightTest1()
    {
        Player p = Player.WHITE;
        Knight knight = new Knight(p);
        Move move = new Move(5, 5, 5, 5);
        assertFalse(knight.isValidMove(move, board));
    }

    // knight moves up 2, right 1
    @Test
    public void knightTest2()
    {
        Player p = Player.WHITE;
        Knight knight = new Knight(p);
        Move move = new Move(5, 5, 3, 6);
        assertTrue(knight.isValidMove(move, board));
    }

    // knight moves down 1, left 2
    @Test
    public void knightTest3()
    {
        Player p = Player.WHITE;
        Knight knight = new Knight(p);
        Move move = new Move(5, 5, 6, 3);
        assertTrue(knight.isValidMove(move, board));
    }

    // knight tries to move straight up
    @Test
    public void knightTest4()
    {
        Player p = Player.WHITE;
        Knight knight = new Knight(p);
        Move move = new Move(5, 5, 1, 5);
        assertFalse(knight.isValidMove(move, board));
    }

    // knight tries to moves down 3, left 3
    @Test
    public void knightTest5()
    {
        Player p = Player.WHITE;
        Knight knight = new Knight(p);
        Move move = new Move(5, 5, 2, 2);
        assertFalse(knight.isValidMove(move, board));
    }

    // king tries to move onto itself
    @Test
    public void kingTest1()
    {
        Player p = Player.WHITE;
        King king = new King(p);
        Move move = new Move(5, 5, 5, 5);
        assertFalse(king.isValidMove(move, board));
    }

    // king moves up right
    @Test
    public void kingTest2()
    {
        Player p = Player.WHITE;
        King king = new King(p);
        Move move = new Move(5, 5, 4, 6);
        assertTrue(king.isValidMove(move, board));
    }

    // king moves down left
    @Test
    public void kingTest3()
    {
        Player p = Player.WHITE;
        King king = new King(p);
        Move move = new Move(5, 5, 6, 4);
        assertTrue(king.isValidMove(move, board));
    }

    // king tries to move right 2 spaces
    @Test
    public void kingTest4()
    {
        Player p = Player.WHITE;
        King king = new King(p);
        Move move = new Move(5, 5, 5, 7);
        assertFalse(king.isValidMove(move, board));
    }

    // pawn tries to move onto itself
    @Test
    public void pawnTest1()
    {
        Player p = Player.WHITE;
        Pawn pawn = new Pawn(p);
        Move move = new Move(5, 5, 5, 5);
        assertFalse(pawn.isValidMove(move, board));
    }

    // pawn moves one space forward
    @Test
    public void pawnTest2(){
        Player p = Player.BLACK;
        Pawn pawn = new Pawn(p);
        Move move = new Move(4, 5, 5, 5);
        assertTrue(pawn.isValidMove(move, board));
    }

    // pawn moves two spaces forward on first turn
    @Test
    public void pawnTest3(){
        Player p = Player.BLACK;
        Pawn pawn = new Pawn(p, true);
        Move move = new Move(3, 5, 5, 5);
        assertTrue(pawn.isValidMove(move, board));
    }

    // pawn moves two spaces forward on second turn
    @Test
    public void pawnTest4(){
        Player p = Player.BLACK;
        Pawn pawn = new Pawn(p, false);
        Move move = new Move(3, 5, 5, 5);
        assertFalse(pawn.isValidMove(move, board));
    }

    // en passant test for white pawns
    @Test
    public void pawnTest5(){
        model = new ChessModel();
        Move moveB = new Move (1, 0, 3, 0 );
        Move moveW1 = new Move (6, 1, 4, 1);
        Move moveW2 = new Move (4, 1, 3, 1);
        Move moveCapture = new Move (3, 1, 2, 0);
        model.move(moveB);
        model.move(moveW1);
        model.move(moveW2);
        assertFalse(model.isValidMove(moveCapture));
    }
    
    // Queen attempts to move backwards

    @Test

    public void queenTest1(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 2, 5);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move forwards

    @Test

    public void queenTest2(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 7, 5);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move to the right

    @Test

    public void queenTest3(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 5, 7);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move left

    @Test

    public void queenTest4(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 5, 3);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move up and left

    @Test

    public void queenTest5(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 3, 3);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move up and right

    @Test

    public void queenTest6(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 3, 7);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move down and left

    @Test

    public void queenTest7(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 7, 3);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move down and right

    @Test

    public void queenTest8(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 7, 7);

        assertTrue(queen.isValidMove(move, board));

    }
    
    // Queen attempts to move in an L shape

    @Test

    public void queenTest9(){

        Player q = Player.BLACK;

        Queen queen = new Queen(q);

        Move move = new Move(5, 5, 7, 6);

        assertFalse(queen.isValidMove(move, board));

    }
}
