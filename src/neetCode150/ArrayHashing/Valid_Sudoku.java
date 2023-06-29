package neetCode150.ArrayHashing;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


public class Valid_Sudoku {
    Set<Character> rowSet = new HashSet<>();
    Set<Character> columnSet = new HashSet<>();
    boolean validRow = true;
    public boolean isValidSudoku(char[][] board) {
        final int rowLen = board[0].length;
        final int colLen = board.length;
        final int boxLen = 9;

        // Check for row
        boolean isValidRow = IntStream.range(0, rowLen)
                .allMatch(i -> {
                    Set<Character> rowSet = new HashSet<>();
                    return IntStream.range(0, colLen)
                            .filter(j -> board[i][j] != '.') // Filter out empty cells
                            .mapToObj(j -> board[i][j])
                            .allMatch(rowSet::add);
                });

        // Check for column
        boolean isValidColumn = IntStream.range(0, rowLen)
                .allMatch(i -> {
                    Set<Character> columnSet = new HashSet<>();
                    return IntStream.range(0, board[0].length)
                            .filter(j -> board[j][i] != '.') // Filter out empty cells
                            .mapToObj(j -> board[j][i])
                            .allMatch(columnSet::add);
                });

        // Check for block
        boolean isValidBlock = IntStream.range(0, boxLen)
                .allMatch(num -> {
                    Set<Character> blockSet = new HashSet<>();
                    final int tempI = (num / 3) * 3;
                    final int tempJ = (num % 3) * 3;
                    return IntStream.range(0, num).allMatch(index -> {
                                char ch = board[tempJ + index % 3][tempI + index / 3];
                                return ch == '.' || blockSet.add(ch);
                            });
                });

        return isValidRow & isValidColumn & isValidBlock;
    }

    public boolean isValidSudoku2(char[][] board) {



        return false;
    }
}

