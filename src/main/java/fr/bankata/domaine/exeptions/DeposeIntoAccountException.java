package fr.bankata.domaine.exeptions;

/**
 * Created by amine on 07/07/18.
 */
public class DeposeIntoAccountException extends RuntimeException {
    public DeposeIntoAccountException(String message){
        super(message);
    }
}
