import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedWordsCounterTest{
    BalancedWordsCounter counter = new BalancedWordsCounter();

    @Test
    public void countWithLettersOnly(){
        String input = "aabbabcccba";
        assertEquals(28, counter.count(input));
    }

    @Test
    public void countWithLengthZeroString(){
        String input = "";
        assertEquals(0, counter.count(input));
    }

    @Test
    public void countWithNumberAsChar(){
        String input = "abababa1";
        assertThrows(RuntimeException.class,
                ()-> counter.count(input));
    }

    @Test
    public void countWithNumberAsInput(){
        assertThrows(RuntimeException.class,
                ()-> counter.count(null));
    }
}