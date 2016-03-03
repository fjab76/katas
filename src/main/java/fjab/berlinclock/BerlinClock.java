package fjab.berlinclock;

public class BerlinClock {

  //Yellow
  private static final char Y = 'Y';
  //Red
  private static final char R = 'R';
  //Off
  private static final char O = 'O';

  public String getTime(String standardRepresentation){

    String[] timeComponents = standardRepresentation.split(":");
    int hour = Integer.parseInt(timeComponents[0]);
    int minute = Integer.parseInt(timeComponents[1]);
    int second = Integer.parseInt(timeComponents[2]);

    //===> TOP YELLOW LAMP
    char[] topYellowLamp = {O};

    boolean isSecondEven = (second % 2 == 0) ? true : false;
    if(isSecondEven){
      topYellowLamp[0] = Y;
    }

    //===> HOUR LAMPS
    char[] _5HourRedLamps = {O,O,O,O};
    char[] _1HourRedLamps = {O,O,O,O};
    if(hour!=0){
      int numLampsOn = hour/5;
      turnLampsOn(_5HourRedLamps,numLampsOn,R);

      numLampsOn = hour%5;
      turnLampsOn(_1HourRedLamps,numLampsOn,R);
    }


    //===> MINUTE LAMPS
    char[] _5MinuteLamps = {O,O,O,O,O,O,O,O,O,O,O};
    char[] _1MinuteYellowLamps = {O,O,O,O};
    if(minute!=0){
      int numLampsOn = minute/5;
      turnLampsOn(_5MinuteLamps,numLampsOn,Y);
      changeQuartersFromYellowToRed(_5MinuteLamps);

      numLampsOn = minute%5;
      turnLampsOn(_1MinuteYellowLamps,numLampsOn,Y);
    }

    return concatenateLamps(topYellowLamp,_5HourRedLamps,_1HourRedLamps,_5MinuteLamps,_1MinuteYellowLamps);
  }


  private void changeQuartersFromYellowToRed(char[] _5MinuteLamps) {

    if(_5MinuteLamps[2]==Y) _5MinuteLamps[2]=R;
    if(_5MinuteLamps[5]==Y) _5MinuteLamps[5]=R;
    if(_5MinuteLamps[8]==Y) _5MinuteLamps[8]=R;

  }


  private void turnLampsOn(char[] lamps, int numLampsOn, char colour) {

    for(int j=0;j<numLampsOn;j++){
      lamps[j]=colour;
    }

  }

  private String concatenateLamps(char[]... lamps) {

    StringBuilder sb = new StringBuilder();
    for(char[] lampSet : lamps){
      for(int j=0;j<lampSet.length;j++){
        sb.append(lampSet[j]);
      }
      sb.append(" ");
    }

    return sb.toString().trim();
  }

}
