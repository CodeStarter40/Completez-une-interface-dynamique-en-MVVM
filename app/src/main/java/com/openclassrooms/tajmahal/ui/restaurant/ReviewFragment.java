package com.openclassrooms.tajmahal.ui.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.ui.adapter.ReviewAdapter;

public class ReviewFragment extends Fragment {

    private ReviewAdapter reviewAdapter;
    private RecyclerView reviewsRecyclerView;
    private DetailsViewModel detailsViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout pour ce fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        initRecyclerView(view);
        return view;
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
