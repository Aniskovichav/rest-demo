package org.example.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@Data
@NoArgsConstructor
@Entity(name="Employee")
@Table(name="Employee") //  uniqueConstraints={@UniqueConstraint(columnNames={"ID"})}
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="NAME", length=20, nullable=true)
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "ROLE")
//    private Role role;

    @Column(name="insert_time", nullable=true)
    private Date insertTime;
}
