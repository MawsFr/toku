package fr.lille1.univ.coo.tp.persistance.requete;

import java.util.Iterator;

import fr.lille1.univ.coo.tp.utils.ReflectionUtils;

public class RequeteVisitor {

	public void visit(Requete requete) {
		requete.accept(this);
	}

	public String visit(RequeteSelection requete) {
		StringBuilder sb = new StringBuilder("SELECT ");
		if (requete.clauseSelect.isEmpty()) {
			sb.append("*");
		} else {
			for (Iterator<String> it = requete.clauseSelect.iterator(); it.hasNext();) {
				sb.append(it.next());
				if (it.hasNext()) {
					sb.append(", ");
				}
			}
		}

		sb.append(" FROM ").append(ReflectionUtils.nomTable(requete.classe)).append(" ");
		sb.append(visit(new RequeteWhere(requete.classe, requete.clauseWhere)));
		if(requete.clauseLimit > 0) {
			sb.append("LIMIT ").append(requete.clauseLimit).toString();
		}
		return sb.toString();
	}

	public String visit(RequeteJoin requete) {
		if(requete.clauseJoin.isEmpty()) {
			return super.toString();
		}

		StringBuilder sb = new StringBuilder();
		for(Iterator<Class<?>> it = requete.clauseJoin.keySet().iterator(); it.hasNext();) {
			Class<?> clazz = it.next();
			Critere c = requete.clauseJoin.get(clazz);
			sb.append("JOIN ").append(ReflectionUtils.nomTable(clazz)).append(" ON ").append(visit(c).replaceAll("\\(", "").replaceAll("\\)", ""));
			if(it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append(super.toString());
		return sb.toString();
	}

	public String visit(RequeteSuppression requete) {
		StringBuilder sb = new StringBuilder("DELETE ");
		sb.append(" FROM ").append(ReflectionUtils.nomTable(requete.classe)).append(" ");
		sb.append(visit(new RequeteWhere(requete.classe, requete.clauseWhere)));
		return sb.toString();
	}

	public String visit(RequeteInsertion requete) {
		StringBuilder sb = new StringBuilder("INSERT INTO ");
		sb.append(ReflectionUtils.nomTable(requete.classe));
		sb.append(" ( ");
		for (int i = 0; i < requete.getFields().length; ++i) {
			sb.append(requete.getFields()[i]);
			if (i < requete.getFields().length - 1) {
				sb.append(", ");
			}
		}
		sb.append(" ) VALUES ( ");
		for (int i = 0; i < requete.getFields().length; ++i) {
			sb.append("?");
			if (i < requete.getFields().length - 1) {
				sb.append(", ");
			}
		}

		sb.append(" )");

		return sb.toString();
	}

	public String visit(RequeteMiseAJour requete) {
		StringBuilder sb = new StringBuilder("UPDATE ");
		sb.append(ReflectionUtils.nomTable(requete.classe));
		sb.append(" SET ");
		for (int i = 0; i < requete.getFields().length; ++i) {
			sb.append(requete.getFields()[i]).append(" = ?");
			if (i < requete.getFields().length - 1) {
				sb.append(", ");
			}
		}
		sb.append(visit(new RequeteWhere(requete.classe, requete.clauseWhere)));

		return sb.toString();
	}

	public String visit(RequeteWhere requete) {
		if(requete.clauseWhere == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(" WHERE ").append(visit(requete.clauseWhere));
		return sb.toString();
	}

	public String visit(Critere critere) {
		return critere.accept(this);
	}

	public String visit(CritereET critere) {
		StringBuilder sb = new StringBuilder("(");
		for(int i = 0; i < critere.getCriteres().size(); ++i) {
			sb.append(visit(critere.getCriteres().get(i)));
			if(i < critere.getCriteres().size() - 1) {
				sb.append(" AND ");
			}
		}

		sb.append(")");
		return sb.toString();
	}

	public String visit(CritereOU critere) {
		StringBuilder sb = new StringBuilder("( ");
		for(int i = 0; i < critere.getCriteres().size(); ++i) {
			sb.append(visit(critere.getCriteres().get(i)));
			if(i < critere.getCriteres().size() - 1) {
				sb.append(" OR ");
			}
		}

		sb.append(" )");
		return sb.toString();
	}
	
	public String visit(CritereEGALE critere) {
		return critere.getField() + " = ?";
	}
	
	public String visit(CritereNONEGALE critere) {
		return critere.getField() + " != ?";
	}
}
