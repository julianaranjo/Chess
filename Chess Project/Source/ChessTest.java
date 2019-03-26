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
    private IChessPiece[][] board = new IChessPiece[8][8];

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
}
