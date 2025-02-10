import java.io.*;

public class TransactionManager {
    private static final String FILE_NAME = "transactions.csv";

    public static void addTransaction(Transaction transaction) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(transaction);
            System.out.println("Транзакция добавлена!\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void showTransactions() {
        double totalIncome = 0;
        double totalExpense = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line= br.readLine();

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split(",");
                double amount = Double.parseDouble(parts[0]);
                String type = parts[2];

                if (type.equalsIgnoreCase("доход")) {
                    totalIncome += amount;
                } else if (type.equalsIgnoreCase("расход")) {
                    totalExpense += amount;
                }
            }
            System.out.println("\nОбщий доход: " + totalIncome);
            System.out.println("Общий расход: " + totalExpense);
            System.out.println("Итоговый баланс: " + (totalIncome - totalExpense) + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}


