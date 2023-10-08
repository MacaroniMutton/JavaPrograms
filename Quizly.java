import java.util.*;

abstract class Questions{

    String question_text;
    String qType ;
    static int score=0;

    Questions(){}

    Questions(String question_text, String qType){
        this.question_text=question_text;
        this.qType=qType;

    }

    abstract void verifyAnswer();
    abstract String getQuestion();
    abstract void getSolution();

}

class ToF extends Questions{
    Boolean mySolution;
    Boolean givenAns;

    ToF(){}

    ToF(String question_text, String qType, Boolean mySolution){
        super(question_text, qType);
        this.mySolution=mySolution;
        
    }

    String getQuestion(){
        return super.question_text;
    }

    void getSolution(){

    }

    void verifyAnswer(){
        if(this.mySolution==this.givenAns){
            Questions.score++;
        }

    }
}

class MCQ extends Questions{
    int mySolution;
    int givenAns;

    MCQ(){

    }
    String[] options = new String[4];

    MCQ(String question_text, String qType, int mySolution){
        super(question_text, qType);
        this.mySolution=mySolution;
    }

    String getQuestion(){
        return super.question_text;
    }

    void getSolution(){
        System.out.println("correct ans =" + this.mySolution);
    }

    void verifyAnswer(){
        if(this.mySolution==this.givenAns){
            Questions.score++;
        }

    }
}
public class Quizly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String question;


        System.out.println("Enter the number of questions you want in quiz: ");
        int quesNo = sc.nextInt();

        Questions[] q = new Questions[quesNo];

        for(int i = 0; i<quesNo ; i++){
            System.out.println("Enter 0 to take true or false question or 1 to take mcq question : ");
            int op = sc.nextInt();
            sc.nextLine();

            switch(op){
                case 0 :
                ToF tf = new ToF();
                tf.qType= "True or False";
                System.out.println(tf.qType);
                System.out.println("Enter the question: ");
                question = sc.nextLine();
                tf.question_text=question;
                System.out.println("Enter the correct answer : ");
                boolean solution = sc.nextBoolean();
                tf.mySolution = solution;
                q[i]= tf;
                break;

                case 1:
                MCQ mcq = new MCQ();
                mcq.qType= "mcq";
                System.out.println(mcq.qType);
                System.out.println("Enter the question: ");
                question = sc.nextLine();
                mcq.question_text=question;
                for(int j =0; j< 4; j++){
                    System.out.println("Enter option" + (j+1));
                    mcq.options[j] = sc.next();
                }
                System.out.println("Enter the correct option : ");
                int soln = sc.nextInt();
                mcq.mySolution = soln;
                q[i]= mcq;
                break;

                default:
                System.out.println("INvalid, try again.");
                break;

            }
            
        }

        List<Questions> list = Arrays.asList(q);    
        Collections.shuffle(list); 
        list.toArray(q);

        for(int i = 0; i< q.length; i++){

            if(q[i].qType=="True or False"){
                // System.out.println(" Question : " + q[i].getQuestion());
                // System.out.println(" Enter your answer tof : ");
                // boolean ans = sc.nextBoolean();
                ToF nah = (ToF) q[i];
                System.out.println("Question: "+ nah.getQuestion());
                System.out.println("Please enter True or False");
                Boolean ans=sc.nextBoolean();
                nah.givenAns=ans;
                nah.verifyAnswer();
                System.out.println();

            }else if(q[i].qType=="mcq"){
                MCQ quiz=(MCQ) q[i];
                System.out.println("Question: "+ quiz.getQuestion());
                for(int j=0;j<4;j++){

                    int num=j+1;
                    System.out.println("Option "+ num+": "+ quiz.options[j]);
                }
                System.out.println();
                System.out.println("Please enter the correct option number.");
                int ans=sc.nextInt();
                quiz.givenAns=ans;
                quiz.verifyAnswer();
                System.out.println();
            }



            }

        }
        

    }           
