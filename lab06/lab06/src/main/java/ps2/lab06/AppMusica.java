// MODELO PARA CRUD DE MÚSICAS
// Usando Spring Boot, similar ao exemplo dado

package ps2.lab06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AppMusica implements CommandLineRunner {

    @Autowired
    private MusicaRepo musicaRepo;

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(AppMusica.class, args);
    }

    @Override
    public void run(String... args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\nMENU - CRUD de Músicas");
            System.out.println("(1) Cadastrar música");
            System.out.println("(2) Listar músicas");
            System.out.println("(3) Buscar por título");
            System.out.println("(4) Remover música");
            System.out.println("(5) Sair");
            System.out.print("# Escolha uma opção: ");

            int opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    cadastrarMusica();
                    break;
                case 2:
                    listarMusicas();
                    break;
                case 3:
                    buscarPorTitulo();
                    break;
                case 4:
                    removerMusica();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarMusica() {
        System.out.print("Título: ");
        String titulo = entrada.nextLine();
        System.out.print("Compositor: ");
        String compositor = entrada.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(entrada.nextLine());
        
        musicaRepo.save(new Musica(titulo, compositor, ano));
        System.out.println("Música cadastrada com sucesso!");
    }

    private void listarMusicas() {
        List<Musica> musicas = (List<Musica>) musicaRepo.findAll();
        System.out.println("\nLista de Músicas:");
        for (Musica m : musicas) {
            System.out.println(m);
        }
    }

    private void buscarPorTitulo() {
        System.out.print("Título: ");
        String titulo = entrada.nextLine();
        List<Musica> musicas = musicaRepo.findByTitulo(titulo);
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música encontrada com esse título.");
        } else {
            for (Musica m : musicas) {
                System.out.println(m);
            }
        }
    }

    private void removerMusica() {
        System.out.print("Título da música a remover: ");
        String titulo = entrada.nextLine();
        List<Musica> musicas = musicaRepo.findByTitulo(titulo);
        if (musicas.isEmpty()) {
            System.out.println("Música não encontrada.");
        } else {
            musicaRepo.deleteAll(musicas);
            System.out.println("Música(s) removida(s).");
        }
    }
}
