package fr.bankata.domaine.exeptions;

/**
 * Created by amine on 07/07/18.
 */
public class WithDrawFromAccountException extends RuntimeException {
    public WithDrawFromAccountException(String message){
        super(message);
    }
}
