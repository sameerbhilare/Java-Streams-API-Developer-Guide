package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // finaAny() is non deterministic - if you run 100 or more than, you 'may' get different values. This is to allow for maximal
    //     * performance in parallel operations; the cost is that multiple invocations
    //     * on the same source may not return the same result.

    Integer any = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findAny()
        .get();
    System.out.println(any);

  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // findFirst() is deterministic - always gives you very first number.
    Integer first = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findFirst()
        .get();

    System.out.println(first);

  }
}

