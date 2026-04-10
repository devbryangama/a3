package model;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    public String nome, descricao;
    public List<Usuario> membros = new ArrayList<>();

    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}