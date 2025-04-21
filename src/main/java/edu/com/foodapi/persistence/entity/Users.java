package edu.com.foodapi.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usarios")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userPassword;
    private String userRole;
}
