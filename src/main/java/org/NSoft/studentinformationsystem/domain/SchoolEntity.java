package org.NSoft.studentinformationsystem.domain;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

@Data
@ComponentScan("school")
@NoArgsConstructor
@Table(name = "student_school_information")
@Entity
public class SchoolEntity implements Serializable {

    private static final long serialVersionUID = 4999561953338235076L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "year")
    private Integer Year;

    @Column(name = "section")
    private Integer Section;

    @Column(name = "course", columnDefinition = "CLOB")
    private String Course;

}

