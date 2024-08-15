package com.codedrop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {
    @Id
    @Size(max = 50)
    @Nationalized
    @Column(name = "bank_number", nullable = false, length = 50)
    private String bankNumber;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "bank_name", nullable = false, length = 100)
    private String bankName;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    @ColumnDefault("0")
    @Column(name = "is_delete")
    private Boolean isDelete;

    @JsonIgnore
    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER)
    List<BankHistory> bankHistories;

    @JsonIgnore
    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER)
    List<User> users;

}