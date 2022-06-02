package bowling.exception;

public class InvalidDeliveryScoreException extends RuntimeException {
    public InvalidDeliveryScoreException(String message) {
        super(message);
    }
}