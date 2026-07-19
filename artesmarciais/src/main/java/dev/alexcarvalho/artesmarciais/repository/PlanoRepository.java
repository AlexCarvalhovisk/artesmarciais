package dev.alexcarvalho.artesmarciais.repository;

import dev.alexcarvalho.artesmarciais.domain.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
