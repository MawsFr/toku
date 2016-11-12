package nezzari.projects.critere;

import java.util.List;

public class ETCritere<T> implements Critere<T>{
	private List<Critere<T> > criteres;
	
	public ETCritere(List<Critere<T>> criteres) {
		this.criteres = criteres;
	}

	@Override
	public boolean estVerifie(T obj) {
		for(Critere<T> critere : criteres) {
			if(critere.estVerifie(obj)) {
				return true;
			}
		}
		
		return false;
	}

}
