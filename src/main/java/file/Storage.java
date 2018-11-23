package file;

import transactionsData.Operations;
import transactionsData.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Darbas su failu
 */

public class Storage {
    private static final String FILENAME = "money.txt";


    /**
     * Failo saugojimas
     * @param operations perduodamas sarašas operacijų
     */
    public static void save(Operations operations) {
        try{
            FileWriter writer = new FileWriter(FILENAME);
            for (Transaction transaction: operations.getList())
                writer.write(transaction.getTransactionName()+ "\n"+ transaction.getAmount()+ "\n");
            writer.close();
        } catch (IOException e){
        }
    }

    public Operations load() {
        Operations operations = new Operations();
        try (
             FileReader fileReader = new FileReader(FILENAME);
             BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String name;
            while (null != (name = reader.readLine())) {
                int amt = Integer.parseInt(reader.readLine());
                Transaction transaction = new Transaction(name, amt);
                operations.addIncome(transaction);
            }
            return operations;
        } catch (IOException e) {
            return operations;
        }
    }

}
