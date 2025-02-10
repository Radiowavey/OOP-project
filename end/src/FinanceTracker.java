import java.util.*;

public class FinanceTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить транзакцию");
            System.out.println("2. Показать все транзакции");
            System.out.println("3. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTransaction(scanner);
                    break;
                case 2:
                    TransactionManager.showTransactions();
                    break;
                case 3:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }
    private static void addTransaction(Scanner scanner) {
        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Категория (еда, транспорт, и т.д.): ");
        String category = scanner.nextLine();

        System.out.print("Тип (доход/расход): ");
        String type = scanner.nextLine();

        System.out.print("Источник (наличность/банк): ");
        String source = scanner.nextLine();

        String cardType = "-";
        if (source.equalsIgnoreCase("банк")) {
            System.out.print("Тип карты (дебетовая/кредитная): ");
            cardType = scanner.nextLine();
        }

        System.out.print("Дата (гггг-мм-дд): ");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(amount, category, type, source, cardType, date);
        TransactionManager.addTransaction(transaction);
    }
    
}

