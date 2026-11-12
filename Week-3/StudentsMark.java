
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class StudentsMark {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            int mark = sc.nextInt();

            marks.add(mark);
        }

       
        System.out.println("\nStudent Marks: " + marks);

        
        int highest = Collections.max(marks);
        int lowest = Collections.min(marks);

        
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);

        sc.close();
    }
}
