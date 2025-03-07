package lab03;

import java.util.List;

public interface GerenciadorNomes {
    void adicionarNome(String nome);
    void removerNome(String nome);
    List<String> listarNomes();
}
