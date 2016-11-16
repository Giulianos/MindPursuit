
package mindrace.model.states;

import java.io.Serializable;

import mindrace.model.Situation;

/**
 * @author Giuliano
 *
 */
abstract public class State implements Serializable {
	
	private State previousState;
	private Situation currentSituation;
	
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
	public Situation getSituation(){
		return currentSituation;
	}
	public void setPreviousState(State previousState){
		this.previousState=previousState;
	}
	public State getPreviousState(){
		return previousState;
	}
	abstract public boolean isModifier();

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		return getClass().equals(obj.getClass());
	}
	
}
