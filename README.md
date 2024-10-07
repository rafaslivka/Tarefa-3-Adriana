# 📚 Projeto de Gerenciamento de Dados

## Descrição
Este projeto foi desenvolvido em Java e tem como objetivo gerenciar diferentes tipos de dados relacionados a produtos, serviços e informações relevantes. O projeto inclui classes para representar bandas, carros, cervejas, chocolates, eletrônicos, frutas, jogadores, redes sociais, streamings e times de futebol.

## Estrutura do Projeto

### 🎶 Classes de Bandas
1. **Bandas**
   - Atributos:
     - `nome`: Nome da banda.
     - `anoFundacao`: Ano de fundação da banda.
     - `genero`: Gênero musical da banda.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações sobre a banda.
     - `compararAno()`: Compara o ano de fundação com outras bandas.
     - `tocarMusica()`: Reproduz uma música/hino da banda.

### 🚗 Classes de Carros
2. **Carros**
   - Atributos:
     - `nome`: Nome do carro.
     - `modelo`: Modelo do carro.
     - `ano`: Ano de fabricação.
   - Métodos:
     - `ligar()`: Liga o carro.
     - `desligar()`: Desliga o carro.

### 🍺 Classes de Cervejas
3. **Cervejas**
   - Atributos:
     - `nome`: Nome da cerveja.
     - `tipo`: Tipo da cerveja.
     - `marca`: Marca da cerveja.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações da cerveja.
     - `volumes()`: Exibe os volumes disponíveis.
     - `compararPeso()`: Compara o peso com outras cervejas.

### 🍫 Classes de Chocolates
4. **Chocolates**
   - Atributos:
     - `nome`: Nome do chocolate.
     - `tipo`: Tipo de chocolate.
     - `marca`: Marca do chocolate.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações sobre o chocolate.
     - `volumes()`: Exibe os volumes disponíveis.
     - `compararPeso()`: Compara o peso com outros chocolates.

### 📱 Classes de Eletrônicos
5. **Eletronicos**
   - Atributos:
     - `nome`: Nome do produto eletrônico.
     - `marca`: Marca do produto eletrônico.
     - `armazenamento`: Capacidade de armazenamento.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações sobre o eletrônico.
     - `ligar()`: Liga o produto eletrônico.
     - `desligar()`: Desliga o produto eletrônico.

### 🍉 Classes de Frutas
6. **Frutas**
   - Atributos:
     - `nome`: Nome da fruta.
     - `epoca`: Época do ano da fruta.
     - `peso`: Peso da fruta.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações sobre a fruta.
     - `atualizarPeso()`: Atualiza o peso da fruta.
     - `exibirEpocaDoAno()`: Exibe a época do ano.

### ⚽ Classes de Jogadores
7. **Jogadores**
   - Atributos:
     - `nome`: Nome do jogador.
     - `numero`: Número da camisa do jogador.
     - `peso`: Peso do jogador.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações sobre o jogador.
     - `atualizarPeso()`: Atualiza o peso do jogador.
     - `atualizarNumero()`: Atualiza o número da camisa.

### 🌐 Classes de Redes Sociais
8. **Redes Sociais**
   - Atributos:
     - `nomeDeUsuario`: Nome de usuário na rede social.
     - `numeroDeSeguidores`: Número de seguidores.
     - `peso`: Peso do usuário na rede social.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações sobre a rede social.
     - `enviarMensagem()`: Envia uma mensagem.
     - `seguir()`: Segue outro usuário.

### 🎬 Classes de Streaming
9. **Streamings**
   - Atributos:
     - `nome`: Nome do serviço de streaming.
     - `quantidadeUsuarios`: Número de usuários.
     - `quantidadeFilmes`: Número de filmes disponíveis.
   - Métodos:
     - `mostrarInformacoes()`: Exibe informações do streaming.
     - `atualizarQuantidadeFilmes(int novaQuantidade)`: Atualiza a quantidade de filmes.
     - `atualizarQuantidadeUsuarios(int novaQuantidade)`: Atualiza a quantidade de usuários.

### ⚽ Classes de Times
10. **Times**
    - Atributos:
      - `nome`: Nome do time.
      - `titulos`: Número de títulos conquistados.
      - `quantidadeMembros`: Número de membros do time.
    - Métodos:
      - `mostrarInformacoes()`: Exibe informações do time.
      - `tocarHino()`: Reproduz o hino do Corinthians.

## 🎵 Reproduzindo Músicas/Hinos
- O projeto inclui uma interface gráfica que permite reproduzir o hino do Corinthians na classe "Times" e uma música/hino de bandas na classe "Bandas", ambos intitulados "O Hino Mais Lindo do Mundo", ao clicar em um botão na interface.

## 🛠️ Requisitos
- Java Development Kit (JDK) instalado.
- Arquivos de áudio e classes corretamente configurados.

## 💻 Exemplo de Uso
1. Compile e execute a classe correspondente ao serviço desejado.
2. Interaja com a interface para visualizar ou atualizar informações e tocar músicas/hinos.
