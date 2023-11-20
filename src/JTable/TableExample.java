package JTable;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class TableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocation(50,0);
        File sourcefile = new File("src");
        File[] files = sourcefile.listFiles();
        String[] header = { "Directory?","File Name", "Read", "Write", "Execute","LastModified"};
        int size = files.length;
        Object[][] stats = new Object[size][6];
        for ( int i =0; i < files.length; i++){
            stats[i][0] = new Boolean(files[i].isDirectory());
            stats[i][1] = new String(files[i].getName());
            stats[i][2] = new Boolean((files[i].canRead()));
            stats[i][3] = new Boolean(files[i].canWrite());
            stats[i][4] = new Boolean(files[i].canExecute());
            stats[i][5] = new Date(files[i].lastModified());
        }

        JTable table = new JTable(stats, header);
        table.getTableHeader().setEnabled(true);
        frame.setContentPane(table);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setColumnSelectionAllowed(true);
        table.addColumnSelectionInterval(1,3);
        frame.repaint();
        table.setColumnSelectionAllowed(true);
        System.out.println(table.getColumnCount());
        System.out.println(table.getRowCount());

        frame.setVisible(true);
    }

}
