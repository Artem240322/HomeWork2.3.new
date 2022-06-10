package pro.sky.hw_2_3.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServuce {

    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    public float plus(float a, float b) {
        return a + b;

    }
    public float minus(float a, float b) {
        return a - b;

    }
    public float multioly(float a, float b) {
        return a * b;

    }
    public float divide(float a, float b) {
        return a / b;

    }


}
