package transactionsData;

import java.util.ArrayList;

/**
 * Operacijų rinkinys
 */

public class Operations {

    private ArrayList<Transaction> operationsList;

    public Operations() {
        this.operationsList = new ArrayList<>();
    }

    /**
     *Metodas prideda pajamas
     * @param transaction pajamų operacija
     */
    public void addIncome(Transaction transaction) {
        operationsList.add(transaction);
    }

    public void addExpense(Transaction transaction) {
        transaction.setNegativeAmount(transaction.getAmount());
        operationsList.add(transaction);
    }
    public ArrayList<Transaction> getList() {
        return operationsList;
    }

    public double getBalanse(){
        if (operationsList.size() == 0)
            return 0;
        int sum = 0;
        for (Transaction transaction: operationsList) {
            sum += transaction.getAmount();
        }
        return sum;
    }
}
