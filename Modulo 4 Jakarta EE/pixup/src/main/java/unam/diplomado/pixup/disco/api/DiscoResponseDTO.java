package unam.diplomado.pixup.disco.api;

public class DiscoResponseDTO {

    private Integer id;
    private String titulo;
    private String artista;
    private String disquera;
    private String genero;
    private Float precio;

    public DiscoResponseDTO(Integer id, String titulo, String artista, String disquera, String genero, Float precio) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.disquera = disquera;
        this.genero = genero;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getDisquera() {
        return disquera;
    }

    public String getGenero() {
        return genero;
    }

    public Float getPrecio() {
        return precio;
    }
}
