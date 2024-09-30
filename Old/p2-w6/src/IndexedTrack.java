import java.util.Comparator;

public class IndexedTrack {
    AudioTrack track;
    int index;

    IndexedTrack(AudioTrack song, int index) {
        this.track = song;
        this.index = index;
    }

    int getDuration() {
        return this.track.getDurationInSeconds();
    }

    String getName() {
        return this.track.getName();
    }

    static final Comparator<IndexedTrack> byDuration = Comparator.comparing(IndexedTrack::getDuration);
    static final Comparator<IndexedTrack> byName = Comparator.comparing(IndexedTrack::getName);

}
