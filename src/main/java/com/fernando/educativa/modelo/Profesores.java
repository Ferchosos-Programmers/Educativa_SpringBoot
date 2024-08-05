package com.fernando.educativa.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_profesores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profesor_id;

    @Column(length = 128, nullable = false)
    private String nombre;

    @Column(length = 128, nullable = false)
    private String apellido;

    @Column(length = 128, unique = true, nullable = false)
    private String email;

    @Column(length = 128)
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "aulas_id")
    private Aulas aulas;
}
