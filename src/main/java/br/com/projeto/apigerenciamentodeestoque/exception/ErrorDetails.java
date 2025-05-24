package br.com.projeto.apigerenciamentodeestoque.exception;

public enum ErrorDetails {
    USER_NOT_FOUND("Usuário não existe", 404, "Err-01"),
    ACESS_DENIED("Acesso negado, usuário ou senha inválidos", 403, "Err-02"),
    USER_EXIST("Este usuário já existe!", 400, "Err-03"),
    EMPTY_FIELDS("Os Campos usuário ou senha está vazio", 400, "Err-03"),
    PASSWORD_ALREADY_USED("A nova senha não pode ser igual à anterior.", 400, "Err-04"),
    USER_NOT_ACTIVE("Usuário não está ativo.", 400, "Err-05");

    private final String message;
    private final int statusCode;
    private final String errCode;

    ErrorDetails(String message, int statusCode, String errCode) {
        this.errCode = errCode;
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getMessage(){
        return message;
    }
}
