package mvcpattern;

public class MVCPatternTest {
    public static void main(String[] args) {
        Student student = new Student("Alice", "S101", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        System.out.println("\n--- Updating Student Details ---\n");

        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        controller.updateView();
    }
}
