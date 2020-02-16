package com.mp.piu_mobile_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private RecyclerView recyclerView_s;
    private RecyclerView.Adapter adapter_s;
    private RecyclerView.LayoutManager layoutManager_s;
    private ArrayList<Sheet> arrayList_s;
    private FirebaseDatabase database_s;
    private DatabaseReference databaseReference_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);               //id 연결
        recyclerView.setHasFixedSize(true);                            //기존성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<User>();
        database = FirebaseDatabase.getInstance();                      //Firebase database와 연동
        databaseReference = database.getReference("User");     //DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //firebase database의 data를 GET
                arrayList.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);
                    arrayList.add(user);
                }
                adapter.notifyDataSetChanged();                         //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //error 발생시
                Log.e("MainActivity", String.valueOf(databaseError.toException()));
            }
        });

        arrayList_s = new ArrayList<Sheet>();
        databaseReference_s = database.getReference("Sheet");     //DB 테이블 연결
        databaseReference_s.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //firebase database의 data를 GET
                arrayList_s.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    Sheet sheet = snapshot.getValue(Sheet.class);
                    arrayList_s.add(sheet);
                }
                adapter_s.notifyDataSetChanged();                         //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //error 발생시
                Log.e("MainActivity", String.valueOf(databaseError.toException()));
            }
        });


        adapter = new CustomAdapter(arrayList,this);
        adapter_s = new SongAdapter(arrayList_s,this);
        recyclerView.setAdapter(adapter_s);

    }
}
