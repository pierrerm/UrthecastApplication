import java.util.*;

public class MergeLists {
  public static void main(String[] args) {

    List<String> originalList = new ArrayList<>();
    originalList.add("one");
    originalList.add("one");
    originalList.add("two");
    originalList.add("three");

    List<String> addList = new ArrayList<>();
    addList.add("one");
    addList.add("two");
    addList.add("five");
    addList.add("six");

    List<String> removeList = new ArrayList<>();
    removeList.add("two");
    removeList.add("five");

    System.out.println(mergeLists(originalList, addList, removeList));
  }

  /**
   * Merge multiple inputs into a single list of strings. Add the strings in
   * <i>addList</i> and remove the strings in <i>removeList</i> from the
   * <i>originalList</i>. Remove duplicates, sort by descending character count
   * and reverse alphabetical order.
   * 
   * @param originalList the original list of strings to be merged into
   * @param addList      the list of strings to be added
   * @param removeList   the list of strings to be removed
   * 
   * @return the merged and sorted list
   */
  static List<String> mergeLists(List<String> originalList, List<String> addList, List<String> removeList) {

    List<String> newList = new ArrayList<>();

    // removes duplicates from original list
    originalList.forEach(eachValue -> {
      if (!newList.contains(eachValue))
        newList.add(eachValue);
    });

    // adds strings that don't already exist from add list
    addList.forEach(addValue -> {
      if (!newList.contains(addValue))
        newList.add(addValue);
    });

    // removes strings from remove list
    removeList.forEach(removeValue -> {
      if (newList.contains(removeValue))
        newList.remove(removeValue);
    });

    // sorts by descending character count and reverse alphabetical order
    Collections.sort(newList, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        // character count is equal, sorts by reverse alphabetical order
        if (s1.length() == s2.length()) {
          // iterates over all characters
          for (int i = 0; i < s1.length(); i++) {
            // characters are different, compares alphabetical order
            if (s1.charAt(i) != s2.charAt(i)) {
              return s2.charAt(i) - s1.charAt(i);
            }
          }
          // compares character count
        } else {
          return s2.length() - s1.length();
        }
        return 1;
      }
    });

    return newList;
  }
}