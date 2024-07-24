package ar.com.unlam.pb2;

import java.util.TreeSet;

public class Suscripcion {

	private Integer id;
	private Cliente cliente;
	private Plan plan;
	private TreeSet<Canal> canales;
	
	public Suscripcion(Integer id, Cliente cliente, Plan plan, TreeSet<Canal> canales) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.plan = plan;
		this.canales = canales;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setIdPlan(Plan plan) {
		this.plan = plan;
	}

	public TreeSet<Canal> getCanales() {
		return canales;
	}

	public void setCanales(TreeSet<Canal> canales) {
		this.canales = canales;
	}
	
	
}
