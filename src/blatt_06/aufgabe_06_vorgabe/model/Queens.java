package blatt_06.aufgabe_06_vorgabe.model;

final class Queens {

  private Queens(){}
  
  static boolean acceptable(int[] placement) {
    for (int i=0; i<placement.length; i++) {
      int x = placement[i];
      for (int j=0; j<placement.length; j++) {
        if (i!=j) {
          int d = i-j; // diagonal: distance between j an j 
          if (placement[j] == x || placement[j] == x-d || placement[j] == x+d) {
              return false;
          }
        }
      }
    }
    return true;
  }

  
}
