package com.gustavo.loja_springboot;

import com.gustavo.loja_springboot.model.Produto;
import com.gustavo.loja_springboot.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDatabase(ProdutoRepository produtoRepository) {
        return (args) -> {
            if (produtoRepository.count() == 0L) {
                produtoRepository.saveAll(List.of(new Produto((Long) null, "Camiseta de academia", new BigDecimal("79.90"), "Camiseta confortável", 5), new Produto((Long) null, "Garrafa Stanley", new BigDecimal("39.90"), "Garrafa que mantém a temperatura", 8), new Produto((Long) null, "Barrinha de proteína", new BigDecimal("2.90"), "Barrinha nutritiva", 15)));
            }

        };
    }
}