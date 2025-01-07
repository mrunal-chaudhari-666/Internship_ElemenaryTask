public class CalculatorLogic {
    public static double calculatePercentage(double part, double total) {
        return (part / total) * 100;
    }

    public static double percentageIncrease(double original, double increase) {
        return ((increase - original) / original) * 100;
    }

    public static double percentageDecrease(double original, double decrease) {
        return ((original - decrease) / original) * 100;
    }

    public static double findWhole(double part, double percentage) {
        return (part / percentage) * 100;
    }
}

