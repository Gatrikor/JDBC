/**
 * Created by Admin on 05.09.2014.
 */
public class Student {

    private String name;
    private int course;
    private int group;
    private float mark;

    public Student( String in_name, int in_course, int in_group, float in_mark ){
        setName( in_name );
        setCourse( in_course );
        setGroup( in_group );
        setMark( in_mark );
    }

    public String getName() {
        return name;
    }

    public void setName(String in_Name) {
        this.name = in_Name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int in_Course) {
        this.course = in_Course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int in_Group) {
        this.group = in_Group;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float in_mark) {
        this.mark = in_mark;
    }
}
