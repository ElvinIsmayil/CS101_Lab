 /* 
 * A simple program that calculates nutritional requirements 
 * and displays information about the amount of macro nutrients
 *  which needs to be consumed in order to reach desired weight goal.
 *
 */

public class Lab01_Q3 {

    public static void main(String[] args) {
        

        // Constants 
        
        // 1 kg weight loss requires a 7700 calorie deficit
        final int caloriesPerKgLoss = 7700;

        // Daily calorie requirement to maintain weight
        final int maintenanceCalories = 2000;
        
        // Recommended macro percentages
        final double carbohydratePercent = 0.50;
        final double fatPercent = 0.30;
        final double proteinPercent = 0.20;
        
        // Calories per gram for each macro
        final int carbohydrateCaloriePerGram = 4;
        final int fatCaloriePerGram = 9;
        final int proteinCaloriePerGram = 4;

        // We store the number of kilograms to lose and the number of days to lose it in
        
        int kilogramsToLose = 1;
        System.out.println("Kilograms to lose: " + kilogramsToLose);

        int daysToLose = 7;
        System.out.println("Days to lose "  + kilogramsToLose + ": " + daysToLose );
        
        
        // Calculations
        
        // Calculate the total calorie deficit required for the goal.
        double totalCalorieDeficit = kilogramsToLose * caloriesPerKgLoss;
        
        // Calculate the required daily deficit.
        double dailyCalorieDeficit = totalCalorieDeficit / daysToLose;
        
        // Calculate the daily calorie goal for weight loss.
        double recommendedDailyCalories = maintenanceCalories - dailyCalorieDeficit;
        
        
        // Macro Calculations
        
        // Calories
        double carbohydrateCalorieRecommendation = recommendedDailyCalories * carbohydratePercent;
        double fatCalorieRecommendation = recommendedDailyCalories * fatPercent;
        double proteinCalorieRecommendation = recommendedDailyCalories * proteinPercent;
        
        // Grams = Calories / Cal_Per_Gram
        double carbohydrateGrams = carbohydrateCalorieRecommendation / carbohydrateCaloriePerGram;
        double fatGrams = fatCalorieRecommendation / fatCaloriePerGram;
        double proteinGrams = proteinCalorieRecommendation / proteinCaloriePerGram;
        
        
        // Output 
        
        // Print the daily deficit statement. Values are rounded to integers as it was shown in the sample code
        System.out.println("To lose " + (int) Math.round(kilogramsToLose) + 
                           " kilograms in " + daysToLose + 
                           " days you will need a daily deficit of " + (int) Math.round(dailyCalorieDeficit) + 
                           " calories");
        
        
        // Print the recommended daily calories goal.
        System.out.println("RECOMMENDED DAILY CALORIES TO LOSE " + (int) Math.round(kilogramsToLose) + 
                           " KILOS IN " + daysToLose + 
                           " DAYS: " + (int) Math.round(recommendedDailyCalories));

        // Table Header
        String headerFormat = "%-16s %-20s %-19s %-42s %s%n";
        System.out.printf(headerFormat, "MACRO", "RECOMMENDED PERCENT", "CALORIES PER GRAM", "RECOMMENDED CALORIES", "GRAMS");

        String dataFormat = "%-32s %-20s %-20d %-25d %.1f%n";

        // Carbohydrate Row
        String carbohydratePercentFormatted = String.format("%d%%", (int) (carbohydratePercent * 100));
        System.out.printf(dataFormat, 
                          "CARBOHYDRATE", 
                          carbohydratePercentFormatted, 
                          carbohydrateCaloriePerGram, 
                          (int) Math.round(carbohydrateCalorieRecommendation), 
                          carbohydrateGrams);

        // Fat Row
        String fatPercentFormatted = String.format("%d%%", (int) (fatPercent * 100));
        System.out.printf(dataFormat, 
                          "FAT", 
                          fatPercentFormatted, 
                          fatCaloriePerGram, 
                          (int) Math.round(fatCalorieRecommendation), 
                          fatGrams); 
        
        // Protein Row
        String proteinPercentFormatted = String.format("%d%%", (int) (proteinPercent * 100));

        System.out.printf(dataFormat, 
                          "PROTEIN", 
                          proteinPercentFormatted, 
                          proteinCaloriePerGram, 
                          (int) Math.round(proteinCalorieRecommendation), 
                          proteinGrams);
    }

    }
