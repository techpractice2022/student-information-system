package org.NSoft.studentinformationsystem.domain;


import java.sql.Blob;
import javassist.bytecode.ByteArray;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.type.BlobType;
import org.springframework.context.annotation.ComponentScan;


@Data
@NoArgsConstructor
@Table(name = "student_personal_information")
@Entity
public class PersonalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middleinitial")
    private String middleinitial;

    @Column(name = "age")
    private Integer age;


   /* @Column(name = "image")
    private Byte image;*/

    /*@Lob
    @Column(name = "image")
    private byte[] image;*/


    /*@Column(name = "image")
    private String image;*/

}


