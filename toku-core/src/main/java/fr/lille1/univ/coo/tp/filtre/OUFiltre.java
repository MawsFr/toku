package fr.lille1.univ.coo.tp.filtre;

import java.util.List;

public class OUFiltre<T> implements Filtre<T>{
	private List<Filtre<T> > criteres;
	
	public OUFiltre(List<Filtre<T>> criteres) {
		this.criteres = criteres;
	}

	@Override
	public boolean accepte(T obj) {
		for(Filtre<T> critere : criteres) {
			if(critere.accepte(obj)) {
				return true;
			}
		}
		
		return false;
	}

}
