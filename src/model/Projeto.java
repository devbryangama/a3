package model;
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    public String nome, descricao, dataInicio, dataTerminoPrevista, status;
    public Usuario gerente;
    public List<Equipe> equipesAlocadas = new ArrayList<>();
    public List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome, String descricao, String dataInicio, String dataTerminoPrevista, String status, Usuario gerente) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.status = status;
        this.gerente = gerente;
    }
}