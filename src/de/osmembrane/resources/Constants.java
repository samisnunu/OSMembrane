/*
 * This file is part of the OSMembrane project.
 * More informations under www.osmembrane.de
 * 
 * The project is licensed under the GNU GENERAL PUBLIC LICENSE 3.0.
 * for more details about the license see http://www.osmembrane.de/license/
 * 
 * Source: $HeadURL$ ($Revision$)
 * Last changed: $Date$
 */

package de.osmembrane.resources;

import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import de.osmembrane.Application;
import de.osmembrane.model.pipeline.Pipeline;
import de.osmembrane.model.settings.SettingsTypeUpdateInterval;
import de.osmembrane.tools.Tools;

/**
 * Constants for OSMembrane.
 * 
 * @author jakob_jarosch
 */
public class Constants {

	/**
	 * The revision of this build.
	 */
	public static final int BUILD_NUMBER = 822;

	/**
	 * Path to the language files.
	 */
	public static final String RESOURCE_BUNDLE_PATH = "de.osmembrane.resources.language.Locale";

	/**
	 * Is used by I18N for a default translation of the XMLHasDescription
	 * objects.
	 */
	public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

	/**
	 * All available Locales.
	 */
	public static final Locale[] AVAILABLE_LOCALES = new Locale[] {
			Locale.ENGLISH, Locale.GERMAN };

	/**
	 * Default OSMembrane-user directory.
	 */
	public static final URL DEFAULT_USER_FOLDER;

	/**
	 * Default Backup filename (for {@link Pipeline}.
	 */
	public static final URL DEFAULT_BACKUP_FILE;

	/**
	 * The default path to the settings file
	 */
	public static final URL DEFAULT_SETTINGS_FILE;

	/**
	 * The default color for a function-group with a non parsable color.
	 */
	public static final Color DEFAULT_FUNCTIONGROUP_COLOR = new Color(0.8f,
			0.8f, 0.8f);

	/**
	 * Color definitions for the various stream types
	 */
	public static final Color ENTITY_STREAM_TYPE_COLOR = new Color(0.5f, 0.5f,
			1.0f);

	/**
	 * Color definitions for the various stream types
	 */
	public static final Color CHANGE_STREAM_TYPE_COLOR = new Color(1.0f, 0.5f,
			0.5f);

	/**
	 * Color definitions for the various stream types
	 */
	public static final Color DATASET_STREAM_TYPE_COLOR = new Color(0.5f, 1.0f,
			0.5f);

	/**
	 * Maximum count of undo steps until the first one is removed from the
	 * undoStack.
	 */
	public static final int MAXIMUM_UNDO_STEPS = 100;

	/**
	 * The default path to the osmosis binaries.
	 */
	public static final String DEFAULT_OSMOSIS_PATH = "osmosis";

	/**
	 * The default path to the JOSM binaries.
	 */
	public static final String DEFAULT_JOSM_PATH = "josm";

	/**
	 * Seperator char of the bbox parameter
	 */
	public static final String BBOX_SEPERATOR = ";";

	/**
	 * The default zoom-size of the view.
	 */
	public static final double DEFAULT_ZOOM_SIZE = 1.0;

	/**
	 * The default raster size of the pipeline.
	 */
	public static final int DEFAULT_PIPELINE_RASTER_SIZE = 30;

	/**
	 * Maximum amount of entries in the statusbar before the oldest one is being
	 * removed.
	 */
	public static final int MAXIMUM_STATUSBAR_ENTRIES = 10;

	/**
	 * Minimal x distance between two functions in the pipeline view, needed for
	 * graph planarization.
	 */
	public static final double PIPELINE_FUNCTION_MINIMAL_X_DISTANCE = 175.0;

	/**
	 * Minimal y distance between two functions in the pipeline view, needed for
	 * graph planarization.
	 */
	public static final double PIPELINE_FUNCTION_MINIMAL_Y_DISTANCE = 75.0;

	/**
	 * The default working directory.
	 */
	public static final String DEFAULT_WORKING_DIRECTORY = System
			.getProperty("user.home");

	/**
	 * Show the startup screen or not.
	 */
	public static final Boolean DEFAULT_SHOW_STARTUP_SCREEN = true;

	/**
	 * The default path to the helpfile pdf.
	 */
	public static final File HELP_FILE_PATH = new File(
			"resources/pdf/manual.pdf");

	/**
	 * Default JOSM Heap size.
	 */
	public static final int JOSM_HEAP_SIZE = 256;

	/**
	 * All view components will have their size modified by this factor. This
	 * automatically affects standard zoom and drag & drop size.
	 */
	public static final double DEFAULT_SIZE_FACTOR = 0.64;

	/**
	 * Default update interval.
	 */
	public static final SettingsTypeUpdateInterval DEFAULT_UPDATE_INTERVAL = SettingsTypeUpdateInterval.ONCE_A_DAY;

	/**
	 * The website where updates can be checked.
	 */
	public static final URL UPDATE_WEBSITE;

	/**
	 * static method
	 */
	static {
		URL urlBackup = null;
		URL urlSettings = null;
		URL urlUserFolder = null;
		URL updateWebsite = null;
		try {
			urlUserFolder = new File(System.getProperty("user.home") + "/"
					+ ".osmembrane/").toURI().toURL();

			urlBackup = new File(Tools.urlToFile(urlUserFolder) + "/"
					+ "pipeline_backup.osmembrane").toURI().toURL();

			urlSettings = new File(Tools.urlToFile(urlUserFolder) + "/"
					+ "osmembrane.settings").toURI().toURL();
			
			updateWebsite = new URL("http://update.osmembrane.de/latest_build");

		} catch (MalformedURLException e) {
			/* no that shouldn't be so! */
			Application.handleException(e);
		} finally {
			DEFAULT_USER_FOLDER = urlUserFolder;
			DEFAULT_BACKUP_FILE = urlBackup;
			DEFAULT_SETTINGS_FILE = urlSettings;
			UPDATE_WEBSITE = updateWebsite;
		}
	}
}
