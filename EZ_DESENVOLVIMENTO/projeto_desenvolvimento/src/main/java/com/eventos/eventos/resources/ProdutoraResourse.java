package com.eventos.eventos.resources;

import com.eventos.eventos.dtos.ProdutoraDTO;
import com.eventos.eventos.models.Produtora;
import com.eventos.eventos.service.ProdutoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtoras")
public class ProdutoraResourse {

    @Autowired
    private ProdutoraService produtoraService;

    @GetMapping("{id}")
    public ResponseEntity<ProdutoraDTO> buscarProdutoraPorId(@PathVariable Long id) {
        Produtora produtora = produtoraService.buscarProdutoraPorId(id);
        return ResponseEntity.ok(new ProdutoraDTO(produtora));
    }

    @GetMapping("/buscar-nome")
    public ResponseEntity<ProdutoraDTO> buscarProdutoraPorNome(@RequestParam String nome) {
        ProdutoraDTO produtoraDTO = produtoraService.buscarProdutoraPorNome(nome);
        return ResponseEntity.ok(produtoraDTO);
    }

    @GetMapping("/buscar-cpf-cnpj")
    public ResponseEntity<ProdutoraDTO> buscarProdutoraPorCpfCnpj(@RequestParam String cpfCnpj) {
        ProdutoraDTO produtoraDTO = produtoraService.buscarProdutoraPorCpfCnpj(cpfCnpj);
        return ResponseEntity.ok(produtoraDTO);
    }

    @PostMapping()
    public ResponseEntity<ProdutoraDTO> criarProdutora(@RequestBody ProdutoraDTO produtoraDTO) {
        return ResponseEntity.ok(produtoraService.salvarProdutora(produtoraDTO));
    }

    @PutMapping()
        public ResponseEntity<ProdutoraDTO> atualizarProdutora(@RequestBody ProdutoraDTO produtoraDTO) {
        return ResponseEntity.ok(produtoraService.atualizarProdutora(produtoraDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarProdutora(@RequestBody ProdutoraDTO produtoraDTO) {
        produtoraService.deletarProdutora(produtoraDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
