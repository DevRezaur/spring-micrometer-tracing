package com.devrezaur.user.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_table")
public class User {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private UUID organizationId;
}
