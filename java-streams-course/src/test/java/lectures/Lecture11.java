package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String concatinatedString = "";
    for(String name: names) {
      concatinatedString = concatinatedString + name + ",";
    }
    concatinatedString = concatinatedString.substring(0, concatinatedString.length() - 1);
    System.out.println(concatinatedString);

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String join = names.stream()
        .map(s -> s.toUpperCase())
        .collect(Collectors.joining(","));

    System.out.println(join);
  }
}
