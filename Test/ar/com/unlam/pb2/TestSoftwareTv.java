package ar.com.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeSet;

public class TestSoftwareTv {
	
	SoftwareTv btc = new SoftwareTv("BTC");

	@Before
	public void setup() {
		btc = new SoftwareTv("BTC");
	}

//1
	@Test
	public void dadoQueExisteUnaCompaniaSePuedeAgregarUnCliente() {
		Cliente clienteNico = new Cliente(3425, "Nico", "Pipo", 30);
		
		assertTrue(btc.agregarCliente(clienteNico));
	}
	
//2
	@Test
	public void dadoQueExisteUnaCompaniaAlAgregarUnClienteExistenteSeLanzaUnaClienteExistenteException() {
		Cliente clienteNico = new Cliente(3425, "Nico", "Pipo", 30);
		Cliente clienteNico2 = new Cliente(3425, "Nico", "Pipo", 30);

		btc.agregarCliente(clienteNico);
		
		assertThrows(ClienteExistenteException.class, () -> 
					{ btc.agregarCliente(clienteNico2); } );
		
	}
//3	
	@Test
	public void dadoQueExisteUnaCompaniaConUnPlanBasicoYUnPlanPremiumCuandoSeObtieneElPrecioDeUnPlanPremiumDevuelve6000() {
		Premium planPremium = new Premium(1, "Premium");	
		Basico planBasico = new Basico(2, "Basico");
		
		btc.agregarPlan(planPremium);
		btc.agregarPlan(planBasico);
		
		assertTrue(planPremium.getValor() == 6000.0);
	}
//4	
	@Test
	public void dadoQueExisteUnaCompaniaConClientesSePuedenListarLosClientesOrdenadosDeManeraAscendentePorSuDni(){
		Cliente clienteNico = new Cliente(8425, "Nico", "Pipo", 30);
		Cliente clienteJavi = new Cliente(5713, "Javi", "Pipo", 32);

		btc.agregarCliente(clienteNico);
		btc.agregarCliente(clienteJavi);
		
		assertEquals(btc.getClientesOrdenadosAscendente().toArray()[1], clienteNico);
	}
//4	
	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLasSuscripcionesAPlanesPremium() {	
		Cliente clienteNico = new Cliente(8425, "Nico", "Pipo", 30);
		Cliente clienteJavi = new Cliente(5713, "Javi", "Pipo", 32);
		Premium planPremium = new Premium(1, "Premium");	
		
		btc.agregarPlan(planPremium);
		btc.agregarCliente(clienteNico);
		btc.agregarCliente(clienteJavi);
		btc.agregarSuscripcion(1, clienteNico, planPremium);
		btc.agregarSuscripcion(2, clienteJavi, planPremium);
		
		assertNotNull(btc.getClientesPremium(planPremium.getId()));
	}
//5
	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLosClientesSuscritosAPlanesBasicos() {
		Cliente clienteNico = new Cliente(8425, "Nico", "Pipo", 30);
		Cliente clienteJavi = new Cliente(5713, "Javi", "Pipo", 32);
		Basico planBasico = new Basico(1, "Basico");	
		
		btc.agregarPlan(planBasico);
		btc.agregarCliente(clienteNico);
		btc.agregarCliente(clienteJavi);
		btc.agregarSuscripcion(1, clienteNico, planBasico);
		btc.agregarSuscripcion(2, clienteJavi, planBasico);
		
		assertNotNull(btc.getClientesPremium(planBasico.getId()));
	}
//6
	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedeMostrarElTotalDePrecioParaUnPlanBasicoOPremium(){
		Premium planPremium = new Premium(1, "Premium");	
		Basico planBasico = new Basico(2, "Basico");
		
		btc.agregarPlan(planPremium);
		btc.agregarPlan(planBasico);
		
		assertTrue(planPremium.getValor() == 6000.0);
		assertTrue(planBasico.getValor() == 5000.0);
	}
//7
	@Test
	public void dadoQueExisteUnCompaniaConClientesSuscritosAPlanesBasicosOPremiumSePuedeObtnerUnMapaConElPlanComoClaveYUnaListaDeClientesOrdenadosDeManeraDescendentePorDniDelClienteComoValores() {
		Premium planPremium = new Premium(1, "Premium");	
		Basico planBasico = new Basico(2, "Basico");
		Cliente clienteNico = new Cliente(8425, "Nico", "Pipo", 30);
		Cliente clienteJavi = new Cliente(5713, "Javi", "Pipo", 32);
		Cliente clienteTiro = new Cliente(9315, "Tiro", "Quico", 36);
		Cliente clientePol = new Cliente(1466, "Pol", "Mano", 54);

		
		btc.agregarPlan(planPremium);
		btc.agregarPlan(planBasico);
		btc.agregarCliente(clienteNico);
		btc.agregarCliente(clienteJavi);
		btc.agregarCliente(clienteTiro);
		btc.agregarCliente(clientePol);
		btc.agregarSuscripcion(2, clienteNico, planBasico);
		btc.agregarSuscripcion(1, clienteJavi, planPremium);
		btc.agregarSuscripcion(2, clientePol, planBasico);
		btc.agregarSuscripcion(2, clienteTiro, planBasico);
		
		HashMap<Integer, TreeSet<Cliente>> map = btc.getMapaDeClientesPorPlan(1, 2);
		assertEquals(map.get(planBasico.getId()).toArray()[0], clienteTiro);
	}
}
