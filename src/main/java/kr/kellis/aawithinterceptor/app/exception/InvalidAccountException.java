package kr.kellis.aawithinterceptor.app.exception;

public class InvalidAccountException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidAccountException() {
        super();
    }

    public InvalidAccountException(String message) {
        super(message);
    }
}
