package Development_Student_System;
import java.util.Scanner;
import System_Student.Student;

public class Update_Student {

    private final Creat_Student creat_student = new Creat_Student();

    protected Update_Student(){}

    public void update_student_context(int number, Development development,
                                       Scanner scanner, Student[] student)
    {
        development.clear();
        System.out.println("1. ѧ��ѧ���޸�");
        System.out.println("2. ѧ�������޸�");
        System.out.println("3. ѧ�������޸�");
        System.out.println("4. ѧ���꼶�޸�");
        System.out.println("5. ѧ���༶�޸�");
        System.out.println("6. ѧ����λ���޸�");
        System.out.print("��ѡ��");
        if (scanner.hasNextInt()){
            int student_select = scanner.nextInt();
            if (!(student_select <= 0) && !(student_select >= 7)){
                System.out.print("�Ƿ��޸ģ�1.y 2.n (һ��ѡ���޸ľͱ����޸�, �޷���ͷ)��");
                String yes_no = scanner.next();
                if ("y".equalsIgnoreCase(yes_no)) {
                    System.out.println("����Ϊ����ת....");
                    development.time();
                    development.clear();
                    switch (student_select) {
                        case 1:
                            System.out.println("��ǰѧ��ѧ�ţ�" + student[number].getID());
                            this.creat_student.set_student_ID_name_age_grade_class_seat(
                                    scanner, student, number
                            );
                            break;
                        case 2:
                            System.out.println("��ǰѧ��������" + student[number].getName());
                            this.creat_student.set_student_id_NAME_age_grade_class_seat(
                                    scanner, number, student
                            );
                            break;
                        case 3:
                            System.out.println("��ǰѧ�������䣺" + student[number].getAge());
                            this.creat_student.set_student_id_name_AGE_grade_class_seat(
                                    number, scanner, student
                            );
                            break;
                        case 4:
                            System.out.println("��ǰѧ�����꼶��" + student[number].getGrade());
                            this.creat_student.set_student_id_name_age_GRADE_class_seat(
                                    number, student, scanner
                            );
                            break;
                        case 5:
                            System.out.println("��ǰѧ���İ༶��" + student[number].getClass_grade());
                            this.creat_student.set_student_id_name_age_grade_CLASS_seat(
                                    student, number, scanner
                            );
                            break;
                        case 6:
                            System.out.println("��ǰѧ������λ�ţ�" + student[number].getSeat());
                            this.creat_student.set_student_id_name_age_grade_class_SEAT(
                                    student, scanner, number
                            );
                            break;
                    }
                    System.out.println("�޸ĳɹ���(�����Զ�����).....");
                }else {
                    System.out.println("���ڷ���....");
                }
            }else {
                System.err.println("�����½���....");
            }
        }else {
            String next = scanner.next();
            System.err.println(next + " �������֣������½���...");
        }
    }

    // �޸�ѧ����Ϣ���ڲ�С����
    public void update_student_applet(int index, Scanner scanner,
                                      Development development, Student[] student)
    {
        while (true) {
            System.out.print("������Ҫ�޸ĵ����(�����޸�����exit�˳���Ϣ�޸�ģʽ)��");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == 0)continue;
                if (number <= index){
                    number -= 1; // ���������ֵ
                    this.update_student_context(number, development, scanner, student);
                }else {
                    System.err.println("��ǰ¼ȡѧ����Ϣ����Ϊ��" + index +
                            "����������Ѿ������˷�Χ������������");
                    Development.enter_exit();
                    return;
                }
            } else {
                String next = scanner.next();
                if ("exit".equalsIgnoreCase(next)){
                    System.out.println("�����˳�....");
                    development.time();
                    development.clear();
                    break;
                }
                System.err.println(next + " ���ǺϷ������");
            }
            development.time();
            development.clear();
        }
    }
}
