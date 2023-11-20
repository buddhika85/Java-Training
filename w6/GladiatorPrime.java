package w6;

import utilities.In;

public class GladiatorPrime {
    private final char YES = 'Y';
    private Customers customers = new Customers();
    private StreamedMovies movies = new StreamedMovies();

    public GladiatorPrime() {
        menu();
    }

    private void menu() {
        char action = readAction();
        switch (action) {
            case 'M':
                addMovie();
                break;
            case 'C':
                addCustomer();
                break;
            case 'R':
                rent();
                break;
            case 'S':
                report();
                break;
            case 'X':
                exit();
                break;
            case '?':
                help();
                break;
            default:
                error();
        }
    }

    private void report() {
        customers.show();
        System.out.println();
        movies.show();
        menu();
    }

    private void rent() {
        System.out.println("Rent movie");
        Customer customer = customers.find(In.readInt("Please enter Customer id "));
        if (customer == null) {
            System.out.println("Error - customer with such ID does not exist");
        } else {
            StreamedMovie movie = movies.find(In.readInt("Please enter Movie id "));
            if (movie == null) {
                System.out.println("Error - Movie with such ID does not exist");
            } else if (!movie.isAvailable()) {
                System.out.println("Error - Movie is unavailable for renting. Try when its returned.");
            } else {
                customer.rent(movie);
            }
        }
        menu();
    }

    private void addCustomer() {
        customers.add();
        menu();
    }

    private void addMovie() {
        movies.add();
        menu();
    }

    private char readAction() {
        System.out.println("Please enter your choice (M, C, R, S, X, ?): ");
        return In.nextUpperChar();
    }

    private void exit() {
        if (!confirm())
            menu();
        else
            System.out.println("Goodbye");
    }

    private boolean confirm() {
        System.out.println("Are you sure (y/n)?: ");
        return In.nextUpperChar() == YES;
    }

    private void help() {
        System.out.println("Welcome to my simple menu; enter");
        System.out.println("M for Add Movie");
        System.out.println("C for Add Customer");
        System.out.println("R for Rent");
        System.out.println("S for Report");
        System.out.println("? for Help");
        System.out.println("X to exit");
        menu();
    }

    private void error() {
        System.out.println("No action found. Try again");
        menu();
    }
}
