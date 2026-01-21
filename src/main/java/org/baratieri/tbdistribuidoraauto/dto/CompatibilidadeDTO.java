package org.baratieri.tbdistribuidoraauto.dto;

import jakarta.validation.constraints.NotNull;
import org.baratieri.tbdistribuidoraauto.entity.Compatibilidade;
import org.baratieri.tbdistribuidoraauto.entity.ModeloVeiculo;
import org.baratieri.tbdistribuidoraauto.entity.Peca;

public record CompatibilidadeDTO(@NotNull Long pecaId,
                                 @NotNull Long modeloId,
                                 @NotNull Integer anoInicio,
                                 @NotNull Integer anoFim,
                                 String observacao) {

    public Compatibilidade toEntity(Peca peca, ModeloVeiculo modelo){
        Compatibilidade compatibilidade = new Compatibilidade();
        compatibilidade.setPeca(peca);
        compatibilidade.setModeloVeiculo(modelo);
        compatibilidade.setAnoInicio(anoInicio);
        compatibilidade.setAnoFim(anoFim);
        compatibilidade.setObservacao(observacao);
        return compatibilidade;
    }
}
