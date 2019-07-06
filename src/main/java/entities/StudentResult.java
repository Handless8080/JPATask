package entities;

import converters.DateConverter;
import entities.embedded_keys.StudentResultKey;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student_result")
public class StudentResult {
    private StudentResultKey id;
    private Integer examId;
    private Byte result;
    private LocalDate date;
    private String note;

    private Student student;
    private TrainingCourse trainingCourse;
    private Exam exam;

    @EmbeddedId
    public StudentResultKey getId() {
        return id;
    }

    public void setId(StudentResultKey id) {
        this.id = id;
    }

    @Column(name = "exam_id")
    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    @Column(name = "result", nullable = false)
    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    @Column(name = "date", nullable = false, columnDefinition = "date")
    @Convert(converter = DateConverter.class)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "note", length = 50)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_course_id", insertable = false, updatable = false)
    public TrainingCourse getTrainingCourse() {
        return trainingCourse;
    }

    public void setTrainingCourse(TrainingCourse trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", insertable = false, updatable = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}