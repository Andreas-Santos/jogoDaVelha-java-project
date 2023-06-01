import java.util.Scanner;

public class jogoDaVelha {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String player1; //nome do primeiro jogador
        String player2; //nome do segundo jogador
        char p1; //simbolo do primeiro jogador
        char p2; //simbolo do segundo jogador
        boolean fim = false;
        char[][] matriz = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}}; //inicialização da matriz

        //pega o nome dos dois jogadores
        System.out.println("Digite o nome do primeiro jogador:");
        player1 = scan.nextLine();
        System.out.println("Digite o nome do segundo jogador:");
        player2 = scan.nextLine();
        System.out.println("");
        //define o simbolo a ser utilizado pelos dois jogadores
        do{
            System.out.printf("%s, qual simbolo deseja utilizar(X ou O)?", player1);
            p1 = scan.next().charAt(0);

            System.out.println(p1);
        }while((p1 != 'O') && (p1 != 'X'));

        if(p1 == 'X'){
            p2 = 'O';
        }else{
            p2 = 'X';
        }

        System.out.println("-----------------------------------");    
        System.out.printf("O jogador %s ficou com o simbolo %c\n", player1, p1);
        System.out.printf("O jogador %s ficou com o simbolo %c\n", player2, p2);
        System.out.println("");

        //explicação da seleção da jogada
        System.out.println("Para jogar, basta digitar o número da casa que deseja preencher durante a sua jogada(como o exemplo abaixo)");
        printMatriz(matriz);

        //zera os valores dentro da matriz para melhor exibição
        for(int x = 0; x < matriz.length; x++){
            for(int y = 0; y < matriz[0].length; y++){
                matriz[x][y] = ' ';
            }
        }

        //loop para realizar todas as jogadas
        for(int i = 1; i < 5; i++){

            //jogada do primeiro jogador
            System.out.println("");
            selecionarJogada(matriz, player1, p1, i);

            //checa se o jogador venceu o jogo
            if((matriz[0][0] == p1 && matriz[0][1] == p1 && matriz[0][2] == p1)
            || (matriz[0][0] == p1 && matriz[1][1] == p1 && matriz[2][2] == p1)
            || (matriz[0][0] == p1 && matriz[1][0] == p1 && matriz[2][0] == p1)
            || (matriz[0][0] == p1 && matriz[1][0] == p1 && matriz[2][0] == p1)
            || (matriz[0][1] == p1 && matriz[1][1] == p1 && matriz[2][1] == p1)
            || (matriz[0][2] == p1 && matriz[1][2] == p1 && matriz[2][2] == p1)
            || (matriz[1][0] == p1 && matriz[1][1] == p1 && matriz[1][2] == p1)
            || (matriz[2][0] == p1 && matriz[2][1] == p1 && matriz[2][2] == p1)
            || (matriz[2][0] == p1 && matriz[1][1] == p1 && matriz[0][2] == p1)
            ){
                System.out.printf("O jogador %s venceu!\n", player1);
                printMatriz(matriz);
                fim = true;
                break;
            }

            //jogada do segundo jogador
            System.out.println("");
            selecionarJogada(matriz, player2, p2, i);

            //checa se o jogador venceu o jogo
            if((matriz[0][0] == p2 && matriz[0][1] == p2 && matriz[0][2] == p2)
            || (matriz[0][0] == p2 && matriz[1][1] == p2 && matriz[2][2] == p2)
            || (matriz[0][0] == p2 && matriz[1][0] == p2 && matriz[2][0] == p2)
            || (matriz[0][0] == p2 && matriz[1][0] == p2 && matriz[2][0] == p2)
            || (matriz[0][1] == p2 && matriz[1][1] == p2 && matriz[2][1] == p2)
            || (matriz[0][2] == p2 && matriz[1][2] == p2 && matriz[2][2] == p2)
            || (matriz[1][0] == p2 && matriz[1][1] == p2 && matriz[1][2] == p2)
            || (matriz[2][0] == p2 && matriz[2][1] == p2 && matriz[2][2] == p2)
            || (matriz[2][0] == p2 && matriz[1][1] == p2 && matriz[0][2] == p2)
            ){
                System.out.printf("O jogador %s venceu!\n", player2);
                printMatriz(matriz);
                fim = true;
                break;
            }
        }

        //verifica se o jogo acabou, se não solicita o preenchimento da ultima casa e declara empate
        if(fim == false){
            selecionarJogada(matriz, player1, p1, 5);

            //checa se o jogador venceu o jogo
            if((matriz[0][0] == p1 && matriz[0][1] == p1 && matriz[0][2] == p1)
            || (matriz[0][0] == p1 && matriz[1][1] == p1 && matriz[2][2] == p1)
            || (matriz[0][0] == p1 && matriz[1][0] == p1 && matriz[2][0] == p1)
            || (matriz[0][0] == p1 && matriz[1][0] == p1 && matriz[2][0] == p1)
            || (matriz[0][1] == p1 && matriz[1][1] == p1 && matriz[2][1] == p1)
            || (matriz[0][2] == p1 && matriz[1][2] == p1 && matriz[2][2] == p1)
            || (matriz[1][0] == p1 && matriz[1][1] == p1 && matriz[1][2] == p1)
            || (matriz[2][0] == p1 && matriz[2][1] == p1 && matriz[2][2] == p1)
            || (matriz[2][0] == p1 && matriz[1][1] == p1 && matriz[0][2] == p1)
            ){
                System.out.printf("O jogador %s venceu!\n", player1);
                printMatriz(matriz);
                fim = true;
            }else {
                printMatriz(matriz);
                System.out.println("-----------------------------------");  
                System.out.println("O jogo empatou!");
            }
        }

        scan.close();
    }

    //método para imprimir a matriz
    public static void printMatriz(char[][] mat){
        for(int x = 0; x < mat.length; x++){
            System.out.print("[ ");
            for(int y = 0; y < mat[0].length; y++){
                System.out.printf("%c ", mat[x][y]);
            }
            System.out.println("]");
        }
    }

    //método para o jogador selecionar sua jogada
    public static void selecionarJogada(char[][] mat, String player, char p, int cont){
        Scanner scan = new Scanner(System.in);

        int escolha; // define a escolha do jogador

        System.out.println("O jogo está da seguinte forma:");
        printMatriz(mat);

        //loop para definir escolha do jogador
        do{
            System.out.printf("%s faça sua %dª jogada digitando o número da casa:\n", player, cont);
            escolha = scan.nextInt();

            switch(escolha){
                case 1:
                    if(mat[0][0] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 2:
                    if(mat[0][1] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 3:
                    if(mat[0][2] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 4:
                    if(mat[1][0] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 5:
                    if(mat[1][1] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 6:
                    if(mat[1][2] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 7:
                    if(mat[2][0] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 8:
                    if(mat[2][1] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                case 9:
                    if(mat[2][2] != ' '){
                        escolha = 0;
                        System.out.println("A casa escolhida já está preenchida, tente outra casa!");
                        System.out.println("");
                    }
                    break;
                default:
                    System.out.println("Número escolhido inválido, tente novamente!");
                    System.out.println("");
                    break;
            }
        }while(escolha < 1 || escolha > 9);

        //preenche a matriz escolhida com o simbolo do jogador
        switch(escolha){
            case 1:
                mat[0][0] = p;
                break;
            case 2:
                mat[0][1] = p;
                break;
            case 3:
                mat[0][2] = p;
                break;
            case 4:
                mat[1][0] = p;
                break;
            case 5:
                mat[1][1] = p;
                break;
            case 6:
                mat[1][2] = p;
                break;
            case 7:
                mat[2][0] = p;
                break;
            case 8:
                mat[2][1] = p;
                break;
            case 9:
                mat[2][2] = p;
                break;
        }
    }
}