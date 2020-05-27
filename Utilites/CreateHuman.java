package Utilites;

import Human.HumanBeing.*;
import Human.HumanBeing;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * create new human
 *
 * @author Diana
 */
public class CreateHuman implements Serializable {
    HumanBeing human = new HumanBeing();

    public String getWhyFailed() {
        return whyFailed;
    }

    public void setWhyFailed(String whyFailed) {
        this.whyFailed = whyFailed;
    }

    String whyFailed = "";

    public void setCreationDateForHuman() {
        human.setCreationDate(LocalDate.now());
    }

    /**
     * Reads input and therefore creates new human
     *
     * @return new human object
     */
    public HumanBeing create() {
        try {
            HumanBeing human = new HumanBeing();
            human.setCreationDate(LocalDate.now());
            this.setCreationDateForHuman();
            this.setNameForHuman(human);
            HumanBeing.Coordinates coords = human.new Coordinates();
            this.setCoordinateXForCoordinates(coords);
            this.setCoordinateYForCoordinates(coords);
            human.setCoordinates(coords);
            this.setRealHeroForHuman(human);
            this.setToothPickForHuman(human);
            this.setImpactSpeedForHuman(human);
            this.setSoundtrackNameForHuman(human);
            this.setMinutesOfWaitingForHuman(human);
            this.setWeaponeTypeForHuman(human);
            HumanBeing.Car car = human.new Car();
            this.setCoolForCar(car);
            this.setNameForCar(car);
            human.setCar(car);
            return human;
        } catch (Exception e) {
            return null;
        }
    }

    public HumanBeing createFromFile(String[] params) {
        if (whyFailed.equals("")) {
            HumanBeing human = new HumanBeing();
            human.setCreationDate(LocalDate.now());
            this.setCreationDateForHuman();
            this.setNameForHumanFromFile(human, params[0]);
            HumanBeing.Coordinates coords = human.new Coordinates();
            this.setCoordinateXForCoordinatesFromFile(coords, params[1]);
            this.setCoordinateYForCoordinatesFromFile(coords, params[2]);
            human.setCoordinates(coords);
            this.setRealHeroForHumanFromFile(human, params[3]);
            this.setToothPickForHumanFromFile(human, params[4]);
            this.setImpactSpeedForHumanFromFile(human, params[5]);
            this.setSoundtrackNameForHumanFromFile(human, params[6]);
            this.setMinutesOfWaitingForHumanFromFile(human, params[7]);
            this.setWeaponeTypeForHumanFromFile(human, params[8]);
            HumanBeing.Car car = human.new Car();
            this.setCoolForCarFromFile(car, params[9]);
            this.setNameForCarFromFile(car, params[10]);
            human.setCar(car);
            return human;
        } else {
            whyFailed = "";
            return null;
        }
    }

