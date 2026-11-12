


class Student {

   
    String name;
    int rollNo;
    String department;
    double marks;

    void displayInfo() {
        System.out.println("Student Information");
        System.out.println("-------------------");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Department : " + department);
        System.out.println("Marks      : " + marks);
    }
}

public class StudentImplementation {
    public static void main(String[] args) {

      
        Student student1 = new Student();

       
        student1.name = "Arthi";
        student1.rollNo = 101;
        student1.department = "Computer Science";
        student1.marks = 90.5;

        student1.displayInfo();
    }
}
