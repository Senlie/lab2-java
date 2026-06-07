/**
 * Лабораторна робота №2
 * Тема: Масиви в мові програмування Java
 *
 * Номер залікової книжки: 5103
 *
 * Варіант:
 *   C5  = 5103 % 5  = 3 → Дія з матрицями: C = A ⊕ B (побітове XOR)
 *   C7  = 5103 % 7  = 5 → Тип елементів: char
 *   C11 = 5103 % 11 = 4 → Дія з C: сума найбільших елементів у парних рядках
 *                          та найменших елементів у непарних рядках
 */
public class Lab2 {

    public static void main(String[] args) {

        // --- Матриці A та B типу char ---
        char[][] A = {
            {5, 3, 8, 2},
            {1, 7, 4, 6},
            {9, 2, 5, 3},
            {4, 6, 1, 8}
        };

        char[][] B = {
            {3, 6, 2, 9},
            {5, 1, 8, 3},
            {7, 4, 6, 1},
            {2, 8, 3, 5}
        };

        int rows = A.length;
        int cols = A[0].length;

        // --- Результуюча матриця C = A ⊕ B ---
        char[][] C = new char[rows][cols];

        try {
            // Перевірка розмірів матриць
            if (B.length != rows || B[0].length != cols) {
                throw new IllegalArgumentException(
                    "Матриці A та B мають різні розміри!"
                );
            }

            // --- Дія 1: C = A ⊕ B (побітове XOR) ---
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    C[i][j] = (char) (A[i][j] ^ B[i][j]);
                }
            }

            // Вивід матриці C
            System.out.println("=== Лабораторна робота №2 ===");
            System.out.println("Матриця A:");
            printMatrix(A);

            System.out.println("Матриця B:");
            printMatrix(B);

            System.out.println("Матриця C = A ⊕ B (побітове XOR):");
            printMatrix(C);

            // --- Дія 2: сума найбільших у парних рядках + найменших у непарних ---
            // Нумерація рядків з 0: парні — 0, 2, 4... непарні — 1, 3, 5...
            long sum = 0;

            for (int i = 0; i < rows; i++) {
                char extreme = C[i][0];

                if (i % 2 == 0) {
                    // Парний рядок
                    for (int j = 1; j < cols; j++) {
                        if (C[i][j] > extreme) {
                            extreme = C[i][j];
                        }
                    }
                    System.out.println("Рядок " + i + " (парний)  → макс = " + (int) extreme);
                } else {
                    // Непарний рядок 
                    for (int j = 1; j < cols; j++) {
                        if (C[i][j] < extreme) {
                            extreme = C[i][j];
                        }
                    }
                    System.out.println("Рядок " + i + " (непарний) → мін = " + (int) extreme);
                }

                sum += extreme;
            }

            System.out.println("-----------------------------");
            System.out.println("Результат суми: " + sum);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка вхідних даних: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Помилка індексу масиву: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непередбачена помилка: " + e.getMessage());
        }
    }

    // --- Допоміжний метод для виводу матриці ---
    static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char val : row) {
                System.out.printf("%4d", (int) val);
            }
            System.out.println();
        }
        System.out.println();
    }
}
