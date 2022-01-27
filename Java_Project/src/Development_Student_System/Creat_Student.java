package Development_Student_System;
import System_Student.Student;
import java.util.Scanner;

public class Creat_Student {

    protected Creat_Student(){}

    /**
     ���������ݴ�Сд�жϹ���ʵ�ֵ���ʲô������: ID����ѧ��
     */
    public void set_student_ID_name_age_grade_class_seat
            (Scanner scanner, Student[] student, int index)
    {
        while (true) {
            System.out.print("������ѧ��ѧ�ţ�");
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
                    System.out.println(String.format("%d �Ѿ�����", number));
                }
            }else {
                String next = scanner.next();
                System.out.println(String.format(
                        "%s ����һ���Ϸ���id", next
                ));
            }
        }
    }

    public void set_student_id_NAME_age_grade_class_seat
            (Scanner scanner, int index, Student[] student)
    {
        while (true) {
            System.out.print("������ѧ��������");
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
                System.out.println(String.format("%s �Ѵ���", name));
            }
        }
    }

    public void set_student_id_name_AGE_grade_class_seat
            (int index, Scanner scanner, Student[] student)
    {
        while (true) {
            System.out.print("������ѧ�����䣺");
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                if (age > 0 && age < 101) {
                    student[index].setAge(age);
                    break;
                }else {
                    System.err.println(String.format("%d ���ǺϷ�������", age));
                }
            }else {
                String next = scanner.next();
                System.out.println(String.format(
                        "%s ����һ���Ϸ�������", next
                ));
            }
        }
    }

    public void set_student_id_name_age_GRADE_class_seat
            (int index, Student[] student, Scanner scanner)
    {
        System.out.print("������ѧ���꼶��");
        String grade = scanner.next();
        student[index].setGrade(grade);
    }

    public void set_student_id_name_age_grade_CLASS_seat
            (Student[] student, int index, Scanner scanner)
    {
        System.out.print("������ѧ���༶��");
        String class_grade = scanner.next();
        student[index].setClass_grade(class_grade);
    }

    public void set_student_id_name_age_grade_class_SEAT
            (Student[] student, Scanner scanner, int index)
    {
        while (true) {
            System.out.print("������ѧ����λ�ţ�");
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
                    System.out.println(String.format("%d �Ѿ�����", seat));
                }
            }else {
                String next = scanner.next();
                System.out.println(String.format(
                        "%s ����һ���Ϸ�������", next
                ));
            }
        }
    }

    // ����ѧ����Ϣ���ڲ�С����
    public void creat_student_applet(int index, Scanner scanner,
                                      Student[] student, Development development)
    {
        // ѧ��
        this.set_student_ID_name_age_grade_class_seat(scanner, student, index);

        // ����
        this.set_student_id_NAME_age_grade_class_seat(scanner, index, student);

        //����
        this.set_student_id_name_AGE_grade_class_seat(index, scanner, student);

        // �꼶
        this.set_student_id_name_age_GRADE_class_seat(index, student, scanner);

        // �༶
        this.set_student_id_name_age_grade_CLASS_seat(student, index, scanner);

        // ��λ��
        this.set_student_id_name_age_grade_class_SEAT(student, scanner, index);

        System.out.println("¼��ɹ�");
    }
}
