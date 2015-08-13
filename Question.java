package cs356_1;

import java.util.ArrayList;
/*
 * Represents a family of classes that support the iVote service 
 * program. Standard functionality is the storage of the question 
 * being asked, the list of possible answers, and the list of answers submitted for 
 * said question
 */
public interface Question {
	
	//question accessor/modifier
	void setQuestionString(String string);
	String getQuestionString();
	//ArrayList accessor/modifier
	void setList(ArrayList list);
	ArrayList getList();
	void receiveSubmission(Submission submission);
	ArrayList getSubmissions();
}
