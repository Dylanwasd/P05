package sg.edu.rp.c346.p05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etSong;
    EditText etSinger;
    EditText etYear;
    RadioGroup stars;
    Button insert;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSong=findViewById(R.id.etSongName);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        stars = findViewById(R.id.rgStars);
        insert = findViewById(R.id.btnInsert);
        show = findViewById(R.id.btnShow);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, song_list.class);
                startActivity(intent);
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = stars.getCheckedRadioButtonId();
                int year = Integer.parseInt(etYear.getText().toString());
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                int rating = Integer.parseInt(rb.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertNote(etSong.getText().toString(), etSinger.getText().toString(), year, rating);
                dbh.close();

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
