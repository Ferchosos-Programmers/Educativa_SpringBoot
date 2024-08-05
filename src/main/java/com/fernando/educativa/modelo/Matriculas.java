package com.fernando.educativa.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_matriculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matriculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula_id;

    @ManyToOne
    @JoinColumn(name = "estudiantes_id", nullable = false)
    private Estudiantes estudiantes;

    @ManyToOne
    @JoinColumn(name = "cursos_id", nullable = false)
    private Cursos cursos;

    @Column(nullable = false)
    private String fecha_matricula;
}
