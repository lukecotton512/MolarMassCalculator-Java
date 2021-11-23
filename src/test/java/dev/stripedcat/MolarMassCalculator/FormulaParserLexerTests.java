package dev.stripedcat.MolarMassCalculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.stripedcat.MolarMassCalculator.calculator.FormulaParser;
import dev.stripedcat.MolarMassCalculator.calculator.Token;

@SpringBootTest
public class FormulaParserLexerTests {
    @Autowired
	private FormulaParser formulaParser;
    
    @Test
	void testLexer() {
		List<Token> tokens = formulaParser.lexFormula("H2O");
		assertArrayEquals(tokens.toArray(), new Object[] {new Token("H"), new Token("2"), new Token("O")});
	}

	@Test
	void testLexer2() {
		List<Token> tokens = formulaParser.lexFormula("Ca(OH)2");
		assertArrayEquals(tokens.toArray(), new Object[] {
			new Token("Ca"),
			new Token("("),
			new Token("O"),
			new Token("H"),
			new Token(")"),
			new Token("2")
		});
	}

	@Test
	void testLexer3() {
		List<Token> tokens = formulaParser.lexFormula("ca2edDe(2hO)");
		assertArrayEquals(tokens.toArray(), new Object[] {
			new Token("ca"),
			new Token("2"),
			new Token("ed"),
			new Token("De"),
			new Token("("),
			new Token("2"),
			new Token("h"),
			new Token("O"),
			new Token(")")
		});
	}
}
