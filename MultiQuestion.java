package cs356_1;

import java.util.ArrayList;
/*
 * question class that can take in multiple choices per student per submission.
 * 
 */
public class MultiQuestion implements Question{

	private String question;
	private ArrayList<String> answerList;
	private ArrayList<Submission> submissionList;
	/*
	 * Constructor, takes in a string and list of answers to create a useable
	 * question object
	 */
	public MultiQuestion(String string, ArrayList list) {
		submissionList = new ArrayList<Submission>();
		answerList = new ArrayList<String>();
		setQuestionString(string);
		setList(list);
	}
	@Override

	public void setQuestionString(String string) {
		// question string mutator
		question = string;
	}

	@Override
	public String getQuestionString() {
		// question string accessor
		return question;
	}
	@Override
	public void setList(ArrayList list) {
		// list mutator
		answerList = list;
	}
	@Override
	public ArrayList getList() {
		// list accessor
		return answerList;
	}
	@Override
	/*
	 * Takes in a submission and detects if the submission input is from
	 * the same student, or student ID
	 */
	public void receiveSubmission(Submission submission){
		//this will parse the answer
		boolean exists = true;
		for(int i = 0;i<submissionList.size();i++){
			if(submissionList.get(i).getID().equals(submission.getID())){
				submissionList.add(i, submission);
				exists = false;
			}
		}
		if(exists){
			submissionList.add(submission);
		}
	}
	@Override
	public ArrayList getSubmissions(){
		return submissionList;
	}
}
