import file.Dialog;
import file.Storage;
import transactionsData.Operations;
import transactionsData.Transaction;


/**
 * Programos eiga, vartotojo passirinkimų medis
 */

public class Program {
     private Operations  operations = new Operations();
     private Dialog dialog = new Dialog();
     private Storage storage = new Storage();


    public void start(){
        operations = storage.load();
        while(true) {
            doShowMenu();
            String item = dialog.input("Iveskite meniu norimą punktą: ");
            switch (item) {
                case "1": //Pajamų registravimas
                    doAddIncome();
                    break;
                case "2": //Išlaidų registravimas
                    doAddExpense();
                    break;
                case "3": //Visų tranzakcijų išvedimas
                    doShowOperations();
                    break;
                case "4": //Balanso skaičiavimas
                    doShowBalance();
                    break;
                case "0": //Failo šsaugojimas ir išėjimas
                    if (doExit()) return;
                    break;
                default: dialog.println("Iveskite skaicių nuo 0 iki 4");
            }
        }

    }

    private void doShowMenu() {
        dialog.println("--<<Sąskaita>>--");
        dialog.println("1 - Pajamų registravimas");
        dialog.println("2 - Išlaidų registravimas");
        dialog.println("3 - Visų tranzakcijų išvedimas");
        dialog.println("4 - Balanso skaičiavimas");
        dialog.println("0 - baigti darba");
        dialog.println("Pasirinkite norima meniu punkta");
    }

    private void doAddIncome() {
        int amt = Integer.parseInt(dialog.input("Iveskite sumą: "));
        String transactionName = dialog.input("Iveskite įplaukų pavadinimą: ");

        Transaction transaction = new Transaction(transactionName, amt);
        operations.addIncome(transaction);
    }

    private void doAddExpense() {
        int amt = Integer.parseInt(dialog.input("Iveskite sumą: "));
        String transactionName = dialog.input("Iveskite išlaidų pavadinimą: ");
        Transaction transaction = new Transaction(transactionName, amt);
        operations.addExpense(transaction);
    }

    private void doShowOperations() {
        if (operations.getList().size() == 0){
            dialog.println("sarasas tuscias");
            return;
        }
        for (Transaction transaction: operations.getList())
            dialog.println(transaction+"");
    }

    private void doShowBalance() {
        dialog.println("Sąskaitos balansas: "+operations.getBalanse());

    }

    private boolean doExit() {
        Storage.save(operations);
        dialog.println("Sąskaitos išrašas saugojamas");
        return true;
    }
}
