// Tutorial A
// --------------------------------------------------------------------------------------

// Warmup loops
class ForLoops {
    public static void main(String[] args) {
        // 1.
        for (int i = 45; i <= 59; i++) {
            System.out.println(i);
        }

        // 2.
        for (int i = 17; i >= 0; i--) {
            System.out.println(i);
        }

        // 3.
        for (int i = 45; i <= 59; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }

        // 4.
        for (int i = 17; i >= 0; i--) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}

class WhileLoops {
    public static void main(String[] args) {
        String hey = "";

        int i = 0;
        while (i < 5) {
            hey += "Hey! ";
            i++;
        }

        System.out.println(hey);

        // To make it print 20 times, just replace 5 above with 20
    }
}

// Arrays exercise
class Arrays {
    public static void main(String[] args) {
        double[] arr1 = { 10, 20, 30, 40, 50, 60 };
        double[] arr2 = { 45, -12, 37, 98 };
        double sum1 = 0;
        double sum2 = 0;

        for (double d : arr1) {
            sum1 += d;
        }

        for (double d : arr2) {
            sum2 += d;
        }

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);

        double average1 = sum1 / arr1.length;
        double average2 = sum2 / arr2.length;

        System.out.println("average1 = " + average1);
        System.out.println("average2 = " + average2);
    }
}

// Initialise arrays with 'new'
class InitArrays {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 9 - i;
            System.out.println(numbers[i]); // here to see what is being assigned
        }

        // For 10 to 1 instead:
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 10 - i;
            System.out.println(numbers[i]);
        }
    }
}

// Countdown
class Countdown {
    public static void main(String[] args) {
        System.out.println("Enter a positive integer");
        int n = In.nextInt();

        // n down to 1
        for (int i = n; i > 0; i--) {
            System.out.println(i);
        }

        // with even or odd:
        for (int i = n; i > 0; i--) {
            if (i % 2 == 0) {
                System.out.println(i + " is EVEN");
            } else {
                System.out.println(i + " is ODD");
            }
        }
    }
}

// Rainfall
class Rainfall {
    public static void main(String[] args) {
        double[] rainfall = {
                10, 15, 5, 7, 20, 12, 8, 5, 2, 10, 6, 10, 14, 9,
                4, 3, 5, 18, 10, 12, 7, 5, 9, 11, 6, 13, 15, 17, 8, 6
        };

        double totalRainfall = 0.0;
        double averageRainfall = 0.0;

        // Compute totalRainfall and averageRainfall
        for (double r : rainfall) {
            totalRainfall += r;
        }

        averageRainfall = totalRainfall / rainfall.length;

        System.out.println("total rainfall: " + totalRainfall);
        System.out.println("average rainfall: " + averageRainfall);
    }
}

// random number generator:
class Rng {
    public static void main(String[] args) {
        int seed = 34;
        int a = 12;
        int m = 100;
        int c = 27;

        int n = 1;

        // First random number is seed
        int xN = seed;
        System.out.println("Random number " + n + " = " + xN);

        
        // generate another 19 random numnbers
        while (n < 20) 
        {
            n++;        
            xN = (a * xN + c) % m;
            System.out.println("Random number " + n + " = " + xN);            
        }

    }
}

// Lab/Tutorial B
// --------------------------------------------------------------------------------------
class SumOddNumbers {
    public static void main(String[] args) {
        System.out.print("Enter a positive integer: ");
        int number = In.nextInt();
        if (number > 0) {
            int[] range = new int[number];
            for (int i = 0; i < number; i++) {
                range[i] = i + 1;
            }

            int sumOdd = 0;
            for (int n : range) {
                if (n % 2 == 1) {
                    sumOdd += n;
                }
            }

            System.out.println("Sum of odd numbers: " + sumOdd);
        } else {
            System.out.println("Number must be positive!");
        }
    }
}

class ReverseIt {
    public static void main(String[] args) {
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 20; i > 0; i -= 1) {
            System.out.println(i);
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }

        System.out.println("Sum of odd numbers: " + sumOdd);
        System.out.println("Sum of even numbers: " + sumEven);
    }
}

class Bools {
    public static void main(String[] args) {

        boolean[] bools = { true, false, true, true, true,
                true, true, true, true, false, true, true,
                true, true, true, false, true, true, true,
                true, false, false, true, true, true, true,
                true, true, false, false, false, false, true,
                true, false, true, false, true, true, false,
                true, false, true, true, true, true, false,
                false, false, true, false, true, false, false,
                true, false, true, false, true, false, false,
                false, false, false, false, false, true, false,
                true, true, true, true, false, true, false, false,
                false, false, false, false, false, true, true,
                false, false, false, true, false, true, false,
                true, false, false, true, false, false, false,
                true, true, true, false, false, true, false,
                true, true, false, false, true, true, true, false,
                false, true, true, true, true, true, false, false,
                false, false, false, true, true, true, true, true,
                false, false, false, true, false, true, true, false,
                true, true, false, false, true, false, true, true,
                false, true, true, true, true, false, false, false,
                true, false, false, true, true, false, false, false,
                true, false, false, false, false, false, true, true,
                false, false, false, true, true, false, false, true,
                false, true, true, true, false, false, false, false,
                true, false, false, true, false, false, true, true,
                true, false, false, true, true, true, true, false };

        int numTrue = 0;
        for (boolean b : bools) {
            if (b) {
                numTrue++;
            }
        }
        System.out.println("# true: " + numTrue + ", # false: " + (bools.length - numTrue));

        System.out.print("How many 'false' values do you want from 'bools'? ");
        int numberFalseValuesSought = In.nextInt();

        int count = 0;
        for (int i = 0; i < bools.length; i++) {
            if (!bools[i]) {
                count++;
            }
            if (count == numberFalseValuesSought) {
                System.out.println(
                        "The smallest sub-array with " + count + " 'false' values is from index 0 to index " + i);
                break;
            }
        }

    }
}