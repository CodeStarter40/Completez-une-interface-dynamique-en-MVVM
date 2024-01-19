package com.openclassrooms.tajmahal.ui.restaurant;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.ui.adapter.ReviewAdapter;

public class ReviewFragment extends Fragment {

    private ReviewAdapter reviewAdapter;
    private RecyclerView reviewsRecyclerView;
    private DetailsViewModel detailsViewModel;
    private RatingBar ratingBar;
    private EditText editTextComment;
    private Button submitButton;

    public ReviewFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout pour ce fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        submitButton = view.findViewById(R.id.submitButton);
        editTextComment = view.findViewById(R.id.editTextReview);
        ratingBar = view.findViewById(R.id.ratingBar);
        initRecyclerView(view);
        setupBackButton(view);
        setupSubmitButton();
        return view;
    }

    private void setupSubmitButton() {
        submitButton.setOnClickListener(view -> {
            String comment = editTextComment.getText().toString();
            int rating = (int) ratingBar.getRating();
            Review newReview = new Review("Manon Garcia","https://xsgames.co/randomusers/assets/avatars/female/3.jpg",comment,rating);

            detailsViewModel.addReview(newReview);

            refreshReviews(); //rafraichi la page des reviews
            hideKeyboard(view); //abaisse le clavier apres ajout d'un avis
        });
    }

    private void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && getActivity().getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }
    private void refreshReviews() {
        detailsViewModel.getReviews().observe(getViewLifecycleOwner(),reviews -> {
            reviewAdapter.setReviews(reviews);
            reviewAdapter.notifyDataSetChanged(); //notification de adaptetaeur du changement
        });
    }

    private void setupBackButton(View view) {
        ImageView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            //logique retour arriere
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Initialisation du ViewModel
        detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);
        observeReviews();
    }

    private void initRecyclerView(View view) {
        // Initialisation du RecyclerView
        reviewsRecyclerView = view.findViewById(R.id.reviewsRecyclerView);
        reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        reviewAdapter = new ReviewAdapter();
        reviewsRecyclerView.setAdapter(reviewAdapter);
    }

    private void observeReviews() {
        detailsViewModel.getReviews().observe(getViewLifecycleOwner(), reviews -> {
            // Mettre à jour l'adaptateur avec les nouvelles données
            reviewAdapter.setReviews(reviews);
        });

    }
}
