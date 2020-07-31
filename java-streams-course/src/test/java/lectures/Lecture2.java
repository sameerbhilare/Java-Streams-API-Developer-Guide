package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }

    System.out.println("exclusive");
    IntStream.range(0,10).forEach(index -> System.out.println(index));

    System.out.println("exclusive");
    IntStream.range(0,10).forEach(System.out::println); // method reference

    System.out.println("inclusive");
    IntStream.rangeClosed(0,10).forEach(System.out::println);
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    // if you need index of the element in the List, use Intstream
    IntStream.range(0, people.size())
        .forEach( index -> {
          Person person = people.get(index);
          System.out.println(person);
        });

    // if you don't need index of the element in the List
    // people.forEach(System.out::println);

  }

  @Test
  public void intStreamIterate() throws Exception {

    // iterate through elements
    IntStream.iterate(0, operand -> operand + 1)
        .limit(10)
        .forEach(System.out::println);

    System.out.println("iterate through elements and get first 10 even numbers");
    // iterate through elements and get first 10 even numbers
    IntStream.iterate(0, operand -> operand + 1)
        .filter(number -> number % 2 == 0)
        .limit(10)
        .forEach(System.out::println);
  }
}
