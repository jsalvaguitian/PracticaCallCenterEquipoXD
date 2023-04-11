package ar.edu.unlam.pb2.equipo;

import java.util.Scanner;

import ar.edu.unlam.pb1.practica.examen.unfinal.Contacto;

public class InterfazCallCenter {
	private static final int INCORPORAR_ZONA_DE_COBERTURA = 1, DAR_DE_ALTA_UN_NUEVO_CONTACTO = 2,
			REALIZAR_UNA_LLAMADA = 3, VER_INFORMACION_DEL_CONTACTO = 4, SALIR = 9;

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		Empresa oesteCableColor = new Empresa();

		do {
			mostrarMenu();
			System.out.print("Ingrese una opción: ");
			opcion = teclado.nextInt();

			switch (opcion) {
			case INCORPORAR_ZONA_DE_COBERTURA:
				incorporarZonaDeCobertura(teclado, oesteCableColor);
				break;

			case DAR_DE_ALTA_UN_NUEVO_CONTACTO:
				darDeAltaNuevoContacto(teclado, oesteCableColor);
				break;

			case REALIZAR_UNA_LLAMADA:
				realizarNuevaLlamada(teclado, oesteCableColor);
				break;

			case VER_INFORMACION_DEL_CONTACTO:
				verInformacionDelContacto(teclado, oesteCableColor);
				break;

			default:
				System.out.println("Opción inválida. Intente otra vez");

			}

		} while (opcion != SALIR);

	}

	private static void mostrarMenu() {
		System.out.println("Bienvenido al callcenter");

		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Incorporar zona de cobertura");
		System.out.println("2 - Dar de alta un nuevo contacto");
		System.out.println("3 - Realizar nueva llamada");
		System.out.println("4 - Ver información del contacto");
		System.out.println("9 - Salir");
		System.out.println("************************");
	}

	/*
	 * Se registra un nuevo código postal dentro de la zona de cobertura de la
	 * empresa
	 */
	private static void incorporarZonaDeCobertura(Scanner teclado, Empresa unaEmpresa) {
		int codigoPostal;
		boolean seAgregoUnaNuevaZonaDeCobertura;

		System.out.println("Ingrese el codigo postal para incorporar una nueva zona de cobertura. ");
		codigoPostal = teclado.nextInt();

		seAgregoUnaNuevaZonaDeCobertura = unaEmpresa.agregarNuevaZonaDeCobertura(codigoPostal);

		if (seAgregoUnaNuevaZonaDeCobertura)
			System.out.println("Joya! :-) ya se agregó una nueva zona de cobertura");
		else
			System.out.println("Lo sentimos, no se pudo agregar la nueva zona de cobertura ¯\\_(ツ)_/¯");
	}

	/*
	 * Registra un nuevo contacto en la empresa
	 */
	private static void darDeAltaNuevoContacto(Scanner teclado, Empresa unaEmpresa) {
		Contacto nuevo = null;
		String nombreYApellido, eMail, direccion, localidad;
		int codigoPostal;
		int celular;
		int opcionProv = 0;
		Provincia[] provincias = Provincia.values();
		Provincia provincia;

		System.out.println("Ingrese el nombre y apellido del contacto");
		teclado.nextLine();
		nombreYApellido = teclado.nextLine();

		System.out.println("Ingrese el celular. ");
		celular = teclado.nextInt();
		do {
			System.out.println("Ingrese el correo electrónico");
			eMail = teclado.next();

			if (!Contacto.esEmailValido)
				System.out.println("El correo no es válido, por fa intente de nuevo escribirlo");
		} while (!Contacto.esEmailValido);

		System.out.println("Ingrese la dirección. ");
		teclado.nextLine();
		direccion = teclado.nextLine();

		System.out.println("Ingrese el código postal");
		codigoPostal = teclado.nextInt();

		System.out.println("Ingrese la localidad");
		teclado.nextLine();
		localidad = teclado.nextLine();

		do {
			System.out.println("Seleccione una provincia. ");
			for (int i = 0; i < provincias.length; i++) {
				System.out.println(i + 1 + ")" + provincias[i]);
			}
			opcionProv = teclado.nextInt();
			if (opcionProv <= 0 || opcionProv > provincias.length)
				System.out.println("Opción inválida. Intente de nuevo, please.");
		} while (opcionProv <= 0 || opcionProv > provincias.length);
		provincia = provincias[opcionProv - 1];

		nuevo = new Contacto(nombreYApellido, celular, eMail, direccion, codigoPostal, localidad, provincia);

		if (unaEmpresa.agregarNuevoContacto(nuevo))
			System.out.println("Perfecto! Se agregó un nuevo contacto");
		else
			System.out.println("Lo sentimos no se pudo agregar un nuevo contacto");

	}

	/*
	 * Busca un candidato, muestra los datos del mismo, y permite almacenar el
	 * resultado de la llamada.
	 * 
	 * a. Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y
	 * no se lo debe volver a llamar). 
	 * 
	 * b. Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga un nuevo
	 * intento en el futuro). c. Observaciones: Texto libre donde el operador deja
	 * registro de lo conversado.
	 */
	private static void realizarNuevaLlamada(Scanner teclado, Empresa unaEmpresa) {
		// busco el candidato
		Contacto candidato = unaEmpresa.buscarCandidato();
		Llamada nuevaLlamada = null;
		char opcion = '\0';
		boolean fueExitosa;
		String observaciones;

		System.out.println("¿La llamada fue exitosa? S(sí) / N(no)");
		opcion = teclado.next().toUpperCase().charAt(0);
		if(opcion == 'S') {
			fueExitosa = true;
			candidato.setEsCliente(true);
			candidato.setEsDeseadoSerLlamado(false);
		}

		System.out.println("¿Este contacto desea ser llamado nuevamente? S(sí) / N(no)");
		opcion = teclado.next().toUpperCase().charAt(0);
		if(opcion == 'N') 
			candidato.setEsDeseadoSerLlamado(false);
			
		System.out.println("¿Quiere dejar alguna observación?");
		observaciones = teclado.nextLine();

		nuevaLlamada = new Llamada(fueExitosa, observaciones);

		candidato.registrarNuevaLlamada(nuevaLlamada);

	}

	/*
	 * Se visualiza la información del contacto, incluso el listado de las llamadas
	 * que se le hicieron ¿A partir de que dato buscaqueremos a nuestro contacto? A
	 * partir del Nombre y apellido
	 */
	private static void verInformacionDelContacto(Scanner teclado, Empresa unaEmpresa) {
		String nombreYApellido;
		Contacto buscado;

		System.out.println("Ingrese el nombre y el apellido: ");
		teclado.nextLine();
		nombreYApellido = teclado.nextLine();
		buscado = unaEmpresa.buscarPorNombreCandidato(nombreYApellido);

		if (buscado != null)
			System.out.println(buscado.toString());
		else
			System.out.println("El candidato no existe. ¯\\_(ツ)_/¯");
	}

}
