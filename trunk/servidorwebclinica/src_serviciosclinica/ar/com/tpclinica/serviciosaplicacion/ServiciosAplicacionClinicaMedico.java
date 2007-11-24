package ar.com.tpclinica.serviciosaplicacion;

import java.util.Collection;

import ar.com.tpclinica.negocio.Especialidad;
import ar.com.tpclinica.negocio.Medico;
import ar.com.tpclinica.persistencia.Repositorio;
import ar.com.tpclinica.persistencia.RepositorioMedicos;

public class ServiciosAplicacionClinicaMedico extends
		ServiciosAplicacionClinica {
	private RepositorioMedicos repositorioMedicos;
	private Repositorio<Especialidad> repositorioEspecialidades;
	
	public Medico getMedico(int idMedico) {
		return repositorioMedicos.get(idMedico);
	}
	public Medico crearNuevoMedico(String nombre, String apellido, int idEspecialidad) {
		return null;
	}
	public void borrarMedico(int idMedico) {
		repositorioMedicos.borrar(getMedico(idMedico));
	}
	public void modificarMedico(int idMedico, String nombre, String apellido, int idEspecialidad) {
		
	}
	public Collection<Medico> getMedicos() {
		return repositorioMedicos.getAll();
	}
	public Collection<Especialidad> getEspecialidades() {
		return repositorioEspecialidades.getAll();
	}
	/**
	 * @return the repositorioEspecialidades
	 */
	public Repositorio<Especialidad> getRepositorioEspecialidades() {
		return repositorioEspecialidades;
	}
	/**
	 * @param repositorioEspecialidades the repositorioEspecialidades to set
	 */
	public void setRepositorioEspecialidades(
			Repositorio<Especialidad> repositorioEspecialidades) {
		this.repositorioEspecialidades = repositorioEspecialidades;
	}
	/**
	 * @return the repositorioMedicos
	 */
	public RepositorioMedicos getRepositorioMedicos() {
		return repositorioMedicos;
	}
	/**
	 * @param repositorioMedicos the repositorioMedicos to set
	 */
	public void setRepositorioMedicos(RepositorioMedicos repositorioMedicos) {
		this.repositorioMedicos = repositorioMedicos;
	}

}