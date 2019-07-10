package entities;

import converters.DateConverter;
import entities.embedded_keys.StudentResultKey;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student_result")
public class StudentResult {
    private StudentResultKey id;
    private Byte result;
    private LocalDate date;
    private String note;

    private Exam exam;

    @EmbeddedId
    public StudentResultKey getId() {
        return id;
    }

    public void setId(StudentResultKey id) {
        this.id = id;
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
    @JoinColumn(name = "exam_id", insertable = false, updatable = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}