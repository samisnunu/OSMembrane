package de.osmembrane.model.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Observable;

import de.osmembrane.model.AbstractFunction;
import de.osmembrane.model.parser.CmdParser;
import de.osmembrane.model.parser.ParseException;
import de.osmembrane.model.parser.ParserFactory;
import de.osmembrane.model.persistence.FileException.Type;
import de.osmembrane.view.ExceptionType;
import de.osmembrane.view.ViewRegistry;

/**
 * Writes and Reads CMD-Files (normally used on Windows systems).
 * 
 * @author jakob_jarosch
 */
public class CmdPersistence extends AbstractPersistence {

	private static final Class<CmdParser> PARSER = CmdParser.class;
	
	@Override
	public void save(String filename, Object data) throws FileException {
		if (!(data instanceof List<?>)) {
			ViewRegistry.showException(this.getClass(),
					ExceptionType.ABNORMAL_BEHAVIOR,
					new Exception("CmdPersistence#save() got a wrong"
							+ " object, object is the following instance:\n"
							+ data.getClass()));
		}

		try {
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			@SuppressWarnings("unchecked")
			String output = ParserFactory.getInstance()
			.getParser(PARSER).parsePipeline((List<AbstractFunction>) data);
			
			bw.write(output);
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			throw new FileException(Type.NOT_WRITABLE, e);
		}
	}

	@Override
	public Object load(String filename) throws FileException {
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			StringBuilder fileContent = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				fileContent.append(line);
			}
			br.close();
			fr.close();

			List<AbstractFunction> functions = ParserFactory.getInstance()
					.getParser(PARSER).parseString(fileContent.toString());
			
			return functions;

		} catch (FileNotFoundException e) {
			throw new FileException(Type.NOT_FOUND, e);
		} catch (IOException e) {
			throw new FileException(Type.NOT_READABLE, e);
		} catch (ParseException e) {
			throw new FileException(Type.SYNTAX_PROBLEM, e);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}