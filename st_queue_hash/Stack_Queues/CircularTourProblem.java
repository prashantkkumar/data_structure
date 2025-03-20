package week3_assignment2;

class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalPetrol = 0, totalDistance = 0, start = 0, fuelBalance = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            fuelBalance += petrol[i] - distance[i];

            if (fuelBalance < 0) {
                start = i + 1;
                fuelBalance = 0;
            }
        }
        return totalPetrol >= totalDistance ? start : -1;
    }
}

public class CircularTourProblem {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(CircularTour.findStartingPoint(petrol, distance));
    }
}

