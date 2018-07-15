package features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.bankata.domaine.Account;
import fr.bankata.infrastricture.adappters.inmemory.InmemoryAccountOperationsAdapter;
import org.junit.Assert;

import java.math.BigDecimal;

public class DepositMoneyFeature {

    InmemoryAccountOperationsAdapter adapter = new InmemoryAccountOperationsAdapter();

    Account account = Account.builder
            .withAdapter(adapter)
            .withId(1)
            .build();

    @Given("^a client with \"([^\"]*)\" EUR in his account$")
    public void initialiseAccount(BigDecimal amount) throws Throwable {
        account.depose(amount);
    }

    @When("^he deposits \"([^\"]*)\" EUR into his account$")
    public void depositMoneyIntoAccount(BigDecimal amount) throws Throwable {
        account.depose(amount);
    }

    @Then("^his new balance is \"([^\"]*)\" EUR$")
    public void verifyRunningBalance(BigDecimal amount) throws Throwable {
        Assert.assertTrue(amount.doubleValue() == account.getBalance().doubleValue());
    }


}
