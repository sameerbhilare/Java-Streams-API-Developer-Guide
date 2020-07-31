package lectures;

import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture13 {
  @Test
  public void intermediateAndTerminalOperations() throws Exception {

    /**
     * intermediate operations - filter, map
     * terminal operations - collect. - converts abstractions into concrete types.
     *
     * Your entire function is called ONLY when the terminal operation is invoked.
     * (You can test by commenting the collect() line above, you won't output the printlns in filter, map)
     *
     * Hence streams are LAZY. i.e. it doesn't do anything until we invoke the terminal operation like collect().
     *
     * streams are highly OPTIMIZED. i.e. the intermediate operations may not run one after another.
     * But it optimizes it to invoke other intermediate operations whenever necessary.
     * e.g. Run this test case and see the output.
     */

    System.out.println(
        MockData.getCars()
            .stream()
            .filter(car -> {
              System.out.println("1. filter car " + car);
              return car.getPrice() < 10000;
            })
            .map(car -> {
              System.out.println("2. mapping car " + car);
              return car.getPrice();
            })
            .map(price -> {
              System.out.println("3. mapping price " + price);
              return price + (price * .14);
            })
            .collect(Collectors.toList()) // terminal operator
    );
  }
}
