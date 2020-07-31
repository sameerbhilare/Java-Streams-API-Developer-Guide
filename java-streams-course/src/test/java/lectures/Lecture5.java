package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    List<Car> filteredCars = cars.stream()
        .filter(carLessThan10000Predicate)
        .collect(Collectors.toList());

    filteredCars.forEach(System.out::println);
    System.out.println(filteredCars.size());
  }
  // in case if we want to reuse the Predicate.
  // Predicate is just an expression which evaluates to true or false
  Predicate<Car> carLessThan10000Predicate = car -> car.getPrice() < 10000;

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    // map() takes one object type and transforms into another object type.
    // Approach 1
    List<PersonDTO> dtos = people.stream()
        .map(person -> {
          PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
          return dto;
        })
        .collect(Collectors.toList());

    dtos.forEach(System.out::println);

    // Approach 2
    List<PersonDTO> dtos2 = people.stream()
        .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
        .collect(Collectors.toList());

    dtos2.forEach(System.out::println);

    // Approach 3
    List<PersonDTO> dtos3 = people.stream()
        .map(PersonDTO::map) // this simply calls the static method 'map' defined in the PersonDTO class
        .collect(Collectors.toList());

    dtos3.forEach(System.out::println);

    // Approach 4
    Function<Person, PersonDTO> mapPersonFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
    List<PersonDTO> dtos4 = people.stream()
        .map(mapPersonFunction)
        .collect(Collectors.toList());

    dtos4.forEach(System.out::println);

    assertThat(dtos).hasSize(1000);
    assertThat(dtos2).hasSize(1000);
    assertThat(dtos3).hasSize(1000);
    assertThat(dtos4).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    double averagePrice = cars.stream()
        .mapToDouble(car -> car.getPrice()) // .mapToDouble(Car::getPrice)
        .average()
        .getAsDouble();

    System.out.println(averagePrice);

    double averagePrice2 = cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0); // return 0 if you don't find an average

    System.out.println(averagePrice2);

  }

  @Test
  public void test() throws Exception {

  }
}



