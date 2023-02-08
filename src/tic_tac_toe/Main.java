package tic_tac_toe;

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

        displayBoard();
        playerMove();
        checkFreeSpace();


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
        int players_move;
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose Board Location From 1 to 9");
            players_move = sc.nextInt();
            if (board[players_move] == ' ') {
                break;
            }
        }
        System.out.println("Player Move = "+"INDEX = "+players_move);
        board[players_move]=player_input;

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
            System.out.println("No more Space Available");
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



}