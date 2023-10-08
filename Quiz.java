import java.util.*;
abstract class Questions {
    String question_text;
    int mySolution;
    String type;
    Questions(String q, int s) {
        question_text = q;
        mySolution = s;
    }
    boolean verifyAnswer(int entered) {
        if (entered == mySolution)
            return true;
        else
            return false;
    }
    String getType() {
        return type;
    }
    abstract String getQuestion();
    abstract String getSolution();
}
class TrueOrFalse extends Questions {
    TrueOrFalse(String q, int s) {
        super(q, s);
        type = "TrueOrFalse";
    }
    String getQuestion() {
        return question_text;
    }
    String getSolution() {
        switch(mySolution) {
            case 1:
                return "TRUE";
            case 2:
                return "FALSE";
            default:
                return "Invalid Entry";
        }
    }
}
class MultipleChoice extends Questions {
    String option1, option2, option3, option4;
    MultipleChoice(String q, String o1, String o2, String o3, String o4, int s) {
        super(q, s);
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;
        type = "MCQ";
    }
    String getQuestion() {
        return question_text;
    }
    String getSolution() {
        switch(mySolution) {
            case 1:
                return option1;
            case 2:
                return option2;
            case 3:
                return option3;
            case 4:
                return option4;
            default:
                return "Invalid Entry";
        }
    }
}

class Quiz {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static void main(String args[]) {
        int o, s = 1;
        String qtext = "";
        Scanner sc = new Scanner(System.in);
        TrueOrFalse[] q1 = new TrueOrFalse[100];
        MultipleChoice[] q2 = new MultipleChoice[100];
        int q1_no = 0, q2_no = 0, ans1_no = 0, ans2_no = 0;
        int total = 0;
        System.out.println("Making the Quiz:");
        do {
            System.out.println("Question "+(total+1));
            System.out.println("Enter type of question. 1 for True/False, 2 for MCQ:");
            int type = sc.nextInt();
            sc.nextLine();
            switch(type) {
                case 1:
                    System.out.println("Enter the question text:");
                    qtext = sc.nextLine();
                    System.out.println("Enter the answer. 1 for true, 2 for false");
                    s = sc.nextInt();
                    q1[q1_no++] = new TrueOrFalse(qtext, s);
                    total++;
                    break;
                case 2:
                    System.out.println("Enter the question text:");
                    qtext = sc.nextLine();
                    System.out.println("Enter option 1:");
                    String o1 = sc.nextLine();
                    System.out.println("Enter option 2:");
                    String o2 = sc.nextLine();
                    System.out.println("Enter option 3:");
                    String o3 = sc.nextLine();
                    System.out.println("Enter option 4:");
                    String o4 = sc.nextLine();
                    System.out.println("Enter the correct option(1/2/3/4):");
                    s = sc.nextInt();
                    q2[q2_no++] = new MultipleChoice(qtext, o1, o2, o3, o4, s);
                    total++;
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
            System.out.println("To input another question, press 1, otherwise press 0 to start the quiz.");
            o = sc.nextInt();
        }while(o!=0);
        int[] anskey1 = new int[q1_no];
        int[] anskey2 = new int[q2_no];
        int[] order  = new int[total];
        TrueOrFalse t1;
        MultipleChoice t2;
        for(int i = 1; i<=500; i++) {
            int a = getRandomNumber(0, q1_no);
            int b = getRandomNumber(0, q1_no);
            t1 = q1[a];
            q1[a] = q1[b];
            q1[b] = t1;
            a = getRandomNumber(0, q2_no);
            b = getRandomNumber(0, q2_no);
            t2 = q2[a];
            q2[a] = q2[b];
            q2[b] = t2;
        }
        System.out.println("\n\nSolving the Quiz:");
        int total_marks = 0;
        for(int i = 0; i<total; i++) {
            int a;
            if(ans1_no==q1_no)
                a = 2;
            else if(ans2_no==q2_no)
                a = 1;
            else
                a = getRandomNumber(1, 3);
            order[i] = a;
            switch(order[i]) {
                case 1:
                    System.out.println(q1[ans1_no].getType());
                    System.out.print((i+1)+". ");
                    System.out.println(q1[ans1_no].getQuestion());
                    System.out.println("Enter your answer. 1 for true, 2 for false:");
                    anskey1[ans1_no] = sc.nextInt();
                    if(q1[ans1_no].verifyAnswer(anskey1[ans1_no])){
                        total_marks += 1;
                    }
                    ans1_no++;
                    break;
                case 2:
                    System.out.println(q2[ans2_no].getType());
                    System.out.print((i+1)+". ");
                    System.out.println(q2[ans2_no].getQuestion());
                    System.out.println("1. "+q2[ans2_no].option1);
                    System.out.println("2. "+q2[ans2_no].option2);
                    System.out.println("3. "+q2[ans2_no].option3);
                    System.out.println("4. "+q2[ans2_no].option4);
                    System.out.println("Enter your answer(1/2/3/4):");
                    anskey2[ans2_no] = sc.nextInt();
                    if (q2[ans2_no].verifyAnswer(anskey2[ans2_no])) {
                        total_marks += 1;
                    }
                    ans2_no++;
                    break;
                default:
                    System.out.println("ERROR");
            }
        }
        ans1_no = 0;
        ans2_no = 0;
        System.out.println("\n\nResults:");
        System.out.println("\nTotal score : "+total_marks);
        for(int i = 0; i<total; i++) {
            switch(order[i]) {
                case 1:
                    if(anskey1[ans1_no]==1)
                        System.out.println("Q"+(i+1)+" Your answer:TRUE  Correct answer:"+q1[ans1_no].getSolution());
                    else if(anskey1[ans1_no]==2)
                        System.out.println("Q"+(i+1)+" Your answer:FALSE  Correct answer:"+q1[ans1_no].getSolution());
                    ans1_no++;
                    break;
                case 2:
                    if(anskey2[ans2_no]==1)
                        System.out.println("Q" + (i + 1) + " Your answer:"+anskey2[ans2_no]+"."+q2[ans2_no].option1+"  Correct answer:" +q2[ans2_no].mySolution +"."+ q2[ans2_no].getSolution());
                    else if(anskey2[ans2_no]==2)
                        System.out.println("Q" + (i + 1) + " Your answer:"+anskey2[ans2_no]+"."+q2[ans2_no].option2+"  Correct answer:" +q2[ans2_no].mySolution +"."+ q2[ans2_no].getSolution());
                    else if(anskey2[ans2_no]==3)
                        System.out.println("Q" + (i + 1) + " Your answer:"+anskey2[ans2_no]+"."+q2[ans2_no].option3+"  Correct answer:" +q2[ans2_no].mySolution +"."+ q2[ans2_no].getSolution());
                    else if(anskey2[ans2_no]==4)
                        System.out.println("Q" + (i + 1) + " Your answer:" + anskey2[ans2_no] + "." + q2[ans2_no].option4 + "  Correct answer:" + q2[ans2_no].mySolution + "." + q2[ans2_no].getSolution());
                    ans2_no++;
            }
        }
        sc.close();
    }
}
