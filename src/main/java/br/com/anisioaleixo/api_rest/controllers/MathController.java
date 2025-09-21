package br.com.anisioaleixo.api_rest.controllers;

import br.com.anisioaleixo.api_rest.excepition.UnsupportedMathOperationException;
import br.com.anisioaleixo.api_rest.math.SimpleMath;
import br.com.anisioaleixo.api_rest.request.converteres.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    //Sum
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return  math.sum(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    //Subtraction
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.subtraction(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.multiplication(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        Double divisor = NumberConverter.convertToDouble(numberTwo);
        if (divisor == 0) {
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        }
        return math.division(
                NumberConverter.convertToDouble(numberOne),
                divisor
        );
    }

    // Média
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.mean(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/square-root/{number}")
    public Double squareRoot(
            @PathVariable String number
    ) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        double value = NumberConverter.convertToDouble(number);
        if (value < 0) {
            throw new UnsupportedMathOperationException("Cannot calculate square root of negative number!");
        }
        return math.squareRoot(value);
    }
}
