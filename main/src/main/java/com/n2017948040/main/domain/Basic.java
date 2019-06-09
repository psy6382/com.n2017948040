package com.n2017948040.main.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Basic implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String label;

    @Column
    private String email;

    @Column
    private String phone;

    @Builder
    public Basic(String name, String label, String email, String phone) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
    }

    public void updateBasic(Basic basic){
        this.name = basic.name;
        this.label = basic.label;
        this.email = basic.email;
        this.phone = basic.phone;
    }

}