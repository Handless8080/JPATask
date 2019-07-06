package entities.embedded_keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentResultKey implements Serializable {
    private Integer studentId;
    private Integer trainingCourseId;

    @Column(name = "student_id", nullable = false)
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Column(name = "training_course_id", nullable = false)
    public Integer getTrainingCourseId() {
        return trainingCourseId;
    }

    public void setTrainingCourseId(Integer trainingCourseId) {
        this.trainingCourseId = trainingCourseId;
    }
}