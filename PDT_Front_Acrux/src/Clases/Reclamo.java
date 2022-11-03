package Clases;

public class Reclamo {

	private String titulo;
	private String descripcion;
	private String fechaHora;
	private String nombreEventoVME;
	private String nombreActividadAPE;
	private String semestre;
	private String fecha;
	private String docente;
	private String creditos;
	private Estado estado;
	private String accion;
	private String accionFec;
	private String accionAnalista;
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getAccionFec() {
		return accionFec;
	}
	public void setAccionFec(String accionFec) {
		this.accionFec = accionFec;
	}
	public String getAccionAnalista() {
		return accionAnalista;
	}
	public void setAccionAnalista(String accionAnalista) {
		this.accionAnalista = accionAnalista;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getNombreEventoVME() {
		return nombreEventoVME;
	}
	public void setNombreEventoVME(String nombreEventoVME) {
		this.nombreEventoVME = nombreEventoVME;
	}
	public String getNombreActividadAPE() {
		return nombreActividadAPE;
	}
	public void setNombreActividadAPE(String nombreActividadAPE) {
		this.nombreActividadAPE = nombreActividadAPE;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public String getCreditos() {
		return creditos;
	}
	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Reclamo(String titulo, String descripcion, String fechaHora, String nombreEventoVME,
			String nombreActividadAPE, String semestre, String fecha, String docente, String creditos, Estado estado,
			String accion, String accionFec, String accionAnalista) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
		this.nombreEventoVME = nombreEventoVME;
		this.nombreActividadAPE = nombreActividadAPE;
		this.semestre = semestre;
		this.fecha = fecha;
		this.docente = docente;
		this.creditos = creditos;
		this.estado = estado;
		this.accion = accion;
		this.accionFec = accionFec;
		this.accionAnalista = accionAnalista;
	}
	@Override
	public String toString() {
		return "Reclamo [titulo=" + titulo + ", descripcion=" + descripcion + ", fechaHora=" + fechaHora
				+ ", nombreEventoVME=" + nombreEventoVME + ", nombreActividadAPE=" + nombreActividadAPE + ", semestre="
				+ semestre + ", fecha=" + fecha + ", docente=" + docente + ", creditos=" + creditos + ", estado="
				+ estado + ", accion=" + accion + ", accionFec=" + accionFec + ", accionAnalista=" + accionAnalista
				+ "]";
	}
	


}
