package sg.edu.rp.c346.p05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    private ArrayList<Song> songs;
    private Context context;
    private TextView tvYear;
    private TextView tvSong;
    private TextView tvArtist;
    private ImageView ivStar1;
    private ImageView ivStar2;
    private ImageView ivStar3;
    private ImageView ivStar4;
    private ImageView ivStar5;
    public SongAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        songs = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvSong = (TextView) rowView.findViewById(R.id.tvSong);
        tvArtist = (TextView) rowView.findViewById(R.id.tvArtist);
        tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        // Get the ImageView object
        ivStar1 = (ImageView) rowView.findViewById(R.id.ivStar1);
        ivStar2 = (ImageView) rowView.findViewById(R.id.ivStar2);
        ivStar3 = (ImageView) rowView.findViewById(R.id.ivStar3);
        ivStar4 = (ImageView) rowView.findViewById(R.id.ivStar4);
        ivStar5 = (ImageView) rowView.findViewById(R.id.ivStar5);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Song currentSong = songs.get(position);
        // Set the TextView to show the food

        tvSong.setText(currentSong.getTitle());
        tvYear.setText(Integer.toString(currentSong.getYear()));
        tvArtist.setText(currentSong.getSinger());
        // Set the image to star or nostar accordingly
        int stars = currentSong.getStars();
        if(stars == 5) {
            ivStar1.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
            ivStar3.setImageResource(R.drawable.star);
            ivStar4.setImageResource(R.drawable.star);
            ivStar5.setImageResource(R.drawable.star);
        }else if (stars == 4){
            ivStar1.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
            ivStar3.setImageResource(R.drawable.star);
            ivStar4.setImageResource(R.drawable.star);
        }else if (stars == 3){
            ivStar1.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
            ivStar3.setImageResource(R.drawable.star);
        }
        else if(stars==2){
            ivStar1.setImageResource(R.drawable.star);
            ivStar2.setImageResource(R.drawable.star);
        }else{
            ivStar1.setImageResource(R.drawable.star);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
