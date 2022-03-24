package CarRacingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        CarNameParser carNameParser = new CarNameParser(scanner.nextLine());
        String[] carNamesArray = carNameParser.getCarNames();
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carNamesArray.length; i++) {
            cars.add(new Car(carNamesArray[i]));
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int index = scanner.nextInt();
        System.out.println("실행 결과");
        int i = 0;
        while(i < index) {
            for(Car car : cars) {
                car.drive();
                System.out.print(car.getName() + " : ");
                for(int j = 0; j < car.getPosition(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
            i++;
        }
        List<Car> winnerCars = WinnerChooser.chooseWinner(cars);
        for(int k  = 0; k < winnerCars.size() - 1; k++) {
            System.out.print(winnerCars.get(k).getName() + ",");
        }
        System.out.print(winnerCars.get(winnerCars.size() - 1).getName() + "가 최종 우승했습니다.");
    }
}
