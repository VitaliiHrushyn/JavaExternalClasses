package ua.testing.regex.model;

import ua.testing.regex.view.View;

public class ModelImp implements Model {
	
	private Notebook notebook;

	public ModelImp(View view) {
		super();
		notebook = new Notebook(view);
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

}
