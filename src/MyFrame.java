import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ShestakAM
 * Date: 21.12.13
 * Time: 15.12
 * To change this template use File | Settings | File Templates.
 */
public class MyFrame extends JFrame implements ActionListener {

    private StudentDialog m_AddDialog;
    private JButton m_btnAddStudent;
    private JTable m_StudentTable;
    //private JTextField myText; //так и не понял зачем оно

    private static String[] m_TableHeader = { "Name", "Course", "Group", "Mark" };
    private DefaultTableModel m_TableModel = new DefaultTableModel( null, m_TableHeader ) {
        @Override
        public Class< ? > getColumnClass( int col ) {
            return getValueAt( 0, col ).getClass();
        }
    };

    public MyFrame(){
        //myText = new JTextField();
        //Инициализация элементов формы
        /*
        m_TableModel.addRow( new Object[] {
                (String) "ivanov",
                (int) 1,
                (int) 1,
                (float) 8.9
        });
        */
        m_StudentTable = new JTable( m_TableModel );
        m_btnAddStudent = new JButton( "Add" );

        //как по мне слишком очевидные коменты и будем пимать коменты на инглише
        //Назначение слушателей
        m_btnAddStudent.addActionListener( this );

        //Добавление элементов на форму
        this.setLayout( new BorderLayout() );

        getContentPane().add( m_StudentTable.getTableHeader(), BorderLayout.NORTH );
        getContentPane().add( m_StudentTable, BorderLayout.CENTER );
        getContentPane().add( m_btnAddStudent, BorderLayout.SOUTH );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if ( event.getSource() == m_btnAddStudent ) {
            m_AddDialog = new StudentDialog( this );
            m_AddDialog.setVisible( true );
            if ( m_AddDialog.accepted() ) {
                Student in_Student = m_AddDialog.getStudent();
                m_TableModel.addRow( new Object[] {
                        (String) in_Student.getName(),
                        (int) in_Student.getCourse(),
                        (int) in_Student.getGroup(),
                        (float) in_Student.getMark()
                });
            }
        }
    }
}
