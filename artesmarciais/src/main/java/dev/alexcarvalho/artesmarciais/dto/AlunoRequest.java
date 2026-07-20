package dev.alexcarvalho.artesmarciais.dto;

import dev.alexcarvalho.artesmarciais.domain.Aluno;

import java.time.LocalDate;

//Criei um record, pois ele é uma classe imutável que é utilizada para retornar oos usuários os dados que queremos.
//Isso serve para quando eu trafegar os dados não expôr a entidade do banco de dados diretamente causando mais segurança.
//O que é um DTO Alex, lembra? DTO é um Data Transfer Object.

public record AlunoRequest(
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    //Aqui criei o função para alimentar a de cima.
    public void preencher(Aluno aluno) {
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }
}
