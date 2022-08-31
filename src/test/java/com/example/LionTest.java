import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

//@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Test
    public void testLionConstructorCorrectMaleSex() throws Exception{
        Lion lion = new Lion(new Feline(), "Самец");
        assertTrue(lion.hasMane);
    }
    @Test
    public void testLionConstructorCorrectFemaleSex() throws Exception{
        Lion lion = new Lion(new Feline(), "Самка");
        assertFalse(lion.hasMane);
    }

    @Test
    public void testLionConstructorEmptySexShouldBeException() throws Exception {
        try {
            new Lion(new Feline(), "");
        } catch (Exception e){
            assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
        }
    }

    @Test
    public void testLionConstructorUndefineSexShouldBeException() throws Exception {
        try {
            new Lion(new Feline(), "Undefine");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
        }
    }
    @Test
    public void testLionConstructorSymbolsInsteadOfSexShouldBeException() throws Exception {
        try {
            new Lion(new Feline(), "@#!*&()");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
        }
    }

    @Test
    public void testDoesHaveManeTrue() throws Exception{
        Lion lion = new Lion(new Feline(), "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeFalse() throws Exception{
        Lion lion = new Lion(new Feline(), "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetKittensMale() throws Exception{
        Lion lion = new Lion(new Feline(), "Самец");
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetKittensFemale()throws Exception{
        Lion lion = new Lion(new Feline(), "Самка");
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testEatMeatMale() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самец");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testEatMeatFemale() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion(feline, "Самка");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test (expected = Exception.class)
    public void testEatMeatFemaleException() throws Exception{
        Feline feline = new Feline();
        try {
            new Lion(feline, "Животное");
        } catch (Exception e){
            throw new Exception(e);
        }
    }
}