package Clases;

public class Usuario {
	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String cedula;
	private String fecNacimiento;
	private String emailPersonal;
	private String telefono;
	private String locDepartamento;
	private String emailInstitucional;
	private String contraseña;
	private String itr;
	private String tipoDeUsuario;
	private String añoIngreso;
	private String area;
	private String rol;
	private String estado;
	
	public Usuario(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			String cedula, String fecNacimiento, String emailPersonal, String telefono, String locDepartamento,
			String emailInstitucional, String contraseña, String itr, String tipoDeUsuario, String añoIngreso,
			String area, String rol, String estado) {
		super();
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.cedula = cedula;
		this.fecNacimiento = fecNacimiento;
		this.emailPersonal = emailPersonal;
		this.telefono = telefono;
		this.locDepartamento = locDepartamento;
		this.emailInstitucional = emailInstitucional;
		this.contraseña = contraseña;
		this.itr = itr;
		this.tipoDeUsuario = tipoDeUsuario;
		this.añoIngreso = añoIngreso;
		this.area = area;
		this.rol = rol;
		this.estado = estado;
	}
	
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getFecNacimiento() {
		return fecNacimiento;
	}
	public void setFecNacimiento(String fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public String getEmailPersonal() {
		return emailPersonal;
	}
	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getLocDepartamento() {
		return locDepartamento;
	}
	public void setLocDepartamento(String locDepartamento) {
		this.locDepartamento = locDepartamento;
	}
	public String getEmailInstitucional() {
		return emailInstitucional;
	}
	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getItr() {
		return itr;
	}
	public void setItr(String itr) {
		this.itr = itr;
	}
	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}
	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	public String getAñoIngreso() {
		return añoIngreso;
	}
	public void setAñoIngreso(String añoIngreso) {
		this.añoIngreso = añoIngreso;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Usuario [primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido="
				+ primerApellido + ", segundoApellido=" + segundoApellido + ", cedula=" + cedula + ", fecNacimiento="
				+ fecNacimiento + ", emailPersonal=" + emailPersonal + ", telefono=" + telefono + ", locDepartamento="
				+ locDepartamento + ", emailInstitucional=" + emailInstitucional + ", contraseña=" + contraseña
				+ ", itr=" + itr + ", tipoDeUsuario=" + tipoDeUsuario + ", añoIngreso=" + añoIngreso + ", area=" + area
				+ ", rol=" + rol + ", estado=" + estado + "]";
	}
}
