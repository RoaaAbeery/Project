package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aasas")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @NotNull(message = "number of day should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer numberOfDay;
    private Double totalPrice;
    @Pattern(regexp = "^(Complete|Uncomplete)$",message = "status must be Complete or UnComplete")
    @Column(columnDefinition = "varchar(10) not null Check (status='Complete' or status='UnComplete') ")
    private String orderStatus;
    private String note;
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
    @PrimaryKeyJoinColumn
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "foodTruck_id",referencedColumnName = "id")
    @JsonIgnore
    private FoodTruck foodTruck;
}
