package amnatariq.org.mylearningapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView correct,incorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        correct = findViewById(R.id.score);
        incorrect = findViewById(R.id.incorrect);

        String correctAns = getIntent().getStringExtra("keycorrect");
        String incorrectAns;
        incorrectAns = getIntent().getStringExtra("keyincorrect");

        correct.setText(correctAns);
        incorrect.setText(incorrectAns);
    }
}