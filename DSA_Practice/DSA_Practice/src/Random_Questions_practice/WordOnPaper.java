import java.util.Scanner;

public class WordOnPaper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer.

        while (cases > 0) {
            String ans = "";
            cases--;

            char grid[][] = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < 8; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Character.isAlphabetic(grid[i][j])) {
                        ans += String.valueOf(grid[i][j]);
                    }
                }
            }
            System.out.println(ans);
        }

        scanner.close();
    }
}
