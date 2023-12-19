package ProgrammersPractice;

public class Puddle {
    public int solution(int m, int n, int[][] puddles){
        // puddle 우물이 있는 곳을 -1로 지정한다.
        int[][] pathCountArr = new int[n][m];
        for (int [] p : puddles) {
            pathCountArr[p[1]-1][p[0]-1] = -1;
        }
        pathCountArr[0][0] = 1;
        // 다음 행으로 넘어가는 반복
        for (int i=0; i<pathCountArr.length; i++) {
            // 옆으로(다음 열로) 이동하며 계산
            pathCountArr = columnCount(pathCountArr, i);
        }
        return pathCountArr[n-1][m-1] % 1000000007;
    }
    private int[][] columnCount(int[][] pathCountArr, int i) {
        for (int j = 0; j< pathCountArr[i].length; j++) {
            if (pathCountArr[i][j] == -1) {
                pathCountArr[i][j] = 0; continue;
            }
            if (i > 0) pathCountArr[i][j] += pathCountArr[i-1][j] % 1000000007;
            if (j > 0) pathCountArr[i][j] += pathCountArr[i][j-1] % 1000000007;
        }
        return pathCountArr;
    }
}
