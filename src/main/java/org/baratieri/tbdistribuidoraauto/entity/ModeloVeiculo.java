package org.baratieri.tbdistribuidoraauto.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_modelo_veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String motor;

    private Integer anoModelo;

    // Muitos modelos (N) pertencem a Uma Montadora (1)
    @ManyToOne
    // Cria a coluna 'montadora_id' no banco que aponta para a tabela tb_montadora
    @JoinColumn(name = "montadora_id", nullable = false)
    private Montadora montadora;
}