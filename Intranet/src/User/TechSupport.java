package User;

import java.util.Date;
import java.util.Vector;

import News.Post;

public class TechSupport extends User{
	private Vector<Post> reports;
	private Vector<Post> doneReports;
	public TechSupport(String name, String surname, String fathername, Date birthdate, Degree deg) {
		super(name, surname, fathername, birthdate, deg);
	}
	public void acceptReport(Post post) {
		reports.add(post);
	}
	public void readReports() {
		for(Post report:reports) {
			doneReports.add(report);
		}
		reports.clear();
	}
	
}
