# BandasGUI

## Descrição
O projeto **BandasGUI** é uma aplicação Java que utiliza a biblioteca Swing para criar uma interface gráfica que permite ao usuário tocar músicas da minha antiga banda, chamada **LockFist669**. O aplicativo apresenta uma lista de músicas disponíveis e um botão para tocar a música selecionada.

## Funcionalidades
- Exibição de um GIF representando a banda.
- Um menu suspenso (ComboBox) que permite ao usuário selecionar uma música.
- Um botão que, ao ser clicado, toca a música escolhida.
- Suporte para arquivos de áudio no formato `.wav`.

## Estrutura do Código

### Principais Componentes
1. **JFrame**: Cria a janela principal da aplicação.
2. **JLabel**: Exibe a imagem GIF da banda.
3. **JComboBox**: Permite ao usuário selecionar uma música da lista.
4. **JButton**: Inicia a reprodução da música selecionada.
5. **AudioInputStream e Clip**: Utilizados para manipular e tocar os arquivos de áudio.

### Fluxo da Aplicação
- Ao iniciar o programa, uma janela é criada com um título, um GIF e um botão para tocar música.
- O usuário pode escolher uma música da lista disponível.
- Ao clicar no botão "Tocar música escolhida", o aplicativo tenta localizar o arquivo de áudio correspondente no diretório especificado.
- Se o arquivo for encontrado, a música será reproduzida.
