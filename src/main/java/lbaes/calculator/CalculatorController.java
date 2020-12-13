package lbaes.calculator;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController implements ErrorController {

    @GetMapping("/calculator")
    public Calculation calculationRequest(@RequestParam(value="A") Double A,@RequestParam(value = "op") String operator ,@RequestParam(value = "B") Double B) {
        Calculation calculation = new Calculation(A, operator, B);
        System.out.println(String.format("%f %s %f = %f", calculation.getOperandA(), calculation.getOperator().toString(),calculation.getOperandB(), calculation.getResult()));
        return calculation;
    }

    @GetMapping("/error")
    public Calculation error() {
        return new Calculation(0.0, Operator.ERR, 0.0);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
