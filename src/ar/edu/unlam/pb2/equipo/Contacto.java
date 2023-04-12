package ar.edu.unlam.pb2.equipo;

public class Contacto {
	private String nombreyapellido;
	private String email;
	private String direccion;
	private Integer codigopostal;
	private String localidad;
	private Provincia provincia;
	private boolean esCliente = false;
	private boolean deseaSerLlamadoNuevamente = true;
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 *	Nombre y Apellido: No se aceptan números.
	 *	Celular: Compuesto del código de país + código de área + número de celular.
	 *	E-Mail: Debe contener al menos el símbolo @ y el caracter ..
	 *	Dirección: Valor alfanumérico.
	 *	Código Postal: Valor numérico.
	 *	Localidad: Valor alfanumérico.
	 *	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 *	Es cliente (Si o No): Inicialmente se carga en No.
	 *	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en Si.
	 */
	

	public String validarEmail(String email) {
	    String regex = "^[^@]+@[^@]+\\.[^@]+$";
	    return String.valueOf(email.matches(regex));
	}
	
	public Contacto(String nombreyapellido, String email, String direccion, Integer codigopostal, String localidad,
			Provincia provincia, boolean esCliente, boolean deseaSerLlamadoNuevamente) {
		super();
		this.nombreyapellido = nombreyapellido;
		this.email = email;
		this.direccion = direccion;
		this.codigopostal = codigopostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.esCliente = esCliente;
		this.deseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}

	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		return false;
	}
	
	@Override
	public String toString() {
		return "Contacto [nombreyapellido=" + nombreyapellido + ", email=" + email + ", direccion=" + direccion
				+ ", codigopostal=" + codigopostal + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", esCliente=" + esCliente + ", deseaSerLlamadoNuevamente=" + deseaSerLlamadoNuevamente + "]";
	}

	public String getNombreyapellido() {
		return nombreyapellido;
	}

	public void setNombreyapellido(String nombreyapellido) {
		this.nombreyapellido = nombreyapellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(Integer codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public boolean isEsCliente() {
		return esCliente;
	}

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	public boolean isDeseaSerLlamadoNuevamente() {
		return deseaSerLlamadoNuevamente;
	}

	public void setDeseaSerLlamadoNuevamente(boolean deseaSerLlamadoNuevamente) {
		this.deseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}
	

}
