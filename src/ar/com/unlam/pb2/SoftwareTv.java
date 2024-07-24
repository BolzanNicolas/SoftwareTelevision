package ar.com.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class SoftwareTv {

	private String nombre;
	private HashSet<Cliente> clientes;
	private ArrayList<Plan> planes;
	private HashSet<Canal> canales;
	private HashSet<Suscripcion> suscripciones;
	
	public SoftwareTv(String nombre) {
		this.nombre = nombre;
		this.clientes = new HashSet<Cliente>();
		this.planes = new ArrayList<Plan>();
		this.canales = new HashSet<Canal>();
		this.suscripciones = new HashSet<Suscripcion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Cliente> getClientesOrdenadosAscendente() {
		TreeSet<Cliente> ordenados = new TreeSet<Cliente>(new ComparadorClientesAscendente());
		ordenados.addAll(clientes);
		return ordenados;
	}
	
	public TreeSet<Cliente> getClientesOrdenadosDescendente() {
		TreeSet<Cliente> ordenados = new TreeSet<Cliente>(new ComparadorClientesDescendente());
		ordenados.addAll(clientes);
		return ordenados;
	}
	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setCliente(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Plan> getPlan() {
		return planes;
	}

	public void setPlan(ArrayList<Plan> planes) {
		this.planes = planes;
	}

	public HashSet<Canal> getCanales() {
		return canales;
	}

	public void setCanales(HashSet<Canal> canales) {
		this.canales = canales;
	}

	public HashSet<Suscripcion> getSuscripciones() {
		return suscripciones;
	}

	public void setSuscripciones(HashSet<Suscripcion> suscripciones) {
		this.suscripciones = suscripciones;
	}
	
	public Boolean agregarCliente(Cliente cliente) {
		if(clientes.contains(cliente)){
			throw new ClienteExistenteException();
		}else {
			return clientes.add(cliente);
		}
	}
	
	public Boolean agregarCanal(Canal canal) {
		return canales.add(canal);
	}
	
	public Boolean agregarPlan(Plan plan) {
		return planes.add(plan);
	}
	
	public Boolean agregarSuscripcion(Integer id, Cliente cliente, Plan plan) {
		Suscripcion suscripcion = new Suscripcion(id, cliente, plan, null);
		return suscripciones.add(suscripcion);
	}

	public HashSet<Suscripcion> getClientesPremium(Integer idPremium){
		HashSet<Suscripcion> clientesPremium = new HashSet<Suscripcion>();
		
		for(Suscripcion suscripcion : suscripciones) {
			if(suscripcion.getPlan().getId() == idPremium) {
				clientesPremium.add(suscripcion);
			}
		}
		return clientesPremium;
	}
	
	public HashSet<Suscripcion> getClientesBasicos(Integer idBasico){
		HashSet<Suscripcion> clientesBasico = new HashSet<Suscripcion>();
		
		for(Suscripcion suscripcion : suscripciones) {
			if(suscripcion.getPlan().getId() == idBasico) {
				clientesBasico.add(suscripcion);
			}
		}
		return clientesBasico;
	}
	
	public HashMap<Integer, TreeSet<Cliente>> getMapaDeClientesPorPlan(Integer idPremium, Integer idBasico) {
		HashMap<Integer, TreeSet<Cliente>> mapa = new HashMap<Integer, TreeSet<Cliente>>();

		TreeSet<Cliente> basicosOrdenadosDesc = new TreeSet<Cliente>(new ComparadorClientesDescendente());

		for(Suscripcion suscripcion : this.getClientesBasicos(idBasico)) {
			basicosOrdenadosDesc.add(suscripcion.getCliente());
		}
		
		TreeSet<Cliente> premiumOrdenadosDesc = new TreeSet<Cliente>(new ComparadorClientesDescendente());

		for(Suscripcion suscripcion : this.getClientesPremium(idPremium)) {
			premiumOrdenadosDesc.add(suscripcion.getCliente());
		}
		
		mapa.put(idPremium, premiumOrdenadosDesc);
		mapa.put(idBasico, basicosOrdenadosDesc);
		
		return mapa;
	}

}
