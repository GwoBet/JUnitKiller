package my.killer.junit.exceptions;

public class ArgumentParserException extends Exception {

    public ArgumentParserException(String message){
        super(message);
    }

    public ArgumentParserException(String message, Throwable throwable){
        super(message, throwable);
    }
}
