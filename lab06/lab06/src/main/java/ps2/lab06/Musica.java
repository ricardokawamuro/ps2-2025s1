package ps2.lab06;

import jakarta.persistence.*;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String compositor;
    private int ano;

    public Musica() {}

    public Musica(String titulo, String compositor, int ano) {
        this.titulo = titulo;
        this.compositor = compositor;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " | " + compositor + " (" + ano + ")";
    }

    // Getters e setters omitidos por brevidade (mas devem ser adicionados)
}
