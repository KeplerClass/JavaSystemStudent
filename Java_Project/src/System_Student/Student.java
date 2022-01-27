package System_Student;

public class Student {

    public Student(){}
    private int ID; // 学生学号
    private String name; // 学生姓名
    private int age; // 学生年龄
    private String grade; // 学生年级
    private String class_grade; // 学生班级
    private int seat; // 学生座位号

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return this.ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade(){
        return this.grade;
    }

    public void setClass_grade(String class_grade){
        this.class_grade = class_grade;
    }

    public String getClass_grade(){
        return this.class_grade;
    }

    public void setSeat(int seat){
        this.seat = seat;
    }

    public int getSeat(){
        return this.seat;
    }
}

