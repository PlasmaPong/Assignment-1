package cs356_1;
/*
 * Student class, represents a student for the purpose of the system
 * -ID identification number, assigned by an outside source or automatically 
 * 		based on method of generating id's
 * -submission is the submission object that the student will submit to the machine when
 * 		it is designated as appropriate to do so
 */
public class Student {
	
	private Submission submission;
	private String id;
	//constructor
	public Student(Submission subm){
		setSubmission(subm);
	}
	public void setSubmission(Submission sub){
		setID(sub.getID());
		submission = sub;
	}
	/*
	 * Sends the stored submission object to the iVote service
	 */
	public void submit(IVoteService ivote){
		ivote.submitAnswer(submission);
	}
	public void setID(String ident){
		id = ident;
		submission.setID(ident);
	}
	public String getID(){
		return id;
	}
}
