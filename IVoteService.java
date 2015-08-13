package cs356_1;

public class IVoteService {

	private Question question;
	/*
	 * default constructor
	 */
	public IVoteService(){

	}
	/*
	 * constructor that takes in a question object as an argument
	 */
	public IVoteService(Question configuredQuestion){
		question = configuredQuestion;
	}
	public void submitAnswer(Submission submission) {
		// TODO Auto-generated method stub
		question.receiveSubmission(submission);
	}
	/*
	 * Collects final submissions from the collection of submissions and 
	 * summarizes their collective results.
	 */
	public void displayStatistics(){

		int[] answerValues = new int[question.getList().size()];
		for(int i = 0;i<question.getSubmissions().size();i++){
			for(int j = 0; j<((Submission) question.getSubmissions().get(i)).getAnswer().size();j++){
				for(int k = 0; k<question.getList().size();k++)
				if(((Submission) question.getSubmissions().get(i)).getAnswer().get(j).equals(question.getList().get(k))){
					answerValues[k]++;
				}
			}
		}
		for(int i = 0; i<answerValues.length;i++){
			System.out.println(question.getList().get(i)+" : "+answerValues[i]+" ");
		}
	}

}
