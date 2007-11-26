package ar.com.tpclinica.serviciosaplicacion;

import ar.com.tpclinica.negocio.OrdenMedica;
import ar.com.tpclinica.negocio.OrdenMedicaEstado;
import ar.com.tpclinica.negocio.OrdenMedicaItem;
import ar.com.tpclinica.negocio.Plan;
import ar.com.tpclinica.negocio.exepciones.OrdenMedicaInvalidaException;
import ar.com.tpclinica.persistencia.Repositorio;
import ar.com.tpclinica.persistencia.RepositorioOrdenes;
import ar.com.tpclinica.persistencia.RepositoriosProvider;

public class ServiciosAplicacionClinicaOrdenMedica extends
		ServiciosAplicacionClinica {
	private Repositorio<OrdenMedica> respositorioOrdenesMedicas;

	public void autorizarOrdenMedica(int idOrdenMedica) {
		RepositorioOrdenes repositorioOrdenes = RepositoriosProvider
				.getInstancia().getRepositorioOrdenes();
		OrdenMedica ordenMedica = repositorioOrdenes.get(idOrdenMedica);
		ordenMedica.cambiarEstado(new OrdenMedicaEstado(
				OrdenMedicaEstado.AUTORIZADA));
		repositorioOrdenes.modify(ordenMedica.getId(), ordenMedica);

	}

	public void cancelarOrdenMedica(int idOrdenMedica) {
		RepositorioOrdenes repositorioOrdenes = RepositoriosProvider
				.getInstancia().getRepositorioOrdenes();
		OrdenMedica ordenMedicaACancelar = repositorioOrdenes
				.get(idOrdenMedica);
		ordenMedicaACancelar.setEstado(new OrdenMedicaEstado(
				OrdenMedicaEstado.CANCELAR_ORDEN));
		repositorioOrdenes.modify(idOrdenMedica, ordenMedicaACancelar);
	}

	public OrdenMedica getOrdenMedica(int idOrdenMedica) {
		return respositorioOrdenesMedicas.get(idOrdenMedica);
	}

	public void crearNuevaOrdenMedica(OrdenMedica nuevaOrdenMedica)
			throws OrdenMedicaInvalidaException {
		Plan plan = nuevaOrdenMedica.getPaciente().getPlan();
		plan.validarOrden(nuevaOrdenMedica);
		RepositoriosProvider.getInstancia().getRepositorioOrdenes().add(
				nuevaOrdenMedica);

	}

	public void agregarDiagnosticoAOrdenMedica(int idOrdenMedica,
			String diagnostico) {
		Repositorio<OrdenMedica> repositorioOrdenes = RepositoriosProvider
				.getInstancia().getRepositorioOrdenes();
		OrdenMedica ordenMedica = repositorioOrdenes.get(idOrdenMedica);
		ordenMedica.setDiagnostico(diagnostico);
		repositorioOrdenes.modify(idOrdenMedica, ordenMedica);
	}

	public void agregarItemAOrdenMedica(int idOrdenMedica,
			OrdenMedicaItem ordenMedicaItem) {
		getOrdenMedica(idOrdenMedica).agregarItem(ordenMedicaItem);
	}

	/**
	 * @return the respositorioOrdenesMedicas
	 */
	public Repositorio<OrdenMedica> getRespositorioOrdenesMedicas() {
		return respositorioOrdenesMedicas;
	}

	/**
	 * @param respositorioOrdenesMedicas
	 *            the respositorioOrdenesMedicas to set
	 */
	public void setRespositorioOrdenesMedicas(
			Repositorio<OrdenMedica> respositorioOrdenesMedicas) {
		this.respositorioOrdenesMedicas = respositorioOrdenesMedicas;
	}

}