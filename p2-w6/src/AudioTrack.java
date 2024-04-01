import java.util.Comparator;
import java.util.Random;

abstract class AudioTrack {
    int durationInSeconds;
    String name;
    // Counts the number of times track was played.
    int playCount;

    public static final Comparator<AudioTrack> PLAY_COUNT_COMPARATOR = Comparator.comparing(AudioTrack::getPlayCount).reversed();
    public static final Comparator<AudioTrack> NAME_ASC_COMPARATOR = Comparator.comparing(AudioTrack::getName);
    public static final Comparator<AudioTrack> NAME_DURATION_ASC_COMPARATOR = Comparator.comparing(AudioTrack::getDurationInSeconds);

    AudioTrack(String name, int durationInSeconds) {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
        this.playCount = 0;
    }

    // Play the track for some random duration. Returns ListeningDuration
    // corresponding to how long the track was listened to.
    ListeningDuration play() 
    {
        ++playCount;
        ListeningDuration listeningDuration = ListeningDuration.YET_TO_LISTEN;
        Random rand = new Random();
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

    public int getPlayCount() 
    {
        return playCount;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getName() {
        return name;
    }
}