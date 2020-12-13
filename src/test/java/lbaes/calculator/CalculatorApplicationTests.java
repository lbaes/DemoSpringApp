package lbaes.calculator;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.math.BigDecimal;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorApplicationTests {
	private double A, B, result;
	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}


	@Test
	void addingTwoNumbersShouldCorrectlyAddTwoNumbers() {

		A = 50.0;
		B = 100.0;
		result = A + B;

		given().standaloneSetup(new CalculatorController()).
				param("A", 50.0 ).param("B", 100.0).param( "op", "add").when().get("http://localhost:" + port + "/calculator").then()
				.statusCode(200)
				.body("result",
						Matchers.is((float) result),
						"operator",
						equalTo("ADD"),
						"operandA",
						Matchers.is((float) A),
						"operandB",
						Matchers.is((float)B)
				);

	}

	@Test
	void subtractingTwoNumbersShouldCorrectlySubtractTwoNumbers() {

		A = 50.0;
		B = 100.0;
		result = A - B;

		given().standaloneSetup(new CalculatorController()).
				param("A", 50.0 ).param("B", 100.0).param( "op", "sub").when().get("http://localhost:" + port + "/calculator").then()
				.statusCode(200)
				.body("result",
						Matchers.is((float) result),
						"operator",
						equalTo("SUB"),
						"operandA",
						Matchers.is((float) A),
						"operandB",
						Matchers.is((float)B)
				);

	}

	@Test
	void multiplyingTwoNumbersShouldCorrectlyMultiplyTwoNumbers() {

		A = 50.0;
		B = 100.0;
		result = A * B;

		given().standaloneSetup(new CalculatorController()).
				param("A", 50.0 ).param("B", 100.0).param( "op", "MUL").when().get("http://localhost:" + port + "/calculator").then()
				.statusCode(200)
				.body("result",
						Matchers.is((float) result),
						"operator",
						equalTo("MUL"),
						"operandA",
						Matchers.is((float) A),
						"operandB",
						Matchers.is((float)B)
				);

	}


	@Test
	void dividingTwoNumbersShouldCorrectlyDivideTwoNumbers() {

		A = 50.0;
		B = 100.0;
		result = A / B;

		given().standaloneSetup(new CalculatorController()).
				param("A", 50.0 ).param("B", 100.0).param( "op", "DIV").when().get("http://localhost:" + port + "/calculator").then()
				.statusCode(200)
				.body("result",
						Matchers.is((float) result),
						"operator",
						equalTo("DIV"),
						"operandA",
						Matchers.is((float) A),
						"operandB",
						Matchers.is((float)B)
				);

	}

}
