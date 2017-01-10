package home.family_planner.planner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by mansur on 1/9/17.
 */

@Document(collection="plans")
public class PlanMongo {

    /**
     * value of the id is the long value of the date
     */
    @Id Long id;
    LocalDate date;
    List<Day> days;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        setId(date.toEpochDay());
        this.date = date;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public static class Day {

        String name;
        List<MealTime> mealTimes;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<MealTime> getMealTimes() {
            return mealTimes;
        }

        public void setMealTimes(List<MealTime> mealTimes) {
            this.mealTimes = mealTimes;
        }
    }

    public static class MealTime {

        String name;

        @Field("links")
        Link _links;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Link get_links() {
            return _links;
        }

        public void set_links(Link _links) {
            this._links = _links;
        }

        public static class Link {
            List<String> foods;
            List<String> meals;

            public List<String> getFoods() {
                return foods;
            }

            public void setFoods(List<String> foods) {
                this.foods = foods;
            }

            public List<String> getMeals() {
                return meals;
            }

            public void setMeals(List<String> meals) {
                this.meals = meals;
            }
        }

    }

}
