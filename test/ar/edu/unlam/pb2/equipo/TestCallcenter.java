package ar.edu.unlam.pb2.equipo;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCallcenter {
	
	@Test
	public void queSePuedaRegistrarUnaLlamada(){
		Contacto contacto = new Contacto("jorge","jorge@gmail.com","ja",1888,"ksks",Provincia.BUENOS_AIRES,true,true);
		Llamada llamada = new Llamada(true, "facha");
		
		contacto.registrarNuevaLlamada(llamada, contacto);
		assertEquals(1, contacto.getNumeroDeLlamadasRegistradas());


	
	}

}
