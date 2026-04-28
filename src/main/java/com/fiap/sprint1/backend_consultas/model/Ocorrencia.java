package com.fiap.sprint1.backend_consultas.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_ocorrencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDefeito;
    private String linhaProducao;
    private LocalDateTime dataHora = LocalDateTime.now();
    private String status;
}
