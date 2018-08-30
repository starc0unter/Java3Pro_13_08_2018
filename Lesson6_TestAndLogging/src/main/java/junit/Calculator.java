package junit;

public class Calculator {

    private NumberProvider provider;

    public Calculator(NumberProvider provider) {
        this.provider = provider;
    }

    public int sumFromProvider() {
        int a = provider.getNumber();
        int b = provider.getNumber();
        return add(a, b);
    }

    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int mul(int a, int b) {
        return a * b;
    }
    public int div(int a, int b) {
        return a / b;
    }
}