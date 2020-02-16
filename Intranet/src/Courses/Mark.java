package Courses;

import java.io.Serializable;

public class Mark implements Serializable{
	private int mark;
	public Mark(int mark) {
		this.mark = mark;
	}
	public int getMark() {
		return this.mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public char getLetter() {
		if(mark >= 50 && mark <= 80)
			return 'B';
		else 
			return 'A';
	}
	public String toString() {
		return getLetter()+" "+mark;
	}
}
