package junit;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


//@RunWith(Parameterized.class)
public class CalculatorTestCase {

    private NumberProvider numberProvider;

//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//                {0, 0, 0},
//                {1, 1, 2},
//                {2, 2, 4},
//                {5, 5, 10},
//                {4, 2, 6},
//                {1, 3, 4},
//                {6, -2, 4},
//                {-1, 5, 3},
//
//        });
//    }

    private int a;
    private int b;
    private int c;

    private Calculator calculator;

//    public CalculatorTestCase(int a, int b, int c) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//    }

    @Before
    public void before() {
        numberProvider = Mockito.mock(NumberProvider.class);
        this.calculator = new Calculator(numberProvider);
    }

    @After
    public void after() {
        this.calculator = null;
    }

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
////
//    @Mock
//    NumberProvider numberProvider;

    @Test
    public void testMock() {
        Mockito
                .when(numberProvider.getNumber())
                .thenReturn(2, 6);


        int result = calculator.sumFromProvider();
        Assert.assertEquals(8, result);
    }

    @Ignore
    @Test
    public void testAdd() {
        int result = calculator.add(a, b);
        Assert.assertThat("a = " + a + ", b = " + b, result, Is.is(c));
    }


    @Ignore
    @Test
    public void testSub() {
        int result = calculator.sub(2, 3);
        Assert.assertThat(result, Is.is(-1));
    }

    @Ignore
    @Test
    public void testMul() {
        int result = calculator.mul(2, 3);
        Assert.assertThat(result, Is.is(6));
    }

    @Ignore("test reason")
    @Test(expected = ArithmeticException.class, timeout = 10)
    public void testDiv() {
        int result = calculator.div(8, 0);
        Assert.assertThat(result, Is.is(4));
    }


}
