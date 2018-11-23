package transactionsData;

/**
 * Transakcijos kortele
 */

public class Transaction {
    private int amount;
    private String transactionName;

    public Transaction(String transactionName, int amount) {
        this.transactionName = transactionName;
        this.amount = amount;
    }

    /**
     * Metodas gąžina veinos transakcijos amount
     * @return
     */
    public int getAmount() {
        return amount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    @Override
    public String toString() {
        return amount + " eur, transakcijos pavadinimas: "+transactionName;
    }

    void setNegativeAmount(int amount) {
        this.amount = amount*-1;
    }
}
