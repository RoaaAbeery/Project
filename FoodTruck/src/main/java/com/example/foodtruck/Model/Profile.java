package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    private Integer id;
    @NotNull(message = "Summary should not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String description;
    private LocalDateTime AccountCreationDate =LocalDateTime.now();
    ;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Set<Address> addresses;
    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;
}
