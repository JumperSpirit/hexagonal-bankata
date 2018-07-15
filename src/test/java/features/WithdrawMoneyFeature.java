package features;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.bankata.domaine.Account;
import fr.bankata.infrastricture.adappters.inmemory.InmemoryAccountOperationsAdapter;
import org.junit.Assert;

import java.math.BigDecimal;


public class WithdrawMoneyFeature {

    InmemoryAccountOperationsAdapter adapter = new InmemoryAccountOperationsAdapter();

    Account account = Account.builder
            .withAdapter(adapter)
            .withId(2)
            .build();

    @Given("^an existing client with \"([^\"]*)\" EUR in his account$")
    public void initAccountWith(BigDecimal amount) throws Throwable {
        account.depose(amount);
    }

    @When("^he withdraws \"([^\"]*)\" EUR form his account$")
    public void withdrawMoney(BigDecimal amount) throws Throwable {
        account.withdraw(amount);
    }

    @Then("^his new balance after withdraws is \"([^\"]*)\" EUR$")
    public void verifyRunningBalance(BigDecimal amount) throws Throwable {
        Assert.assertTrue(amount.doubleValue() == account.getBalance().doubleValue());
    }
}
