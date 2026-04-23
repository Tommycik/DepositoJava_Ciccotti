class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    //Overload 
    public int add(int a, int b, int c) {
        return a + b +c;
    }
}
public class EsempioOverride {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.add(1, 2, 3));
        Calculator calc2 = new AdvancedCalculator();
        calc2.add(1, 2);
        calc2.add(1, 2, 3);
    }
}

class AdvancedCalculator extends Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("a + b = " + (a + b));
        return a + b;
    }
    @Override
    public int add(int a, int b, int c) {
        System.out.println("a + b + c = " + (a + b + c));
        return a + b + c;
    }
}