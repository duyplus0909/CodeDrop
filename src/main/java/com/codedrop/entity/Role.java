package com.codedrop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Column(name = "id", nullable = false, length = 5)
    private String id;

    @Size(max = 10)
    @NotNull
    @Nationalized
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @ColumnDefault("0")
    @Column(name = "is_delete")
    private Boolean isDelete;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Authority> authorities;

}