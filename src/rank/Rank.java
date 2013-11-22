/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rank;

import java.util.ArrayList;
import java.util.List;
import jogodavelha.Jogo;

/**
 *
 * @author LOI2
 */
public class Rank {
    int jogador1;
    int jogador2;
    int empate;
    ManipulaTxt arq;
    jogodavelha.Jogo jogo = new Jogo();

    public Rank() {
        arq = new ManipulaTxt("C:\\dados\\rank.txt");
    }

    
    private void atualizaLinha(String linha){
        arq.insereLinha(linha, false);
    }
    @Override
    public String toString(){
        return jogador1 + ";" + jogador2 + ";" + empate;
    }
    public void contar(){
        switch (jogo.verificaGanhador(jogo.getJogadas())) {
            case "Jogador 1 venceu.":
                jogador1++;
                atualizaLinha(toString());
                break;
            
            case "Jogador 2 venceu.":
                jogador2++;
                atualizaLinha(toString());
                break;
            case "Sem ganhador":
                empate++;
                atualizaLinha(toString());
                break;
        }
    }
    public List<String> getLista(){
        List<String> lista = new ArrayList<String>();
        for (int i = 0; i < arq.getLinhas().size(); i++) {
          lista = arq.getLinhas();    
        }
        
        return lista;
    }
    
}
