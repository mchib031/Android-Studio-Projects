import java.util.ArrayList;
import java.util.LinkedList;

public class ex2{

  public static int x=10000000;
  public static ArrayList<Character> character = new ArrayList<Character>();
  public static LinkedList<Character> list = new LinkedList<Character>();
  public static Character [] table = new Character[x];

  public ex2(){
    }

  public static ArrayList<Character> remplirAL(){
      for(int i=0; i<x; i++){
        character.add('a');
      }
      return character;
  }

  public static int sommeAL(){
    int s=0;
    ArrayList<Integer> characterint = new ArrayList<Integer>();
      for(int i=0; i<x; i++){
        characterint.add(i);
        s=s+characterint.get(i);
      }
      return s;
  }

  public static LinkedList<Character> remplirL(){
      for(int i=0; i<x; i++){
        list.add('a');
      }
      return list;
  }

  public static int sommeL(){
    int s=0;
    LinkedList<Integer> listint = new LinkedList<Integer>();
      for(int i=0; i<x; i++){
        listint.add(i);
        s=s+listint.get(i);
      }
      return s;
  }

  public static Character [] remplirA(){
    for(int i=0; i<x; i++){
      table[i]='a';
    }
    return table;
  }

  public static int sommeA(){
    int s=0;
    int[] tableint = new int[x];
    for(int i=0; i<x; i++){
      tableint[i]=i;
      s=s+tableint[i];
    }
    return s;
  }

  private static double nanoToSeconds( long time ) {
		return (double) time / 1000000000.0;
	}

  public static void main(String[] args) {

  long avant= System.nanoTime();
  ex2 ex2 = new ex2();
  remplirAL();
  long apres =System.nanoTime();
  long res = apres - avant;

  System.out.println("le temps necessaire pour remplir ArrayList par " + x + " est " + nanoToSeconds(res) +" secondes.");

  character = null;

  avant= System.nanoTime();
  remplirL();
  apres =System.nanoTime();
  res = apres - avant;
  System.out.println("le temps necessaire pour remplir Linkedlist par " + x + " est " + nanoToSeconds(res) +" secondes.");

  list = null;

  avant= System.nanoTime();
  remplirA();
  apres =System.nanoTime();
  res = apres - avant;
  System.out.println("le temps necessaire pour remplir Array par " + x + " est " + nanoToSeconds(res) +" secondes.");

  table = null;

  avant= System.nanoTime();
  sommeAL();
  apres =System.nanoTime();
  res = apres - avant;
  System.out.println("le temps necessaire pour sommer ArrayList par " + x + " est " + nanoToSeconds(res) +" secondes.");

  avant= System.nanoTime();
  sommeL();
  apres =System.nanoTime();
  res = apres - avant;
  System.out.println("le temps necessaire pour sommer LinkedList par " + x + " est " + nanoToSeconds(res) +" secondes.");

  avant= System.nanoTime();
  sommeA();
  apres =System.nanoTime();
  res = apres - avant;
  System.out.println("le temps necessaire pour sommer Array par " + x + " est " + nanoToSeconds(res) +" secondes.");

}

}
