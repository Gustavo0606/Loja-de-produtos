package com.gustavo.loja_springboot.repository;

import com.gustavo.loja_springboot.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
