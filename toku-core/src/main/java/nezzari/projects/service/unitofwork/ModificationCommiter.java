package nezzari.projects.service.unitofwork;

/**
 * Cette classe applique les modification d'objet du domaine sur la BDD.
 * @author Mustapha Nezzari
 *
 */
public class ModificationCommiter extends Commiter {

//	/**
//	 * Modifie un bureau dans la BDD.
//	 */
//	@Override
//	public void visit(Bureau bureau) throws DAOException {
//		DAOFactory.getBureauDAO().modifier(bureau);
//		System.out.println(bureau + " modifie");
//	}
//
//	/**
//	 * Modifie une affectation (numero) dans la BDD.
//	 */
//	@Override
//	public void visit(Affectation affectation) throws DAOException {
//		DAOFactory.getPersonneDAO().modifier(affectation);
//		System.out.println(affectation.getPersonne() + " au bureau " + affectation.getBureau()
//				+ " a vu son numero modifie en " + affectation.getNumero());
//	}
//
//	/**
//	 * Modifie un administratif dans la BDD.
//	 */
//	@Override
//	public void visit(Administratif administratif) throws DAOException {
//		DAOFactory.getPersonneDAO().modifierAdministratif(administratif);
//		System.out.println(administratif + " modifie");
//	}
//
//	/**
//	 * Modifie un chercheur dans la BDD.
//	 */
//	@Override
//	public void visit(Chercheur chercheur) throws DAOException {
//		DAOFactory.getPersonneDAO().modifierChercheur(chercheur);
//		System.out.println(chercheur + " modifie");
//	}

}
