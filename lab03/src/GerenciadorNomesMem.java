package lab03;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesMem implements GerenciadorNomes {
    private List<String> nomes = new ArrayList<>();

    @Override
    public void adicionarNome(String nome) {
        nomes.add(nome);
    }

    @Override
    public void removerNome(String nome) {
        nomes.remove(nome);
    }

    @Override
    public List<String> listarNomes() {
        return new ArrayList<>(nomes);
    }
}
