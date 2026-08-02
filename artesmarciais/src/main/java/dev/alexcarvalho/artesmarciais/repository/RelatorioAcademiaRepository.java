package dev.alexcarvalho.artesmarciais.repository;

import dev.alexcarvalho.artesmarciais.domain.FaturaMatricula;
import dev.alexcarvalho.artesmarciais.projection.AlunosPorCidadeProjection;
import dev.alexcarvalho.artesmarciais.projection.FaturamentoMensalProjection;
import dev.alexcarvalho.artesmarciais.projection.FaturasEmAbertoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import java.util.List;

public interface RelatorioAcademiaRepository extends Repository<FaturaMatricula, Long> {

    @Query(
            value = """
                SELECT 
                        TO_CHAR(data_vencimento, 'YYYY-MM') AS mes,
                        SUM(valor) AS total
                FROM faturas_matriculas
                WHERE status = 'PAGA'
                GROUP BY TO_CHAR(data_vencimento, 'YYYY-MM')
                ORDER BY mes 
            """,
            nativeQuery = true
    )
    List<FaturamentoMensalProjection> faturamentoMensal();

    @Query(
            value = """
                SELECT 
                        cidade,
                        count(*) AS quantidade
                FROM alunos
                GROUP BY cidade
                ORDER BY quantidade desc
            """,
            nativeQuery = true
    )
    List<AlunosPorCidadeProjection> alunosPorCidade();

    @Query(
            value = """
                SELECT 
                        m.id AS matricula_id,
                        a.nome AS alunoNome,
                        f.data_vencimento AS data_vencimento,
                        f.valor
                FROM faturas_matriculas f 
                JOIN matriculas m ON m.id = f.matricula_id
                JOIN alunos a ON a.id = m.aluno_id
                WHERE f.status = 'ABERTA'
                ORDER BY f.data_vencimento desc
            """,
            nativeQuery = true
    )
    List<FaturasEmAbertoProjection> faturasEmAberto();
}
