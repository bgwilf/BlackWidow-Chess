package com.chess.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chess.engine.classic.board.Board;
import com.chess.engine.classic.board.Move;
import com.chess.engine.classic.board.StandardBoardConfigurator;
import com.chess.engine.classic.player.Player;
import com.chess.engine.classic.player.ai.MiniMax;
import com.chess.engine.classic.player.ai.MoveStrategy;

public class TestMiniMax {

    @Test
    public void testOpeningDepth1() {
        final Board board = new Board(new StandardBoardConfigurator());
        final Player currentPlayer = board.currentPlayer();
        final MoveStrategy minMax = new MiniMax();
        currentPlayer.setMoveStrategy(minMax);
        final Move bestMove = board.currentPlayer().getMoveStrategy().execute(board, 1);
        final long numBoardsEvaluated = minMax.getNumBoardsEvaluated();
        assertEquals(numBoardsEvaluated, 20L);
        assertEquals(bestMove, Move.MoveFactory
                .createMove(board, Board.getCoordinateAtPosition("e2"), Board.getCoordinateAtPosition("e4")));
    }

    @Test
    public void testOpeningDepth2() {
        final Board board = new Board(new StandardBoardConfigurator());
        final Player currentPlayer = board.currentPlayer();
        final MoveStrategy minMax = new MiniMax();
        currentPlayer.setMoveStrategy(minMax);
        final Move bestMove = board.currentPlayer().getMoveStrategy().execute(board, 2);
        final long numBoardsEvaluated = minMax.getNumBoardsEvaluated();
        assertEquals(numBoardsEvaluated, 400L);
        assertEquals(bestMove, Move.MoveFactory
                .createMove(board, Board.getCoordinateAtPosition("e2"), Board.getCoordinateAtPosition("e4")));
    }

    @Test
    public void testOpeningDepth3() {
        final Board board = new Board(new StandardBoardConfigurator());
        final Player currentPlayer = board.currentPlayer();
        final MoveStrategy minMax = new MiniMax();
        currentPlayer.setMoveStrategy(minMax);
        final Move bestMove = board.currentPlayer().getMoveStrategy().execute(board, 3);
        final long numBoardsEvaluated = minMax.getNumBoardsEvaluated();
        assertEquals(numBoardsEvaluated, 8902L);
        assertEquals(bestMove, Move.MoveFactory
                .createMove(board, Board.getCoordinateAtPosition("d2"), Board.getCoordinateAtPosition("d4")));
    }

    @Test
    public void testOpeningDepth4() {
        final Board board = new Board(new StandardBoardConfigurator());
        final Player currentPlayer = board.currentPlayer();
        final MoveStrategy minMax = new MiniMax();
        currentPlayer.setMoveStrategy(minMax);
        final Move bestMove = board.currentPlayer().getMoveStrategy().execute(board, 4);
        final long numBoardsEvaluated = minMax.getNumBoardsEvaluated();
        assertEquals(numBoardsEvaluated, 197281L);
        assertEquals(bestMove, Move.MoveFactory
                .createMove(board, Board.getCoordinateAtPosition("e2"), Board.getCoordinateAtPosition("e4")));
    }

    @Test
    public void testOpeningDepth4BlackMovesFirst() {
        final Board board = new Board(new StandardBoardConfigurator());
        board.setCurrentPlayer(board.blackPlayer());
        final Player currentPlayer = board.currentPlayer();
        final MoveStrategy minMax = new MiniMax();
        currentPlayer.setMoveStrategy(minMax);
        final Move bestMove = board.currentPlayer().getMoveStrategy().execute(board, 4);
        final long numBoardsEvaluated = minMax.getNumBoardsEvaluated();
        assertEquals(numBoardsEvaluated, 197281L);
        assertEquals(bestMove, Move.MoveFactory
                .createMove(board, Board.getCoordinateAtPosition("e7"), Board.getCoordinateAtPosition("e5")));
    }
}
