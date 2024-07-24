package ar.com.unlam.pb2;


public class Premium extends Plan {

	public Premium(Integer id, String nombre) {
		super(id, nombre);	
	}
	
	@Override
	public Double getValor() {
		return super.getValor() * 1.2;
	}
}
