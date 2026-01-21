package org.baratieri.tbdistribuidoraauto.config;

import org.baratieri.tbdistribuidoraauto.entity.*;
import org.baratieri.tbdistribuidoraauto.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
@Profile("default") // Roda no perfil padrão (sempre que der play)
public class TestConfig implements CommandLineRunner {

    // Injetamos TODOS os repositórios, pois vamos salvar em todas as tabelas
    @Autowired
    private MontadoraRepository montadoraRepository;

    @Autowired
    private ModeloVeiculoRepository modeloVeiculoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PecaRepository pecaRepository;

    @Autowired
    private CompatibilidadeRepository compatibilidadeRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria catFreio = new Categoria(null,"Freios","Discos,Pastilhas e Fluidos");
        Categoria catMotor = new Categoria(null,"Motor", "Componentes internos do motor.");

        categoriaRepository.saveAll(Arrays.asList(catMotor,catFreio));

        Montadora gm = new Montadora(null,"Chevrolet","EUA", null);
        Montadora fiat = new Montadora(null,"Fiat","Italia", null);
        montadoraRepository.saveAll(Arrays.asList(gm,fiat));

        ModeloVeiculo meriva = new ModeloVeiculo(null,"Meriva", "Joy 1.8",2008,gm);
        ModeloVeiculo corsa = new ModeloVeiculo(null,"Corsa","Hatch 1.4",2010,gm);
        ModeloVeiculo palio = new ModeloVeiculo(null,"Palio","Fire 1.0",2005,fiat);

        modeloVeiculoRepository.saveAll(Arrays.asList(meriva,corsa,palio));

        Peca pastilha = new Peca(null,"Pastilha de feio dianteiro", "PAS-001","ACD-9988", new BigDecimal("120.50"),50, catFreio);
        Peca oleo = new Peca(null, "Óleo 5w30", "OLE-530", "OIL-X", new BigDecimal("45.90"), 200, catMotor);

        pecaRepository.saveAll(Arrays.asList(oleo,pastilha));

        Compatibilidade comp1 = new Compatibilidade(null,2002,2012,"Eixo dianteiro",pastilha,meriva);
        Compatibilidade comp2 = new Compatibilidade(null,2005,2012,"Eixo dianteiro",pastilha,corsa);
        compatibilidadeRepository.saveAll(Arrays.asList(comp1,comp2));

        System.out.println("--------------------------------------------");
        System.out.println("CARGA DE DADOS REALIZADA COM SUCESSO! 🚀");
        System.out.println("--------------------------------------------");
    }
}