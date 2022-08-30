import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTestWithoutMockito {
    Feline feline = new Feline();

    @Test
    public void testGetKittens(){
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetFamily(){
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception{
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }


}