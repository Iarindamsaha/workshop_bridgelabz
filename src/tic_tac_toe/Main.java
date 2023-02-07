package tic_tac_toe;

public class Main {

    static char[] board =new char[10];

    public static void main(String[] args) {

        System.out.println("Welcome To The Tic Tac Toe Game");
        System.out.println("-------------------------------");

    }
    public static void board(){
        for (int i =1; i<=9; i++){
            board[i]=' ';
        }
    }
}