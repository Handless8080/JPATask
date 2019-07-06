import entities.Student;
import entities.StudentResult;
import entities.embedded_keys.StudentResultKey;
import org.junit.Test;
import services.StudentResultService;
import services.StudentService;

import java.time.LocalDate;

public class StudentServiceTest {
    private StudentService studentService = new StudentService();
    private StudentResultService studentResultService = new StudentResultService();

    @Test
    public void test() {
        Student student = studentService.get(1);

        StudentResult result = new StudentResult();
        StudentResultKey key = new StudentResultKey();

        key.setStudentId(1);
        key.setTrainingCourseId(3);

        result.setId(key);
        result.setDate(LocalDate.now());
        result.setResult((byte) 4);
        result.setNote("some text");

        studentResultService.addOrUpdate(result);

        student = studentService.get(student.getId());
    }
}