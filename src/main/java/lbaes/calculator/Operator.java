package lbaes.calculator;

public enum Operator {

    ADD("ADD"), SUB("SUB"), MUL("MUL"), DIV("DIV"), ERR("ERR");
    private String strName;

    private Operator(String strName) {
        this.strName = strName;
    }


}
