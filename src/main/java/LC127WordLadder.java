import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC127WordLadder {
  public int ladderLength(String start, String end, List<String> wordList) {
    Set<String> dict = new HashSet<>();
    for (String word : wordList) {
      dict.add(word); // add the word list to a set
    }

    if (start.equals(end)) {
      return 1;
    }

    HashSet<String> hash = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    hash.add(start);

    int length = 1;
    while (!queue.isEmpty()) {
      length++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        for (String nextWord : getNextWords(word, dict)) {
          if (hash.contains(nextWord)) {
            continue;
          }
          if (nextWord.equals(end)) {
            return length;
          }

          hash.add(nextWord);
          queue.offer(nextWord);
        }
      }
    }

    return 0;
  }

  // replace character of a string at given index to a given character
  // return a new string
  private String replace(String s, int index, char c) {
    char[] chars = s.toCharArray();
    chars[index] = c;
    return new String(chars);
  }

  // get connections with given word.
  // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
  // it will return ['hit', 'hog']
  private ArrayList<String> getNextWords(String word, Set<String> dict) {
    ArrayList<String> nextWords = new ArrayList<>();
    for (char c = 'a'; c <= 'z'; c++) {
      for (int i = 0; i < word.length(); i++) {
        if (c == word.charAt(i)) {
          continue;
        }
        String nextWord = replace(word, i, c);
        if (dict.contains(nextWord)) {
          nextWords.add(nextWord);
        }
      }
    }
    return nextWords;
  }
}
