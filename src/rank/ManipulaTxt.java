package rank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManipulaTxt {
    private String nomeArq;

    public ManipulaTxt(String nomeArq){
        this.nomeArq = nomeArq;
    }

    public void insereLinha(String linha, boolean adicionar){
        PrintWriter escritor = null;
        try {
            escritor = new PrintWriter(
                    new FileWriter(nomeArq, adicionar));
            escritor.println(linha);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (escritor!=null) {
                escritor.close();
            }
        }
    }

    public void gravar(List<String> linhas, boolean adicionar){
        PrintWriter escritor = null;
        try {
            // se adicionar for true irá inserir linhas no final do arquivo
            // se adicionar for false irá sobrescrever o arquivo
            escritor = new PrintWriter(
                    new FileWriter(nomeArq, adicionar));
            for (int i = 0; i < linhas.size(); i++) {
                escritor.println((String)linhas.get(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (escritor!=null) {
                escritor.close();
            }
        }
    }

    public List<String> getLinhas(){
        List<String> linhas = new ArrayList<String>();
        String linha="";
        try {
            File arquivo = new File(nomeArq);
            if (arquivo.exists()){
               BufferedReader br = new BufferedReader(
                    new FileReader(arquivo)
                    );
               while(linha!=null){
                  linha = br.readLine();
                  if (linha!=null){
                      linhas.add(linha);
                  }
               }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return linhas;
    }

    public String getArquivo(){
        String str = "";
        String linha="";
        try {
            File arquivo = new File(nomeArq);
            if (arquivo.exists()){
               BufferedReader br = new BufferedReader(
                    new FileReader(arquivo)
                    );
               while(linha!=null){
                  linha = br.readLine();
                  if (linha!=null){
                     str += linha+"\n";
                  }
               }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return str;
    }

    public void excluir(){
        File arq = new File(nomeArq);
        arq.delete();
    }

}
