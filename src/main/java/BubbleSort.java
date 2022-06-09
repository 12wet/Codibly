import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BubbleSort{

    public List<Comparable<?>> sort(List<Comparable<?>> input) {

        if (input == null)
            throw new RuntimeException();

        input = input
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        /*
        Considering subsection 2 of the exercise:
        "method should return List of Comparable, but the numbers should be sorted ascending"
        it is assumed that in this case the Comparable is always a Number,
        thus implementing doubleValue() method.

        In case non-Number Comparable was used as an input element, 
        unhandled exception would be thrown.
         */
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = 0; j < input.size() - 1; j++) {

                double first = ((Number) input.get(j)).doubleValue();
                double second = ((Number) input.get(j + 1)).doubleValue();

                if (Double.compare(first, second) > 0) {
                    Comparable<?> temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }

        return input;
    }
}