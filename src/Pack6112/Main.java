//Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
//Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
//С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
//Pair<Integer, String> pair = Pair.of(1, "hello");
//Integer i = pair.getFirst(); // 1
//String s = pair.getSecond(); // "hello"
//Pair<Integer, String> pair2 = Pair.of(1, "hello");
//boolean mustBeTrue = pair.equals(pair2); // true!
//boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

package Pack6112;
import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}

class Pair <T, U> {
        private final T a;
        private final U b;
        private Pair(T a, U b){
            this.a = a;
            this.b = b;
        }

    public static <T, U> Pair <T, U> of(T t, U s) {
        return new Pair<>( t, s );
    }

    public T getFirst() {
            return a;
        }
        public U getSecond() {
            return b;
        }

        @Override
        public boolean equals(Object other){
            if (this == other) {
                return true;
            }
            if (Pair.class.isInstance(other)) {
                return Objects.equals(a, ((Pair<?,?>)other).a) &&
                        Objects.equals(b, ((Pair<?,?>)other).b);
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hashCode(a) ^ Objects.hashCode(b);
        }
    }
    