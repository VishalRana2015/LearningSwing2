package formattedTextFiled;

import javax.swing.text.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

class CombinationFormatter extends DefaultFormatter{
    @Override
    public Object stringToValue(String string) throws ParseException {
        if ( string == null)
            return null;
        int [] array;
        String[] sa = string.split("-");
        array = new int[ sa.length];

        for (int i =0; i < sa.length; i ++){
            try{
                array[i] = Integer.parseInt( sa[i]);
            }
            catch( Exception e){
                System.out.println(" Exception thrown : "+e.getMessage());
            }
        }
        return array;
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        StringBuffer sb = new StringBuffer();
        if ( value == null)
            return null;

        try {
            int[] array = (int[]  ) value;
            sb.append( ((Integer)array[0] ) .toString());
            for ( int i =1; i < array.length; i++){
                sb.append("-");
                sb.append( ((Integer)array[i]).toString());
            }

        }
        catch(  Exception e){
            System.out.println( " Exception thrown : "+e.getMessage());
        }
        return sb.toString();
    }
    public static void main( String[] args){
        JFormattedTextField field1 = new JFormattedTextField( new CombinationFormatter());
        JFormattedTextField field2 = new JFormattedTextField( new CombinationFormatter());
        int [] comb1 = { 22, 33 ,44};
        int [] comb2 = { 55, 66, 77};
        field1.setValue(comb1);
        field2.setValue( comb2);
        JPanel panel = new JPanel();
        panel.add( new JLabel( "Change the Combination from : "));
        panel.add( field1);
        panel.add( new JLabel ( " to " ));
        panel.add( field2);
        JFrame frame = new JFrame( "Default Formatter Example");
        frame.setSize( 500, 500);
        frame.setLocation( 50, 0 ) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // MaskFormatter mf = (MaskFormatter)field1.getFormatter();
        DefaultFormatter df = (DefaultFormatter)field1.getFormatter();

        field1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( " is edit valid : "+field1.isEditValid());
                System.out.println(" Formatter : "+ field1.getFormatter().toString());

            }
        });
        field1.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        DefaultFormatter formatter = ( DefaultFormatter) field1.getFormatter();
        formatter.setCommitsOnValidEdit(false);
        formatter.setOverwriteMode( false);

        MaskFormatter mf = new MaskFormatter();
       try{
           mf.setMask("AAAAA");

       }
       catch(Exception e){
           System.out.println(" Exception thrown : "+e.getMessage());
       }
        mf.setPlaceholder("-----");
        JFormattedTextField field = new JFormattedTextField( new DefaultFormatter());
        panel.add( field);
        frame.setContentPane(panel);
        frame.setVisible(true);
        mf.install(field);
    }
}