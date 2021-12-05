package dev.stripedcat.MolarMassCalculator.calculator;

import org.springframework.stereotype.Component;

import dev.stripedcat.MolarMassCalculator.calculator.tree.Element;
import dev.stripedcat.MolarMassCalculator.calculator.tree.Formula;
import dev.stripedcat.MolarMassCalculator.calculator.tree.FormulaItem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Component
public class FormulaParser {
    // Parse a formula into a tree given a formula string.
    public Formula parseFormula(String formulaStr) {
        // First, run the lexer on the formula.
        List<Token> tokenList = this.lexFormula(formulaStr);

        // Now, parse it.
        Deque<FormulaItem> formulaStack = new LinkedList<>();
        formulaStack.push(new Formula());

        for (Token token: tokenList) {
            // Our token string.
            String tokenString = token.getToken();

            // See if this token is an element.
            if (tokenString.matches("^[A-Z][a-z]*?$")) {
                // Push the element to the stack.
                formulaStack.push(new Element(tokenString));
            } else if (tokenString.matches("^[0-9]*?$")) {
                // We have a number, so pop the top element, and give it the multiplier.
                FormulaItem poppedItem = formulaStack.peek();
                poppedItem.setMultiplier(Integer.parseInt(tokenString));
            } else if (tokenString.equals("(")) {
                // First, pop everything that isn't a formula, and give it to said formula.
                if (!formulaStack.isEmpty()) {
                    for (FormulaItem top = formulaStack.pop();
                         !formulaStack.isEmpty() && !(top instanceof Formula);
                         top = formulaStack.pop()) {
                        
                    }
                }
            }
        }

        FormulaItem finalItem = formulaStack.pop();

        if (finalItem instanceof Formula) {
            return (Formula) finalItem;
        } else {
            return null;
        }
    }

    // Given a formula string, run the lexer on it.
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
