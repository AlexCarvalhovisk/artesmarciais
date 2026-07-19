package dev.alexcarvalho.artesmarciais.repository;

import dev.alexcarvalho.artesmarciais.domain.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {
}
