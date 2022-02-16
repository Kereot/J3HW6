import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestHW2 {
    private Homework2 hw2;

    @BeforeEach
    public void init() {
        hw2 = new Homework2();
    }

    public static Stream<Arguments> arrayCheck() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 1, 1, 4, 4, 1, 4, 4}, 1, 4, true));
        out.add(Arguments.arguments(new int[] {1, 1, 1, 1, 1, 1}, 1, 4, false));
        out.add(Arguments.arguments(new int[] {4, 4, 4, 4}, 1, 4, false));
        out.add(Arguments.arguments(new int[] {1, 4, 4, 1, 1, 4, 3}, 1, 4, false));
        out.add(Arguments.arguments(new int[] {14, 41, 11, 44}, 1, 4, false));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("arrayCheck")
    public void testCheckPair(int[] arr, int a, int b, boolean ch) {
        Assertions.assertEquals(ch, hw2.checkPair(arr, a, b));
    }
}
