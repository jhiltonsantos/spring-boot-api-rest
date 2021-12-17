package br.com.hilton.config.validate;

public class ErrorFormDto {
    public String field;
    private String error;

    public ErrorFormDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }


}
