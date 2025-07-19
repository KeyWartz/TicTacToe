import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[4][4];

        //Initialising the board
        board[0][0]=" ";
        board[0][1]="1";
        board[0][2]="2";
        board[0][3]="3:X";

        board[1][0]="1";
        board[1][1]=" ";
        board[1][2]=" ";
        board[1][3]=" ";

        board[2][0]="2";
        board[2][1]=" ";
        board[2][2]=" ";
        board[2][3]=" ";

        board[3][0]="3";
        board[3][1]=" ";
        board[3][2]=" ";
        board[3][3]=" ";
        //

        PrintBoard(board);

        String b=new String(" ");
        //Conduct the game
        for(int i=1; i<=9; i++){
            if(i%2==1){
                int y; int x;
                boolean isBlank=false;
                boolean c=false; //to check for range of x,y
                do{
                    System.out.println("Player 1");
                    System.out.print("Enter X:");
                    x=sc.nextInt();
                    if(x<=0||x>=4)c=true;
                    else c=false;
                    System.out.print("Enter Y:");
                    y=sc.nextInt();
                    if(y<=0||y>=4)c=true;
                    else c=false;
                    if(!c){
                        isBlank=board[y][x].equals(b);
                        if(isBlank){
                            board[y][x]="x";
                        }
                        else{
                            System.out.println("Cannot overwrite in already occupied square");
                        }
                    }
                    else {
                        System.out.println("Hey smartass, the  X or Y values you entered are invalid.");
                    }
                }while(!isBlank || c);

            }
            else{
                int y; int x;
                boolean isBlank=false;
                boolean c=false; //to check for range of x,y
                do{
                    System.out.println("Player 2");
                    System.out.print("Enter X:");
                    x=sc.nextInt();
                    if(x<=0||x>=4)c=true;
                    else c=false;
                    System.out.print("Enter Y:");
                    y=sc.nextInt();
                    if(y<=0||y>=4)c=true;
                    else c=false;
                    if(!c){
                        isBlank=board[y][x].equals(b);
                        if(isBlank){
                            board[y][x]="o";
                        }
                        else{
                            System.out.println("Cannot overwrite in already occupied square");
                        }
                    }
                    else {
                        System.out.println("Hey smartass, the X or Y values you entered are invalid.");
                    }
                }while(!isBlank || c);
            }
            PrintBoard(board);
            CheckForWin(i%2, board);
        }
    }
    public static void PrintBoard(String[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void CheckForWin(int player, String[][] board){
        String s;
        boolean win=false;
        if(player==1)s="x";
        else s="o";
        //Case 1:Horizontally
        if(board[1][1]==s&&board[1][2]==s&&board[1][3]==s)win=true;
        if(board[2][1]==s&&board[2][2]==s&&board[2][3]==s)win=true;
        if(board[3][1]==s&&board[3][2]==s&&board[3][3]==s)win=true;
        //Case 2:Vertically
        if(board[1][1]==s&&board[2][1]==s&&board[3][1]==s)win=true;
        if(board[2][1]==s&&board[2][2]==s&&board[2][3]==s)win=true;
        if(board[3][1]==s&&board[3][2]==s&&board[3][3]==s)win=true;
        //Case 3:Diagonally
        if(board[1][1]==s&&board[2][2]==s&&board[3][3]==s)win=true;
        if(board[3][3]==s&&board[2][2]==s&&board[1][1]==s)win=true;

        //Player 1 wins
        if(s=="x"&&win){
            System.out.println("Player 1 wins!");
            StopGame();
        }
        //Player 2 wins
        if(s=="o"&&win){
            System.out.println("Player 2 wins!");
            StopGame();
        }
    }

    public static void StopGame(){
        System.exit(0);
    }
}
