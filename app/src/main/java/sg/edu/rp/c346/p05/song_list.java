package sg.edu.rp.c346.p05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class song_list extends AppCompatActivity {
    Button five;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song> songs;
    ArrayList<Song> fiveStar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        lv = findViewById(R.id.lv);
        five = findViewById(R.id.btnFiveStar);
        DBHelper dbh = new DBHelper(song_list.this);
        final ArrayList<Song> songs = dbh.getAllSongs();

        dbh.close();
        aa = new SongAdapter(this, R.layout.row, songs);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = songs.get(position);
                Intent i = new Intent(song_list.this,
                        EditActivity.class);
                i.putExtra("data", data);
                startActivityForResult(i, 9);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(song_list.this);
                final ArrayList<Song> fiveStar = dbh.getAllSongs();
                fiveStar.clear();
                for (int i = 0; i<songs.size(); i++){
                    if (songs.get(i).getStars() == 5){
                        fiveStar.add(songs.get(i));
                    }
                    aa = new SongAdapter(song_list.this, R.layout.row, fiveStar);
                    lv.setAdapter(aa);
                }

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            DBHelper dbh = new DBHelper(song_list.this);
            final ArrayList<Song> songs = dbh.getAllSongs();

            dbh.close();
            aa = new SongAdapter(this, R.layout.row, songs);
            lv.setAdapter(aa);


        }
    }
}
