package dev.alexcarvalho.artesmarciais.repository;

import dev.alexcarvalho.artesmarciais.domain.Assiduidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssisuidadeRepository extends JpaRepository<Assiduidade, Long> {
}
