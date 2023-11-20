package JavaBean;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.beans.*;
import java.util.*;
// The object of this class is the source of event for bound properties
class Temperature2{
    protected double temperature = 22.2; // we are going to make this property as a bound property
    Vector propertyChangeListeners = new Vector();
    Temperature2( double temperature){
        this.temperature = temperature;
    }
    public void incrementBy(double t){
        Double old= this.temperature;
        this.temperature += t;
        notifyPropertyListeners("TempChanged", (Double)this.temperature, (Double)old);
    }
    public void decrementBy( double t){
        Double old = this.temperature;
        this.temperature -= t;
        notifyPropertyListeners("tempChanged", (Double)this.temperature, (Double)old);
    }
    public void addPropertyChangeListener( PropertyChangeListener l){
        if( !propertyChangeListeners.contains(l) )
            propertyChangeListeners.add(l);
    }
    public void removePropertyChangeListener( PropertyChangeListener l){
        if ( propertyChangeListeners.contains(l))
            propertyChangeListeners.remove(l);
    }
    public void notifyPropertyListeners(String propertyName, Object newValue, Object oldValue){
        if (propertyChangeListeners == null)
            return;

        PropertyChangeListener p ;
        Vector temp;
        synchronized(this){
            temp = this.propertyChangeListeners;
        }
        // Declaring an object of PropertychangeEvent
        PropertyChangeEvent  evt = new PropertyChangeEvent(this,propertyName,oldValue,newValue);

        int size  =  temp.size();
        for ( int i =0; i < size;i ++){
            p = (PropertyChangeListener) temp.elementAt(i);
            // Passing this event object to all propertyChangeListenrs
            p.propertyChange(evt);
        }
    }
}

class Thermometer3  implements PropertyChangeListener{
    protected double temperature;
    Thermometer3( double temperature){
        this.temperature = temperature;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Event Occurred");
    }
}
public class BoundPropertyExample {
    public static void main(String[] args) {
        Temperature2 temp = new Temperature2(22.2);
        Temperature2  temp2 = new Temperature2( 44.0);
        Thermometer3 thermometer = new Thermometer3(20.2);
        temp.addPropertyChangeListener( thermometer);
        temp.incrementBy(2);


    }
}
