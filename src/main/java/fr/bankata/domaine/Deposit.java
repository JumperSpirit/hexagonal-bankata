package fr.bankata.domaine;

import java.math.BigDecimal;

/**
 * Created by amine on 07/07/18.
 */
public class Deposit implements Transaction {

    private final BigDecimal amount;
    private final Integer accountId;

    public Deposit(Integer accountId,BigDecimal amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    public Integer getAccountId() {
        return accountId;
    }

    @Override
    public BigDecimal getAmount(){
        return amount;
    }
}
