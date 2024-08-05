package com.fernando.educativa.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_estudiantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estudiantes_id;

    @Column(length = 128, nullable = false)
    private String nombre;

    @Column(length = 128, nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String fecha_nacimiento;

    @Column(length = 128, unique = true, nullable = false)
    private String email;
}
