package com.openclassrooms.tajmahal.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    private List<Review> reviewList;

    public ReviewAdapter() {
        this.reviewList = new ArrayList<>(); //Initialisez avec une liste vide pour éviter les NullPointerException
    }

    //Mettre à jour la liste des avis et notifier l'adaptateur du changement
    public void setReviews(List<Review> reviews) {
        this.reviewList = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Review review = reviewList.get(position);
        holder.usernameTextView.setText(review.getUsername());
        holder.commentTextView.setText(review.getComment());
        //ajouter photo et rating après essai
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    //Classe ViewHolder interne
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTextView;
        TextView commentTextView;
        //ajout autre apres essai

        ViewHolder(View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView); //ajout autre apres essai
            commentTextView = itemView.findViewById(R.id.commentTextView);
        }
    }
}
