package com.openclassrooms.tajmahal.domain.model;

import java.util.Objects;


/**
 * Représente un avis d'utilisateur.
 * Cette classe encapsule tous les détails d'un avis, y compris le nom d'utilisateur de la critique,
 * sa photo de profil, le commentaire qu'il a laissé, et la note qu'il a donné.
 */

public class Review {

    /** Le nom de l'utilisateur qui a laissé l'avis. */
    private String username;

    /** La photo de profil de l'utilisateur qui a laissé l'avis. */
    private String picture;

    /** Le commentaire ou retour d'information donné par l'utilisateur. */
    private String comment;

    /** La note fournie par l'utilisateur. Généralement sur 5 ou 10. */
    private int rate;

    /**
     * Construit une nouvelle instance de Review.
     *
     * @param username le nom de l'utilisateur qui laisse l'avis
     * @param picture  l'URL ou le chemin de la photo de profil de l'utilisateur
     * @param comment  le retour ou le commentaire de l'utilisateur
     * @param rate     la note donnée par l'utilisateur
     */
    public Review(String username, String picture, String comment, int rate) {
        this.username = username;
        this.picture = picture;
        this.comment = comment;
        this.rate = rate;
    }

    /**
     * Retourne le nom d'utilisateur de la critique.
     *
     * @return une chaîne de caractères représentant le nom d'utilisateur
     */
    public String getUsername() {
        return username;
    }

    /**
     * Définit ou met à jour le nom d'utilisateur de la critique.
     *
     * @param username le nouveau nom d'utilisateur à définir
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the profile picture of the reviewer.
     *
     * @return a String representing the picture's URL or path
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets or updates the profile picture of the reviewer.
     *
     * @param picture the new profile picture's URL or path to be set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Returns the comment left by the reviewer.
     *
     * @return a String containing the feedback or comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets or updates the comment left by the reviewer.
     *
     * @param comment the new comment or feedback to be set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the rating given by the reviewer.
     *
     * @return an integer representing the rating value
     */
    public int getRate() {
        return rate;
    }

    /**
     * Sets or updates the rating given by the reviewer.
     *
     * @param rate the new rating value to be set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * Compares this review with another object for equality.
     * Two reviews are considered equal if all their fields are identical.
     *
     * @param o the object to be compared with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return rate == review.rate && Objects.equals(username, review.username) && Objects.equals(picture, review.picture) && Objects.equals(comment, review.comment);
    }

    /**
     * Generates a hash code for this review based on its fields.
     *
     * @return the generated hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, picture, comment, rate);
    }
}
