package JavaBean;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.EventListener;
import java.util.EventObject;
class Temperature {
    protected double currentTemp;
    Temperature (){
        currentTemp = 22.2;
    }
    Temperature ( double d){
        currentTemp =d;
    }
    void incrementBy( double d){
        this.currentTemp += d;
        notifyListeners();
    }
    void decrementBy ( double d){
        this.currentTemp -= d;
        notifyListeners();
    }

    Vector tempChangeListeners = new Vector();
    public void addTempChangeListeners ( TempChangeListener t){
        if (  !tempChangeListeners.contains( t) )
            tempChangeListeners.add( t);
    }
    public void removeTempChangeListeners ( TempChangeListener t){
        if (  tempChangeListeners.contains( t))
            tempChangeListeners.remove(t);
    }
    protected void notifyListeners () {
        if (tempChangeListeners == null)
            return;
        Vector v;
        synchronized (this){
            v = tempChangeListeners;
        }
        TempChangedEvent e;
        for (Object temp : tempChangeListeners) {
            TempChangeListener client =  ( TempChangeListener)temp;
            e = new TempChangedEvent(this,this.currentTemp);
            client.tempChanged( e);
        }
    }
    public TempChangeListener[] getTempChangeListeners(){
        TempChangeListener[] temp ;
        int size = tempChangeListeners.size();
        temp = new TempChangeListener[size];
        for ( int i =0; i < size; i++){
            temp[i] = ( TempChangeListener)tempChangeListeners.elementAt(i);
        }
        return temp;
    }
}


class TempChangedEvent extends EventObject{
    protected double temperature ;
    TempChangedEvent ( Object source, double temperature){
        super(source);

        this.temperature = temperature;
    }
    public double getTemperature(){
        return temperature;
    }
}


interface TempChangeListener extends EventListener {
    public void tempChanged(TempChangedEvent evt);
}

class Thermometer implements TempChangeListener{
    double temperature;
    public void tempChanged( TempChangedEvent e){
        this.temperature = e.getTemperature();
        System.out.println("Temperature changed to : " + e.getTemperature());
        System.out.println(" source of the event : " + e.getSource());
    }
    Thermometer ( double temperature ) {
        this.temperature = temperature;
    }
}
public class EventModelExample {
    public static void main(String[] args) {
        Temperature  temp = new Temperature();
        Thermometer thermometer = new Thermometer(22.2);
        temp.addTempChangeListeners( thermometer);
        Thermometer thermometer2 = new Thermometer(44);
        temp.addTempChangeListeners( thermometer2);
        temp.incrementBy( 2);
        temp.decrementBy(1);
        System.out.println(" Listeners object : ");
        TempChangeListener[] t = temp.getTempChangeListeners();
        for ( int i =0; i < t.length; i++){
            System.out.println( t.toString());
        }
    }

}
