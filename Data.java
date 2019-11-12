public class Data{
  double arrivalTime;
  double departureTime;
  
  public Data(){
    // Setting initial data to 0
    arrivalTime = 0;
    departureTime = 0;
  }


  public void setArrivalTime(double a){
    arrivalTime = a; 
  }

  public void setDepartureTime(double d){
    departureTime = d;
  }

  public double getDepartureTime(){
    return departureTime;
  }

  public double getArrivalTime(){
    return arrivalTime;
  }

  public double getWaitingTime() {
    return (getDepartureTime() - getArrivalTime());
  }
}