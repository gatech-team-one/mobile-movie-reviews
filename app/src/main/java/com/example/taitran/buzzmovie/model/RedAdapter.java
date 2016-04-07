package com.example.taitran.buzzmovie.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.graphics.Color;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.taitran.buzzmovie.controller.R;

import java.util.ArrayList;

/**
 * Created by taitr on 2/28/2016.
 */
public class RedAdapter extends RecyclerView.Adapter<RedAdapter.MovieView>{
    /**
     * The image loader
     */
    private ImageLoader image;
    /**
     * The volley singleton
     */
    private VolleySingleton volleySingleton;
    /**
     * The layout inflater
     */
    private LayoutInflater layout;
    /**
     * The movie list
     */
    private static ArrayList<FilterList> movieList = new ArrayList<>();

    /**
     * The red adaptor constructor
     * @param context the context for the adapter
     */
    public RedAdapter(Context context) {
        layout = LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance(context);
        image = volleySingleton.getImage();
    }

    @Override
    public MovieView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layout.inflate(R.layout.filtereditem, parent, false);
        MovieView viewHolder = new MovieView(view);
        return viewHolder;
    }

    /**
     * Set the movie list
     * @param movie the movie list you're setting
     */
    public void setMovieList(ArrayList<FilterList> movie) {
        this.movieList = movie;
        notifyItemRangeChanged(0, movie.size());
    }

    /**
     * Return the movie list
     * @return the movie list
     */
    public static ArrayList<FilterList> getMovieList() {
        return (ArrayList<FilterList>) movieList.clone();
    }


    @Override
    public void onBindViewHolder(MovieView holder, int position) {
        FilterList currentView = movieList.get(position);
        holder.movieTitle.setText(currentView.getTitle());
        holder.movieDate.setText("Year: " + currentView.getYear());
        holder.movieType.setText("Type: " + currentView.getType());
        holder.score.setRating(currentView.getScore());
        String thumbNail = currentView.getPoster();
        holder.moviePosterURL = thumbNail;
        holder.position = position;
        final MovieView temp = holder;
        if(thumbNail != null) {
            image.get(thumbNail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    temp.moviePoster.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    static class MovieView extends RecyclerView.ViewHolder{
        /**
         * The movie poster
         */
        private ImageView moviePoster;
        /**
         * The movie title
         */
        private TextView movieTitle;
        /**
         * The date of the movie
         */
        private TextView movieDate;
        /**
         * The type of movie
         */
        private TextView movieType;
        /**
         * The url of the poster
         */
        private String moviePosterURL;
        /**
         * The movie rating
         */
        private RatingBar score;
        /**
         * The position of the movie.
         */
        private int position;

        /**
         * The movie view
         * @param itemView reference to the movie view
         */
        public MovieView(View itemView) {
            super(itemView);
            moviePoster = (ImageView) itemView.findViewById(R.id.imageURL);
            movieTitle = (TextView) itemView.findViewById(R.id.movieTitle);
            movieDate = (TextView) itemView.findViewById(R.id.movieYear);
            movieType = (TextView) itemView.findViewById(R.id.movieType);
            score = (RatingBar) itemView.findViewById(R.id.MyRating);
            Drawable progress = score.getProgressDrawable();
            DrawableCompat.setTint(progress, Color.parseColor("#03A9F4"));
        }


    }
}
