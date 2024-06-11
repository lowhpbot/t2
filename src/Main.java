import java.util.Random;
import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0, m = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Введите количество строк (n): ");
                n = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите количество столбцов (m): ");
                m = Integer.parseInt(scanner.nextLine());
                if (n > 0 && m > 0) {
                    validInput = true;
                } else {
                    System.out.println("Размеры матрицы должны быть положительными числами. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целые числа.");
            }
        }


        int[][] matrix = new int[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(100); 
            }
        }

        System.out.println("Исходная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);

        System.out.println("Суммы элементов для каждой строки:");
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Строка " + (i + 1) + ": " + rowSum);
        }

        System.out.println("Суммы элементов для каждого столбца:");
        for (int j = 0; j < m; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Столбец " + (j + 1) + ": " + colSum);
        }

        scanner.close();
    }
}
