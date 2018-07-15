package fr.bankata.domaine;


import fr.bankata.domaine.exeptions.BalanceComputationException;
import fr.bankata.domaine.exeptions.DeposeIntoAccountException;
import fr.bankata.domaine.exeptions.WithDrawFromAccountException;
import fr.bankata.domaine.operations.AccountOperations;

import java.math.BigDecimal;

/**
 * Created by amine on 07/07/18.
 */
public class Account {

    public static AccountBuilder builder = new AccountBuilder();

    private AccountOperations accountOperations;
    private final Integer accountId;

    public Account(Integer accountId,AccountOperations accountOperations) {
        this.accountId=accountId;
        this.accountOperations = accountOperations;
    }

    public Account depose(BigDecimal amount){
        try {
            Deposit deposit = new Deposit(accountId,amount);
            accountOperations.deposeAdapter()
                    .accept(deposit);
            }
        catch(Throwable technicalException){
            throw new DeposeIntoAccountException("You cant depose money now");
        }
        return this;
    }

    public Account withdraw(BigDecimal amount){
        try {
            Withdraw withdraw = new Withdraw(accountId,amount);
            withdrawPrecondition(withdraw);
            accountOperations.withdrawAdapter()
                    .accept(withdraw);
            }
        catch(Throwable technicalException){
            throw new WithDrawFromAccountException("You cant withdraw money now");
        }
        return this;
    }

    private void withdrawPrecondition(Withdraw withdraw) {
        if(getBalance().doubleValue() - withdraw.getAmount().doubleValue() == new Double(0).doubleValue()){
            throw new WithDrawFromAccountException("you are brock");
        }
    }

    public Double getBalance(){
        try {
            return accountOperations.balanceComputingAdapter(accountId)
                    .getAsDouble();
            }
        catch(Throwable technicalException){
                throw new BalanceComputationException("You cant see balance");
        }
    }

    public Integer getAccountId() {
        return accountId;
    }


}
