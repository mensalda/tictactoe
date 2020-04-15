
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] ticTacToe = new char[3][3];
        int count = 1;
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < ticTacToe.length; i++) {
                for (int j = 0; j < ticTacToe[0].length; j++) {
                    ticTacToe[i][j] = ' ';
                }
            }
            boolean noWinGame = true;
            while (noWinGame) {
                System.out.println("---------");
                for (int i = 0; i < ticTacToe.length; i++) {
                        System.out.printf("| %c %c %c |\n", ticTacToe[i][0], ticTacToe[i][1], ticTacToe[i][2]);
                }
                System.out.println("---------");
                noWinGame = gamestate(ticTacToe);
                while (noWinGame) {
                    System.out.print("Enter the coordinates: ");
                    int n1 = 0;
                    int n2 = 0;
                    String[] n = scanner.nextLine().split(" ");
                    try {
                        n1 = Integer.parseInt(n[0]);
                        n2 = Integer.parseInt(n[1]);
                    } catch (Exception e) {
                        System.out.println("You should enter numbers!");
                        continue;
                    }
                    if (n1 > 3 || n1 < 1 || n2 > 3 || n2 < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        continue;
                    }
                    if (ticTacToe[3 - n2][n1 - 1] == ' ') {
                        if (count % 2 != 0)
                            ticTacToe[3 - n2][n1 - 1] = 'X';
                        else
                            ticTacToe[3 - n2][n1 - 1] = 'O';
                        count++;
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                }
            }
        }
    }

    private static boolean gamestate(char[][] ticTacToe) {
        int countWins = 0;
        char charWins = ' ';
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToe[i][j] == ' ')
                    count++;
            }
        }
        if (ticTacToe[1][1] == ticTacToe[0][0] && ticTacToe[1][1] == ticTacToe[2][2]) {
            if (ticTacToe[1][1] != ' ') {
                charWins = ticTacToe[1][1];
                countWins++;
            }
        }
        if (ticTacToe[1][1] == ticTacToe[2][0] && ticTacToe[1][1] == ticTacToe[0][2]) {
            if (ticTacToe[1][1] != ' ') {
                charWins = ticTacToe[1][1];
                countWins++;
            }
        }
        if (ticTacToe[1][1] == ticTacToe[0][1] && ticTacToe[1][1] == ticTacToe[2][1]) {
            if (ticTacToe[1][1] != ' ') {
                charWins = ticTacToe[1][1];
                countWins++;
            }
        }
        if (ticTacToe[1][1] == ticTacToe[1][0] && ticTacToe[1][1] == ticTacToe[1][2]) {
            if (ticTacToe[1][1] != ' ') {
                charWins = ticTacToe[1][1];
                countWins++;
            }
        }
        if (ticTacToe[0][0] == ticTacToe[1][0] && ticTacToe[1][0] == ticTacToe[2][0]) {
            if (ticTacToe[0][0] != ' ') {
                charWins = ticTacToe[0][0];
                countWins++;
            }
        }
        if (ticTacToe[2][0] == ticTacToe[2][1] && ticTacToe[2][1] == ticTacToe[2][2]) {
            if (ticTacToe[2][0] != ' ') {
                charWins = ticTacToe[2][0];
                countWins++;
            }
        }
        if (ticTacToe[2][2] == ticTacToe[1][2] && ticTacToe[1][2] == ticTacToe[0][2]) {
            if (ticTacToe[2][2] != ' ') {
                charWins = ticTacToe[2][2];
                countWins++;
            }
        }
        if (ticTacToe[0][2] == ticTacToe[0][1] && ticTacToe[0][1] == ticTacToe[0][0]) {
            if (ticTacToe[0][2] != ' ') {
                charWins = ticTacToe[0][2];
                countWins++;
            }
        }
        if (countWins == 1) {
            System.out.println(charWins + " wins");
            return false;
        }
        if (count == 0) {
            System.out.println("Draw");
            return false;
        }
        return true;
    }
}
