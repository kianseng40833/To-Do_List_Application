import java.util.Scanner;
import java.text.DecimalFormat;

public class To_Do_List_Application{

    private static String[] currentList = new String[100]; // Assuming a maximum of 100 items
    private static int itemCount = 0;

    public static void main(String[] args) {
        int menuItem = -1;
        while (menuItem != 0) {
            menuItem = menu();
            switch (menuItem) {
                case 1:
                    showList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    predictDay();
                    break;
                case 5:
                    converter();
                case 0:
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
        }
    }

    public static int menu() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("Main Menu");
        System.out.println("----------------------");
        System.out.println("0. Exit the program");
        System.out.println("1. Display to-do list");
        System.out.println("2. Add item to list");
        System.out.println("3. Remove item from list");
        System.out.println("4. Days Prediction");
        System.out.println("5. Converter");
        System.out.println("----------------------");
        System.out.println();
        System.out.print("Enter choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public static void showList() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("To-Do List");
        System.out.println("----------------------");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + " " + currentList[i]);
        }
        System.out.println("----------------------");
    }

    public static void addItem() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("Add Item");
        System.out.println("----------------------");
        System.out.print("Enter an item: ");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        currentList[itemCount] = item;
        itemCount++;
        showList();
    }

    public static void removeItem() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("Remove Item");
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the item to remove: ");
        int index = scanner.nextInt();
        if (index < 1 || index > itemCount) {
            System.out.println("Wrong index number! Please enter a valid index in the range of 1 to " + itemCount);
        } else {
            // Shift elements to the left to fill the gap
            for (int i = index - 1; i < itemCount - 1; i++) {
                currentList[i] = currentList[i + 1];
            }
            itemCount--;
        }
        System.out.println("----------------------");
        showList();
    }

    public static void predictDay() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("Predict Day");
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type out today's day (Monday, Tuesday, etc.): ");
        String day = scanner.nextLine();
        System.out.println();
        System.out.print("Please specify after how many days from today? ");
        int predict = scanner.nextInt();
        System.out.println();
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int currentIndex = -1;
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (daysOfWeek[i].equalsIgnoreCase(day)) {
                currentIndex = i;
                break;
            }
        }

        if (currentIndex == -1) {
            System.out.println("Invalid day entered!");
        } else {
            int predictedIndex = (currentIndex + predict) % 7;
            String predictedDay = daysOfWeek[predictedIndex];
            System.out.println("The day after " + predict + " day(s) is: " + predictedDay);
        }

        System.out.println("----------------------");
    }

        public static void converter(){
            System.out.println();
            System.out.println("----------------------");
            System.out.println("Converter");
            System.out.println("----------------------");
            final DecimalFormat df = new DecimalFormat("0.00");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the index that you want to calculate.");
            System.out.println("0. Back to Main Menu");
            System.out.println("1. Body Mass Index (BMI)");
            System.out.println("2. Calculate the inch (in)/ foot (ft) /centimetre (cm) of your height.");
            System.out.println("3. Metric Converter");
            System.out.println();
            System.out.print("Enter choice: ");
    
            int index = scanner.nextInt();
            double weight,height,bmi;
    
            switch(index){
                case 0:
                break;

                case 1:
                System.out.println();
                System.out.println("--------------------------------------------");
                System.out.println("This is a Body Mass Index(BMI) calculator.");
                System.out.println("--------------------------------------------");
                System.out.println("Please enter your weight(kg).");
                System.out.print("Enter your weight (kg): ");
                weight = scanner.nextDouble();
                if(weight<0){
                    System.out.println("INVALID INPUT");
                    break;
                }
                System.out.println();
                System.out.println("Please enter your height(m).");
                System.out.print("Enter your height (m): ");
                height = scanner.nextDouble();
                if(height <0){
                    System.out.println("INVALID INPUT");
                    break;
                }
                bmi = weight /(height*height);
                String result;
    
                if(bmi<18.5 && bmi>0){
                    result = "Underweight";
                    System.out.println();
                    System.out.println("Your BMI : "+ df.format(bmi));
                    System.out.println("Your BMI status is "+result);
                }else if(bmi>=18.5 && bmi<25){
                    result = "Normal weight";
                    System.out.println();
                    System.out.println("Your BMI : "+ df.format(bmi));
                    System.out.println("Your BMI status is "+result);
                }else if(bmi>=25 && bmi<30){
                    result = "Overweight";
                    System.out.println();
                    System.out.println("Your BMI : "+ df.format(bmi));
                    System.out.println("Your BMI status is "+result);
                }else if(bmi>=30){
                    result = "Obesity";
                    System.out.println();
                    System.out.println("Your BMI : "+ df.format(bmi));
                    System.out.println("Your BMI status is "+result);
                }else if(bmi<0){
                    System.out.println();
                    System.out.println("INVALID NUMBER");
                }
                System.out.println("----------------------");
                break;

                case 2:
                System.out.println();
                System.out.println("--------------------------------------------");
                System.out.println("This is a height converter");
                System.out.println("--------------------------------------------");
                System.out.println("Please enter your height following the instruction: ");
                System.out.println("1. In centimeter(cm)");
                System.out.println("2. In inch(in)");
                System.out.println("3. In foot(ft)");
                System.out.println("--------------------------------------------");
                System.out.println();
                System.out.print("Enter Your choice: ");
                int hType = scanner.nextInt();
                
                double num;
                double numCm;
                double numInch;
                double numFoot;
                
                switch (hType){
                    case 1:
                    System.out.println();
                    System.out.print("Please enter your height in centimeter(cm) : ");
                    num = scanner.nextDouble();
                    numCm = num;
                    numInch = num/ 2.54;
                    numFoot = num/30.48;
                    System.out.println();
                    System.out.println("This are the result:");
                    System.out.println("Centimeter(cm) = " + numCm);
                    System.out.println("Inch(in) = " + numInch);
                    System.out.println("Foot(ft) = "+ numFoot);
                    break;
                
                    case 2:
                    System.out.println();
                    System.out.print("Please enter your height in inch(ft) : ");
                    num = scanner.nextDouble();
                    numInch = num;
                    numCm = num * 2.54;
                    numFoot = numCm / 30.48;
                    System.out.println();
                    System.out.println("This are the result:");
                    System.out.println("Inch(in) = " + numInch);
                    System.out.println("Centimeter(cm) = " + numCm);
                    System.out.println("Foot(ft) = "+ numFoot);
                    break;
                
                    case 3:
                    System.out.print("Please enter your height in foot(ft) : ");
                    num = scanner.nextDouble();
                    numFoot = num;
                    numCm = num * 30.48;
                    numInch = numCm / 2.54;
                    System.out.println();
                    System.out.println("This are the result:");
                    System.out.println("Foot(ft) = "+ numFoot);
                    System.out.println("Centimeter(cm) = " + numCm);
                    System.out.println("Inch(in) = " + numInch);
                    break;

                    default:
                    System.out.println("INVALID INDEX");
                }
                System.out.println("----------------------");
                break;

                case 3:
                    System.out.println();
                    System.out.println("--------------------------------------------");
                    System.out.println("This is a convertor that convert your values.");
                    System.out.println("--------------------------------------------");
                    System.out.println("0. Back to Main Menu");
                    System.out.println(" 1. kilogram(kg)     ->   gram(g)");
                    System.out.println(" 2. gram(g)          ->   kilogram(kg)");
                    System.out.println(" 3. kilogram(kg)     ->   pound(lb)");
                    System.out.println(" 4. pound(lb)        ->   kilogram(kg)");
                    System.out.println(" 5. centimeter(cm)   ->   meter(m)");
                    System.out.println(" 6. meter(m)         ->   centimeter(cm)");
                    System.out.println(" 7. centimeter(cm)   ->   feet(ft)");
                    System.out.println(" 8. feet(ft)         ->   centimeter(cm)");
                    System.out.println(" 9. hour(h)          ->   minute(min)");
                    System.out.println("10. minute(min)      ->   hour(h)");
                    System.out.println("11. hour(h)          ->   day(d)");
                    System.out.println("12. day(d)           ->   hour(h)");
                    System.out.println("13. Celsius(oC)      ->   Fahrenheit(oF)");
                    System.out.println("14. Fahrenheit(oF)   ->   Celsius(oC)");
                    System.out.println("--------------------------------------------");
                    System.out.println();
                    System.out.print("Enter your choice:");
                    int index1 = scanner.nextInt();
                    double num3;
                    double result1;
                    switch(index1){
                        case 1:
                        System.out.println();
                        System.out.print("Please insert your value (kg) :");
                        num3 = scanner.nextDouble();
                        result1 = num3*1000;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(g)");
                        break;

                        case 2:
                        System.out.println();
                        System.out.print("Please insert your value (g) :");
                        num3 = scanner.nextDouble();
                        result1 = num3/1000;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(kg)");
                        break;

                        case 3:
                        System.out.println();
                        System.out.print("Please insert your value (kg) :");
                        num3 = scanner.nextDouble();
                        result1 = num3*2.20462;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(lb)");
                        break;

                        case 4:
                        System.out.println();
                        System.out.print("Please insert your value (lb) :");
                        num3 = scanner.nextDouble();
                        result1 = num3/2.20462;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(kg)");
                        break;

                        case 5:
                        System.out.println();
                        System.out.print("Please insert your value (cm) :");
                        num3 = scanner.nextDouble();
                        result1 = num3/100;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(m)");
                        break;

                        case 6:
                        System.out.println();
                        System.out.print("Please insert your value (m) :");
                        num3 = scanner.nextDouble();
                        result1 = num3*100;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(cm)");
                        break;

                        case 7:
                        System.out.println();
                        System.out.print("Please insert your value (ft) :");
                        num3 = scanner.nextDouble();
                        result1 = num3*30.48;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(cm)");
                        break;

                        case 8:
                        System.out.println();
                        System.out.print("Please insert your value (cm) :");
                        num3 = scanner.nextDouble();
                        result1 = num3/30.48;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(ft)");
                        break;

                        case 9:
                        System.out.println();
                        System.out.print("Please insert your value (min) :");
                        num3 = scanner.nextDouble();
                        result1 = num3/60;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(h)");
                        break;

                        case 10:
                        System.out.println();
                        System.out.print("Please insert your value (h) :");
                        num3 = scanner.nextDouble();
                        result1 = num3*60;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(min)");
                        break;

                        case 11:
                        System.out.println();
                        System.out.print("Please insert your value (h) :");
                        num3 = scanner.nextDouble();
                        result1 = num3/24;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(day)");
                        break;

                        case 12:
                        System.out.println();
                        System.out.print("Please insert your value (day) :");
                        num3 = scanner.nextDouble();
                        result1 = num3*24;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(h)");
                        break;

                        case 13:
                        System.out.println();
                        System.out.print("Please insert your value (oC) :");
                        num3 = scanner.nextDouble();
                        result1 = (num3*(9/5.0)+32);
                        System.out.println();
                        System.out.println("Your value: "+result1+"(oF)");
                        break;

                        case 14:
                        System.out.println();
                        System.out.print("Please insert your value (oF) :");
                        num3 = scanner.nextDouble();
                        result1 = (num3-32)*5/9;
                        System.out.println();
                        System.out.println("Your value: "+result1+"(oC)");
                        break;

                        default:
                        System.out.println("INVALID INDEX");
                    }
                System.out.println("----------------------");
                break;

                default:
                System.out.println("INVALID INDEX");
            }
}
}


