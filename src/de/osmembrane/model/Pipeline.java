package de.osmembrane.model;

import java.util.List;
import java.util.Observable;
import java.util.Stack;

public class Pipeline extends Observable implements IPipeline {
	private Stack<Pipeline> undoStack;
	private List<Function> functions;
	private Stack<Pipeline> redoStack;

	private Pipeline getState() {
		throw new UnsupportedOperationException();
	}

	public boolean redo() {
		throw new UnsupportedOperationException();
	}

	public void addFunction(IFunction func) {
		throw new UnsupportedOperationException();
	}

	public void deleteFunction(IFunction func) {
		throw new UnsupportedOperationException();
	}

	public IFunction[] getFunctions() {
		throw new UnsupportedOperationException();
	}

	public boolean undo() {
		throw new UnsupportedOperationException();
	}

	public boolean optimizeGraph() {
		throw new UnsupportedOperationException();
	}

	public boolean execute() {
		throw new UnsupportedOperationException();
	}

	public void save(String filename) {
		throw new UnsupportedOperationException();
	}

	public void load(String filename) {
		throw new UnsupportedOperationException();
	}

	public void import_326(String filename) {
		throw new UnsupportedOperationException();
	}

	public void export(String filename) {
		throw new UnsupportedOperationException();
	}

	public void truncate() {
		throw new UnsupportedOperationException();
	}

	public void generate(String filetype) {
		throw new UnsupportedOperationException();
	}
}