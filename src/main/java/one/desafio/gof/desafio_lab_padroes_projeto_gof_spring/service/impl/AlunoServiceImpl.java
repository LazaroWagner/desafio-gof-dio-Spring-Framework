package one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.service.impl;

import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.model.Aluno;
import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.model.Endereco;
import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.repository.AlunoRepository;
import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.repository.EnderecoRepository;
import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.service.AlunoService;
import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private AlunoRepository AlunoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Aluno> findAll() {
        // Buscar todos os Alunos.
        return AlunoRepository.findAll();
    }

    @Override
    public Aluno findById(Long id) {
        // Buscar Aluno por ID.
        Optional<Aluno> Aluno = AlunoRepository.findById(id);
        return Aluno.get();
    }

    @Override
    public void cadastrarAluno(Aluno Aluno) {
        salvarAlunoComCep(Aluno);
    }

    @Override
    public void atualizar(Long id, Aluno Aluno) {
        // Buscar Aluno por ID, caso exista:
        Optional<Aluno> AlunoBd = AlunoRepository.findById(id);
        if (AlunoBd.isPresent()) {
            salvarAlunoComCep(Aluno);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Aluno por ID.
        AlunoRepository.deleteById(id);
    }

    private void salvarAlunoComCep(Aluno Aluno) {

        String cep = Aluno.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        Aluno.setEndereco(endereco);
        AlunoRepository.save(Aluno);
    }

}
