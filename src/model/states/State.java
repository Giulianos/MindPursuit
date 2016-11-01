/**
 * 
 */
package model.states;

import model.Situation;

/**
 * @author Giuliano
 *
 */
abstract public class State {
	
	protected State previousState;
	protected Situation currentSituation;
	
	/**
	 * Inicializa el estado y realiza todas las acciones
	 * que sean posibles hacer sin recibir input del usuario.
	 */
	abstract public void initialize();



	



	/**
	 * Realiza las acciones necesarias para determinar a
	 * que estado se ira luego.
	 * 
	 * @return El estado siguiente.
	 */
	abstract public State terminate();
	
	/**
	 * @param currentSituation the currentSituation to set
	 */
	public void setCurrentSituation(Situation currentSituation) {
		this.currentSituation = currentSituation;
	}
	
}
