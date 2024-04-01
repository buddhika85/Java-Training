
class Podcast extends AudioTrack {
    // Podcasts are created by 'hosts'
    String host;
    PodcastGenre genre;
    int episodeNumber;

    Podcast(String name, int durationInSeconds, String host, PodcastGenre genre, int episodeNumber) {
        super(name, durationInSeconds);
        this.host = host;
        this.genre = genre;
        this.episodeNumber = episodeNumber;
    }

    @Override
    ListeningDuration play() {
        String playString = "Starting podcast '" + this.toString();
        ListeningDuration playDuration = super.play();
        if (playDuration == ListeningDuration.UNDER_1_MINUTE) {
            playString += ". Listened for < 1 minute";
        } else if (playDuration == ListeningDuration.ONE_QUARTER) {
            playString += ". Listened to a quarter of the podcast";
        } else if (playDuration == ListeningDuration.HALF) {
            playString += ". Listened to half of the podcast";
        } else if (playDuration == ListeningDuration.THREE_QUARTERS) {
            playString += ". Listened to 3 quarters of the podcast";
        } else if (playDuration == ListeningDuration.WHOLE_DURATION) {
            playString += ". Listened to the entire podcast";
        }
        System.out.println(playString);
        return playDuration;
    }

    @Override
    public String toString() {
        return super.name + ", by " + this.host + ", episode #" + this.episodeNumber;
    }
}