import java.util.*;

public class mazer{
    public static final int movesLimit = 50;
    public static void main(String[] args){
        Maze myMap = new Maze();
        intro();
        myMap.printMap();
        /*
        char[][] sol=myMap.printSolution();
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
        */

        int moves=0;
        do {
            String move = userMove();
            if (move.equalsIgnoreCase("exit")) {
                System.out.println("You exited.");
                break;
            }

            if (move.equalsIgnoreCase("r")) {
                if (myMap.canIMoveRight()) {
                    myMap.moveRight(); // Moves your position one to the right and prints out the new board
                } else if (myMap.isThereAPit("R")) {
                    if (navigatePit()) {
                        myMap.jumpOverPit("R");
                    } else {
                        System.out.println("There is a pit and you didn't jump it.");
                    }
                } else {
                    System.out.println("Sorry, you’ve hit a wall. Pick another direction.");
                }
            } else if (move.equalsIgnoreCase("l")) {
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft(); // Moves your position one to the right and prints out the new board
                } else if (myMap.isThereAPit("L")) {
                    if (navigatePit()) {
                        myMap.jumpOverPit("L");
                    } else {
                        System.out.println("There is a pit and you didn't jump it.");
                    }
                }  else {
                    System.out.println("Sorry, you’ve hit a wall. Pick another direction.");
                }
            } else if (move.equalsIgnoreCase("u")) {
                if (myMap.canIMoveUp()) {
                    myMap.moveUp(); // Moves your position one to the right and prints out the new board
                } else if (myMap.isThereAPit("U")) {
                    if (navigatePit()) {
                        myMap.jumpOverPit("U");
                    } else {
                        System.out.println("There is a pit and you didn't jump it.");
                    }
                }  else {
                    System.out.println("Sorry, you’ve hit a wall. Pick another direction.");
                }
            } else if (move.equalsIgnoreCase("d")) {
                if (myMap.canIMoveDown()) {
                    myMap.moveDown(); // Moves your position one to the right and prints out the new board
                } else if (myMap.isThereAPit("D")) {
                    if (navigatePit()) {
                        myMap.jumpOverPit("D");
                    } else {
                        System.out.println("There is a pit and you didn't jump it.");
                    }
                }  else {
                    System.out.println("Sorry, you’ve hit a wall. Pick another direction.");
                }
            }
            myMap.printMap();
            if (moves==movesLimit-1){
                System.out.println("Sorry, you lose.");
                break;
            } else {
                moves++;
                int rest=movesLimit-moves;
                System.out.println("You have "+rest+"steps left");
            }
        } while(!myMap.didIWin());
        if (myMap.didIWin()) {
            System.out.println("Congratulations, you made it out alive!");
        }
    }

    public static void intro() {
        System.out.println("Welcome to mazeRunner!");
        System.out.println("Here is your current position");
    }

    public static String userMove() {
        System.out.println("Where would you like to move? (R, L, U, D)");
        Scanner keyboard=new Scanner(System.in);
        String move=keyboard.nextLine();
        if (move.equalsIgnoreCase("exit")){
            return move;
        } else {
            while (!move.equalsIgnoreCase("r") && !move.equalsIgnoreCase("u") && !move.equalsIgnoreCase("d") && !move.equalsIgnoreCase("l")) {
                System.out.println("Undesired Input. Please re-insert.");
                move = keyboard.nextLine();
            }
        }
        return move;
    }

    public static boolean navigatePit(){
        System.out.println("Watch out! There's a pit ahead, jump it?");
        Scanner pitkey=new Scanner(System.in);
        String jump=pitkey.nextLine();
        if (jump.equalsIgnoreCase("y")){
            return true;
        } else {
            return false;
        }
    }
}
