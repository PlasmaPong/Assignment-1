package cs356_1;

import java.util.ArrayList;
/*
 * A question class designed to accept only single answers to the question
 * 
 */
public class SingleQuestion implements Question{

	private String question;
	private ArrayList<String> answerList;
	private ArrayList<Submission> submissionList;
	/*
	 * Constructor, takes in a string and list of answers to create a useable
	 * question object
	 */
	public SingleQuestion(String string, ArrayList list) {
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
	 * This will filter out any choices beyond the first
	 */
	public void receiveSubmission(Submission submission){
		//this will parse the answer
		boolean exists = false;
		Submission temp = new Submission();
		temp.setAnswer((String) submission.getAnswer().get(0));
		temp.setID((String) submission.getID());
		for(int i = 0;i<submissionList.size();i++){
			if(submissionList.get(i).getID().equals(temp.getID())){
				submissionList.add(i, temp);
				exists = true;
			}
		}
		if(!exists){
			submissionList.add(temp);
		}
	}
	@Override
	public ArrayList getSubmissions(){
		return submissionList;
	}
}

