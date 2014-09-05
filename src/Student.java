/**
 * Created by Admin on 05.09.2014.
 */
public class Student {

    private String m_Name;
    private int m_Course;
    private int m_Group;
    private float m_Mark;

    public Student( String in_name, int in_course, int in_group, float in_mark ){
        setName( in_name );
        setCourse( in_course );
        setGroup( in_group );
        setMark( in_mark );
    }

    public String getName() {
        return m_Name;
    }

    public void setName(String in_Name) {
        this.m_Name = in_Name;
    }

    public int getCourse() {
        return m_Course;
    }

    public void setCourse(int in_Course) {
        this.m_Course = in_Course;
    }

    public int getGroup() {
        return m_Group;
    }

    public void setGroup(int in_Group) {
        this.m_Group = in_Group;
    }

    public float getMark() {
        return m_Mark;
    }

    public void setMark(float in_mark) {
        this.m_Mark = in_mark;
    }
}
