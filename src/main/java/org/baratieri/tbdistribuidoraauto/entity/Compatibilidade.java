package org.baratieri.tbdistribuidoraauto.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_compatibilidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compatibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anoInicio;
    private Integer anoFim;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "peca_id", nullable = false)
    private Peca peca;

    @ManyToOne
    @JoinColumn(name = "modelo_veiculo_id", nullable = false)
    private ModeloVeiculo modeloVeiculo;
}