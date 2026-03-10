package one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.controller;


import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.model.Aluno;
import one.desafio.gof.desafio_lab_padroes_projeto_gof_spring.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private  AlunoService alunoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        alunoService.cadastrarAluno(aluno);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping
    public ResponseEntity<Iterable<Aluno>> listarTodos() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        alunoService.atualizar(id, aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

