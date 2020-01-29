package com.jiratask.crud.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "dictionary")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String discriminator;

    @Column(name = "role_name")
    private String roleName;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
//    private List<User> users;

}
