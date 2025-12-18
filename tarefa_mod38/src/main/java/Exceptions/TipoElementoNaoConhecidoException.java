package Exceptions;

public class TipoElementoNaoConhecidoException extends RuntimeException {
    public TipoElementoNaoConhecidoException(String message) {
        super(message);
    }
}
