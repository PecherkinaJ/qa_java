import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(5);
        assertEquals(5, feline.getKittens());
    }

    @Test
    public void testGetFamily() {
        Mockito.when(feline.getFamily()).thenReturn("Куньи");
        assertEquals("Куньи", feline.getFamily());
    }

    @Test
    public void testEatMeatRealObjectShouldBeHerbivorousFood() throws Exception {
        Feline realFeline = new Feline();
        Feline spyFeline = Mockito.spy(realFeline);
        Mockito.when(spyFeline.getFood("Травоядное")).thenReturn(List.of("Трава", "Различные растения"));
        assertEquals(List.of("Трава", "Различные растения"), spyFeline.getFood("Травоядное"));
    }

    @Test
    public void testEatMeatRealObjectShouldBePredatorFood() throws Exception {
        Feline realFeline = new Feline();
        Feline spyFeline = Mockito.spy(realFeline);
        Mockito.when(spyFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), spyFeline.getFood("Хищник"));
    }

    @Test(expected = Exception.class)
    public void testEatMeatRealObjectShouldBeException() throws Exception {
        Feline realFeline = new Feline();
        Feline spyFeline = Mockito.spy(realFeline);
        try {
            spyFeline.getFood("Животное");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    @Test
    public void testGetKittensShouldBeOne() {
        Feline curFeline = new Feline();
        assertEquals(1, curFeline.getKittens());
    }

    @Test
    public void testGetKittensShouldBeTwo() {
        Feline curFeline = new Feline();
        assertEquals(2, curFeline.getKittens(2));
    }

    @Test
    public void testGetFamilyRealObject() {
        Feline curFeline = new Feline();
        assertEquals("Кошачьи", curFeline.getFamily());
    }

    @Test
    public void testEatMeatRealObject() throws Exception {
        Feline curFeline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), curFeline.eatMeat());
    }

}
