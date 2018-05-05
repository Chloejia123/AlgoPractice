import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC690EmployeeImportance {
  public int getImportance(List<Employee> employees, int id) {
    int res = 0;
    Map<Integer, Employee> map = new HashMap<>();
    Queue<Employee> queue = new LinkedList<>();
    for (Employee e : employees) {
      map.put(e.id, e);
    }
    queue.offer(map.get(id));
    while (!queue.isEmpty()) {
      Employee em = queue.poll();
      res += em.importance;
      for (Integer subId : em.subordinates) {
        queue.offer(map.get(subId));
      }
    }
    return res;
  }

  class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
  };
}
