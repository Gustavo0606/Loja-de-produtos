package com.gustavo.loja_springboot.controller;

import com.gustavo.loja_springboot.model.Produto;
import com.gustavo.loja_springboot.repository.ProdutoRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/loja"})
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> listar() {
        return this.produtoRepository.findAll();
    }
}
