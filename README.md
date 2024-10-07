# Projeto de Gerenciamento de Times de Futebol

## Descrição
Este projeto tem como objetivo gerenciar informações sobre diferentes times de futebol e, em especial, reproduzir o hino do Corinthians, um dos maiores clubes do Brasil. A aplicação foi desenvolvida em Java e utiliza uma interface gráfica para interação com o usuário.

## Estrutura do Projeto

### Classes

1. **Streamings**
   - Responsável por armazenar informações sobre serviços de streaming.
   - Atributos:
     - `nome`: Nome do serviço de streaming.
     - `quantidadeUsuarios`: Número de usuários do serviço.
     - `quantidadeFilmes`: Número de filmes disponíveis.
   - Métodos:
     - `mostrarInformacoes()`: Exibe as informações do serviço.
     - `atualizarQuantidadeFilmes(int novaQuantidade)`: Atualiza a quantidade de filmes.
     - `atualizarQuantidadeUsuarios(int novaQuantidade)`: Atualiza a quantidade de usuários.

2. **Times**
   - Responsável por armazenar informações sobre times de futebol.
   - Atributos:
     - `nome`: Nome do time.
     - `titulos`: Número de títulos conquistados.
     - `quantidadeMembros`: Número de membros do time.
   - Métodos:
     - `mostrarInformacoes()`: Exibe as informações do time.
     - `tocarHino()`: Reproduz o hino do Corinthians.

### Interface Gráfica

- **TimesGUI**
  - Uma interface gráfica simples que permite ao usuário interagir com a aplicação.
  - Contém um botão que, ao ser clicado, toca o hino do Corinthians.
  - Título: "CORINTHIANS O MAIOR DE TODOS!"

## Funcionamento

- A aplicação é iniciada pela classe `TimesGUI`, que cria a janela com o botão para tocar o hino.
- O hino é reproduzido usando a biblioteca de áudio do Java, ao clicar no botão.

### Exemplo de Uso

1. Compile e execute a classe `TimesGUI`.
2. Clique no botão "Tocar o hino mais lindo do mundo" para ouvir o hino do Corinthians.

## Requisitos

- Java Development Kit (JDK) instalado.
- Um arquivo WAV do hino do Corinthians localizado em `D:/Tarefa3Adriana/hino_corinthians.wav`.


