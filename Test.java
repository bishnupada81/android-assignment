import java.util.*;

interface Converter{

    Object convert(Object a);
}

abstract class TemperatureConverter implements Converter{

    abstract protected boolean isHot(double temperature);

}

abstract class SpeedConverter implements Converter{

    abstract protected boolean isFast(double speed);

}

class Thermometer extends TemperatureConverter{

    public Object convert(Object a){

        double celsius = (double) a;
        double fahrenheit;

        fahrenheit = (celsius * 1.8)+32;
        return fahrenheit;

    }

    protected boolean isHot(double temperature){

      return temperature>50;


    }

}

class Thermocouple extends TemperatureConverter{

    public Object convert(Object a){

        double celsius = (double) a;
        double kelvin;

        kelvin = celsius + 273.15;
        return kelvin;

    }

    protected boolean isHot(double temperature){

      return temperature > 50;


    }

}

class PitotTube extends SpeedConverter{


    public Object convert(Object a){

        double kms = (double) a;
        double mach;

        mach = kms * 0.00081;
        return mach;

    }

    protected boolean isFast(double speed){

      return speed > 60;

    }

}


class ShaftLog extends SpeedConverter{


    public Object convert(Object a){

        double kmh = (double) a;
        double mph;

        mph = kmh * 0.621371;
        return mph;

    }

    protected boolean isFast(double speed){

      return speed > 60;

    }

}

class Test {

    public static void main(String[] args) { 

        Converter converter;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a choice 1-4: ");
        int choice = input.nextInt();

         switch(choice) {
             case 1: 
                    converter = new Thermometer();
                    System.out.println(converter.convert(57.1));
                     //System.out.println(converter.isHot(57.1));  
                    System.out.println(((Thermometer)converter).isHot(57.1)); 
                    break;

            case 2: 
                    converter = new Thermocouple();
                    System.out.println(converter.convert(57.1));
                    //System.out.println(converter.isHot(57.1)); 
                    System.out.println(((Thermocouple)converter).isHot(57.1)); 
                    break;

            case 3: 
                    converter = new PitotTube();
                    System.out.println(converter.convert(1235.00));
                    // System.out.println(converter.isFast(1235.00)); 
                    System.out.println(((PitotTube)converter).isFast(1235.00)); 
                    break;

            case 4:
                    converter = new ShaftLog();
                    System.out.println(converter.convert(100.0));
                    // System.out.println(converter.isFast(100.0)); 
                    System.out.println(((ShaftLog)converter).isFast(100.0)); 
         }

    }
}