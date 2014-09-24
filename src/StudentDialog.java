import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 05.09.2014.
 */
public class StudentDialog extends JDialog implements ActionListener {

    private Student myStudent;
    private boolean isAccepted;

    private JTextField txtName;
    private JTextField txtCourse;
    private JTextField txtGroup;
    private JTextField txtMark;

    private JLabel lblName;
    private JLabel lblCourse;
    private JLabel lblGroup;
    private JLabel lblMark;

    private JButton btnOK;
    private JButton btnCancel;

    public StudentDialog( MyFrame parentFrame ) {
        super( parentFrame, ModalityType.APPLICATION_MODAL );
        //Инициализация элементов диалога
        isAccepted = false;

        lblName = new JLabel( "Name" );
        lblCourse = new JLabel( "Course" );
        lblGroup = new JLabel( "Group" );
        lblMark = new JLabel( "Mark" );

        txtName = new JTextField( "" );
        txtCourse = new JTextField( "" );
        txtGroup = new JTextField( "" );
        txtMark = new JTextField( "" );

        btnOK = new JButton ( "OK" );
        btnCancel = new JButton ( "Cancel" );

        //Назначение слушателей

        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);

        //Добавление элементов на диалог
        setLayout(new GridLayout(5, 2));

        getContentPane().add(lblName);
        getContentPane().add(txtName);

        getContentPane().add(lblCourse);
        getContentPane().add(txtCourse);

        getContentPane().add(lblGroup);
        getContentPane().add(txtGroup);

        getContentPane().add(lblMark);
        getContentPane().add(txtMark);

        getContentPane().add(btnOK);
        getContentPane().add(btnCancel);

        pack();
    }

    @Override
    public void actionPerformed( ActionEvent event ) {
        if ( event.getSource() == btnOK) {
            isAccepted = true;
            myStudent = new Student(
                    txtName.getText(),
                    Integer.parseInt( txtCourse.getText() ),
                    Integer.parseInt( txtGroup.getText() ),
                    Float.parseFloat(txtMark.getText())
            );
        }
        if ( event.getSource() == btnCancel) {
            isAccepted = false;
        }
        setVisible( false );
        dispose();
    }

    public boolean accepted() {
        return isAccepted;
    }

    public Student getStudent() {
        return myStudent;
    }
}
