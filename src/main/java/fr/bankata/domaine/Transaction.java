package fr.bankata.domaine;

import java.math.BigDecimal;

/**
 * Created by amine on 07/07/18.
 */
public interface Transaction {
    Integer getAccountId();
    BigDecimal getAmount();
}
