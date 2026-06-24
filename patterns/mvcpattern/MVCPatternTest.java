package mvcpattern;

public class MVCPatternTest {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("Alice", "S101", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        System.out.println("\n--- Updating Student Details ---\n");

        // Update student details via controller
        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        // Display updated details
        controller.updateView();
    }
}
