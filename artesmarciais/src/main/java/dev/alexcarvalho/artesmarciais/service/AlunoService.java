package dev.alexcarvalho.artesmarciais.service;

import dev.alexcarvalho.artesmarciais.domain.Aluno;
import dev.alexcarvalho.artesmarciais.dto.AlunoRequest;
import dev.alexcarvalho.artesmarciais.dto.AlunoResponse;
import dev.alexcarvalho.artesmarciais.exception.RegraNegocioException;
import dev.alexcarvalho.artesmarciais.repository.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    //A camada de serviço SEMPRE fará uso do Repositório
    public final AlunoRepository alunoRepository;

    //Eu sempre terei que ter um construtor a menos que eu use a anotações do Spring o @autowarid e args e etc...
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    //Metodo cadastrar vai ficar com a regra de conferir se o e-mail existe e como estou testando no IF abaixo e criando a regra no Repository.
    public AlunoResponse cadastrar(AlunoRequest request) {
        if(request.email() != null && alunoRepository.existsByEmail(request.email())){
            throw new RegraNegocioException("Já existe um aluno cadastrado com esse e-mail");
        }

        Aluno aluno = request.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);
    }

    //Aqui estou fazendo um select, mas preciso entender melhor como funciona.
    public Page<AlunoResponse> listar(Pageable pageable) {
        return alunoRepository.findAll(pageable).map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = buscarEntidadePorId(id);
        return AlunoResponse.fromEntity(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        //Aqui eu fiz uma busca e retornei o aluno
        Aluno aluno = buscarEntidadePorId(id);
        //Aqui chamei o metodo preencher para eu poder atualizar
        request.preencher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id) {
        Aluno aluno = buscarEntidadePorId(id);
        alunoRepository.delete(aluno);
    }

    //Como vou usar o findById para deletar e atualizar, criei antes o metodo abaixo para não ficar repetindo código.
    private Aluno buscarEntidadePorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Aluno não encontrado"));
    }
}
