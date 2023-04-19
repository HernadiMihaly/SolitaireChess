import inf.unideb.hu.chessgame.state.ai.HeuristicSearch;
import inf.unideb.hu.chessgame.state.board.Board;
import inf.unideb.hu.chessgame.state.board.boardimpl.SimpleBoard;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Ez a tesztosztály a Heuristic Search algoritmus működését teszteli.
 * Futtatás előtt a heap-et bővíteni kell mivel sok a lépés az expert szinten, így StackOverflowError lesz
 */
public class HeuristicSearchTest {

    /**
     * Egy kezdő szintű kártyafeladványt tesztel, hogy az algoritmus megfejtése alapján a célállapot megfelel-e a vártnak.
     */
    @Test
    public void testSolveBeginner() {
        Board board = new SimpleBoard();
        board.setBoardFromString(" x, Bishop, x, x\n x, x, Queen, x\n x, x, x, Bishop\n Rook, x, x, x\n");

        Board expectedBoard = new SimpleBoard();
        expectedBoard.setBoardFromString(" x, x, x, x\n x, x, x, x\n x, x, x, x\n Bishop, x, x, x\n");

        HeuristicSearch heuristicSearch = new HeuristicSearch(board);
        board = heuristicSearch.solve().get(heuristicSearch.solve().size()-1);

        assertEquals(expectedBoard.toString(), board.toString());
    }

    /**
     * Egy közepes szintű kártyafeladványt tesztel, hogy az algoritmus megfejtése alapján a célállapot megfelel-e a vártnak.
     */
    @Test
    public void testSolveIntermediate() {
        Board board = new SimpleBoard();
        board.setBoardFromString(" x, Knight, x, x\n x, Bishop, Pawn, Bishop\n Pawn, x, Knight, x\n x, x, x, x\n");

        Board expectedBoard = new SimpleBoard();
        expectedBoard.setBoardFromString(" x, x, x, x\n x, x, Knight, x\n x, x, x, x\n x, x, x, x\n");

        HeuristicSearch heuristicSearch = new HeuristicSearch(board);
        board = heuristicSearch.solve().get(heuristicSearch.solve().size()-1);

        assertEquals(expectedBoard.toString(), board.toString());
    }

    /**
     * Egy haladó szintű kártyafeladványt tesztel, hogy az algoritmus megfejtése alapján a célállapot megfelel-e a vártnak.
     */
    @Test
    public void testSolveAdvanced() {
        Board board = new SimpleBoard();
        board.setBoardFromString(" x, x, Rook, x\n Rook, x, x, Pawn\n x, Bishop, King, x\n Pawn, x, x, Bishop\n");

        Board expectedBoard = new SimpleBoard();
        expectedBoard.setBoardFromString(" x, x, King, x\n x, x, x, x\n x, x, x, x\n x, x, x, x\n");

        HeuristicSearch heuristicSearch = new HeuristicSearch(board);
        board = heuristicSearch.solve().get(heuristicSearch.solve().size()-1);

        assertEquals(expectedBoard.toString(), board.toString());
    }

    /**
     * Egy profi szintű kártyafeladványt tesztel, hogy az algoritmus megfejtése alapján a célállapot megfelel-e a vártnak.
     */
    @Test
    public void testSolveExpert() {
        Board board = new SimpleBoard();
        board.setBoardFromString(" x, x, x, Rook\n Rook, Bishop, Pawn, x\n King, x, x, x\n Knight, Pawn, Bishop, x\n");

        Board expectedBoard = new SimpleBoard();
        expectedBoard.setBoardFromString(" x, x, x, King\n x, x, x, x\n x, x, x, x\n x, x, x, x\n");

        HeuristicSearch heuristicSearch = new HeuristicSearch(board);
        board = heuristicSearch.solve().get(heuristicSearch.solve().size()-1);

        assertEquals(expectedBoard.toString(), board.toString());
    }

}