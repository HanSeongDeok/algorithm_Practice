package neetCode150.ArrayHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Valid_Sudoku {
    Set<Character> rowSet = new HashSet<>();
    Set<Character> columnSet = new HashSet<>();
    boolean validRow = true;
    public boolean isValidSudoku(char[][] board) {
        // Check for row
        boolean isValidRow = IntStream.range(0, board[0].length)
                .allMatch(i -> {
                    Set<Character> rowSet = new HashSet<>();
                    return IntStream.range(0, board.length)
                            .filter(j -> board[i][j] != '.') // Filter out empty cells
                            .mapToObj(j -> board[i][j])
                            .allMatch(rowSet::add);
                });

        // Check for column
        boolean isValidColumn = IntStream.range(0, board.length)
                .allMatch(i -> {
                    Set<Character> columnSet = new HashSet<>();
                    return IntStream.range(0, board[0].length)
                            .filter(j -> board[j][i] != '.') // Filter out empty cells
                            .mapToObj(j -> board[j][i])
                            .allMatch(columnSet::add);
                });

        // Check for block
       /* boolean isValidBlock = IntStream.range(0, row)
                .allMatch(i -> {
                    Set<Character> blockSet = new HashSet<>();
                    int tempI = (i / 3) * 3;
                    int tempJ = (i % 3) * 3;
                    return IntStream.range(0, column)
                            .filter(j -> j % 3 == 0 || j == 0)
                            .allMatch(j -> {
                                if (board[tempJ][tempI] == '.') {
                                    tempJ++;
                                    return true;
                                }
                                boolean isValid = blockSet.add(board[tempJ][tempI]);
                                tempJ++;
                                return isValid;
                            });
                });*/

        return validRow;
    }
}
