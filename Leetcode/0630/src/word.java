import java.util.*;
public class word {
    public static void main(String[] arg){
        char[][] board={{'a','b'},{'a','a'}};
                //{{'b','a','a','b','a','b'},{'a','b','a','a','a','a'},{'a','b','a','a','a','b'},{'a','b','a','b','b','a'},{'a','a','b','b','a','b'},{'a','a','b','b','b','a'},{'a','a','b','a','a','b'}};
        String[] words ={"bab"};
                //{"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
        findWords(board, words);
    }
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList<String>(); ;
        for (int index = 0; index < words.length; index++) {
            char[] word = words[index].toCharArray();

            boolean flag=false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    flag=false;
                    boolean[][] used=new boolean[board.length][board[0].length];
                    if (board[i][j] == word[0]) {

                        if (exist(used,board,i,j, word,0) == true) {
                            result.add(words[index]);
                            flag=true;
                            break;
                        }
                    }
                }
                if(flag) break;

            }

        }
        return result;
    }

    public static boolean exist(boolean[][] used,char[][] board,int row,int col,char[] word,int numofchar) {
        if (board[row][col] != word[numofchar]) {
            return false;
        } else if (numofchar == word.length-1 ) {
            return true;
        } else {
            boolean a = false;
            boolean b = false;
            boolean c = false;
            boolean d = false;
            if (row != 0&&used[row-1][col]==false) {
                used[row][col]=true;
                a = exist(used, board, row - 1, col, word, numofchar + 1);
                if(!a)used[row][col]=false;
            }
            if (row != board.length-1&&used[row+1][col]==false) {
                used[row][col]=true;
                b = exist(used, board, row + 1, col, word, numofchar + 1);
                if(!b)used[row][col]=false;
            }
            if (col != 0&&used[row][col-1]==false) {
                used[row][col]=true;
                c = exist(used, board, row, col - 1, word, numofchar + 1);
                if(!c)used[row][col]=false;
            }
            if (col != board[0].length-1&&used[row][col+1]==false) {
                used[row][col]=true;
                d = exist(used, board, row, col + 1, word, numofchar + 1);
                if(!d)used[row][col]=false;
            }
            return a || b || c || d;
        }

    }
}



class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs[0].length()==0) {
            return "";
        }
        if(strs.length==1) {
            return strs[1];
        }
        for (int pre=0;pre<strs[0].length();pre++){
            for(int i=0;i<strs.length-1;i++){
                String temp1=strs[i].substring(0,pre);
                String temp2=strs[i+1].substring(0,pre);
                if(!temp1.equals(temp2)){
                    return strs[i].substring(0,pre-1);
                }
            }
        }
        return strs[0].substring(0,strs[0].length()-1);
    }
}
