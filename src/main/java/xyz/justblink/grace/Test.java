package xyz.justblink.grace;

import com.github.rjeschke.txtmark.Processor;

import java.util.StringJoiner;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    private static final UnaryOperator<Long> count = x -> x == 0 ? 1 : x * Test.count.apply(x - 1);

    static String testBetta = "";

    public static void main(String[] args) {
        String process = Processor.process("");

        System.out.println(count.apply(500000L));
        
    }

    enum Mine implements MineInterface {
        INSTANCE;

        @Override
        public void hello() {

        }
    }

    interface MineInterface {
        void hello();
    }

    class TestInside {
        static final String gold = "";
    }
}
