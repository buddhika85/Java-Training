import java.util.ArrayList;
import java.util.List;

class PlayList {
    List<Integer> trackIndexes;
    String name;

    PlayList(String name) {
        this.name = name;
        this.trackIndexes = new ArrayList<>();
    }

    PlayList(String name, List<Integer> list) {
        this.name = name;
        this.trackIndexes = list;
    }

    void addTrack(int trackIndex) {
        this.trackIndexes.add(trackIndex);
    }

    void removeTrack(int trackIndex) {
        this.trackIndexes.remove(trackIndex);
    }
}