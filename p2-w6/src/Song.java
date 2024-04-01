
class Song extends AudioTrack {
    String artist;
    MusicGenre genre;

    Song(String name, int durationInSeconds, String artist, MusicGenre genre) {
        super(name, durationInSeconds);
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    ListeningDuration play() {
        String playString = "Starting song '" + this.toString();
        ListeningDuration playDuration = super.play();
        if (playDuration == ListeningDuration.UNDER_1_MINUTE) {
            playString += ". Listened for < 1 minute";
        } else if (playDuration == ListeningDuration.ONE_QUARTER) {
            playString += ". Listened to a quarter of the song";
        } else if (playDuration == ListeningDuration.HALF) {
            playString += ". Listened to half of the song";
        } else if (playDuration == ListeningDuration.THREE_QUARTERS) {
            playString += ". Listened to 3 quarters of the song";
        } else if (playDuration == ListeningDuration.WHOLE_DURATION) {
            playString += ". Listened to the entire song";
        }
        System.out.println(playString);
        return playDuration;

    }

    @Override
    public String toString() {
        return super.name + ", by " + this.artist;
    }
}