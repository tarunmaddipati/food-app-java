package org.food.util;

import org.food.model.Customer;
import org.food.model.Dish;
import org.food.model.Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
        public List<Customer> readCustomerFromCsv() {
            String customerCsvFilePath = "/Users/tarun/Developer/foodie-cli-app-java/data/customer.csv";
            List<Customer> customersList = new ArrayList<>();
            String line;
            String csvSplitBy = ",";
            try (BufferedReader br = new BufferedReader(new FileReader(customerCsvFilePath))) {
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);
                    Customer customer = new Customer();
                    customer.setId(data[0]);
                    customer.setName(data[1]);
                    customer.setEmail(data[2]);
                    customer.setPassword(data[3]);

                    customersList.add(customer);
                }
            } catch (IOException e) {
                System.out.println("File not found" + customerCsvFilePath);
                System.exit(0);
                e.printStackTrace();
            }

            return customersList;
        }

    public List<Restaurant> readRestaurantsFromCsv() {
        String RESTAURANTS_CSV_PATH =  "/Users/tarun/Developer/foodie-cli-app-java/data/restaurants.csv";
        String line;
        List<Restaurant> restaurantsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RESTAURANTS_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Restaurant restaurant = new Restaurant();

                restaurant.setId(data[0]);
                restaurant.setName(data[1]);
                restaurant.setAddress(data[2]);
                restaurant.setMenu(Arrays.asList(data[3].split(":")));
                restaurantsList.add(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + RESTAURANTS_CSV_PATH);
            System.exit(0);
        }
        return restaurantsList;
    }
    private List<Dish> dishesList;

    public List<Dish> readDishesFromCsv() {
        String DISHES_CSV_PATH = "/Users/tarun/Developer/foodie-cli-app-java/data/dishes.csv";
        String line;
        List<Dish> dishesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Dish dish = new Dish();
                dish.setId(data[0]);
                dish.setName(data[1]);
                dish.setDescription(data[2]);
                dish.setPrice(Double.parseDouble(data[3]));
                dishesList.add(dish);
            }
            this.dishesList = dishesList;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + DISHES_CSV_PATH);
            System.exit(0);
        }
        return dishesList;
    }

}