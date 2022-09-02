import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    @Mock
    Cat mockedCat;

    @Test
    public void testGetSoundMeow() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void testGetSoundArrr() {
        Mockito.when(mockedCat.getSound()).thenReturn("Аррр");
        String actual = mockedCat.getSound();
        assertEquals("Аррр", actual);
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(expected, cat.getFood());
    }
}