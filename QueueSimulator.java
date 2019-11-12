import java.lang.*;

// enum of both possible events
public class QueueSimulator{
  public enum Event { ARRIVAL, DEPARTURE };

  private double currTime;
  private double arrivalRate;
  private double serviceTime;
  private double timeForNextArrival;
  private double timeForNextDeparture;
  private double totalSimTime;
  
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
  
  private Event e;
  
  public double getRandTime(double arrivalRate){
    double time1, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    return time1;
  }
  
  public QueueSimulator(double aR, double servT, double simT){

    serviceTime = servT;
    totalSimTime = simT;
	  currTime = 0;
    arrivalRate = aR;
	  timeForNextArrival = getRandTime(aR); 
    timeForNextDeparture = servT + timeForNextArrival;
  }

  public double calcAverageWaitingTime(){
	  double averageTime = 0;
    double[] waitTimes = new double[eventQueue.size()];
    Data data;
      int i = 0;
      while(eventQueue.size() > 0)
      {
          data = eventQueue.dequeue();
          waitTimes[i] = data.getDepartureTime() - data.getArrivalTime();
          i++;
      }
      double tot = 0;
      for(int j = 0; j < waitTimes.length; j++) {
          tot += waitTimes[j];
      }
      averageTime  = tot / waitTimes.length;
      return averageTime;

  }
  
  
  public double runSimulation(){
    Data data;

      while(currTime < totalSimTime){      
          if(buffer.isEmpty()){
              timeForNextDeparture = timeForNextArrival + serviceTime;
          }
          if (timeForNextArrival < timeForNextDeparture) {
        	  e = Event.ARRIVAL;
          }
          else {
        	  e = Event.DEPARTURE;
          }
          
          if(e == Event.ARRIVAL) {
              currTime = timeForNextArrival;
              data = new Data();
              data.setArrivalTime(currTime);   
              buffer.enqueue(data);
              timeForNextArrival = currTime + getRandTime(arrivalRate);
          }
      
      	  else {
              currTime = timeForNextDeparture;
              Data data = buffer.dequeue();
              data.setDepartureTime(currTime);
              eventQueue.enqueue(data);
              timeForNextDeparture = currTime + serviceTime;
          }
      }
      return calcAverageWaitingTime();
  }
}






