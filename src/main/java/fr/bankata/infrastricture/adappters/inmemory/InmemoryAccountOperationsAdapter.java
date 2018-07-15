package fr.bankata.infrastricture.adappters.inmemory;

import fr.bankata.domaine.Deposit;
import fr.bankata.domaine.Transaction;
import fr.bankata.domaine.Withdraw;
import fr.bankata.domaine.operations.AccountOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;

/**
 * Created by amine on 07/07/18.
 */
public class InmemoryAccountOperationsAdapter implements AccountOperations {

    public static List<Transaction> DB = new ArrayList<>();

    public Consumer<Deposit> deposeAdapter(){
        return deposit -> DB.add(deposit);
    }

    public Consumer<Withdraw> withdrawAdapter(){
        return withdraw -> DB.add(withdraw);
    }

    public DoubleSupplier balanceComputingAdapter(Integer accountId){
        return () -> DB.stream()
                .filter(transaction1 -> transaction1.getAccountId().intValue() == accountId.intValue())
                .map(transaction -> transaction.getAmount())
                .reduce((am1,am2) -> am1.add(am2))
                .get()
                .doubleValue();
    }

}
