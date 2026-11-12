
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "employees.txt";

    // Add employee
    public static void addEmployee() {

        try {
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(sc.nextLine());

            if (id <= 0) {
                throw new IllegalArgumentException("ID must be positive.");
            }

            // Check duplicate ID
            for (Employee emp : employees) {
                if (emp.getId() == id) {
                    throw new IllegalArgumentException(
                            "Employee ID already exists.");
                }
            }

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Department: ");
            String department = sc.nextLine().trim();

            if (name.isEmpty() || department.isEmpty()
                    || name.contains("|") || department.contains("|")) {
                throw new IllegalArgumentException(
                        "Invalid name or department.");
            }

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            if (!Double.isFinite(salary) || salary <= 0) {
                throw new IllegalArgumentException(
                        "Salary must be a positive valid number.");
            }

            Employee emp = new Employee(id, name, department, salary);

            employees.add(emp);

            System.out.println("Employee added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display employees
    public static void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.println("\nEmployee Records");

        for (Employee emp : employees) {
            emp.display();
        }
    }

    // Save employees to file
    public static void saveEmployees() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Employee emp : employees) {

                writer.write(
                        emp.getId() + "|" +
                        emp.getName() + "|" +
                        emp.getDepartment() + "|" +
                        emp.getSalary()
                );

                writer.newLine();
            }

            System.out.println("Employee records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load employees from file
    public static void loadEmployees() {

        ArrayList<Employee> loadedEmployees = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length != 4) {
                    System.out.println("Skipping invalid record: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String department = data[2];
                    double salary = Double.parseDouble(data[3]);

                    if (id <= 0 || name.trim().isEmpty()
                            || department.trim().isEmpty()
                            || !Double.isFinite(salary) || salary <= 0) {
                        throw new IllegalArgumentException();
                    }

                    boolean duplicate = false;

                    for (Employee emp : loadedEmployees) {
                        if (emp.getId() == id) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Skipping duplicate ID: " + id);
                        continue;
                    }

                    loadedEmployees.add(
                            new Employee(id, name, department, salary));

                } catch (
                         IllegalArgumentException e) {
                    System.out.println("Skipping invalid record: " + line);
                }
            }

            employees.clear();
            employees.addAll(loadedEmployees);

            System.out.println("Employee records loaded successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Employee file not found. Add employees first.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Save Employees to File");
            System.out.println("4. Load Employees from File");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        addEmployee();
                        break;

                    case 2:
                        displayEmployees();
                        break;

                    case 3:
                        saveEmployees();
                        break;

                    case 4:
                        loadEmployees();
                        break;

                    case 5:
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }
}
