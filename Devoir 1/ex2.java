import java.util.ArrayList;

public class ex2{
  public static int x=500000000;
  public ArrayList<Character> character = new ArrayList<Character>();

  public ex2(){
    for(int i=0; i<x; i++){
      character.add('a');
    }
  }
  private static double nanoToSeconds( long time ) {
		return (double) time / 1000000000.0;
	}

  public static void main(String[] args) {

  long avant= System.nanoTime();
  ex2 ex2 = new ex2();
  long apres =System.nanoTime();
  long res = apres - avant;

  System.out.println("le temps necessaire pour remplir ArrayList par " + x + " est " + nanoToSeconds(res) +" secondes.");
}

}
