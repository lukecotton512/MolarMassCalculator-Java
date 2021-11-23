package dev.stripedcat.MolarMassCalculator.calculator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FormulaParser {
    public List<Token> lexFormula(String formula) {
        List<Token> tokenList = new ArrayList<>();

        String token = "";
        for (char character: formula.toCharArray()) {
            // Handle us hitting another token.
            if (Character.isUpperCase(character)) {
                if (!token.isEmpty()) {
                    tokenList.add(new Token(token));
                }

                token = "" + character;
            } else if (Character.isLowerCase(character)) {
                if (!token.isEmpty() && token.matches("^[0-9]*?$")) {
                    tokenList.add(new Token(token));
                    token = "";
                }

                // Handle a lowercase character.
                token += character;
            } else if (Character.isDigit(character)) {
                if (!token.isEmpty() && !token.matches("^[0-9]*?$")) {
                    tokenList.add(new Token(token));
                }

                token = "" + character;
            } else if (character == '(' || character == ')' ||
                        character == '[' || character == ']') {
                if (!token.isEmpty()) {
                    tokenList.add(new Token(token));
                    token = "";
                }

                tokenList.add(new Token("" + character));
            }
        }

        // Add any last remaining tokens to the list.
        if (!token.isEmpty()) {
            if (!token.isEmpty()) {
                tokenList.add(new Token(token));
            }
        }

        return tokenList;
    }
}
