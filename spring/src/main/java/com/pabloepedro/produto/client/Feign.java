package com.pabloepedro.produto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente", url = "${services.cliente.url}")

public interface Feign {
    @GetMapping("/clientes/{id}")
    void validarCliente(@PathVariable("id") String id);
}
