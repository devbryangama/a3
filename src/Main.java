import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Cores ANSI para o console
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String CIANO = "\u001B[36m";
    public static final String NEGRITO = "\u001B[1m";

    static List<Usuario> usuarios = new ArrayList<>();
    static List<Projeto> projetos = new ArrayList<>();
    static List<Equipe> equipes = new ArrayList<>();
    static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println(CIANO + "\n╔══════════════════════════════════════════════╗");
            System.out.println("║ " + NEGRITO + "       GERENCIADOR DE PROJETOS              " + RESET + CIANO + " ║");
            System.out.println("╚══════════════════════════════════════════════╝" + RESET);
            System.out.println(NEGRITO + " 1." + RESET + " Cadastrar Usuário");
            System.out.println(NEGRITO + " 2." + RESET + " Cadastrar Equipe");
            System.out.println(NEGRITO + " 3." + RESET + " Cadastrar Projeto");
            System.out.println(NEGRITO + " 4." + RESET + " Alocar Equipe no Projeto");
            System.out.println(NEGRITO + " 5." + RESET + " Adicionar Membros à Equipe");
            System.out.println(NEGRITO + " 6." + RESET + " Adicionar Tarefa ao Projeto");
            System.out.println(NEGRITO + " 7." + AMARELO + " EXIBIR RELATÓRIO GERAL" + RESET);
            System.out.println(VERMELHO + " 0. Sair" + RESET);
            System.out.print("\n Escolha: ");

            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (Exception e) {
                System.out.println(VERMELHO + "Digite apenas números!" + RESET);
                continue;
            }

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> cadastrarEquipe();
                case 3 -> cadastrarProjeto();
                case 4 -> alocarEquipeNoProjeto();
                case 5 -> adicionarMembrosEquipe();
                case 6 -> cadastrarTarefa();
                case 7 -> gerarRelatorio();
                case 0 -> System.out.println("Saindo...");
            }
        }
    }

    static void cadastrarUsuario() {
        System.out.println(AZUL + "\n--- Novo Usuário ---" + RESET);
        System.out.print("Nome: "); String nome = leitor.nextLine();
        System.out.print("CPF: "); String cpf = leitor.nextLine();
        System.out.print("Login: "); String login = leitor.nextLine();
        System.out.print("Senha: "); String senha = leitor.nextLine();
        System.out.print("Perfil (Adm/Gerente/Colab): "); String perfil = leitor.nextLine();
        usuarios.add(new Usuario(nome, cpf, "email@email.com", "Cargo", login, senha, perfil));
        System.out.println(VERDE + "Cadastrado!" + RESET);
    }

    static void cadastrarEquipe() {
        System.out.print("Nome da Equipe: "); String nome = leitor.nextLine();
        equipes.add(new Equipe(nome, "Descrição"));
        System.out.println(VERDE + "Equipe Criada!" + RESET);
    }

    static void adicionarMembrosEquipe() {
        if (equipes.isEmpty() || usuarios.isEmpty()) return;
        System.out.println("ID Equipe:");
        for (int i = 0; i < equipes.size(); i++) System.out.println(i + " - " + equipes.get(i).nome);
        int idEq = Integer.parseInt(leitor.nextLine());
        System.out.println("ID Usuário:");
        for (int i = 0; i < usuarios.size(); i++) System.out.println(i + " - " + usuarios.get(i).nome);
        int idUs = Integer.parseInt(leitor.nextLine());
        equipes.get(idEq).membros.add(usuarios.get(idUs));
        System.out.println(VERDE + "Membro Adicionado!" + RESET);
    }

    static void cadastrarProjeto() {
        if (usuarios.isEmpty()) return;
        System.out.print("Nome: "); String nome = leitor.nextLine();
        System.out.print("Status: "); String status = leitor.nextLine();
        System.out.println("ID Gerente:");
        for (int i = 0; i < usuarios.size(); i++) System.out.println(i + " - " + usuarios.get(i).nome);
        int idG = Integer.parseInt(leitor.nextLine());
        projetos.add(new Projeto(nome, "Desc", "01/01", "30/12", status, usuarios.get(idG)));
        System.out.println(VERDE + "Projeto Criado!" + RESET);
    }

    static void alocarEquipeNoProjeto() {
        if (projetos.isEmpty() || equipes.isEmpty()) return;
        System.out.print("ID Projeto: "); int idp = Integer.parseInt(leitor.nextLine());
        System.out.print("ID Equipe: "); int ide = Integer.parseInt(leitor.nextLine());
        projetos.get(idp).equipesAlocadas.add(equipes.get(ide));
    }

    static void cadastrarTarefa() {
        if (projetos.isEmpty()) return;
        System.out.print("ID Projeto: "); int id = Integer.parseInt(leitor.nextLine());
        System.out.print("Tarefa: "); String t = leitor.nextLine();
        projetos.get(id).tarefas.add(new Tarefa(t, "Pendente"));
    }

    static void gerarRelatorio() {
        for (Projeto p : projetos) {
            System.out.println(AMARELO + "PROJETO: " + p.nome + " | Status: " + p.status + RESET);
            System.out.println("Gerente: " + p.gerente.nome + " (" + p.gerente.perfil + ")");
            System.out.println("-------------------------------------------------");
        }
    }
}