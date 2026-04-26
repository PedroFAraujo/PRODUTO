package com.pabloepedro.produto.controller;

import com.pabloepedro.entity.Produto;
import com.pabloepedro.produto.controller.adapter.ProdutoCtrlAdp;
import com.pabloepedro.produto.controller.dto.request.ProdutoRequest;
import com.pabloepedro.produto.controller.dto.response.ProdutoResponse;
import com.pabloepedro.repository.ProdutoRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoCtrl {
    public final ProdutoRepo repo;

    public ProdutoCtrl(ProdutoRepo repo){
        this.repo = repo;
    }

    @PostMapping("/produto/cadastrar")
    public ProdutoResponse salvar(@RequestBody ProdutoRequest request) {
        Produto produto = ProdutoCtrlAdp.castRequest(request);
        Produto produtoSalvo = repo.cadastro(produto);
        return ProdutoCtrlAdp.castResponse(produtoSalvo);
    }

    @GetMapping("/produto/{id}")
    public ProdutoResponse buscar(@PathVariable String id){
        Produto produto = repo.buscar(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ProdutoCtrlAdp.castResponse(produto);
    }

    @GetMapping("/produtos")
    public List<ProdutoResponse> Listar(){
        List<Produto> produtos = repo.listar();
        return produtos.stream().map(ProdutoCtrlAdp::castResponse).toList();
    }

    @PutMapping("/produto/atualizar/{id}")
    public ProdutoResponse atualizar(@PathVariable String id, @RequestBody ProdutoRequest request){

        Produto produtoExistente = repo.buscar(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Produto produtoAtualizado = new Produto(
                produtoExistente.id(),
                request.nome(),
                request.value()
        );

        Produto produtoSalvo = repo.cadastro(produtoAtualizado);

        return ProdutoCtrlAdp.castResponse(produtoSalvo);
    }

    @DeleteMapping("/produto/deletar/{id}")
    public void deletar(@PathVariable String id){
        Produto produto = repo.buscar(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        repo.deletar(id);
    }
}
