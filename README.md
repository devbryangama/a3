

1. Objetivo do Sistema
O projeto é um Sistema de Gestão de Projetos e Equipes desenvolvido em Java. O objetivo principal é organizar como uma empresa gerencia seus recursos humanos (pessoas) e seus esforços técnicos (projetos).

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3. A Arquitetura do Software (Classes)
O sistema foi construído utilizando o paradigma de Orientação a Objetos (POO). Isso significa que cada elemento do mundo real virou uma "peça" no código:

Classe Usuario: Representa as pessoas. Armazena dados sensíveis (Login, Senha, CPF) e o Perfil, que define o nível de acesso (Adm, Gerente ou Colaborador).

Classe Projeto: É o coração do sistema. Ela guarda o status, os prazos e, o mais importante: quem é o Gerente responsável.

Classe Equipe: Funciona como uma "ponte". Ela agrupa vários usuários para que eles possam ser movidos juntos para dentro de um projeto.

Classe Tarefa: Representa o nível operacional, ou seja, o que exatamente precisa ser feito dentro de cada projeto.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. O que o Relatório faz (Lógica do Código)

Ela puxa o Gerente diretamente do objeto Projeto.

Ela percorre a lista de Equipes Alocadas.

Dentro de cada equipe, ela percorre a lista de Membros.

Ela lista todas as Tarefas associadas.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

4. O Fluxo da Informação
Para o sistema funcionar, ele segue uma ordem lógica:

Entrada: Você cadastra os Usuários (as pessoas).

Organização: Você cria as Equipes e adiciona os usuários a elas.

Planejamento: Você cria o Projeto e vincula um Gerente.

Execução: Você aloca a Equipe ao projeto e cria as Tarefas.

Saída: O Relatório Geral consolida tudo isso em uma visão clara para o gestor.
