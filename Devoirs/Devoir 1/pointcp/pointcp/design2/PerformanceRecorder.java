import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PerformanceRecorder{
  public static void main(String[] args) {
    Random rd = new Random();
    int i = 1;
    long medianTime = 0;
    long minTime= TimeUnit.NANOSECONDS.convert(300, TimeUnit.SECONDS);;
    long maxTime=-1;
    long timeRecorded;

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

    long loopTimeStart = System.nanoTime();
    long duration = TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS);
    try{
      while(System.nanoTime()-loopTimeStart <= duration){
        timeRecorded= runRecorder(rd,createRandomPoints(rd));
        if(timeRecorded>maxTime){
          maxTime = timeRecorded;
        }
        if(timeRecorded < minTime){
          minTime = timeRecorded;
        }
        medianTime = timeRecorded+medianTime;
        i++;
      }
    }catch (Exception e) {
      while (i<=25){
        timeRecorded=runRecorder(rd,createRandomPoints(rd));
        if(timeRecorded>maxTime){
          maxTime = timeRecorded;
        }
        if(timeRecorded < minTime){
          minTime = timeRecorded;
        }
        medianTime = timeRecorded+medianTime;
        i++;
      }
    }
    medianTime= medianTime/i;
    try {
      FileWriter fw = new FileWriter("Records.txt");
      fw.write("For "+(i-1)+" iterations in 10 seconds we have:\n");
      fw.write("maxTime = "+maxTime+" nanoseconds\n");
      fw.write("minTime = "+minTime+" nanoseconds\n");
      fw.write("medianTime = "+medianTime+" nanoseconds\n");
      fw.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static PointCP2 createRandomPoints(Random rd){
    char rdType = rd.nextBoolean() ? 'C' : 'P';
    double rdXOrRho = rd.nextDouble();
    double rdYOrTheta = rd.nextDouble();
    return new PointCP2(rdType, rdXOrRho, rdYOrTheta);
  }

  public static long runRecorder(Random rd, PointCP2 testPoint){
    long endTime;
    long startTime;
    long elapsedTime;

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
    return elapsedTime;
  }
}
