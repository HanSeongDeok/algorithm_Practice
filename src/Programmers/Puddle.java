package Programmers;

public class Puddle {
    public int solution(int m, int n, int[][] puddles) {
        int [][]paths = new int[n][m];
        for (int [] puddle : puddles) {
            paths[puddle[1]-1][puddle[0]-1] = -1;
        }
        paths[0][0] = 1;
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (paths[i][j] == -1){
                    paths[i][j] = 0; continue;
                }
                if (i > 0) paths[i][j] += paths[i-1][j];
                if (j > 0) paths[i][j] += paths[i][j-1];
            }
        }
        return paths[n-1][m-1] % 1000000007;
    }
}
