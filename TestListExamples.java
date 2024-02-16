import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(right, left);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  } 


  @Test(timeout = 500)
  public void testMergeNullArg() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    assertThrows( IllegalArgumentException.class, () -> {ListExamples.merge(null, left);});
    assertThrows( IllegalArgumentException.class, () -> {ListExamples.merge(right, null);});
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> list = Arrays.asList("a", "moon", "moon beam");
    List<String> expected = Arrays.asList("moon");
    List<String> filtered = ListExamples.filter(list, new IsMoon());
    assertEquals(expected, filtered);
  } 

  // @Test(timeout = 500)
  // public void testFilterSubset() {
  //   List<String> list = Arrays.asList("a", "b", "c", "d", "e");
  //   List<String> filter = Arrays.asList("b", "d", "f", "g");
  //   List<String> expected = Arrays.asList("b", "d");
  //   List<String> filtered = ListExamples.filter(list, new IsMoon());
  //   assertEquals(expected, filtered);
  // } 

  // @Test(timeout = 500)
  // public void testFilterSameFilterDiffOrder() {
  //   List<String> list = Arrays.asList("a", "b", "c");
  //   List<String> filter = Arrays.asList("b", "c", "a");
  //   List<String> expected = Arrays.asList("a", "b", "c");
  //   List<String> filtered = ListExamples.filter(list, filter);
  //   assertEquals(expected, filtered);
  // } 


  // @Test(timeout = 500)
  // public void testFilterSameListDiffOrder() {
  //   List<String> filter = Arrays.asList("a", "b", "c");
  //   List<String> list = Arrays.asList("b", "c", "a");
  //   List<String> expected = Arrays.asList("a", "b", "c");
  //   List<String> filtered = ListExamples.filter(list, filter);
  //   assertEquals(expected, filtered);
  // } 

  // @Test(timeout = 500)
  // public void testFilterNoSame() {
  //   List<String> filter = Arrays.asList("a", "b", "c");
  //   List<String> list = Arrays.asList("d", "e", "f");
  //   List<String> filtered = ListExamples.filter(list, filter);
  //   assertTrue(filtered.isEmpty());
  // }
  
  @Test(timeout = 500)
  public void testFilterNullArg() {
    List<String> list = Arrays.asList("a", "b", "c");
    assertThrows( IllegalArgumentException.class, () -> {ListExamples.filter(null, new IsMoon());});
    assertThrows( IllegalArgumentException.class, () -> {ListExamples.filter(list, null);});
  }
}
