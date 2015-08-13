package cs356_1;

import java.util.ArrayList;
import java.util.Random;
/*
 * Simulates configuration of students, submissions, question and answer
 * It also simulates student submissions into the iVote service
 * 
 */
public class SimulationDriver {
	static Question sampleQuestion;
	static String questionString = "asdassd";
	static String[] tempAnswers = {"A", "B", "C", "D"}; 
	public static void main(String[] args){
		ArrayList<String> answers = new ArrayList();
		for(int i = 0;i<tempAnswers.length;i++){
			answers.add(tempAnswers[i]);
		}
		sampleQuestion = new MultiQuestion(questionString, answers);
		IVoteService iVote = new IVoteService(sampleQuestion);
		Random random = new Random();
		int studentCount = random.nextInt(49)+1;
		ArrayList<Student> studentTemp = new ArrayList<Student>(studentCount);
		for(int i = 0; i<studentCount;i++){
			Submission subm = answerSelector();
			Integer tempInt = new Integer(i);
			subm.setID(tempInt.toString());
			Student student = new Student(subm);
			studentTemp.add(student);
		}
		for(int i = 0; i<studentCount;i++){
			studentTemp.get(i).submit(iVote);
		}
		iVote.displayStatistics();
	}
	/*
	 * This method just helps to divide up the work into a more readable format
	 * It generates the answer portion of the submission object, by selecting from
	 * the available answers
	 */
	private static Submission answerSelector() {
		
		Submission submission = new Submission();
		
		for(int i = 0; i<tempAnswers.length;i++){
			Random rand = new Random();
			int k = rand.nextInt(tempAnswers.length); 
			submission.setAnswer(tempAnswers[k]);
		}
		return submission;
	}

}
