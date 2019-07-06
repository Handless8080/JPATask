package entities;

import converters.DateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Boolean sex;
    private Boolean hostelLive;

    private Set<StudentResult> studentResultSet = new HashSet<>();
    private Set<ExamResult> examResultSet = new HashSet<>();

    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birth_date", nullable = false, columnDefinition = "date")
    @Convert(converter = DateConverter.class)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "sex", nullable = false)
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Column(name = "hostel_live")
    public Boolean getHostelLive() {
        return hostelLive;
    }

    public void setHostelLive(Boolean hostelLive) {
        this.hostelLive = hostelLive;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.studentId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<StudentResult> getStudentResultSet() {
        return studentResultSet;
    }

    public void setStudentResultSet(Set<StudentResult> studentResultSet) {
        this.studentResultSet = studentResultSet;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ExamResult> getExamResultSet() {
        return examResultSet;
    }

    public void setExamResultSet(Set<ExamResult> examResultSet) {
        this.examResultSet = examResultSet;
    }
}