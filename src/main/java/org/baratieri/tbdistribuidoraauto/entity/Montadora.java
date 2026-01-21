package org.baratieri.tbdistribuidoraauto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_montadora")
// @Data: O Lombok gera automaticamente Getters, Setters, toString, equals e hashCode
@Data
// Construtores gerados pelo Lombok (o JPA exige um construtor vazio)
@NoArgsConstructor
@AllArgsConstructor
public class Montadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "pais_origem") // Mapeia camelCase do Java para snake_case do Banco
    private String paisOrigem;
    @OneToMany(mappedBy = "montadora")
    @JsonIgnore
    private List<ModeloVeiculo> modelos = new ArrayList<>();

}