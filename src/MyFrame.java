import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created with IntelliJ IDEA.
 * User: ShestakAM
 * Date: 21.12.13
 * Time: 15.12
 * To change this template use File | Settings | File Templates.
 */
public class MyFrame extends JFrame  {

    JTable myTable;
    JTextField myText;

    private static String[] header = {"name", "course", "group", "mark"};
    private DefaultTableModel dtm = new DefaultTableModel(null, header) {
        @Override
        public Class<?> getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    };

    public MyFrame(){
        myText = new JTextField();
        myTable = new JTable(dtm);
        getContentPane().add(myTable);
        dtm.addRow(new Object[]{
                (String)"ivanov",
                (int)1,
                (int)1,
                (float)8.9
        });
    }
    public class Dialog extends JDialog {


    }
}
