package amnatariq.org.mylearningapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="MyQuiz.db";
    private static final int DATABASE_VERSION =1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE "+
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER + " TEXT" + ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL ("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1 = new Question("A is correct","A","B","C","A");
        addQuestion(q1);
    }

    private void addQuestion(Question question)
    {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER,question.getAnswer());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME,null,cv);
    }

    public List<Question> getAllQuestions(){
        List<Question> alist = new ArrayList<>();
        db=getReadableDatabase();
    }
}
