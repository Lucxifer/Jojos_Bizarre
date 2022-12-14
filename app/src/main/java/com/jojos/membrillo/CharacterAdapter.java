package com.jojos.membrillo;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CharacterAdapter extends RecyclerView.Adapter<ViewHolder>{


    private final List<Character> mCharacterList;

    public CharacterAdapter(List<Character> characterList) {
        mCharacterList = characterList;
    }

    @Override
    public void onBindViewHolder(com.jojos.membrillo.ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @NonNull
    @Override
    public com.jojos.membrillo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.character_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (mCharacterList != null & mCharacterList.size() > 0) {
            return mCharacterList.size();
        } else {
            return 0;
        }
    }

    public void addItems(List<Character> characterList) {
        mCharacterList.addAll(characterList);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        if (mCharacterList != null & mCharacterList.size() > 0) {
            mCharacterList.remove(position);
        }
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    public class ViewHolder extends com.jojos.membrillo.ViewHolder {

        @BindView(R.id.characterImageView)
        ImageView mCharacterImageView;

        @BindView(R.id.nameTextView)
        TextView mNameTextView;

        @BindView(R.id.animeTextView)
        TextView mAnimeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            mCharacterImageView.setImageDrawable(null);
            mNameTextView.setText("");
            mAnimeTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            Character mCharacter= mCharacterList.get(position);

            int[] charactersImages= {R.drawable.goku,R.drawable.luffy,R.drawable.naruto,R.drawable.usagi_tsukino};

            if (mCharacter.getUrl() < 4) {
                mCharacterImageView.setImageResource(charactersImages[mCharacter.getUrl()]);
            }

            if (mCharacter.getName() != null) {
                mNameTextView.setText(mCharacter.getName());
            }

            if (mCharacter.getAnime() != null) {
                mAnimeTextView.setText(mCharacter.getAnime());
            }

            itemView.setOnClickListener(v -> {
                Intent intent=new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra("key",  mCharacter.getKey());
                itemView.getContext().startActivity(intent);
            });

            itemView.setOnLongClickListener(v -> {
                Intent intent=new Intent(itemView.getContext(), EditActivity.class);
                intent.putExtra("key",  mCharacter.getKey());
                itemView.getContext().startActivity(intent);
                return false;
            });

        }
    }

}