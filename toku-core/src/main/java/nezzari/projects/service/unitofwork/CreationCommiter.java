package nezzari.projects.service.unitofwork;

/**
 * Cette classe applique les creation d'objet du domaine sur la BDD.
 * 
 * @author Mustapha Nezzari
 *
 */
public class CreationCommiter extends Commiter {

//	/**
//	 * Cree un bureau dans la BDD.
//	 */
//	@Override
//	public void visit(Bureau bureau) throws DAOException {
//		DAOFactory.getBureauDAO().creer(bureau);
//		System.out.println(bureau + " cree");
//	}
//
//	/**
//	 * Cree une affectation dans la BDD.
//	 */
//	@Override
//	public void visit(Affectation affectation) throws DAOException {
//		DAOFactory.getBureauDAO().creer(affectation);
//		System.out.println(affectation.getPersonne() + " affectee au bureau " + affectation.getBureau()
//				+ " avec le numero " + affectation.getNumero());
//	}
//
//	/**
//	 * Cree un administratif dans la BDD.
//	 */
//	@Override
//	public void visit(Administratif administratif) throws DAOException {
//		DAOFactory.getPersonneDAO().creerAdministratif(administratif);
//		System.out.println(administratif + " cree");
//	}
//
//	/**
//	 * Cree un chercheur dans la BDD.
//	 */
//	@Override
//	public void visit(Chercheur chercheur) throws DAOException {
//		DAOFactory.getPersonneDAO().creerChercheur(chercheur);
//		System.out.println(chercheur + " cree");
//	}

}
