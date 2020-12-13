package lbaes.calculator;


import java.util.Locale;

public class Calculation {
    private double result;
    private Operator operator;
    private double operandA;
    private double operandB;

    private static double calculateResult(Double A, Operator operator, Double B) {
        double result = 0;
        switch (operator) {
            case ADD:
                result = A + B;
                break;
            case SUB:
                result = A - B;
                break;
            case MUL:
                result = A * B;
                break;
            case DIV:
                result = A / B;
                break;
        }
        return result;
    }

    public Calculation(double A, Operator operator, double B) {
        operandA = A;
        operandB = B;
        this.operator = operator;
        result = calculateResult(A, operator, B);
    }

    public Calculation(double A, String operator, double B) {
        operandA = A;
        operandB = B;
        switch (operator.toLowerCase(Locale.ROOT)){
            case "add":
                this.operator = Operator.ADD;
                break;
            case "sub":
                this.operator = Operator.SUB;
                break;
            case "mul":
                this.operator = Operator.MUL;
                break;
            case "div":
                this.operator = Operator.DIV;
                break;
            default:
                this.operator = Operator.ERR;
        }
        result = calculateResult(A, this.operator, B);
    }


    public Operator getOperator() {
        return operator;
    }

    public double getOperandA() {
        return operandA;
    }

    public double getOperandB() {
        return operandB;
    }

    public double getResult() {
        return result;
    }
}
