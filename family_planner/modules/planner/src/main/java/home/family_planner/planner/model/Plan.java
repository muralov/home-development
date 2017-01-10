package home.family_planner.planner.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mansur on 12/20/16.
 */

@Entity
public class Plan implements Serializable{

    @EmbeddedId
    private MealPlanPK mealPlanPK;

    private int weekDay;

    public Plan(MealPlanPK mealPlanPK) {
        this.mealPlanPK = mealPlanPK;
    }

    public MealPlanPK getMealPlanPK() {
        return mealPlanPK;
    }

    public void setMealPlanPK(MealPlanPK mealPlanPK) {
        this.mealPlanPK = mealPlanPK;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }
}
