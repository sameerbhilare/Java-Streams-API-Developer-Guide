package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    Integer minNumber = numbers.stream()
        .min((num1, num2) -> num1 > num2 ? 1 : -1)
        .get();
    /*
     With this if you mistakenly use num1 < num2 ? 1, then you will get max number from the min() function, which is misleading.
     To avoid the confusion, use Comparator.naturalOrder() as shown below.
     */

    minNumber = numbers.stream()
        .min(Comparator.naturalOrder())
        .get();

    assertThat(minNumber).isEqualTo(1);
    System.out.println(minNumber);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    Integer maxNumber = numbers.stream()
        .max(Comparator.naturalOrder())
        .get();

    assertThat(maxNumber).isEqualTo(100);
    System.out.println(maxNumber);
  }
}
