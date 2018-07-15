package fr.bankata.domaine.operations;

import fr.bankata.domaine.Deposit;
import fr.bankata.domaine.Withdraw;

import java.util.function.Consumer;
import java.util.function.DoubleSupplier;

/**
 * Created by amine on 08/07/18.
 */
public interface AccountOperations {

     Consumer<Deposit> deposeAdapter();

     Consumer<Withdraw> withdrawAdapter();

     DoubleSupplier balanceComputingAdapter(Integer accountId);

}
