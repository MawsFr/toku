package fr.lille1.univ.coo.tp.filtre;

import java.util.List;

public class ETFiltre<T> implements Filtre<T>{
	private List<Filtre<T> > criteres;
	
	public ETFiltre(List<Filtre<T>> criteres) {
		this.criteres = criteres;
	}

	@Override
	public boolean accepte(T obj) {
		for(Filtre<T> critere : criteres) {
			if(!critere.accepte(obj)) {
				return false;
			}
		}
		
		return true;
	}

}
