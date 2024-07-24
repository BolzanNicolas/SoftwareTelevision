package ar.com.unlam.pb2;

import java.util.Objects;

public class Canal {

	private Integer numero;
	private String nombre;
	private TipoDeCanal tipoCanal;
	private String clasificacion;
	
	public Canal(Integer numero, String nombre, TipoDeCanal tipoCanal, String clasificacion) {
		this.numero = numero;
		this.nombre = nombre;
		this.tipoCanal = tipoCanal;
		this.clasificacion = clasificacion;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeCanal getTipoCanal() {
		return tipoCanal;
	}

	public void setTipoCanal(TipoDeCanal tipoCanal) {
		this.tipoCanal = tipoCanal;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canal other = (Canal) obj;
		return Objects.equals(numero, other.numero);
	}
	
	
}
