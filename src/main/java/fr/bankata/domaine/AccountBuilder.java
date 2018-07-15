package fr.bankata.domaine;


import fr.bankata.domaine.operations.AccountOperations;

/**
 * Created by amine on 08/07/18.
 */
public class AccountBuilder {

    private AccountOperations accountOperations;
    private Integer accountId;

    public AccountBuilder withAdapter(AccountOperations adapter){
        this.accountOperations = adapter;
        return this;
    }

    public AccountBuilder withId(Integer accountId){
        this.accountId = accountId;
        return this;
    }

    public Account build(){
        return new Account(accountId,accountOperations);
    }
}
