package pro.sky.hw_2_3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw_2_3.service.CalculatorServuce;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

private CalculatorServuce calculatorServuce;

    public CalculatorController(CalculatorServuce calculatorServuce) {
        this.calculatorServuce = calculatorServuce;
    }

    @GetMapping
    public String greetings() {
        return calculatorServuce.greetings();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "numb1", required = false) Float a,
                       @RequestParam(value = "numb2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не правельно переданны параметры";
        }
        return buildString(a, b, calculatorServuce.plus(a, b), "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "numb1", required = false) Float a,
                       @RequestParam(value = "numb2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не правельно переданны параметры";
        }
        return buildString(a, b, calculatorServuce.minus(a, b), "-");
    }

    @GetMapping("/multiply")
        public String multiply(@RequestParam(value = "numb1", required = false) Float a,
                               @RequestParam(value = "numb2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не правельно переданны параметры";
        }
        return buildString(a, b, calculatorServuce.multioly(a, b), "*");
    }
    @GetMapping("/divide")
    public String divide(@RequestParam (value = "numb1", required = false) Float a,
                         @RequestParam (value = "numb2", required = false) Float b){
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не правельно переданны параметры";
        }

        if (b == 0) {
            return "На ноль делить нельзя!";
        }

        return buildString(a, b, calculatorServuce.divide(a, b), "/");
    }
    private String buildString(float a,
                               float b,
                               float result,
                               String operation) {
        return String.format("%.f1 %s %.f1 = %.f1", a, operation, b, result);

    }
}
