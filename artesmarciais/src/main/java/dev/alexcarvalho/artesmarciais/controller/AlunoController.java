package dev.alexcarvalho.artesmarciais.controller;

import dev.alexcarvalho.artesmarciais.doc.AlunoControllerDoc;
import dev.alexcarvalho.artesmarciais.dto.AlunoFiltroRequest;
import dev.alexcarvalho.artesmarciais.dto.AlunoRequest;
import dev.alexcarvalho.artesmarciais.dto.AlunoResponse;
import dev.alexcarvalho.artesmarciais.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController implements AlunoControllerDoc {

    private final AlunoService alunoService;

    //Contrutor da classe
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //Rotas do CRUD
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest alunoRequest) {
        return alunoService.cadastrar(alunoRequest);
    }

    @GetMapping
    //Aqui vou deixar como estava antes do Specification
    /*public Page<AlunoResponse> listar(Pageable pageable) {
        return alunoService.listar(pageable);*/
    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable) {
        return alunoService.listar(filtro, pageable);
    }

    //Sempre que uso interpolação como no caso abaixo do ID, tenho que usar a anotação PathVariable dentrp do metodo.
    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AlunoRequest alunoRequest) {
        return alunoService.atualizar(id, alunoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        alunoService.excluir(id);
    }
}
