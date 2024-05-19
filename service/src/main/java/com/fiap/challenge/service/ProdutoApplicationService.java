package com.fiap.challenge.service;

import com.fiap.challenge.domain.Produto;
import com.fiap.challenge.domain.ProdutoRepository;
import com.fiap.challenge.domain.TipoDoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoApplicationService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoApplicationService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProduto(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }
//
//    @Transactional
//    public void incluirProduto(ProdutoDTO produtoDTO) {
//        Produto produto = new Produto(produtoDTO.getNome(), produtoDTO.getPreco());
//        produtoRepository.save(produto);
//    }

    @Transactional
    public void atualizarProduto(Long idDoProduto, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(idDoProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.atualizarProduto(produtoDTO.getNome(), produtoDTO.getPreco());
        produtoRepository.save(produto);
    }

    @Transactional
    public void deletarProduto(Long idDoProduto) {
        Produto produto = produtoRepository.findById(idDoProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }
//
//    public List<Produto> listarLanches() {
//        return produtoRepository.findAllByTipo(TipoDoProduto.LANCHE);
//    }
//
//    public List<Produto> listarAcompanhamentos() {
//        return produtoRepository.findAllByTipo(TipoDoProduto.ACOMPANHAMENTO);
//    }
//
//    public List<Produto> listarBebidas() {
//        return produtoRepository.findAllByTipo(TipoDoProduto.BEBIDA);
//    }
//
//    public List<Produto> listarSobremesas() {
//        return produtoRepository.findAllByTipo(TipoDoProduto.SOBREMESA);
//    }
}