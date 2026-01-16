public class OutputProcessor {

    public void printCars(int[] cars) {
        for (int car : cars) {
            for (int i = 0; i < car; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}