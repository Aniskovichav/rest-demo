package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
    @XmlAttribute private int id;

    @Column(name = "NumCode", length = 20)
    private String NumCode;

    @Column(name = "CharCode", length = 20)
    private String CharCode;

    @Column(name="Name", length=50)
    private String Name;

    @Column(name="Scale", length=20)
    private String Scale;

    @Column(name = "Rate", length = 20)
    private String Rate;
}
