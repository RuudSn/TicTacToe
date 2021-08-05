package novi.basics;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welkom bij boter, kaas en eieren.");
        System.out.println();


        Field[] board = new Field[9];
        for (int i = 0; i < 9; i++) {
            board[i] = new Field(Integer.toString(i + 1));
        }
        printBoard(board);
        System.out.println();

        Player playerA = new Player("Kruisje", "X");
        Player playerB = new Player("Nulletje", "O");

        Game game = new Game(playerA, playerB);


        boolean hasWon = false;

        while (!hasWon) {

            Scanner userInput = new Scanner(System.in);
            System.out.println("\nGeef nummer van vak waar je een " + game.getCurrentPlayer().getName() + " wilt zetten");
            int selectedField = userInput.nextInt() - 1;

            String currentPlayerToken = game.getCurrentPlayer().getToken();
            board[selectedField].setToken(currentPlayerToken);


            printBoard(board);
            hasWon = game.hasPlayerWon(board);

            if (hasWon) {
                game.getCurrentPlayer().setScore(1);
                System.out.println();
                System.out.println(game.getCurrentPlayer().getName() + ", je hebt gewonnen");
            }
            game.switchPlayer();
        }

        System.out.println("Speler " + playerA.getName() + " heeft " + playerA.getScore() + " punten.");
        System.out.println("Speler " + playerB.getName() + " heeft " + playerB.getScore() + " punten.");


    }

    public static void printBoard(Field[] board) {
        for (int i = 0; i < board.length; i++) {
            boolean isEndOfRow = (i + 1) % 3 == 0;
            if (!isEndOfRow) {
                System.out.print(board[i].getToken() + " | ");
            } else {
                System.out.print(board[i].getToken());
                if (i < 8) {
                    System.out.println("\n__________");
                }
            }
        }
    }


}