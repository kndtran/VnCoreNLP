package vn.pipeline;

public class Word {
    private int index = -1;
    private String form;
    private String posTag;
    private String nerLabel;
    private int head = -1;
    private String depLabel;

    public Word(Word word) {
        this.index = word.index;
        this.form = word.form;
        this.posTag = word.posTag;
        this.nerLabel = word.nerLabel;
        this.head = word.head;
        this.depLabel = word.depLabel;
    }
    public Word(int index, String form, String posTag) {
        this.index = index;
        this.form = form;
        this.posTag = posTag;
    }

    public Word(int index, String form) {
        this.index = index;
        this.form = form;
    }

    public Word(int index, String form, String posTag, String nerLabel) {
        this.index = index;
        this.form = form;
        this.posTag = posTag;
        this.nerLabel = nerLabel;
    }

    public Word(int index, String form, String posTag, String nerLabel, String chunkingLabel) {
        this.index = index;
        this.form = form;
        this.posTag = posTag;
        this.nerLabel = nerLabel;
    }

    public Word(int index, String form, String posTag, String nerLabel, int head, String depLabel, String chunkingLabel) {
        this.index = index;
        this.form = form;
        this.posTag = posTag;
        this.nerLabel = nerLabel;
        this.head = head;
        this.depLabel = depLabel;
    }

    @Override
    public String toString() {
        return this.getIndex() + "\t" +
                this.getForm() + "\t" +
                (this.getPosTag() == null?"_": this.getPosTag()) +  "\t" +
                (this.getNerLabel() == null?"_": this.getNerLabel()) + "\t" +
                (this.getHead() == -1?"_\t": this.getHead()) + "\t" +
                (this.getDepLabel() == null?"_": this.getDepLabel());
    }
    
    public String toStringCoNNLU() {
        return this.getIndex() + "\t" +  // ID
                this.getForm() + "\t" +  // FORM
                "_" + "\t" +  // LEMMA
                (this.getPosTag() == null ? "_" : convertToUPOS(this.getPosTag())) +  "\t" + // UPOS
                (this.getPosTag() == null ? "_" : this.getPosTag()) +  "\t" +  // XPOS
                "_" + "\t" +  // FEATS
                (this.getHead() == -1 ? "_" : this.getHead()) + "\t" +  // HEAD
                (this.getDepLabel() == null ? "_" : this.getDepLabel()) + "\t" +  // DEPREL
                "_" + "\t" +  // DEPS
                "_" + "\t";  // MISC
    }
    
    public String convertToUPOS(String tag) {
    	String cTag = tag;
    	switch(tag) {
	    	case "Np": cTag = "PROPN"; break;
	    	case "Nc": cTag = "_"; break;
	    	case "Nu": cTag = "_"; break;
	    	case "N": cTag = "NOUN"; break;
	    	case "Ny": cTag = "_"; break;
	    	case "Nb": cTag = "_"; break;
	    	
	    	case "V": cTag = "VERB"; break;
	    	case "Vb": cTag = "_"; break;
	    	
	    	case "A": cTag = "ADJ"; break;
	    	case "P": cTag = "PRON"; break;
	    	case "R": cTag = "ADV"; break;
	    	case "L": cTag = "DET"; break;
	    	case "M": cTag = "NUM"; break;
	    	case "E": cTag = "_"; break;
	    	
	    	case "C": cTag = "SCONJ"; break;
	    	case "Cc": cTag = "CCONJ"; break;
	    	case "I": cTag = "INTJ"; break;
	    	case "T": cTag = "AUX"; break;
	    	case "Y": cTag = "_"; break;
	    	case "Z": cTag = "_"; break;
	    	case "X": cTag = "X"; break;
	    	
	    	case "CH": cTag = "PUNCT"; break;
    	}
    	return cTag;
    }
    
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPosTag() {
        return posTag;
    }

    public void setPosTag(String pos) {
        this.posTag = pos;
    }

    public String getNerLabel() {
        return nerLabel;
    }

    public void setNerLabel(String nerLabel) {
        this.nerLabel = nerLabel;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getDepLabel() {
        return depLabel;
    }

    public void setDepLabel(String depLabel) {
        this.depLabel = depLabel;
    }

}
