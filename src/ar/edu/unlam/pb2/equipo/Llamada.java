package ar.edu.unlam.pb2.equipo;

public class Llamada {
	private boolean fueExitosa;
	private String observaciones;
	private Integer id = 0;
	
	public Llamada(boolean fueExitosa, String observaciones) {
		this.setFueExitosa(fueExitosa);
		this.setObservaciones(observaciones);
		id = id + 1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isFueExitosa() {
		return fueExitosa;
	}

	public void setFueExitosa(boolean fueExitosa) {
		this.fueExitosa = fueExitosa;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
