package one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.repository;

import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.model.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    Endereco findByCep(String cep);
}
