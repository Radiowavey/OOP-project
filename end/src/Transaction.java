public class Transaction {
    double amount;
    String category;
    String type;
    String source;
    String cardType;
    String date;

    public Transaction(double amount, String category, String type, String source, String cardType, String date) {
        this.amount = amount;
        this.category = category;
        this.type = type;
        this.source = source;
        this.cardType = cardType;
        this.date = date;
    }

    public String toString() {
        return amount + "," + category + "," + type + "," + source + "," + cardType + "," + date;
    }
}
