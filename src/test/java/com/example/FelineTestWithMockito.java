import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTestWithMockito {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens(){
        Mockito.when(feline.getKittens()).thenReturn(5);
        assertEquals(5, feline.getKittens());
    }

    @Test
    public void testGetFamily(){
        Mockito.when(feline.getFamily()).thenReturn("Куньи");
        assertEquals("Куньи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception{
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Трава", "Растения"));
        assertEquals(List.of("Трава", "Растения"), feline.eatMeat());
    }
}
