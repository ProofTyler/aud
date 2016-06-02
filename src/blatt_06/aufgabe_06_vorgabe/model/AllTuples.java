package blatt_06.aufgabe_06_vorgabe.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class AllTuples {
  
  private Set<Integer> M = null;
  
  /**
   * @param M Set of elements that form the tuples.
   */
  public AllTuples(Set<Integer> M) {
    this.M = M;
  }
  
  /**
   * Build all tuples of size k build from elements of a set M.
   * @param k size tuples.
   * @return List of all tuples of size k build from elements of a set M
   */
  public List<int[]> ofLength(int k) {
    if (k == 0) {
      ArrayList<int[]> result = new ArrayList<>();
      result.add((int[]) new int[0]);
      return result;
    } else {
      List<int[]> result = new ArrayList<>();
      List<int[]> rec = ofLength(k-1);
      for (int[] t: rec) {
        for (int x: M) {
          int[] tt = Arrays.copyOf(t, t.length+1);
          tt[tt.length-1] = x;
          result.add(tt);
        }
      }
      return result;
    }
  }
  
}
