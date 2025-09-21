package br.com.anisioaleixo.api_rest.math;

public class SimpleMath {
    //Sum
    public Double sum(Double numberOne, Double numberTwo) {
        return  numberOne + numberTwo;
    }

    //Subtraction
    public Double subtraction(Double numberOne, Double numberTwo) {
        return  numberOne - numberTwo;
    }

    //Multiplication
    public Double multiplication(Double numberOne, Double numberTwo) {
        return  numberOne * numberTwo;
    }

    //Division
    public Double division(Double numberOne, Double numberTwo) {
        return  numberOne / numberTwo;
    }

    //Mean
    public Double mean(Double numberOne, Double numberTwo) {
        return  (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double number) {
        return  Math.sqrt(number);
    }
}
