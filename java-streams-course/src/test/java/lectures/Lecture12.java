package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    // how Collectors.toList() actually works
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(
            () -> new ArrayList<String>(),
            (list, element) -> list.add(element),
            (list1, list2) -> list1.addAll(list2) // streams are powerful, they take care of multithreading.
                                                  // why do we need this line? To combine results from multiple threads
                                                  // (if the main list is being operated on by multiple threads).
        );
        //.collect(Collectors.toList());

    emails.forEach(System.out::println);

    // how Collectors.toList() actually works - alternate syntax
    emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(
            ArrayList::new,
            ArrayList::add,
            ArrayList::addAll
        );
    //.collect(Collectors.toList());

    emails.forEach(System.out::println);
  }
}
