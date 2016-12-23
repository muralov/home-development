package home.family_planner.meals.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by mansur on 12/20/16.
 */
@Embeddable
public class MealPlanPK implements Serializable {

    protected Integer planId;
    protected String mealId;

    public MealPlanPK(){}

    public MealPlanPK(Integer planId, String mealId) {
        this.planId = planId;
        this.mealId = mealId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public String getMealId() {
        return mealId;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;

        if(obj==null || !(obj instanceof MealPlanPK))
            return false;

        MealPlanPK that = (MealPlanPK) obj;

        if(that.mealId != this.mealId) return false;

        if(that.planId != this.planId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planId.hashCode();
        return 31 * result + mealId.hashCode();
    }
}
