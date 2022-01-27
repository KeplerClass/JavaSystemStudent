package Development_Student_System;
import System_Student.Student;
import java.util.Scanner;

public class Creat_Student {

    protected Creat_Student(){}

    /**
     函数名根据大小写判断功能实现的是什么，比如: ID就是学号
     */
    public void set_student_ID_name_age_grade_class_seat
            (Scanner scanner, Student[] student, int index)
    {
        while (true) {
            System.out.print("请输入学生学号：");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                boolean flag = true;
                for (Student num : student){
                    if (num.getID() == number) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    student[index].setID(number);
                    break;
                }else {
                    System.out.println(String.format("%d 已经存在", number));
                }
            }else {
                String next = scanner.next();
                System.out.println(String.format(
                        "%s 不是一个合法的id", next
                ));
            }
        }
    }

    public void set_student_id_NAME_age_grade_class_seat
            (Scanner scanner, int index, Student[] student)
    {
        while (true) {
            System.out.print("请输入学生姓名：");
            String name = scanner.next();
            boolean flag = true;
            for (Student stu : student){
                if (name.equalsIgnoreCase(stu.getName())){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                student[index].setName(name);
                break;
            }else {
                System.out.println(String.format("%s 已存在", name));
            }
        }
    }

    public void set_student_id_name_AGE_grade_class_seat
            (int index, Scanner scanner, Student[] student)
    {
        while (true) {
            System.out.print("请输入学生年龄：");
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                if (age > 0 && age < 101) {
                    student[index].setAge(age);
                    break;
                }else {
                    System.err.println(String.format("%d 不是合法的年龄", age));
                }
            }else {
                String next = scanner.next();
                System.out.println(String.format(
                        "%s 不是一个合法的年龄", next
                ));
            }
        }
    }

    public void set_student_id_name_age_GRADE_class_seat
            (int index, Student[] student, Scanner scanner)
    {
        System.out.print("请输入学生年级：");
        String grade = scanner.next();
        student[index].setGrade(grade);
    }

    public void set_student_id_name_age_grade_CLASS_seat
            (Student[] student, int index, Scanner scanner)
    {
        System.out.print("请输入学生班级：");
        String class_grade = scanner.next();
        student[index].setClass_grade(class_grade);
    }

    public void set_student_id_name_age_grade_class_SEAT
            (Student[] student, Scanner scanner, int index)
    {
        while (true) {
            System.out.print("请输入学生座位号：");
            if (scanner.hasNextInt()) {
                int seat = scanner.nextInt();
                boolean flag = true;
                for (Student num : student){
                    if (num.getSeat() == seat) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    student[index].setSeat(seat);
                    break;
                }else {
                    System.out.println(String.format("%d 已经存在", seat));
                }
            }else {
                String next = scanner.next();
                System.out.println(String.format(
                        "%s 不是一个合法的数字", next
                ));
            }
        }
    }

    // 创建学生信息的内部小程序
    public void creat_student_applet(int index, Scanner scanner,
                                      Student[] student, Development development)
    {
        // 学号
        this.set_student_ID_name_age_grade_class_seat(scanner, student, index);

        // 姓名
        this.set_student_id_NAME_age_grade_class_seat(scanner, index, student);

        //年龄
        this.set_student_id_name_AGE_grade_class_seat(index, scanner, student);

        // 年级
        this.set_student_id_name_age_GRADE_class_seat(index, student, scanner);

        // 班级
        this.set_student_id_name_age_grade_CLASS_seat(student, index, scanner);

        // 座位号
        this.set_student_id_name_age_grade_class_SEAT(student, scanner, index);

        System.out.println("录入成功");
    }
}
