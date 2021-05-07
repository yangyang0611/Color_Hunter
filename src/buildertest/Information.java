package buildertest;

import java.io.Serializable;

public class Information implements Serializable{
	private static final long serialVersionUID = 1L;
	private int score;
	private String name="Unknown";
	public Information(String name,int score) {
		this.name=name;
		this.score=score;
	}
	public int get_score() {
		return score;
	}
	public String get_name() {
		return name;
	}
}
