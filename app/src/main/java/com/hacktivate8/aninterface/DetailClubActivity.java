package com.hacktivate8.aninterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailClubActivity extends AppCompatActivity {

    private ImageView imagelogoview;
    private TextView nameview, stadionview, infoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_club);

        imagelogoview = findViewById(R.id.image_logo);
        nameview = findViewById(R.id.club_name);
        stadionview = findViewById(R.id.club_stadion);
        infoview = findViewById(R.id.club_info);

        Bundle bundle = getIntent().getExtras();

        String logoTim = bundle.getString("logo");
        String nameTim = bundle.getString("name");
        String infoTim = bundle.getString("info");
        String stadionTim = bundle.getString("stadion");

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.build().load(logoTim)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imagelogoview);
        nameview.setText(nameTim);
        stadionview.setText(stadionTim);
        infoview.setText(infoTim);
    }
}