import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(1,2,3,4,5,6);

        Stream<Integer> test_stream = test.parallelStream();

        List<Integer> pass = new ArrayList<>();

    }  
}
