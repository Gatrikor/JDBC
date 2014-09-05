import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 05.09.2014.
 */
public class StudentDialog extends JDialog implements ActionListener {

    private Student m_Student;
    private boolean m_Accepted;

    private JTextField m_txtName;
    private JTextField m_txtCourse;
    private JTextField m_txtGroup;
    private JTextField m_txtMark;

    private JLabel m_lblName;
    private JLabel m_lblCourse;
    private JLabel m_lblGroup;
    private JLabel m_lblMark;

    private JButton m_btnOK;
    private JButton m_btnCancel;

    public StudentDialog( MyFrame parentFrame ) {
        super( parentFrame, ModalityType.APPLICATION_MODAL );
        //Инициализация элементов диалога
        m_Accepted = false;

        m_lblName = new JLabel( "Name" );
        m_lblCourse = new JLabel( "Course" );
        m_lblGroup = new JLabel( "Group" );
        m_lblMark = new JLabel( "Mark" );

        m_txtName = new JTextField( "" );
        m_txtCourse = new JTextField( "" );
        m_txtGroup = new JTextField( "" );
        m_txtMark = new JTextField( "" );

        m_btnOK = new JButton ( "OK" );
        m_btnCancel = new JButton ( "Cancel" );

        //Назначение слушателей

        m_btnOK.addActionListener( this );
        m_btnCancel.addActionListener( this );

        //Добавление элементов на диалог
        setLayout(new GridLayout(5, 2));

        getContentPane().add( m_lblName );
        getContentPane().add(m_txtName);

        getContentPane().add( m_lblCourse );
        getContentPane().add(m_txtCourse);

        getContentPane().add(m_lblGroup);
        getContentPane().add( m_txtGroup );

        getContentPane().add( m_lblMark );
        getContentPane().add( m_txtMark );

        getContentPane().add( m_btnOK );
        getContentPane().add( m_btnCancel );

        pack();
    }

    @Override
    public void actionPerformed( ActionEvent event ) {
        if ( event.getSource() == m_btnOK ) {
            m_Accepted = true;
            m_Student = new Student(
                    m_txtName.getText(),
                    Integer.parseInt( m_txtCourse.getText() ),
                    Integer.parseInt( m_txtGroup.getText() ),
                    Float.parseFloat( m_txtMark.getText() )
            );
        }
        if ( event.getSource() == m_btnCancel ) {
            m_Accepted = false;
        }
        setVisible( false );
        dispose();
    }

    public boolean accepted() {
        return m_Accepted;
    }

    public Student getStudent() {
        return m_Student;
    }
}
