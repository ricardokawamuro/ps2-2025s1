package ps2.lab06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private ProfessorRepo professorRepo;

	@Autowired
	private FaculdadeRepo faculdadeRepo;

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) {
		out.println("# Gerenciador de Professores e Faculdades!");
		//Professor p = new Professor("Carlos", "5555", 999);
		//professorRepo.save(p);
		//out.println("id do novo professor: " + p.getId());
		boolean sair = false;
		while (!sair) {
			out.println("\nMenu");
			out.println("(1) Criar Faculdade");
			out.println("(2) Listar Faculdades");
			out.println("(3) Criar Professor");
			out.println("(4) Listar Professores");
			out.println("(0) Sair");
			out.print("# Escolha uma opção: ");
			int opcao = Integer.parseInt(entrada.nextLine());

			switch(opcao) {
			case 1: 
				break;

			case 2: 
				break;

	        case 3: 
			System.out.prinln("Nome do novo professor: ");
			entrada = new entrada.Line();
			System.out.println("CPF do novo professor: ");
			entrada = new 
			System.out.println("Digite a matrícula do professor: ");


				break;
			
			case 4: 
				break;

			case 5: 
				break;

			case 6: 
				break;
		}

		private static void criarFacudade() {
			out.println("\n CRIAÇÃO DE NOVA FACULDADE");
			out.println("Nome da nova faculdade: ");
			String nome = entrada.nextLine();
			out.print("Ano da fundacao desta faculdade: ");
			int ano = Integer.parseInt

		}


		Faculdade f = new Faculdade("Faculdade de Engenharia", 1890);
		faculdadeRepo.save(f);
		out.println("id da nova faculdade: " + f.getId());

		out.println("Pressione ENTER para terminar o programa...");
		entrada.nextLine();
	}
}