package com.fernando.educativa.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_aulas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aulas_id;

    @Column(nullable = false)
    private Integer numero_aula;

    @Column(nullable = false)
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private Cursos cursos;
}
