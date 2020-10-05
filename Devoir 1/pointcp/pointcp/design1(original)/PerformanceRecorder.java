import java.io.*;
import java.util.*;
public class PerformanceRecorder{
  public static void main(String[] args) {
    Random rd = new Random();
    int i = 1;
    long recordedTime;
    long medianTime=-1;
    long minTime=60000000;
    long maxTime=-1;
    try {
      File myObj = new File("Records.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }}catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
    while(i<=10){
      recordedTime = runRecorder(rd);
      System.out.println(recordedTime);
      medianTime = recordedTime + medianTime;
      if(recordedTime>maxTime){
        maxTime = recordedTime;
      }
      if(recordedTime < minTime){
        minTime = recordedTime;
      }
      medianTime = medianTime/i;
      i++;
    }
    try {
      FileWriter fw = new FileWriter("Records.txt");
      fw.write("For "+(i-1)+" iterations we have:");
      fw.write("maxTime = "+maxTime+".");
      fw.write("minTime = "+minTime+".");
      fw.write("medianTime = "+medianTime+".");
      fw.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static PointCP createRandomPoints(Random rd){
    char rdType = rd.nextBoolean() ? 'C' : 'P';
    double rdXOrRho = rd.nextDouble();
    double rdYOrTheta = rd.nextDouble();
    return new PointCP(rdType, rdXOrRho, rdYOrTheta);
  }

  public static long[] runRecorder(Random rd, PointCP testPoint){
    long endTime;
    long startTime;
    long elapsedTime;
    long minTime= TimeUnit.NANOSECONDS.convert(300, TimeUnit.SECONDS);;
    long maxTime=-1;

    long loopTimeStart = System.nanoTime();
    long duration = TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS);

    try{
    while(System.nanoTime()-loopTimeStart <= duration){
        startTime = System.nanoTime();
        testPoint.toString();
        testPoint.getX();
        testPoint.getY();
        testPoint.getRho();
        testPoint.getTheta();
        testPoint.convertStorageToPolar();
        testPoint.convertStorageToCartesian();
        testPoint.getDistance(createRandomPoints(rd));
        testPoint.rotatePoint(rd.nextDouble());
        endTime = System.nanoTime();
        elapsedTime = endTime-startTime;
        if(elapsedTime>maxTime){
          maxTime = elapsedTime;
        }
        if(elapsedTime < minTime){
          minTime = elapsedTime;
        }
        
      }
    }
    catch(Exception e){
      for(int i =0 ; i<15;i++){
        startTime = System.nanoTime();
        testPoint.toString();
        testPoint.getX();
        testPoint.getY();
        testPoint.getRho();
        testPoint.getTheta();
        testPoint.convertStorageToPolar();
        testPoint.convertStorageToCartesian();
        testPoint.getDistance(createRandomPoints(rd));
        testPoint.rotatePoint(rd.nextDouble());
        endTime = System.nanoTime();
        elapsedTime = endTime-startTime;
      }
    }
    return elapsedTime;
  }
}
