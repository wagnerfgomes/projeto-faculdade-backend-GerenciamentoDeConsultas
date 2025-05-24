package br.com.projeto.apigerenciamentodeestoque.exception;

public class ApiException extends RuntimeException{
    private ErrorDetails errorDetails;

    public ApiException(ErrorDetails errorDetails) {
        super(errorDetails.getMessage());
        this.errorDetails = errorDetails;
    }

    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public int getStatusCode() {
        return errorDetails.getStatusCode();
    }

    public String getErrCode() {
        return errorDetails.getErrCode();
    }

    public String getMessage(){
        return errorDetails.getMessage();
    }
}
