import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


/**
 * Created with IntelliJ IDEA.
 * User: ShestakAM
 * Date: 21.12.13
 * Time: 15.12
 * To change this template use File | Settings | File Templates.
 */
public class MyFrame extends JFrame implements ActionListener {

    private StudentDialog addDialog;
    private JButton btnAddStudent;
    private JTable studentTable;
    private Connection databaseConnection;
    //private JTextField myText; //так и не понял зачем оно

    private static String[] m_TableHeader = { "Name", "Course", "Group", "Mark" };
    private DefaultTableModel m_TableModel = new DefaultTableModel( null, m_TableHeader ) {
        @Override
        public Class< ? > getColumnClass( int col ) {
            return getValueAt( 0, col ).getClass();
        }
    };

    public MyFrame(){

        studentTable = new JTable( m_TableModel );
        btnAddStudent = new JButton( "Add" );

        //JDBC initialisatin
        databaseConnection = null;
        String url = "jdbc:mysql://localhost:3306/univer";
        String name = "root";
        String password = "12345678";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver ok ");
            databaseConnection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
            /*String query = "select * from test";
            PreparedStatement preStatement = databaseConnection.prepareStatement(query);
            ResultSet resultSet = preStatement.executeQuery();

            while(resultSet.next()) {

            }
*/


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //как по мне слишком очевидные коменты и будем пимать коменты на инглише
        //Назначение слушателей
        btnAddStudent.addActionListener(this);

        //Добавление элементов на форму
        this.setLayout(new BorderLayout());

        getContentPane().add( studentTable.getTableHeader(), BorderLayout.NORTH );
        getContentPane().add(studentTable, BorderLayout.CENTER );
        getContentPane().add(btnAddStudent, BorderLayout.SOUTH );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if ( event.getSource() == btnAddStudent) {

            addDialog = new StudentDialog( this );
            addDialog.setVisible(true);
            if ( addDialog.accepted() ) {
                Student inStudent = addDialog.getStudent();
                m_TableModel.addRow( new Object[] {
                        (String) inStudent.getName(),
                        (int) inStudent.getCourse(),
                        (int) inStudent.getGroup(),
                        (float) inStudent.getMark()
                });
                try {
                    PreparedStatement ps =
                            databaseConnection.prepareStatement("insert into students(name,course,gr,mark) values(?,?,?,?)");

                    ps.setString(1,inStudent.getName());
                    ps.setInt(2,inStudent.getCourse());
                    ps.setInt(3,inStudent.getGroup());
                    ps.setFloat(4,inStudent.getMark());
                    ps.executeUpdate();


                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
