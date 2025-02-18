import java.util.Scanner;

class CourseFullException extends Exception 
{
    public CourseFullException(String message) 
    {
        super(message);
    }
}
class PrerequisiteNotMetException extends Exception 
{
    public PrerequisiteNotMetException(String message)
    {
        super(message);
    }
}
class UniversityEnrollment 
{
    private static final int MAX_COURSE_CAPACITY = 30;
    private int enrolledStudents = 0;
    public void enrollStudent(String course, boolean prerequisiteCompleted) throws CourseFullException, PrerequisiteNotMetException 
    {
        if (!prerequisiteCompleted) 
        {
            throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete Core Java before enrolling in " + course + ".");
        }
        if (enrolledStudents >= MAX_COURSE_CAPACITY) 
        {
            throw new CourseFullException("Error: CourseFullException - Enrollment limit reached for " + course + ".");
        }
        enrolledStudents++;
        System.out.println("Enrollment successful in " + course);
    }
}
public class UniEnroll 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        UniversityEnrollment enrollment = new UniversityEnrollment();
        System.out.print("Enroll in Course: ");
        String course = scanner.nextLine();
        System.out.print("Prerequisite completed? (true/false): ");
        boolean prerequisiteCompleted = scanner.nextBoolean();
        try 
        {
            enrollment.enrollStudent(course, prerequisiteCompleted);
        } 
        catch (CourseFullException | PrerequisiteNotMetException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
