package JavaBean;
import java.util.*;
import java.lang.reflect.Method;

// This adapter class is intended to be created for
class GenericTemperatureAdapter implements TempChangeListener  {
    protected Thermometer2 target;
    protected Class targetClass;
    protected Hashtable mappingTable = new Hashtable();
    GenericTemperatureAdapter( Thermometer2 thermtemp){
        // temp is the listener object for which this instance of adapter class is being created for.
        target = thermtemp;
        targetClass = thermtemp.getClass();
    }
    public void registerEventHandler( Temperature temp , String methodName){
        Method method;
        // since this listener has only one method to implement
        // Therefore it is easy to determine its parameter list or simply we can fix this parameter list.
        Class [] params = {JavaBean.TempChangedEvent.class};


        try{
            method = (Method)(targetClass.getMethod(methodName,params));


            mappingTable.put(temp,method);
        }
        catch( NoSuchMethodException exp){
            System.out.println("No Such Exception thrown.");
        }
        catch( Exception e){
            System.out.println( "Exception throws : "+e.getMessage());
        }
    }
    public void unregisterEventHandler( Temperature temp){
        mappingTable.remove(temp);
    }
    public void tempChanged( TempChangedEvent e){

            Method method;
            //Class [] methodparams = { JavaBean.TempChangedEvent.class};

            try {
                Object [] params = { e};
                method = (Method)mappingTable.get( e.getSource());
                method.invoke(target,e);
            }
            catch( Exception exp) {
                System.out.println("Exception thrown method not matched : " + exp.getMessage());
            }
    }
}
class Thermometer2 {

  public void temperature1Changed( TempChangedEvent e ){
      System.out.println("Temperature 1 Changed called");
      System.out.println(" Temperature changed to "+ e.temperature);

  }
  public void temperature2Changed( TempChangedEvent e){
      System.out.println( " Temperature 2 Changed called ");
      System.out.println ( " Temperature Changed to " +e.temperature);
  }
}
public class AdapterExample{
    public static void main(String[] args) {
        Temperature temperature1 = new Temperature(20);
        Temperature temperature2 = new Temperature( 40);
        Thermometer2 thermometer = new Thermometer2();
        GenericTemperatureAdapter adapter = new GenericTemperatureAdapter(thermometer);
        temperature1.addTempChangeListeners(adapter);
        temperature2 . addTempChangeListeners(adapter);
        adapter.registerEventHandler(temperature1,"temperature1Changed");
        adapter.registerEventHandler(temperature2,"temperature2Changed");

        temperature1.incrementBy(2);
        temperature2.incrementBy(5);
    }
}