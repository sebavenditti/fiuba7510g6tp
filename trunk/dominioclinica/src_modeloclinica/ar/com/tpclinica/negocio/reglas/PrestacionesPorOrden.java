package ar.com.tpclinica.negocio.reglas;

import ar.com.tpclinica.negocio.OrdenMedica;
import ar.com.tpclinica.negocio.Prestacion;

public class PrestacionesPorOrden extends Operando {
private Prestacion prestacion;
	
	public PrestacionesPorOrden(Prestacion presta) {
		prestacion = presta;
	}

	/**
	 * @return the prestacion
	 */
	public Prestacion getPrestacion() {
		return prestacion;
	}

	/**
	 * @param prestacion the prestacion to set
	 */
	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	public int getValor(OrdenMedica om){
		//cant de veces q  aparece la prestac. atrib. en la omedica q me pasan
		int cant_veces = 0;
		
		for (ar.com.tpclinica.negocio.OrdenMedicaItem omi : om.getItems()) {
			 if (omi.getPrestacion().getId() == this.prestacion.getId()) cant_veces++;
		 }
		return cant_veces;
	}
	
	@Override
	public boolean equals(Object obj) {
		PrestacionesPorOrden o = (PrestacionesPorOrden)obj;
		OrdenMedica om = null;
		
		if (o.getValor(om)==this.getValor(om))
			return true;
		else return false;
	
	}
}
