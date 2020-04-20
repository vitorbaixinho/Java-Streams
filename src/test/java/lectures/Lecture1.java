package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {

    List<Person> people = MockData.getPeople();

    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

    final int max = 10;
    int counter = 0;

    List<Person> youngers = Lists.newArrayList();
    for (Person person : people) {
      if (person.getAge() <= 18) {
        youngers.add(person);
        counter++;
      }
      if (counter == max) {
        break;
      }
    }

    for (Person younger : youngers) {
      System.out.println(younger);
    }

    assertThat(youngers).hasSize(10);
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
//    ImmutableList<Person> people = MockData.getPeople();
//
//    List<Person> youngers = people.stream().filter(person -> person.getAge() <= 18).limit(10)
//        .collect(Collectors.toList());
//
//    youngers.forEach(System.out::println);

    MockData.getPeople().stream().filter(person -> person.getAge() <= 18).limit(10)
        .collect(Collectors.toList()).forEach(System.out::println);

  }
}
