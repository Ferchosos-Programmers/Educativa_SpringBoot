package com.fernando.educativa.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tbl_cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cursos_id;

    @Column(length = 128, nullable = false)
    private String nombre;

    @Column(length = 256)
    private String descripcion;

    @Column(nullable = false)
    private int creditos;
}
