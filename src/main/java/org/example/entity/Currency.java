package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Currency")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@Data
@NoArgsConstructor
@Entity(name="Currency")
@Table(name="Currency")
public class Currency {

    @Id
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @Column(name = "numCode", length = 20)
    private String numCode;

    @Column(name = "charCode", length = 20)
    private String charCode;

    @Column(name="name", length=50)
    private String name;

    @Column(name="scale", length=20)
    private String scale;

    @Column(name = "rate", length = 20)
    private String rate;
}
