package cs356_1;

import java.util.ArrayList;
/*
 * Submission class, represents the information that the student 
 * conveys to the iVote service responding to the question asked
 */
public class Submission {
	private ArrayList<String> answer;
	private String id;
	//constructor
	public Submission(){
		answer = new ArrayList();
	}
	/*
	 * constructor that takes in arguments as an alternative to manually setting
	 * the fields with mutator
	 */
	public Submission(String ans, String ident){
		answer = new ArrayList();
		setID(ident);
	}
	public void setID(String string){
		id = string;
	}
	public String getID(){
		return id;
	}
	/*
	 * checks for an answer that has been put into the submission before
	 * otherwise adds to the list of choices selected
	 */
	public void setAnswer(String string){
		//if(answer.isEmpty())
		if(!answer.contains(string)){
			answer.add(string);
		}
	}
	public ArrayList<String> getAnswer(){
		return answer;
	}
}
