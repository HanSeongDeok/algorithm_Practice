package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class ValidSudoku {
    public static boolean solution(char[][] board){
        int row = board.length;
        int column = board.length;
        Set rowSet = null;
        Set columnSet = null;
        Set blockSet = null;

        //Check for row
        for(int i=0; i<column; i++){
            rowSet = new HashSet();
            for(int j=0; j<row; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(rowSet.contains(board[i][j])){
                    return false;
                }
                rowSet.add(board[i][j]);
            }
        }
        //check for column
        for(int i=0; i<row; i++){
            columnSet = new HashSet();
            for(int j=0; j<column; j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(columnSet.contains(board[j][i])){
                    return false;
                }
                columnSet.add(board[j][i]);
            }
        }
        //check for block
        for(int i=0; i<row; i++){
            blockSet = new HashSet();
            int tempI = ((i/3)*3);
            int tempJ = ((i%3)*3);
            for(int j=0; j<column; j++){
                if(j!=0 && j%3==0){
                    tempI++;
                    tempJ = ((i%3)*3);
                }
                if(board[tempJ][tempI]=='.'){
                    tempJ++;
                    continue;
                }
                if(blockSet.contains(board[tempJ][tempI])){
                    return false;
                }
                blockSet.add(board[tempJ][tempI]);
                tempJ++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = {{'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        solution(board);
    }
}
