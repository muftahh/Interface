package com.hacktivate8.aninterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClubAdapter.ListItemClikcListener {
    private RecyclerView clubRv;
    private List<Club> mClubList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clubRv = findViewById(R.id.club_rv);
        mClubList = new ArrayList<>();

        //data
        Club club = new Club();
        club.setName("Man City");
        club.setImg_logo("https://ssl.gstatic.com/onebox/media/sports/logos/z44l-a0W1v5FmgPnemV6Xw_96x96.png");
        club.setStadion("Stadion Etihad");
        club.setInformation(getResources().getString(R.string.ManCity_Info));
        mClubList.add(club);

        club = new Club();
        club.setName("Liverpool");
        club.setImg_logo("https://ssl.gstatic.com/onebox/media/sports/logos/0iShHhASp5q1SL4JhtwJiw_96x96.png");
        club.setStadion("Stadion Anfield");
        club.setInformation(getResources().getString(R.string.Liverpool_Info));
        mClubList.add(club);

        club = new Club();
        club.setName("Chelsea");
        club.setImg_logo("https://ssl.gstatic.com/onebox/media/sports/logos/fhBITrIlbQxhVB6IjxUO6Q_96x96.png");
        club.setStadion("Stadion Stamford Bridge");
        club.setInformation(getResources().getString(R.string.Chelsea_Info));
        mClubList.add(club);

        club = new Club();
        club.setName("Man Utd");
        club.setImg_logo("https://ssl.gstatic.com/onebox/media/sports/logos/udQ6ns69PctCv143h-GeYw_96x96.png");
        club.setStadion("Stadion Old Trafford");
        club.setInformation(getResources().getString(R.string.ManUtd_Info));
        mClubList.add(club);



        ClubAdapter adapter = new ClubAdapter(this, mClubList);
        adapter.setListener(this);
        clubRv.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        clubRv.setLayoutManager(layoutManager);
    }

    @Override
    public void onListItemClick(View v, int position) {
        Club clubSelected = mClubList.get(position);

        Intent intent = new Intent(this, DetailClubActivity.class);
        intent.putExtra("name", clubSelected.getName());
        intent.putExtra("logo", clubSelected.getImg_logo());
        intent.putExtra("info", clubSelected.getInformation());
        intent.putExtra("stadion", clubSelected.getStadion());

        startActivity(intent);
    }
}