package de.osmembrane.model.persistence;

import java.io.Serializable;
import java.util.Observer;


/**
 * AbstractPersistence provides two methods save and load, so all
 * Persistence-classes are used in the same way.
 * 
 * @author jakob_jarosch
 */
public abstract class AbstractPersistence implements Observer {

	/**
	 * Saves a given object into the given file.
	 * 
	 * @param file
	 *            path to the file where the object should be saved
	 * @param data
	 *            object which should be saved into the file, normally it should
	 *            be {@link Serializable}
	 * 
	 * @throws FileException
	 */
	public abstract void save(String file, Object data) throws FileException;

	/**
	 * Loads a file and returns the object inside of it.
	 * 
	 * @param file
	 *            path to the file from where the object should be loaded
	 * @return the object, which is loaded from the file
	 * 
	 * @throws FileException
	 */
	public abstract Object load(String file) throws FileException;
}