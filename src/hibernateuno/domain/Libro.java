package hibernateuno.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idlibro")
	private Long id;
		
	@Column(name="titulo") // No es necesario porque las columnas de la tabla se llaman de igual manera
	private String titulo;
	@Column(name="autor")
	private String autor;
	@Column(name="editorial")
	private String editorial;
	@Column(name="anio_registrado_bd")
	private Timestamp anio;
	
	public Libro() {}
	
	public Libro(String titulo, String autor, String editorial, Timestamp anio) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anio = anio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Timestamp getAnio() {
		return anio;
	}
	public void setAnio(Timestamp anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", anio="
				+ anio + "]";
	}
		
	

}
