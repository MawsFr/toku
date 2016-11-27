package fr.lille1.univ.coo.tp.utils;

import java.util.logging.Logger;

public class Log {
	
	private static final Logger LOGGER = Logger.getLogger(Log.class.getName());
	
	public static void severe(String msg) {
		LOGGER.severe(msg);
	}
	public static void warning(String msg) {
		LOGGER.warning(msg);
	}
	public static void info(String msg) {
		LOGGER.info(msg);
	}
	public static void config(String msg) {
		LOGGER.config(msg);
	}
	public static void fine(String msg) {
		LOGGER.fine(msg);
	}
	public static void finer(String msg) {
		LOGGER.finer(msg);
	}
	public static void finest(String msg) {
		LOGGER.finest(msg);
	}
	
	public static void throwing(String sourceClass, String sourceMethod, Throwable thrown) {
		LOGGER.throwing(sourceClass, sourceMethod, thrown);
	}
	
	
	
}
