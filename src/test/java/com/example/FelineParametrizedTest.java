import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    Feline feline = new Feline();

    private final int kittenNumber;
    private final int expected;

    public FelineParametrizedTest(int kittenNumber, int expected) {
        this.kittenNumber = kittenNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: ожидается: {0}, результат: {1}")
    public static Object[] data() {
        return new Object[][]{
                {-1, -1},
                {0, 0},
                {1, 1},
                {999999, 999999},
        };
    }

    @Test
    public void testGetKittens() {
        int actualKittens = feline.getKittens(kittenNumber);
        assertEquals(expected, actualKittens);
    }

}