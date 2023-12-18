package com.openclassrooms.tajmahal.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.openclassrooms.tajmahal.data.service.RestaurantApi;
import com.openclassrooms.tajmahal.domain.model.Restaurant;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Ceci est la classe de répertoire pour la gestion des données de restaurant. Les répertoires sont responsables
 * de la coordination des opérations de données provenant de sources de données telles que les API réseau, les bases de données, etc.
 * Typiquement dans une application Android construite avec des composants d'architecture, le répertoire gérera
 * la logique pour décider s'il faut récupérer des données d'une source réseau ou utiliser des données d'un cache local.
 *
 * @see Restaurant
 * @see RestaurantApi
 */

@Singleton
public class RestaurantRepository {

    // The API interface instance that will be used for network requests related to restaurant data.
    private final RestaurantApi restaurantApi;

    /**
     * Construit une nouvelle instance de {@link RestaurantRepository} avec la {@link RestaurantApi} donnée.
     *
     * @param restaurantApi L'interface API réseau pour la récupération des données de restaurant.
     */

    @Inject
    public RestaurantRepository(RestaurantApi restaurantApi) {
        this.restaurantApi = restaurantApi;
    }

    /**
     * Récupère les détails du restaurant.
     * Cette méthode effectuera un appel réseau en utilisant l'instance {@link RestaurantApi} fournie
     * pour récupérer les données du restaurant. Notez que la gestion des erreurs et toute transformation des données
     * devront être gérées.
     *
     * @return LiveData contenant les détails du restaurant.
     */

    public LiveData<Restaurant> getRestaurant() {
        return new MutableLiveData<>(restaurantApi.getRestaurant());
    }

}
