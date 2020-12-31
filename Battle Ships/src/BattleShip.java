import java.util.*; // you must import Scanner to use it


public class BattleShip {
    public static void main(String[] args) {
        String[][] shown=new String[5][5];
        String[][] hidenComp=new String[5][5];
        System.out.println("Welcome to battle ship game");
        System.out.println("Now start. The sea is empty.");
        System.out.println("");
        printmap(shown);
        deploy(shown);
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                hidenComp[i][j] = shown[i][j];
            }
        }
        compdeploy(hidenComp);
/*
        printmap(shown);
        printmap(hidenComp); //computer's map, check for debugging
        System.out.println("1");

 */
        do {
            printmap(shown);
            yourturn(shown,hidenComp);

            if (checkwin(hidenComp,"c")){
                System.out.println("You win!");
                break;
            } else if (checkwin(shown,"@")){
                System.out.println("You lose!");
                break;
            }

            compturn(shown,hidenComp);
            if (checkwin(hidenComp,"c")){
                System.out.println("You win!");
                break;
            } else if (checkwin(shown,"@")){
                System.out.println("You lose!");
                break;
            }
/*
            printmap(hidenComp);
            printmap(shown);
            System.out.println("2");
 */
        } while (true);

    }

    public static boolean checkwin(String[][] map,String signal) {
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(map[i][j]==signal){
                    return false;
                }
            }
        }
        return true;
    }

    public static void compturn(String[][] shown,String[][] hidenComp){
        //computer turn
        System.out.println("Computer turn");
        coord step;
        do {
             step = randcoord();
        } while (hidenComp[step.x - 1][step.y - 1] == "-"|| hidenComp[step.x - 1][step.y - 1] == "!"||hidenComp[step.x - 1][step.y - 1] == "x") ;

        if(hidenComp[step.x-1][step.y-1]=="c"){
            System.out.println("The Computer sunk one of its own ships");
            shown[step.x-1][step.y-1] = "!";
            hidenComp[step.x-1][step.y-1] = "!";
        } else if (shown[step.x-1][step.y-1]=="@"){
            System.out.println("The Computer sunk one of your ships!");
            shown[step.x-1][step.y-1] = "x";
            hidenComp[step.x-1][step.y-1] = "x";
        } else {
            System.out.println("Computer missed.");
            hidenComp[step.x-1][step.y-1] = "-";
        }

        //printmap(hidenComp);
    }

    public static void yourturn(String[][] shown,String[][] hidenComp) {
        //your turn
        System.out.println("Your turn");
        coord step = GetCoord();
        if (hidenComp[step.x - 1][step.y - 1] == "c") {
            System.out.println("Boom! You sunk the ship!");
            shown[step.x - 1][step.y - 1] = "!";
            hidenComp[step.x - 1][step.y - 1] = "!";
        } else if (hidenComp[step.x - 1][step.y - 1] == "@") {
            System.out.println("Oh no, you sunk your own ship :(");
            shown[step.x - 1][step.y - 1] = "x";
            hidenComp[step.x - 1][step.y - 1] = "x";
        } else {
            System.out.println("Sorry, you missed.");
            shown[step.x - 1][step.y - 1] = "-";
        }
        Scanner inp=new Scanner(System.in);
        inp.nextLine();
    }

    public static void compdeploy(String[][] shown){
        System.out.println("Computer is deploying ships");
        Boolean vilidflag=false;
        int time=5;
        do{
            System.out.println(6-time+". ship deployed");
            do{
                coord place=randcoord();
                if (shown[place.x-1][place.y-1] !="@" && shown[place.x-1][place.y-1] !="c") {
                    vilidflag = true;
                    shown[place.x-1][place.y-1] = "c";
                    time--;
                }
            } while(!vilidflag);
            vilidflag=false;
        } while (time>0);
    }

    public static coord randcoord() {
        Random rn=new Random();
        int x=rn.nextInt(4)+1;
        int y=rn.nextInt(4)+1;
        //System.out.println(x+","+y);
        return new coord(x,y);
    }

    public static void deploy(String[][] shown){

        Boolean vilidflag=false;
        int time=5;
        do{
            System.out.println("Enter your ship " + (6-time) +".");
            do{
                coord place=GetCoord();
                if ((place.x>0&&place.x<6&&place.y>0&&place.y<6) && shown[place.x-1][place.y-1] !="@") {
                        vilidflag = true;
                        shown[place.x-1][place.y-1] = "@";
                        time--;
                } else {
                    System.out.println("Re-input please");
                }
            } while(!vilidflag);
            vilidflag=false;
        } while (time>0);
    }

    public static class coord {
        int x;
        int y;
        coord(int a,int b){
            x=a;
            y=b;
        }
    }

    public static coord GetCoord() {
        Scanner input = new Scanner(System.in); //This line creates a Scanner for you to use
        System.out.print("Enter X coordinate: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate: ");
        int y = input.nextInt();
        return new coord(x,y);
    }

    public static void printmap(String[][] map){
        System.out.println("  12345  ");
        for (int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                if(j==0||j==8){
                    System.out.print(i+1);
                } else if(j==1||j==7){
                    System.out.print("|");
                } else{
                    if(map[i][j-2]==null) {
                        System.out.print(" ");
                    } else {
                        System.out.print(map[i][j-2]);
                    }
                }
            }
            System.out.println();
        }
        System.out.println("  12345  ");
    }
}
