package dev.stripedcat.MolarMassCalculator.calculator;

public class Token {
    private String token;

    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Token) {
            Token token = (Token) obj;
            return token.getToken().equals(this.token);
        } else {
            return false;
        }
    }
}
