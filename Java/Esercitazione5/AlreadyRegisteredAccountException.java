package Esercitazione5;

public class AlreadyRegisteredAccountException extends IllegalArgumentException{
    public AlreadyRegisteredAccountException(){}

    public AlreadyRegisteredAccountException(String s){
        super(s);
    }
}
