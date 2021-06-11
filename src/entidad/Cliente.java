package entidad;

import java.sql.Date;

public class Cliente {
	
	private int idCliente;
	private String nombres;
	private String apellidos;
	private String dni;
	private Date fechaNacimiento;
	private tipoCliente tipo;
	private String tipotexto;
	
	public String getTipotexto() {
		tipotexto=tipo.getDescripcion();
		return tipotexto;
	}
	public void setTipotexto(String tipotexto) {
		this.tipotexto = tipotexto;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public tipoCliente getTipo() {
		return tipo;
	}
	public void setTipo(tipoCliente tipo) {
		this.tipo = tipo;
	}
	
	

	
	
	
}
