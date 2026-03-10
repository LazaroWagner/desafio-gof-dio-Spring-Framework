package one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.service;

import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.model.Aluno;


public interface AlunoService {

    Iterable<Aluno> findAll();

    Aluno findById(Long id);

    void cadastrarAluno(Aluno aluno);

    void atualizar(Long id, Aluno aluno);

    void deletar(Long id);
}
