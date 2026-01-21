package org.baratieri.tbdistribuidoraauto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.baratieri.tbdistribuidoraauto.entity.Categoria;
import org.baratieri.tbdistribuidoraauto.entity.Peca;

import java.math.BigDecimal;

public record PecaDTO(@NotBlank(message = "O nome é obrigatório")
                      String nome,

                      @NotBlank(message = "O SKU é obrigatório")
                      String sku,

                      String partNumber,

                      @NotNull(message = "O preço é obrigatório")
                      @Positive(message = "O preço deve ser maior que zero")
                      BigDecimal preco,

                      @Positive(message = "O estoque deve ser positivo")
                      Integer quantidadeEstoque,

                      @NotNull(message = "O ID da categoria é obrigatório")
                      Long categoriaId
)  {

    public Peca toEntity(Categoria categoria) {
        Peca peca = new Peca();
        peca.setNome(nome);
        peca.setSku(sku);
        peca.setPartNumber(partNumber);
        peca.setPreco(preco);
        peca.setQuantidadeEstoque(quantidadeEstoque);
        peca.setCategoria(categoria);
        return  peca;
    }

    // Método estático: PecaDTO.fromEntity(peca)
    public static PecaDTO fromEntity(Peca peca) {
        return new PecaDTO(
                peca.getNome(),
                peca.getSku(),
                peca.getPartNumber(),
                peca.getPreco(),
                peca.getQuantidadeEstoque(),
                peca.getCategoria().getId()
        );
    }
}

