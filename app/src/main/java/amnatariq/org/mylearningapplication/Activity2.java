package amnatariq.org.mylearningapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Activity2 extends AppCompatActivity {

    TextView correctView,incorrectView,dateView;
    TextView questionView,questionValView;

    ArrayList<String> array;
    int count=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        correctView = findViewById(R.id.score);
        incorrectView = findViewById(R.id.incorrect);
        dateView = findViewById(R.id.date_val);

        questionView = findViewById(R.id.question_num);
        questionValView = findViewById(R.id.ques_val);

        String correctAns = getIntent().getStringExtra("keycorrect");
        String incorrectAns;
        incorrectAns = getIntent().getStringExtra("keyincorrect");

        correctView.setText(correctAns);
        incorrectView.setText(incorrectAns);

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        dateView.setText(strDate);

        Bundle bundle = getIntent().getExtras();
        array= bundle.getStringArrayList("stringArray");

        ListView lv =findViewById(R.id.list_val);
        ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        lv.setAdapter(items);

    }
}