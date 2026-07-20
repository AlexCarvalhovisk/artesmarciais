package dev.alexcarvalho.artesmarciais.dto;

import dev.alexcarvalho.artesmarciais.domain.Aluno;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlunoResponse(
        Long id,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String celular,
        String email,
        String cidade,
        String estado,
        LocalDateTime crieadoEm
) {

    //Aqui nesse função vou criar como estatica, pois vou usar como um Mapper vou usar expressões regulares, lambda, stream
    public static AlunoResponse fromEntity(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getSexo(),
                aluno.getCelular(),
                aluno.getEmail(),
                aluno.getCidade(),
                aluno.getEstado(),
                aluno.getCriadoEm()
        );
    }
}
