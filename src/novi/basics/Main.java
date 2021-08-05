package novi.basics;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("BOTER KAAS EN EIEREN");
        System.out.println();
//bord
        String[] board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = Integer.toString(i);
        }

//printbord
            printBoard(board);

        Player playerA = new Player("Kruisje","X");
        Player playerB = new Player("Nulletje","O");

        Player currentPlayer = playerA;


            boolean hasWon = false;
            while(!hasWon) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nGeef veldnummer waar je een " + currentPlayer.getName() + " wilt zetten");
            int selectedField = userInput.nextInt();

            board[selectedField] = currentPlayer.getToken();
//printbord
            printBoard(board);

            hasWon = hasPlayerWon(board);
            if(hasWon){
                System.out.println(currentPlayer.getName()+", je hebt gewonnen");
            }
//wissel v speler
            currentPlayer = switchPlayer(currentPlayer, playerA, playerB);
        }
        System.out.println();


    }
     public static void printBoard(String[] board ){
                for(int i = 0;i<board.length;i++) {

                    boolean isEndOfRow = (i + 1) % 3 == 0;

                    if(!isEndOfRow){
                        System.out.print(board[i]+" | "); }
                    else{
                        System.out.print(board[i]);
                        if(i<8){
                            System.out.println("\n_________");}
                    }
                }
            }
     public static Player switchPlayer(Player currentPlayer,Player playerA, Player playerB){
       if(currentPlayer.getToken() == "X"){
       return playerB;}
       else{
       return playerA;
         }



}
     public static boolean hasPlayerWon(String[] board){
     if(board[0]==board[1]&&board[1]==board[2]){
     return true; }
     if(board[3]==board[4]&&board[4]==board[5]){
     return true; }
     if(board[6]==board[7]&&board[7]==board[8]){
     return true; }
     if(board[0]==board[3]&&board[3]==board[6]){
     return true; }
     if(board[1]==board[4]&&board[4]==board[7]){
     return true; }
     if(board[2]==board[5]&&board[5]==board[8]){
     return true; }
     if(board[0]==board[4]&&board[4]==board[8]){
     return true; }
     if(board[2]==board[4]&&board[4]==board[6]){
     return true; }
     return false;
     }

     
}