    public void setNameForHuman(HumanBeing human) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя челика.");
        System.out.print("$ ");
        String name = scanner.nextLine();
        human.setName(name);
        if (name.equals("") || name.equals(null)) this.setNameForHuman(human);

    }

    public void setCoordinateXForCoordinates(HumanBeing.Coordinates coords) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату x");
            System.out.print("$ ");
            String x = scanner.nextLine();
            if (x.equals("") || x.equals(null)) this.setCoordinateXForCoordinates(coords);
            long xn = Long.parseLong(x);
            coords.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            this.setCoordinateXForCoordinates(coords);
        }
    }

    public void setCoordinateYForCoordinates(Coordinates coords) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координату y");
            System.out.print("$ ");
            String y = scanner.nextLine();
            if (y.equals("") || y.equals(null)) this.setCoordinateYForCoordinates(coords);
            coords.setY(Long.parseLong(y));
            long yn = Long.parseLong(y);
            if (yn <= 867) coords.setY(yn);
            else {
                System.out.println("Значение должно быть меньше 867");

                this.setCoordinateYForCoordinates(coords);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");

            this.setCoordinateYForCoordinates(coords);
        }
    }

    public void setRealHeroForHuman(HumanBeing human) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите является ли челик настоящим героем(true/false)");
        System.out.print("$ ");
        String isRealHero = scanner.nextLine();
        if (isRealHero.equals("")) {
        } else if (isRealHero.equals("true") || isRealHero.equals("false"))
            human.setRealHero(Boolean.parseBoolean(isRealHero));
        else {
            System.out.println("Значение должно быть типа:\"boolean\". Введите значение заново");

            this.setRealHeroForHuman(human);
        }

    }

    public void setToothPickForHuman(HumanBeing human) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите есть ли у челика зубочистка(true/false)");
        System.out.print("$ ");
        String hasToothPick = scanner.nextLine();
        if (hasToothPick.equals("")) {
        } else if (hasToothPick.equals("true") || hasToothPick.equals("false"))
            human.setHasToothpick(Boolean.parseBoolean(hasToothPick));
        else {
            System.out.println("Значение должно быть типа:\"boolean\". Введите значение заново");

            this.setToothPickForHuman(human);
        }
    }

    public void setImpactSpeedForHuman(HumanBeing human) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите скорость удара челика.");
            System.out.print("$ ");
            String impactSpeed = scanner.nextLine();
            if (impactSpeed.equals("") || impactSpeed.equals(null)) this.setImpactSpeedForHuman(human);
            double impactSpeedn = Double.parseDouble(impactSpeed);
            human.setImpactSpeed(impactSpeedn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"double\". Введите значение заново");

            this.setImpactSpeedForHuman(human);
        }
    }

    public void setSoundtrackNameForHuman(HumanBeing human) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название трека.");
        System.out.print("$ ");
        String soundtrackName = scanner.nextLine();
        if (soundtrackName.equals("") || soundtrackName.equals(null)) this.setSoundtrackNameForHuman(human);
        human.setSoundtrackName(soundtrackName);
    }

    public void setMinutesOfWaitingForHuman(HumanBeing human) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите время ожидания челика.");
            System.out.print("$ ");
            String minutesOfWaiting = scanner.nextLine();
            if (minutesOfWaiting.equals("") || minutesOfWaiting.equals(null)) this.setMinutesOfWaitingForHuman(human);
            Double minutesOfWaitingn = Double.parseDouble(minutesOfWaiting);
            human.setMinutesOfWaiting(minutesOfWaitingn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"double\". Введите значение заново");
            this.setMinutesOfWaitingForHuman(human);
        }
    }

    public void setWeaponeTypeForHuman(HumanBeing human) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите тип оружия челика(KNIFE, HAMMER, BAT, RIFLE).");
            System.out.print("$ ");
            String weaponeType = scanner.nextLine().toUpperCase();
            if (weaponeType.equals("KNIFE") || weaponeType.equals("HAMMER") || weaponeType.equals("BAT") || weaponeType.equals("RIFLE"))
                human.setWeaponType(WeaponType.valueOf(weaponeType));
            else if (weaponeType.equals("") || weaponeType.equals(null)) this.setWeaponeTypeForHuman(human);
            else this.setWeaponeTypeForHuman(human);
        } catch (InputMismatchException e) {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение заново");
            this.setMinutesOfWaitingForHuman(human);
        }
    }

    public void setNameForCar(Car car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя машины");
        System.out.print("$ ");
        String nameCar = scanner.nextLine();
        if (nameCar.equals("") || nameCar.equals(null)) this.setNameForCar(car);
        car.setCarName(nameCar);
    }

    public void setCoolForCar(Car car) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите четкая ли у челика тачка(true/false)");
            System.out.print("$ ");
            String coolCar = scanner.nextLine();
            if (coolCar.equals("") || coolCar.equals(null)) this.setCoolForCar(car);
            car.setCarCool(Boolean.parseBoolean(coolCar));
        } catch (InputMismatchException e) {
            System.out.println("Значение должно быть типа:\"Boolean\". Введите значение заново");

            this.setCoolForCar(car);
        }
    }

    public void setNameForHumanFromFile(HumanBeing human, String name) {
        human.setName(name);
    }

    public void setCoordinateXForCoordinatesFromFile(Coordinates coords, String xs) {
        try {
            long x = Long.parseLong(xs);
            coords.setX(x);
        } catch (InputMismatchException | NumberFormatException e) {
            whyFailed += "Значение поля \"X\" должно быть типа:\"long\"\n";

        }
    }

    public void setCoordinateYForCoordinatesFromFile(Coordinates coords, String ys) {
        try {
            long y = Long.parseLong(ys);
            if (y <= 867) coords.setY(y);
            else
                whyFailed += ("Значение должно быть меньше 867") + "\n";
        } catch (InputMismatchException | NumberFormatException e) {
            whyFailed += "Значение поля \"Y\" должно быть типа:\"long\"\n";
        }
    }

    public void setRealHeroForHumanFromFile(HumanBeing human, String isRealHero) {
        if (isRealHero.equals("")) {
        } else if (isRealHero.equals("true") || isRealHero.equals("false"))
            human.setRealHero(Boolean.parseBoolean(isRealHero));
        else {
            whyFailed += ("Значение поля \"Является ли челик настоящим героем\" должно быть типа:\"boolean\".\n");

        }

    }

    public void setToothPickForHumanFromFile(HumanBeing human, String hasToothPick) {

        if (hasToothPick.equals("")) {
        } else if (hasToothPick.equals("true") || hasToothPick.equals("false"))
            human.setHasToothpick(Boolean.parseBoolean(hasToothPick));
        else {
            whyFailed += "Значение поля \"Есть ли у челика зубочистка\" должно быть типа:\"boolean\".\n";

        }
    }

    public void setImpactSpeedForHumanFromFile(HumanBeing human, String impactSpeed) {
        try {
            if (impactSpeed.equals("") || impactSpeed.equals(null)) this.setImpactSpeedForHuman(human);
            double impactSpeedn = Double.parseDouble(impactSpeed);
            human.setImpactSpeed(impactSpeedn);
        } catch (InputMismatchException | NumberFormatException e) {
            whyFailed += ("Значение поля \"Скорость удара\" должно быть типа:\"double\".\n");

        }
    }

    public void setSoundtrackNameForHumanFromFile(HumanBeing human, String soundtrackName) {
        try {
            if (soundtrackName.equals("") || soundtrackName.equals(null)) this.setSoundtrackNameForHuman(human);
            human.setSoundtrackName(soundtrackName);
        } catch (InputMismatchException e) {
            whyFailed += ("Значение поля \"Название саундтрека\" должно быть строчного типа\n");

        }
    }

    public void setMinutesOfWaitingForHumanFromFile(HumanBeing human, String minutesOfWaiting) {
        try {
            if (minutesOfWaiting.equals("") || minutesOfWaiting.equals(null)) this.setMinutesOfWaitingForHuman(human);
            Double minutesOfWaitingn = Double.parseDouble(minutesOfWaiting);
            human.setMinutesOfWaiting(minutesOfWaitingn);
        } catch (InputMismatchException | NumberFormatException e) {
            whyFailed += ("Значение поля \"Время ожидания\" должно быть типа:\"double\".\n");

        }
    }

    public void setWeaponeTypeForHumanFromFile(HumanBeing human, String weaponeType) {
        try {
            if (weaponeType.toUpperCase().equals("KNIFE") || weaponeType.toUpperCase().equals("HAMMER") || weaponeType.toUpperCase().equals("BAT") || weaponeType.equals("RIFLE"))
                human.setWeaponType(WeaponType.valueOf(weaponeType));
            else if (weaponeType.equals("") || weaponeType.equals(null)) this.setWeaponeTypeForHuman(human);
            else
                whyFailed += ("Значение поля \"Тип оружия\" должно соответствовать перечислинным типам(KNIFE, HAMMER, BAT, RIFLE).\n");

        } catch (InputMismatchException e) {
            whyFailed += ("Значение поля \"Тип оружия\" должно соответствовать перечислинным типам(KNIFE, HAMMER, BAT, RIFLE).\n");

        }
    }

    public void setNameForCarFromFile(Car car, String nameCar) {
        try {
            if (nameCar.equals("") || nameCar.equals(null)) this.setNameForCar(car);
            car.setCarName(nameCar);
        } catch (InputMismatchException e) {
            whyFailed += ("Значение должно быть типа:\"String\". Введите значение заново\n");

        }
    }

    public void setCoolForCarFromFile(Car car, String coolCar) {
        try {
            if (coolCar.equals("") || coolCar.equals(null)) this.setCoolForCar(car);
            car.setCarCool(Boolean.parseBoolean(coolCar));
        } catch (InputMismatchException e) {
            whyFailed += ("Значение поля \"Пантовая ли у челика тачка\" должно быть типа:\"Boolean\". Введите значение:");

        }
    }
}

