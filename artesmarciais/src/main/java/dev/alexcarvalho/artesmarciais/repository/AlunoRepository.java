package dev.alexcarvalho.artesmarciais.repository;

import dev.alexcarvalho.artesmarciais.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//Incluí o JpaSpecificator ao final para poder usar o Aluno Specificator
public interface AlunoRepository extends JpaRepository<Aluno, Long>, JpaSpecificationExecutor<Aluno> {
    boolean existsByEmail(String email);
}
