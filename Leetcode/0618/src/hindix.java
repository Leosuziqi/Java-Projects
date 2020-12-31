import java.util.*;
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0||citations[citations.length-1]==0) return 0;
        if(citations.length==1) return 1;
        int size;
        size = citations.length;
        return reindex(size,0,size-1,citations);

    }
    public int reindex(int size,int start,int end,int[] citations) {
        int index=(start+end)/2;
        if(index==0){
            if(citations[0]>=2 )return size;
            else if(citations[1]==0) return 0;
            else return 1;
        }
        if(size-index<=citations[index] && citations[index-1]<=size-index){
            return size-index;
        } else if (size-index>citations[index]){
            return reindex(size,index,end,citations);
        } else {
            return reindex(size,start,index,citations);
        }

    }
}




class Solution {
    public static void main(String[] args) {
        int v=0;
        char[][] board={{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        int[][] map = new int[board.length][board[0].length];
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board[0].length-1; j++) {
                map[i][j] = 1;
            }
        }
        for (int j = 1; j < board[0].length-1; j++) {
            if (board[0][j] == 'O') {
                map[1][j] = 0;
            }
            if (board[board.length - 1][j] == 'O') {
                map[board.length - 2][j] = 0;
            }
            if (board[0][j] == 'O') {
                map[1][j] = 0;
            }
            if (board[board.length - 1][j] == 'O') {
                map[board.length - 2][j] = 0;
            }
        }
        Boolean flag;
        int count=(board.length-1)*(board.length-1);
        do{
            flag=true;
            for (int i = 1; i < board.length-1; i++) {
                for (int j = 1; j < board[0].length-1; j++) {
                    if(map[i][j]==0&&board[i][j]=='O'){
                        map[i+1][j]=0;
                        map[i-1][j]=0;
                        map[i][j-1]=0;
                        map[i][j+1]=0;
                        flag=false;
                    }
                }
            }
            count--;
            System.out.println(count);
        } while(!flag&&count!=0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board[0].length-1; j++) {
                if(map[i][j]==0&&board[i][j]=='O'){
                    map[i][j]='X';
                }
            }
        }
    }
}