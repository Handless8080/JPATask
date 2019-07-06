package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam")
public class Exam {
    private Integer id;
    private Date date;
    private Integer teacherId;
    private Integer trainingCourseId;

    private Teacher teacher;

    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "date", nullable = false, insertable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "teacher_id", nullable = false)
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Column(name = "training_course_id", nullable = false)
    public Integer getTrainingCourseId() {
        return trainingCourseId;
    }

    public void setTrainingCourseId(Integer trainingCourseId) {
        this.trainingCourseId = trainingCourseId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}