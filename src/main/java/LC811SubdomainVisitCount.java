import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC811SubdomainVisitCount {
  class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
      List<String> res = new ArrayList<>();
      Map<String, Integer> map = new HashMap<>();
      for (String s : cpdomains) {
        String[] countDomain = s.split(" ");
        int count = Integer.parseInt(countDomain[0]);
        String domain = countDomain[1];

        map.put(domain, map.getOrDefault(domain, 0) + count);

        for (int i = 0; i < domain.length(); i++) {
          if (domain.charAt(i) == '.') {
            String subdomain = domain.substring(i + 1);
            map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
          }
        }
      }

      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        res.add(entry.getValue() + " " + entry.getKey());
      }
      return res;
    }
  }

}
