package tic_tac_toe;

import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static char[] board =new char[10];
    static char player_input;
    static char computer_input;

    public static void main(String[] args) {

        System.out.println("Welcome To The Tic Tac Toe Game");
        System.out.println("-------------------------------");
        board();
        choose_letter();
        if(toss()==1){
            playerMove();
            displayBoard();
        }
        else{
            computer_turn();
            displayBoard();
        }

        while(true){
            playerMove();
            computer_turn();
            displayBoard();
            checkFreeSpace();
            check_winner();
            winnerWarning();
        }



    }
    public static void board(){
        for (int i =1; i<=9; i++){
            board[i]=' ';
        }
    }

    public static void choose_letter(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Choose a Letter Between X or O");
        player_input = sc.next().toUpperCase().charAt(0);
        computer_input= (player_input=='X')?'O':'X';
    }

    public static void displayBoard(){
        System.out.println(board[1]+"||"+board[2]+"||"+board[3]);
        System.out.println("-------");
        System.out.println(board[4]+"||"+board[5]+"||"+board[6]);
        System.out.println("-------");
        System.out.println(board[7]+"||"+board[8]+"||"+board[9]);
    }
    public static void playerMove(){
        int players_moves;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose Board Location From 1 to 9");
            players_moves = sc.nextInt();
            if(board[players_moves] == ' '){
                break;
            }

        }
        System.out.println("Player Move = "+players_moves);
        board[players_moves]=player_input;

    }

    public static void checkFreeSpace(){
        boolean space = false;
        int remaining_space = 0;

        for(int i = 1; i<=9; i++){
            if(board[i]==' '){
                space=true;
                remaining_space++;
            }
        }
        if (space==false){
            System.out.println("No more Space Available || The Game is a Draw");
            System.exit(0);
        }
        else{
            System.out.println("Spaces Are Available= "+remaining_space);
        }
    }

    public static int toss(){
        Random random = new Random();
        int check = random.nextInt(0,2);
        int value_return;
        if(check == 1){
            System.out.println("Player plays First");
            value_return=1;
        }
        else{
            System.out.println("Computer Plays First");
            value_return = 0;
        }
        return value_return;
    }

    public static void check_winner(){
        if ((board[1] == player_input && board[2] == player_input && board[3] == player_input ||
                board[1] == player_input && board[4] == player_input && board[7] == player_input ||
                board[1] == player_input && board[5] == player_input && board[9] == player_input ||
                board[3] == player_input && board[5] == player_input && board[7] == player_input ||
                board[2] == player_input && board[5] == player_input && board[8] == player_input ||
                board[3] == player_input && board[6] == player_input && board[9] == player_input ||
                board[4] == player_input && board[5] == player_input && board[6] == player_input ||
                board[7] == player_input && board[8] == player_input && board[9] == player_input
        )){
            System.out.println("Player Wins The Game");
            System.exit(0);
        } else if ((board[1] == computer_input && board[2] == computer_input && board[3] == computer_input ||
                board[1] == computer_input && board[4] == computer_input && board[7] == computer_input ||
                board[1] == computer_input && board[5] == computer_input && board[9] == computer_input ||
                board[3] == computer_input && board[5] == computer_input && board[7] == computer_input ||
                board[2] == computer_input && board[5] == computer_input && board[8] == computer_input ||
                board[3] == computer_input && board[6] == computer_input && board[9] == computer_input ||
                board[4] == computer_input && board[5] == computer_input && board[6] == computer_input ||
                board[7] == computer_input && board[8] == computer_input && board[9] == computer_input
        )) {
            System.out.println("Computer Won The Game");
            System.exit(0);
        }
    }

    public static void computer_turn(){
        int computerMove;
        Random random = new Random();
        while(true){
            computerMove= random.nextInt(9)+1;
            if (board[computerMove]==' '){
                break;
            }
        }
        System.out.println("Computer Move: "+computerMove);
        board[computerMove]=computer_input;
    }
     public static void winnerWarning(){
        if(     //first row check

                board[1] == computer_input && board[2] == computer_input && board[3] == ' ' ||
                board[1] == ' ' && board[2] == computer_input && board[3] == computer_input ||
                board[1] == computer_input && board[2] == ' ' && board[3] == computer_input ||

                //first column

                board[1] == computer_input && board[4] == computer_input && board[7] == ' ' ||
                board[1] == ' ' && board[4] == computer_input && board[7] == computer_input ||
                board[1] == computer_input && board[4] == ' ' && board[7] == computer_input ||

                //second column check

                board[2] == computer_input && board[5] == computer_input && board[8] == ' ' ||
                board[2] == ' ' && board[5] == computer_input && board[8] == computer_input ||
                board[2] == computer_input && board[5] == ' ' && board[8] == computer_input ||

                //third column check

                board[3] == computer_input && board[6] == computer_input && board[9] == ' ' ||
                board[3] == ' ' && board[6] == computer_input && board[9] == computer_input ||
                board[3] == computer_input && board[6] == ' ' && board[9] == computer_input ||

                //for second row

                board[4] == computer_input && board[5] == computer_input && board[6] == ' '||
                board[4] == ' ' && board[5] == computer_input && board[6] == computer_input ||
                board[4] == computer_input && board[5] == ' ' && board[6] == computer_input||

                //for third row

                board[7] == computer_input && board[8] == computer_input && board[9] == ' '||
                board[7] == ' ' && board[8] == computer_input && board[9] == computer_input ||
                board[7] == computer_input && board[8] == ' ' && board[9] == computer_input ||

                // for corners

                board[1] == computer_input && board[5] == computer_input && board[9] == ' ' ||
                board[1] == ' ' && board[5] == computer_input && board[9] == computer_input ||
                board[1] == computer_input && board[5] == ' ' && board[9] == computer_input ||

                board[3] == computer_input && board[5] == computer_input && board[7] == ' ' ||
                board[3] == ' ' && board[5] == computer_input && board[7] == computer_input ||
                board[3] == computer_input && board[5] == ' ' && board[7] == computer_input


        ){
            System.out.println("Computer Can Almost Win the Game Play Carefully");
        }
     }



}