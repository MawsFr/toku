package fr.lille1.univ.coo.tp.persistance.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import fr.lille1.univ.coo.tp.persistance.proxy.factory.Factory;

/**
 * Cette classe des proxy pour un type de variable données. Elle est couplé au
 * {@link Factory} qui permettent de créer l'objet au moment ou l'on en a
 * besoin.
 * 
 * @param <T>
 *            Le type de paramètre que l'on veut proxifier.
 */
public class VirtualProxyBuilder<T> implements InvocationHandler {

	/**
	 * L'objet réel.
	 */
	private T objet;
	private Factory<T> factory;
	private Class<?> iface;

	/**
	 * Constructeur prenant en paramètre :
	 * 
	 * @param factory
	 * @param iface
	 */
	public VirtualProxyBuilder(Factory<T> factory, Class<?> iface) {
		this.factory = factory;
		this.iface = iface;
	}

	@SuppressWarnings("unchecked")
	public T creerProxy() {
		return (T) Proxy.newProxyInstance(iface.getClassLoader(), new Class<?>[]{iface}, this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		assurerInit();		
		return method.invoke(objet, args);
	}
	
	public void assurerInit() {
		if(objet == null) {
			this.objet = factory.creer();
		}
	}

}
