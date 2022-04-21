package NumberGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    public String generate() {
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<String> strings = integers.stream().map(String::valueOf).collect(Collectors.toList());
        Collections.shuffle(strings);

        List<String> result = strings.subList(0, 4);
        //result.stream().collect(Collectors.joining())
        return String.join("", result);
    }
}
