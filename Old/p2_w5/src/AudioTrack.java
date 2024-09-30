import java.util.Random;


abstract class AudioTrack {
    int durationInSeconds;
    String name;
    Random rand;

    AudioTrack(String name, int durationInSeconds) {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
        this.rand = new Random();
    }

    // Play the track for some random duration. Returns ListeningDuration
    // corresponding to how long the track was listened to.
    ListeningDuration play() {
        ListeningDuration listeningDuration = ListeningDuration.YET_TO_LISTEN;
        int choice = rand.nextInt(5);
        if (choice == 0) {
            listeningDuration = ListeningDuration.UNDER_1_MINUTE;
        } else if (choice == 1) {
            listeningDuration = ListeningDuration.ONE_QUARTER;
        } else if (choice == 2) {
            listeningDuration = ListeningDuration.HALF;
        } else if (choice == 3) {
            listeningDuration = ListeningDuration.THREE_QUARTERS;
        } else if (choice == 4) {
            listeningDuration = ListeningDuration.WHOLE_DURATION;
        } else {
            System.out.println("Unreachable code");
        }
        return listeningDuration;
    }

}