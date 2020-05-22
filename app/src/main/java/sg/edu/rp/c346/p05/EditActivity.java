package sg.edu.rp.c346.p05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    Button cancel;
    Button update;
    Button delete;
    EditText year;
    EditText song;
    EditText singer;
    TextView id;
    RadioGroup stars;
    Song songs;
    RadioButton rb1,rb2,rb3,rb4,rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id = findViewById(R.id.textId);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        year = findViewById(R.id.etYear);
        song = findViewById(R.id.etTitle);
        singer = findViewById(R.id.etSingers);
        stars = findViewById(R.id.rgStars);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        cancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        songs = (Song) i.getSerializableExtra("data");

        id.setText(String.valueOf(songs.getId()));
        Log.w("check", songs.getTitle());
        song.setText(songs.getTitle());
        singer.setText(songs.getSinger());
        year.setText(String.valueOf(songs.getYear()));


        if (songs.getStars()==Integer.parseInt(rb1.getText().toString())){
            rb1.setChecked(true);
        }else if (songs.getStars()==Integer.parseInt(rb2.getText().toString())){
            rb2.setChecked(true);
        }else if (songs.getStars()==Integer.parseInt(rb3.getText().toString())){
            rb3.setChecked(true);
        }else if (songs.getStars()==Integer.parseInt(rb4.getText().toString())){
            rb4.setChecked(true);
        }else{
            rb5.setChecked(true);

        }



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = stars.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                DBHelper dbh = new DBHelper(EditActivity.this);
                songs.setSinger(singer.getText().toString());
                songs.setStars(Integer.parseInt(rb.getText().toString()));
                songs.setTitle(song.getText().toString());
                songs.setYear(Integer.parseInt(year.getText().toString()));
                dbh.updateNote(songs);
                dbh.close();
                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(songs.getId());
                dbh.close();
                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();

            }
        });

    }


}

