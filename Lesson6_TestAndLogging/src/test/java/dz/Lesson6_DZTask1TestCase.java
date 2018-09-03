package dz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Lesson6_DZTask1TestCase {

    private Lesson6_DZ dz;

    @BeforeEach
    @Before
    public void prepare() {
        dz = new Lesson6_DZ();
    }

    @Test(expected = RuntimeException.class)
    public void test_task1_empty_array() {
        dz.task1(new int[0]);
    }

    @Test(expected = RuntimeException.class)
    public void test_task1_without_4() {
        dz.task1(new int[] {1, 2, 3});
    }

    @Test
    public void test_task1_where_4_is_not_last() {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        Assert.assertArrayEquals(new int[] {5, 6, 7}, dz.task1(data));
    }

    @Test
    public void test_task1_with_some_4() {
        int[] data = {1, 4, 3, 4, 5, 6, 4};
        Assert.assertArrayEquals(new int[] {}, dz.task1(data));
    }

    @ParameterizedTest
    @MethodSource("params")
    public void test_task1_with_params(int[] data, int[] result) {
        Assert.assertArrayEquals(result, dz.task1(data));
    }

    private static Stream params() {
        return Stream.of(
                Arguments.of(
                        new int[] {1, 2, 3, 4},
                        new int[]{}),
                Arguments.of(
                        new int[] {1, 4, 3, 4},
                        new int[]{}),
                Arguments.of(
                        new int[] {1, 4, 3, 5},
                        new int[]{3, 5})
        );
    }

}
