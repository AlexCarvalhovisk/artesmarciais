package dev.alexcarvalho.artesmarciais.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "graduacoes")
public class Graduacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String nome;

    //As informações abaixo são porque a coluna é uma FK, aqui quero trazer somente as modalidades usadas.
    //Na linha seguinte estou dizendo que uma modalidade pode ter muitas graduações
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modalidade_id")
    private Modalidade modalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
