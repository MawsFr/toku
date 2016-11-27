package nezzari.projects.critere;

import java.util.List;

public class OUCritere<T> implements Critere<T>{
	private List<Critere<T> > criteres;
	
	public OUCritere(List<Critere<T>> criteres) {
		this.criteres = criteres;
	}

	@Override
	public boolean estVerifie(T obj) {
		for(Critere<T> critere : criteres) {
			if(!critere.estVerifie(obj)) {
				return false;
			}
		}
		
		return true;
	}

}
