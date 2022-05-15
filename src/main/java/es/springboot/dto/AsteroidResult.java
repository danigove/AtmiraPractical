package es.springboot.dto;

import java.math.BigDecimal;

public class AsteroidResult implements Comparable
{

	
	private String name;
	
	private BigDecimal diametro;

	private String velocidad;
	
	private String fecha;
	
	private String planeta;
	
	
	public AsteroidResult(String name, BigDecimal diametro, String velocidad, String fecha, String planeta) {
		this.name = name;
		this.diametro = diametro;
		this.velocidad = velocidad;
		this.fecha = fecha;
		this.planeta = planeta;
	}


	@Override
	public int compareTo(Object o) {
		AsteroidResult ast = (AsteroidResult) o;	
		return this.getDiametro().compareTo(ast.getDiametro());
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getDiametro() {
		return diametro;
	}


	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}


	public String getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getPlaneta() {
		return planeta;
	}


	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}
	
	

	
	
}
