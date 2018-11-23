package transactionsData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void getAmount() {
        Transaction transaction = new Transaction("mokejimas", 60);
        assertEquals(transaction.getAmount(), 60);
    }

    @Test
    void getTransactionName() {
        Transaction transaction = new Transaction("mokejimas", 60);
        assertEquals(transaction.getTransactionName(), "mokejimas");
    }

    @Test
    void toStringTest() {
        Transaction transaction = new Transaction("mokejimas", 60);
        assertEquals(transaction.toString(),  "60 eur, transakcijos pavadinimas: mokejimas");

    }

    @Test
    void setNegativeAmount() {
        Transaction transaction = new Transaction("mokejimas", 0);
        transaction.setNegativeAmount(60);
        assertEquals(transaction.getAmount(), -60);
    }
}