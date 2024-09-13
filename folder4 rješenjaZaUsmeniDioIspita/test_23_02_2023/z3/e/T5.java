
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class T5 {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(100, 200, 30, 10, 20, 50, 100, 400, 200, 500, 300);
Optional<Integer> result = numbers.stream().distinct().
filter(e -> e > 100).reduce((a, b) -> a + b);
System.out.println(result.get());
numbers.stream().distinct().sorted().
collect(Collectors.toList()).forEach(System.out::println);
Stream.iterate(2, e -> e + 2).peek(e -> {
System.out.print("peek");
}).limit(20).forEach(System.out::println);
}
}

/*
1400
10
20
30
50
100
200
300
400
500
peek2
peek4
peek6
peek8
peek10
peek12
peek14
peek16
peek18
peek20
peek22
peek24
peek26
peek28
peek30
peek32
peek34
peek36
peek38
peek40

*/