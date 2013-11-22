package jogodavelha;

public class AI {
Jogo jogo = new Jogo();
String tab[] = new String[8];
 private int linha, coluna;
public AI(){
	tabuleiro();
	melhorJogada();
}
public int getLinha (){
	return linha;
}
public int getColuna(){
	return coluna;
}

public void tabuleiro(){
	tab[0] = jogo.getTabuleiro()[0][0] + jogo.getTabuleiro()[0][1] + jogo.getTabuleiro()[0][2];
    tab[1] = jogo.getTabuleiro()[1][0] + jogo.getTabuleiro()[1][1] + jogo.getTabuleiro()[1][2];
    tab[2] = jogo.getTabuleiro()[2][0] + jogo.getTabuleiro()[2][1] + jogo.getTabuleiro()[2][2];
    tab[3] = jogo.getTabuleiro()[0][0] + jogo.getTabuleiro()[1][0] + jogo.getTabuleiro()[2][0];
    tab[4] = jogo.getTabuleiro()[0][1] + jogo.getTabuleiro()[1][1] + jogo.getTabuleiro()[2][1];
    tab[5] = jogo.getTabuleiro()[0][2] + jogo.getTabuleiro()[1][2] + jogo.getTabuleiro()[2][2];
    tab[6] = jogo.getTabuleiro()[0][0] + jogo.getTabuleiro()[1][1] + jogo.getTabuleiro()[2][2];
    tab[7] = jogo.getTabuleiro()[0][2] + jogo.getTabuleiro()[1][1] + jogo.getTabuleiro()[2][0];
}
public void melhorJogada(){ //Este método analisa a melhor jogada a ser feita sem que haja alguem com chance de vitória
	if (jogo.getTabuleiro()[1][1].equals("-")){
		linha = 1;
		coluna = 1;
	} else if (jogo.getTabuleiro()[0][0].equals("-")){
		linha = 0;
		coluna = 0;
	} else if (jogo.getTabuleiro()[0][2].equals("-")){
		linha = 0;
		coluna = 2;
	} else if (jogo.getTabuleiro()[2][0].equals("-")){
		linha = 2;
		coluna = 0;
	} else if (jogo.getTabuleiro()[2][2].equals("-")){
		linha = 2;
		coluna = 2;
	} else {
            linha = NumerosAleatorios.gerarNumero();
            coluna = NumerosAleatorios.gerarNumero();
        }

}
}