package com.fiit.krizanek.data;

public class Destinations {
  private static String destinations[][] = {{"Bucharest","90","1200"}, {"Bratislava","60","1400"}, {"Paris","180","2200"}, {"Nice","170","2100"}, {"London","210","2400"}};

  public static String getCity(int ind){
    if(ind < destinations.length)
      return destinations[ind][0];
    else return"Error";
  }

  public static int getLength(){
    return destinations.length;
  }

  public static int getTime(int i) {
    if(i < destinations.length)
      return Integer.parseInt(destinations[i][1]);
    else return 30;
  }

  public static int getValue(int i){
    return Integer.parseInt(destinations[i][2]);
  }

  public static void getCorrectTime(int i){
    System.out.println(getTime(i)/60 + "h " + getTime(i)%20 + "m");
  }
}
