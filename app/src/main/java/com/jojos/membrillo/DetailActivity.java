package com.jojos.membrillo;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.characterImageView)
    ImageView mCharacterImageView;

    @BindView(R.id.backgroundImageView)
    ImageView mBackgroundImageView;

    @BindView(R.id.nameTextView)
    TextView mNameTextView;

    @BindView(R.id.descriptionTextView)
    TextView mDescriptionTextView;

    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        String mKey= Objects.requireNonNull(getIntent().getExtras()).getString("key");

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("character").child(mKey);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Character charater = dataSnapshot.getValue(Character.class);

                if (charater.getName() != null) {
                    mNameTextView.setText(charater.getName());
                }

                if (charater.getDescription() != null) {
                    mDescriptionTextView.setText(charater.getDescription());
                }

                int[] charactersImages= {R.drawable.goku,R.drawable.luffy,R.drawable.naruto,R.drawable.usagi_tsukino};
                int[] backgroundsImages= {R.drawable.dbz_background,R.drawable.onepiece_background,R.drawable.naruto_background,R.drawable.sailormoon_background};
                if (charater.getUrl() < 4) {
                    mCharacterImageView.setImageResource(charactersImages[charater.getUrl()]);
                }

                if (charater.getUrl() < 4) {
                    mBackgroundImageView.setImageResource(backgroundsImages[charater.getUrl()]);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(DetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}