package com.openclassrooms.tajmahal;

import org.junit.Test;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.data.service.RestaurantFakeApi;


import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ReviewUnitTest {

    @Test
    public void givenReviewModel_whenInitialized_thenCorrectValuesReturned() {
        //Création d'une instance de Review
        Review review = new Review("Alice", "https://xsgames.co/randomusers/assets/avatars/female/3.jpg", "Très bon restaurant", 4);

        //Vérification que les getters retournent les bonnes valeurs
        assertEquals("Alice", review.getUsername());
        assertEquals("https://xsgames.co/randomusers/assets/avatars/female/3.jpg", review.getPicture());
        assertEquals("Très bon restaurant", review.getComment());
        assertEquals(4, review.getRate());
    }
    @Test
    public void testFakeApiResponses() {
        RestaurantFakeApi fakeApi = new RestaurantFakeApi();
        assertNotNull(fakeApi.getRestaurant());
        assertNotNull(fakeApi.getReviews());
    }



}
