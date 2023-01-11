package amnatariq.org.mylearningapplication;

import static java.util.Collections.shuffle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    String mQuestions[] ={"Which of the following are object oriented languages?",
            "In programming, a series of logically ordered steps that lead to a required result is called?",
            "Which is a typical language for programming inside Web pages?",
            "Which of the following converts source code into machine code at each runtime?",
            "Which of the following commonly happens to variables (in most languages)?",
            "AND, OR and NOT are logical operators. What data type is expected for their operands?"};

    String mChoices [][] = {
            {"Java","Cobol","C++"},
            {"a compiler","a data structure","an algorithm"},
            {"JavaScript","HTML","XML"},
            {"linker","compiler","interpreter"},
            {"declaration","assignment","derivation"},
            {"integer","boolean","character"}
    };

    String mCorrectAnswers[] = {"C++","an algorithm","JavaScript","interpreter","declaration","boolean"};

    String myQuestions[]={};
    String myAnswers[] ={};

    TextView mScoreView;
    TextView mIncorrectView;
    TextView mTotalQuestionView;
    TextView mQuestionView;
    TextView mResultView;
    TextView textView;
    Button mBtnChoice1, mBtnChoice2, mBtnChoice3, mShowAns;
    Button mAnswerBtn;

    Button resBtn;

    int questionNum=5;

    String mAnswer;
    String ans;
    String cAns;
    int mScore = 0;
    int mIncorrect = 0;
    int mQuestionNumber = 0;

    int mTotalQuestion = 0;

    int temp;
    int t;
    int t1;
    int t2;
    int t3;

    int n1,n2,n3,n4,n5;

    int num=0;

    int[] array;
    ArrayList<Integer> list = new ArrayList<Integer>(6);
    ArrayList<String> q1 = new ArrayList<>();
    ArrayList<String> q2 = new ArrayList<>();
    ArrayList<String> q3 = new ArrayList<>();
    ArrayList<String> q4 = new ArrayList<>();
    ArrayList<String> q5 = new ArrayList<>();
    ArrayList<String> q6 = new ArrayList<>();
    String choice;

    List<Integer> l = new ArrayList<>();
    int count=0;
    int counting=0;

    String resultArr[];

    private List<Question> qList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView)findViewById(R.id.score);
        mIncorrectView = (TextView)findViewById(R.id.incorrect);

        mTotalQuestionView = (TextView)findViewById(R.id.totalquestion);
        mQuestionView = (TextView)findViewById(R.id.question);

        mBtnChoice1 = (Button)findViewById(R.id.choice1);
        mBtnChoice2 = (Button)findViewById(R.id.choice2);
        mBtnChoice3 = (Button)findViewById(R.id.choice3);

        resBtn = (Button)findViewById(R.id.resultBtn);

        textView = (TextView)findViewById(R.id.answer);

        resBtn.setVisibility(View.INVISIBLE);

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        qList = dbgHelper.getAllQuestions();

        updateQuestion();

        mBtnChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cAns=mAnswer;
                if(mBtnChoice1.getText() == mAnswer){
                    choice = "1";
                    cAns=mAnswer;
                    mScore = mScore+1;
                    updateScore(mScore);
                    ans="Correct";
                    textView.setText("Correct");
                    textView.setBackgroundColor(getResources().getColor(R.color.green));
                    if(mTotalQuestion<=(questionNum)) {
                        updateQuestion();
                    }
                    else{
                        resBtn.setVisibility(View.VISIBLE);
                        //updateQuestionView();
                    }
                }
                else
                {
                    choice ="1";
                    mIncorrect = mIncorrect+1;
                    updateIncorrectScore(mIncorrect);
                    ans="Incorrect";
                    textView.setText("Incorrect");
                    textView.setBackgroundColor(getResources().getColor(R.color.red));
                    if(mTotalQuestion<=(questionNum)) {
                        updateQuestion();
                    }
                    else{
                        resBtn.setVisibility(View.VISIBLE);
                        //updateQuestionView();
                    }
                }
                q1.add(cAns);
                q1.add(ans);
                cAns=" ";
            }
        });


        mBtnChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cAns=mAnswer;
                if(mBtnChoice2.getText() == mAnswer){
                    choice ="2";
                    cAns=mAnswer;
                    mScore = mScore+1;
                    updateScore(mScore);
                    ans="Correct";
                    textView.setText("Correct");
                    textView.setBackgroundColor(getResources().getColor(R.color.green));
                    if(mTotalQuestion<=(questionNum)) {
                        updateQuestion();
                    }
                    else{
                        resBtn.setVisibility(View.VISIBLE);
                        //updateQuestionView();
                    }
                }
                else
                {
                    choice ="2";
                    mIncorrect = mIncorrect+1;
                    updateIncorrectScore(mIncorrect);
                    ans="Incorrect";
                    textView.setText("Incorrect");
                    textView.setBackgroundColor(getResources().getColor(R.color.red));
                    if(mTotalQuestion<=(questionNum)) {
                        updateQuestion();
                    }
                    else{
                        resBtn.setVisibility(View.VISIBLE);
                        //updateQuestionView();
                    }
                }
                q1.add(cAns);
                q1.add(ans);
                cAns=" ";
                //resultArr[num+1]=ans;
            }
        });

        mBtnChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cAns=mAnswer;
                if(mBtnChoice3.getText() == mAnswer){
                    choice="3";
                    cAns=mAnswer;
                    mScore = mScore+1;
                    updateScore(mScore);
                    ans="Correct";
                    textView.setText("Correct");
                    textView.setBackgroundColor(getResources().getColor(R.color.green));
                    if(mTotalQuestion<=(questionNum)) {
                        updateQuestion();
                    }
                    else{
                        resBtn.setVisibility(View.VISIBLE);
                        //updateQuestionView();
                    }
                }
                else
                {
                    choice="3";
                    mIncorrect = mIncorrect+1;
                    updateIncorrectScore(mIncorrect);
                    ans="Incorrect";
                    textView.setText("Incorrect");
                    textView.setBackgroundColor(getResources().getColor(R.color.red));
                    if(mTotalQuestion<=(questionNum+1)) {
                        updateQuestion();
                    }
                    else{
                        resBtn.setVisibility(View.VISIBLE);
                        //updateQuestionView();
                    }
                }
                q1.add(cAns);
                q1.add(ans);
                cAns=" ";
                //resultArr[num+1]=ans;
            }
        });
        //q1.add(resultArr);

        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateView();
            }
        });
    }

    public void updateScore(int point)
    {
        mScoreView.setText(""+mScore);
    }
    public void updateIncorrectScore(int point)
    {
        mIncorrectView.setText(""+mIncorrect);
    }

    public void updateQuestionNum(int point)
    {
        mTotalQuestionView.setText(""+mTotalQuestion+"/6");
    }

    public void updateView()
    {
        String s=String.valueOf(mScore);
        String i=String.valueOf(mIncorrect);

        Intent intent = new Intent(MainActivity.this,Activity2.class);
        intent.putExtra("keycorrect",s);
        intent.putExtra("keyincorrect",i);
        intent.putExtra("stringArray", q1);

        startActivity(intent);
    }

    public void updateQuestionView()
    {
//       mQuestionView.setMaxHeight(900);
//        mQuestionView.setText("Question 1: " + q1.get(2) +"\nCorrect Answer: "+q1.get(1)+
//                "\nQuestion 2: " + q1.get(4) +"\nCorrect Answer: "+q1.get(3) +"\nQuestion 3: " + q1.get(6) +"\nCorrect Answer: "+q1.get(5)+
//                "\nQuestion 4: " + q1.get(8) +"\nCorrect Answer: "+q1.get(7));
//        mBtnChoice1.setVisibility(View.INVISIBLE);
//        mBtnChoice2.setVisibility(View.INVISIBLE);
//        mBtnChoice3.setVisibility(View.INVISIBLE);
//        textView.setText("");

        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }

    public void updateQuestion()
    {
        num=0;
        mTotalQuestion = mTotalQuestion+1;
        updateQuestionNum(mTotalQuestion);
        String q = getQuestionRand();
        mQuestionView.setText(q);


        //q1.add(q);
        //resultArr[num]=q;

        mBtnChoice1.setText(getChoices1(temp));
        mBtnChoice2.setText(getChoices2(temp));
        mBtnChoice3.setText(getChoices3(temp));
        mAnswer = getCorrectAnswer(temp);
        mQuestionNumber++;
    }

    public String getQuestionRand(){
        Random r = new Random();
        temp = r.nextInt(6);

        while(l.contains(temp))
        {
            temp = r.nextInt(6);
        }
        l.add(counting,temp);
        counting=counting+1;

        String question = mQuestions[temp];
        return question;
    }

    public String getChoices1(int a){
        Random r = new Random();
        t= r.nextInt(2);
        String choice = mChoices[a][t];
        return choice;
    }
    public String getChoices2(int a){
        Random r = new Random();
        t1 = r.nextInt(2);
        if (t1==t)
        {
            while(t1==t)
            {
                Random r1 = new Random();
                t1 = r1.nextInt(2);
            }
            String choice = mChoices[a][t1];
            return choice;
        }
        else
        {
            String choice = mChoices[a][t1];
            return choice;
        }
    }
    public String getChoices3(int a){
        Random r = new Random();
        t2 = r.nextInt(3);
        if(t2==t1 || t2==t)
        {
            while(t2==t1 || t2==t)
            {
                Random r2 = new Random();
                t2 = r2.nextInt(3);
            }
            String choice = mChoices[a][t2];
            return choice;
        }
        else
        {
            String choice = mChoices[a][t2];
            return choice;
        }

    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }

}