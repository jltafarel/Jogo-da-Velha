/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;


/**
 *
 * @author LOI2
 */
public class Jogo {

    String[][] tabuleiro = new String[3][3];
    int jogadas = 0;
    Jogador jogadores = new Jogador();
    boolean vitoria = false;
    boolean velha = false;

    public boolean isVelha() {
        return velha;
    }

    public int getJogadas() {
        return jogadas;
    }

    public boolean isVitoria() {
        return vitoria;
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Jogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = "-";
            }
        }
        vitoria = false;
        velha = false;
        
    }

    public void jogada(int linha, int coluna) {
        if ("-".equals(tabuleiro[linha][coluna])) {
            if (jogadas % 2 == 0) {
                tabuleiro[linha][coluna] = jogadores.getJogador1();
                jogadas++;
            } else {
                tabuleiro[linha][coluna] = jogadores.getJogador2();
                jogadas++;
            }
        }
    }

    @SuppressWarnings("unused")
	private void imprimeTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j == 0 || j == 1) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
        System.out.println("-----------");
    }

    public String verificaGanhador(int jogadas) {
        String msg = "";
        String[] tab = new String[8];
        tab[0] = tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2];
        tab[1] = tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2];
        tab[2] = tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2];
        tab[3] = tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0];
        tab[4] = tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1];
        tab[5] = tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2];
        tab[6] = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        tab[7] = tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];
        for (int i = 0; i < tab.length; i++) {
            switch (tab[i]) {
                case "XXX":
                    msg = "Jogador 1 venceu.";
                    vitoria = true;
                    break;
                case "OOO":
                    msg = "Jogador 2 venceu.";
                    vitoria = true;
                    break;
            }
            if (vitoria){
                break;
            }
        }
        if (jogadas == 9 && vitoria == false) {
            msg = "Sem ganhador";
            velha = true;
        }
        return msg;
    }
}