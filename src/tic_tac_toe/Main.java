package tic_tac_toe;

import java.util.Scanner;

public class Main {

    static char[] board =new char[10];
    static char player_input;
    static char computer_input;

    public static void main(String[] args) {

        System.out.println("Welcome To The Tic Tac Toe Game");
        System.out.println("-------------------------------");

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

}