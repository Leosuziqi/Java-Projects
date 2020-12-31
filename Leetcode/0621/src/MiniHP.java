class Solution {
    public static void main(String[] args){
        int[][] dungeon={{-2,-3,3},{5,-10,1},{10,30,-5}};
        int[][] sum=new int[dungeon.length][dungeon[0].length];
        int[][] hp=new int[dungeon.length][dungeon[0].length];
        hp[0][0]=dungeon[0][0];
        sum[0][0]=dungeon[0][0];
        calhp(dungeon,sum,hp,0,0);
        int minimum=-100;
        for(int i=0;i<dungeon.length;i++){
            for(int j=0;j<dungeon[0].length;j++){
                if (hp[i][j]>minimum){
                    minimum=hp[i][j];
                }

            }
        }

        for(int i=0;i<dungeon.length;i++){
            for(int j=0;j<dungeon[0].length;j++){
                System.out.print(hp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void calhp(int[][] grid,int[][] sum,int[][] hp,int row, int col){
        if(row==grid.length-1&&col==grid[0].length-1){

        }
        if(row<grid.length-1) {
            if(sum[row][col]<hp[row][col]){
                hp[row][col]=sum[row][col];
            }
            if (grid[row + 1][col] <= 0) {
                hp[row + 1][col] = grid[row + 1][col] + hp[row][col];
            }
            sum[row + 1][col] = grid[row + 1][col] + sum[row][col];

            calhp(grid, sum,hp ,row + 1, col);
        }
        if(col<grid[0].length-1) {

            if(sum[row][col]<hp[row][col]){
                hp[row][col]=sum[row][col];
            }
            if (grid[row][col+ 1] <= 0) {
                hp[row][col + 1] = grid[row][col+ 1] + hp[row][col];
            }
            sum[row][col + 1] = grid[row][col + 1] + sum[row][col];

            calhp(grid, sum,hp ,row, col+1);
        }
    }
}





class Solution {
    public int romanToInt(String s) {
        char[] schar=s.toCharArray();
        int sum=0;
        for(int i=0;i<schar.length;i++){
            if(i!=schar.length-1){
                if(schar[i]=='I'){
                    if (schar[i+1]=='V'||schar[i+1]=='X'||schar[i+1]=='L'||schar[i+1]=='C'||schar[i+1]=='D'||schar[i+1]=='M'){
                        sum=sum-1;
                    } else sum++;
                }
                if(schar[i]=='X'){
                    if (schar[i+1]=='V'||schar[i+1]=='X'||schar[i+1]=='L'||schar[i+1]=='C'||schar[i+1]=='D'||schar[i+1]=='M'){
                        sum=sum-1;
                    } else sum++;
                }
            }
        }

        return 1;
    }
}