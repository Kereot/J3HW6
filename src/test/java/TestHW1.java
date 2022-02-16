import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestHW1 {
    private Homework1 hw1;

    @BeforeEach
    public void init() {
        hw1 = new Homework1();
    }

    public static Stream<Arguments> arrayCheck() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, 4, new int[] {1, 7}));
        out.add(Arguments.arguments(new int[] {1, 2, 4, 1, 7, 5, 3, 2}, 4, new int[] {1, 7, 5, 3, 2}));
        out.add(Arguments.arguments(new int[] {4, 8, 9, -5, 0}, 4, new int[] {8, 9, -5, 0}));
        out.add(Arguments.arguments(new int[] {1 , 2, 4}, 4, new int[]{}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("arrayCheck")
    public void testGetTail(int[] a, int b, int[] result) {
        Assertions.assertArrayEquals(result, hw1.getTail(a, b));
    }
    @ParameterizedTest
    @MethodSource("arrayCheck")
    public void testGetTailAlt(int[] a, int b, int[] result) {
        Assertions.assertArrayEquals(result, hw1.getTailAlt(a, b));
    }
    @ParameterizedTest
    @MethodSource("arrayCheck")
    public void testGetTailNoList(int[] a, int b, int[] result) {
        Assertions.assertArrayEquals(result, hw1.getTailNoList(a, b));
    }

    @Test
    public void rExGetTail() {
        Assertions.assertThrows(RuntimeException.class, () -> {
           hw1.getTail(new int[] {1, 2, 5, 6}, 4);
        });
    }
    @Test
    public void rExGetTailAlt() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            hw1.getTailAlt(new int[] {1, 2, 5, 6}, 4);
        });
    }
    @Test
    public void rExGetTailNoList() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            hw1.getTailNoList(new int[] {1, 2, 5, 6}, 4);
        });
    }
    @Test
    public void iExGetTail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            hw1.getTail(new int[] {}, 4);
        });
    }
    @Test
    public void iExGetTailAlt() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            hw1.getTailAlt(new int[] {}, 4);
        });
    }
    @Test
    public void iExGetTailNoList() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            hw1.getTailNoList(new int[] {}, 4);
        });
    }
}
