package com.pabloepedro.produto.controller;

import com.pabloepedro.entity.Compras;
import com.pabloepedro.entity.Produto;
import com.pabloepedro.produto.client.Feign;
import com.pabloepedro.produto.controller.adapter.ComprasCtrlAdp;
import com.pabloepedro.produto.controller.dto.request.ComprasRequest;
import com.pabloepedro.produto.controller.dto.response.ComprasResponse;
import com.pabloepedro.repository.ComprasRepo;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComprasCtrl {
    public final ComprasRepo repo;
    public final Feign feign;

    public ComprasCtrl(ComprasRepo repo, Feign feign){
        this.repo = repo;
        this.feign = feign;
    }

    @PostMapping("/compras/efetuar")
    public ResponseEntity<?> salvar(@RequestBody ComprasRequest request) {
        Compras compras = ComprasCtrlAdp.castRequest(request);

        try{
            feign.validarCliente(compras.clientId());
        }catch (FeignException.NotFound e){
            return ResponseEntity.badRequest().body("Cliente não encontrado");
        }catch (Exception ex){
            return ResponseEntity.status(503).body("Erro no Feign");
        }
        Compras compraSalva = repo.comprar(compras);
        return ResponseEntity.ok(ComprasCtrlAdp.castResponse(compraSalva));
    }

    @GetMapping("/compras/{id}")
    public ComprasResponse buscar(@PathVariable String id){
        Compras compras = repo.buscar(id).orElseThrow(() -> new RuntimeException("Compra não encontrada"));
        return ComprasCtrlAdp.castResponse(compras);
    }

    @GetMapping("/compras")
    public List<ComprasResponse> Listar(){
        List<Compras> compras = repo.listarCompras();
        return compras.stream().map(ComprasCtrlAdp::castResponse).toList();
    }
}
