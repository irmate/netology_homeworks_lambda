public class Main {
    /*
    Код не работает так как в лямбда-выражении divide аргумент "y" принимает значение 0, а деление на 0 запрещено в арифметике.
    1. Для решения проблемы можно выбросить Exception с описанием ошибки
    1.1 например в методе main с помощью блока try/catch:
    try {
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.divide.apply(a, b);
        calc.println.accept(c);
    } catch (ArithmeticException e) {
        System.out.println("Ошибка! Деление на 0");
    }

    1.2 в лямбда-выражении divide:
    BinaryOperator<Integer> divide = (x, y) -> {
        if (y==0) throw new ArithmeticException("Деление на 0");
        return x / y;
    };

    2. Можно доработать тело лямбда-выражения divide для исключания варианта появления у аргумента "y" значения 0:
    BinaryOperator<Integer> divide = (x, y) -> {
        if (y==0) {
            y++;
        }
        return x / y;
    };

    3. Можно написать лямбда-выражение аналогичное выражению abs которое будет отвечать за исключение принятие аргументом "y" значения 0.
    Имплементация данного примера в основном коде.
     */

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.divide.apply(a, calc.notNull.apply(b));
        calc.println.accept(c);
    }
}
