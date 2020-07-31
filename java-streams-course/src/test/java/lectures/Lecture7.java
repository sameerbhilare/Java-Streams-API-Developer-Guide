package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long femaleCount = MockData.getPeople().stream()
        .filter(person -> person.getGender().equalsIgnoreCase("female"))
        .count();
    System.out.println(femaleCount);
  }

  @Test
  public void min() throws Exception {
    double min = MockData.getCars().stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .min() // min without Comparator
        //.getAsDouble();
        .orElse(0); // default value if unable to find min value. e.g. in case of empty list

    System.out.println("Price of cheapest yellow car is = "+min);

  }

  @Test
  public void max() throws Exception {
    double max = MockData.getCars().stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .max() // max without Comparator
        //.getAsDouble();
        .orElse(0); // default value if unable to find max value. e.g. in case of empty list

    System.out.println("Price of costliest yellow car is = "+max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

    double averagePrice = cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);
    System.out.println(averagePrice);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();

    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();

    System.out.println(statistics);
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getMin());
    System.out.println(BigDecimal.valueOf(statistics.getSum()));
  }

}