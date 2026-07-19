package dev.alexcarvalho.artesmarciais.repository;

import dev.alexcarvalho.artesmarciais.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
