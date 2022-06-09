import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    BubbleSort bubbleSort = new BubbleSort();

    @Test
    void sortWholeNumbers() {
        List<Comparable<?>> expected = Arrays.asList(1,3,4,5,6,8,8);
        List<Comparable<?>> actual = bubbleSort.sort(Arrays.asList(1,4,5,6,8,3,8));
        assertEquals(expected, actual);
    }

    @Test
    void sortWholeAndFractionalNumbers() {
        List<Comparable<?>> expected = Arrays.asList(-9.3,0.1,0.2,4,5,9);
        List<Comparable<?>> actual = bubbleSort.sort(Arrays.asList(-9.3,0.2,4,0.1,5,9));
        assertEquals(expected, actual);
    }

    @Test
    void sortEmptyList() {
        List<Comparable<?>> expected = List.of();
        List<Comparable<?>> actual = bubbleSort.sort(List.of());
        assertEquals(expected, actual);
    }

    @Test
    void sortWithNullAsElement() {
        List<Comparable<?>> expected = List.of(5.0001);
        List<Comparable<?>> actual = bubbleSort.sort(Arrays.asList(null,5.0001));
        assertEquals(expected, actual);
    }

    @Test
    void sortWithNullAsInput() {
        assertThrows(RuntimeException.class, ()-> bubbleSort.sort(null));
    }
}