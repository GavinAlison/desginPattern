package prototype;

// 基本类型
public class Student implements Cloneable {
    private String stuName;
    private String stuSex;
    private int stuAge;
    private String stuMajor;
    private String stuCollege;
    private String stuUniversity;


    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public void setStuUniversity(String stuUniversity) {
        this.stuUniversity = stuUniversity;
    }

    public String getStuName() {
        return (this.stuName);
    }

    public String getStuSex() {
        return (this.stuSex);
    }

    public int getStuAge() {
        return (this.stuAge);
    }

    public String getStuMajor() {
        return (this.stuMajor);
    }

    public String getStuCollege() {
        return (this.stuCollege);
    }

    public String getStuUniversity() {
        return (this.stuUniversity);
    }

    public Student clone() {
        Student cpStudent = null;
        try {
            cpStudent = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return cpStudent;
    }
}

