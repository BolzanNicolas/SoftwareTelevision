package ar.com.unlam.pb2;

import java.util.TreeSet;

public class Plan {

	private Integer id;
	private String nombre;
	private TreeSet<Canal> canales;
	private Double valor;

	
	public Plan(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.canales = new TreeSet<Canal>();
		this.valor = 5000.0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Canal> getCanales() {
		return canales;
	}

	public void setCanales(TreeSet<Canal> canales) {
		this.canales = canales;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
