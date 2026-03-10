package one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.repository;

import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.model.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}

