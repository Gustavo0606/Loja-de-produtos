package com.gustavo.loja_springboot.controller;

import com.gustavo.loja_springboot.model.Produto;
import com.gustavo.loja_springboot.repository.ProdutoRepository;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private final ProdutoRepository produtoRepository;

    public HomeController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping({"/"})
    public String index() {
        return "index";
    }

    @GetMapping({"/gestao"})
    public String gestao(Model model) {
        model.addAttribute("produtos", this.produtoRepository.findAll());
        return "gestao";
    }

    @GetMapping({"/cliente"})
    public String cliente(Model model) {
        model.addAttribute("produtos", this.produtoRepository.findAll());
        return "cliente";
    }

    @PostMapping({"/gestao"})
    public String salvarProduto(Produto produto) {
        this.produtoRepository.save(produto);
        return "redirect:/gestao";
    }

    @PostMapping({"/cliente"})
    public String comprarProduto(Long id) {
        Optional<Produto> produtoOpt = this.produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = (Produto) produtoOpt.get();
            if (produto.getEstoque() > 0) {
                produto.setEstoque(produto.getEstoque() - 1);
                this.produtoRepository.save(produto);
            }
        }

        return "redirect:/cliente";
    }
}
