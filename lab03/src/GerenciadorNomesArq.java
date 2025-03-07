package lab03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesArq implements GerenciadorNomes {
    private static final String ARQUIVO = "nomes.txt";

    @Override
    public void adicionarNome(String nome) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(nome);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    @Override
    public void removerNome(String nome) {
        List<String> nomes = listarNomes();
        if (nomes.remove(nome)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
                for (String n : nomes) {
                    writer.write(n);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao remover nome: " + e.getMessage());
            }
        }
    }

    @Override
    public List<String> listarNomes() {
        List<String> nomes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                nomes.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return nomes;
    }
}
