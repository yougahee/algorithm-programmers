/**
    링크 url 
    - https://school.programmers.co.kr/learn/courses/30/lessons/120866
**/

class Solution {
    
    public int solution(int[][] board) {
        
        var size = board.length;        
        
        int[][] dangerLine = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if (board[i][j] == 1) { // 지뢰존재
                    checkDangerRegion(dangerLine, board, i, j);
                }
            }
        }
        
        return getSafeRegion(board, size);
    }
    
    
    public void checkDangerRegion(int[][] dangerLine, int[][] board, int x, int y) {
        
        int size = board.length;
        
        for (int i=0; i<8; i++) {
            
            int moveX = x + dangerLine[i][0];
            int moveY = y + dangerLine[i][1];
            
            if (moveX < 0 || moveX >= size || moveY < 0 || moveY >= size) continue;
            
            // 폭탄을 덮어쓰면 안되니까.
            if(board[moveX][moveY] == 0) {
                board[moveX][moveY] = 2;
            }               
        }
    }
    
    public int getSafeRegion(int[][] danger, int size) {
        
        int answer = 0;
        
        for(int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if(danger[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
        
    }
}
