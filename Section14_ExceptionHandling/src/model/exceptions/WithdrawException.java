package model.exceptions;

public class WithdrawException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public WithdrawException(String msg) {
        super(msg);
    }
}
