package vladimir.java_dz_13;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/fraction")
public class FractionController {

    @GetMapping("/reduce")
    public Map<String, Integer> reduce(@RequestParam int num, @RequestParam int den) {
        Fraction f = new Fraction(num, den);
        return Map.of("numerator", f.getNumerator(), "denominator", f.getDenominator());
    }

    @GetMapping("/add")
    public Map<String, Integer> add(@RequestParam int num1, @RequestParam int den1, @RequestParam int num2, @RequestParam int den2) {
        Fraction result = new Fraction(num1, den1).add(new Fraction(num2, den2));
        return Map.of("numerator", result.getNumerator(), "denominator", result.getDenominator());
    }

    @GetMapping("/subtract")
    public Map<String, Integer> subtract(@RequestParam int num1, @RequestParam int den1, @RequestParam int num2, @RequestParam int den2) {
        Fraction result = new Fraction(num1, den1).subtract(new Fraction(num2, den2));
        return Map.of("numerator", result.getNumerator(), "denominator", result.getDenominator());
    }

    @GetMapping("/multiply")
    public Map<String, Integer> multiply(@RequestParam int num1, @RequestParam int den1, @RequestParam int num2, @RequestParam int den2) {
        Fraction result = new Fraction(num1, den1).multiply(new Fraction(num2, den2));
        return Map.of("numerator", result.getNumerator(), "denominator", result.getDenominator());
    }

    @GetMapping("/divide")
    public Map<String, Integer> divide(@RequestParam int num1, @RequestParam int den1, @RequestParam int num2, @RequestParam int den2) {
        Fraction result = new Fraction(num1, den1).divide(new Fraction(num2, den2));
        return Map.of("numerator", result.getNumerator(), "denominator", result.getDenominator());
    }
}
