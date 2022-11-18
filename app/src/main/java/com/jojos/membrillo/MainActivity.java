package com.jojos.membrillo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ImageView atras;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.characterRecyclerView)
    RecyclerView mRecyclerView;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.newFloatingActionButton)
    FloatingActionButton mNewFloatingActionButton;

    CharacterAdapter mCharacterAdapter;

    LinearLayoutManager mLayoutManager;

    private ArrayList<Character> mListCharacter;

    private DatabaseReference mDatabaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mListCharacter = new ArrayList<>();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("character");

        mNewFloatingActionButton.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        });

        Recycler();
        atras = findViewById(R.id.volverAtras2);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }

        });

    }

    public void Recycler() {

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mCharacterAdapter = new CharacterAdapter(mListCharacter);
        mRecyclerView.setAdapter(mCharacterAdapter);
        Content();
        deleteSwipe();
    }

    private void Content() {

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mListCharacter.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Character character = postSnapshot.getValue(Character.class);

                    if (character != null) {
                        character.setKey(postSnapshot.getKey());
                    }

                    mListCharacter.add(character);

                }
                mCharacterAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteSwipe() {

        ItemTouchHelper.SimpleCallback touchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mDatabaseReference.child(mListCharacter.get(viewHolder.getAdapterPosition()).getKey()).setValue(null);
                mCharacterAdapter.deleteItem(viewHolder.getAdapterPosition());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelperCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

}