import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

abstract class AudioTrack {
    int durationInSeconds;
    String name;
    // Counts the number of times track was played.
    int playCount;

    // comparators
    public static final Comparator<AudioTrack> COMP_PLAY_COUNT_DESC 
        = Comparator.comparing(AudioTrack :: getPlayCount).reversed();
    public static final Comparator<AudioTrack> COMP_NAME_DESC 
        = Comparator.comparing(AudioTrack :: getName);
    public static final Comparator<AudioTrack> COMP_DURATION_DESC 
        = Comparator.comparing(AudioTrack :: getDurationInSeconds);
    

    AudioTrack(String name, int durationInSeconds) {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
        this.playCount = 0;
    }

    // Play the track for some random duration. Returns ListeningDuration
    // corresponding to how long the track was listened to.
    ListeningDuration play() {
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

    
    public int getPlayCount() {
        return playCount;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getName() {
        return name;
    }
}

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
        return super.name + ", by " + this.artist + ", genre: " + genre + ", duration: " + durationInSeconds;
    }
}

enum MusicGenre {
    METAL,
    POP,
    ROCK,
    CLASSICAL,
}

enum PodcastGenre {
    TECHNOLOGY,
    COMEDY,
    NEWS,
    BUSINESS,
    HISTORY,
}

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

interface ListTracks {
    // Lists all podcasts in the library
    PlayList listPodcasts();

    // Lists all podcasts in the library with the given host
    PlayList listPodcasts(String host);

    // Lists all songs in the library
    PlayList listSongs();

    // Lists all songs in the library by the given artist
    PlayList listSongs(String artist);

    PlayList listSongs(MusicGenre genre);

    PlayList listSongs(int minimumDuration);
}

interface UserPlayLists 
{
    int createNewPlayList(String playlistName);

    void removePlaylist(int playlistID);

    List<PlayList> getAllUserPlayLists();

    PlayList generateMusicPlayList(int size);

}

interface UsePlayList 
{
    void listenToPlayList(PlayList playList);

    void displayPlayList(PlayList playList);

    PlayList getPlayList(int playListID);
}

// Add the following class (why is it necessary?)
// Playlist just stores a list of numbers (indexes in the library), and these numbers cannot be used to sort actual audio tracks
// So, we need to have a connection between index of the track and actual track it self for sorting the playlist
// This class establishes that connection
class IndexedTrack {
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

class MusicPlayer implements ListTracks, UserPlayLists, UsePlayList 
{
    List<AudioTrack> library;
    PlayMode currentPlayMode;
    List<PlayList> userPlayLists;

    MusicPlayer(AudioTrack[] library, PlayMode playmode) 
    {
        this.library = new ArrayList<>(Arrays.asList(library));
        this.currentPlayMode = playmode;
        this.userPlayLists = new ArrayList<>();
    }

    // Hard
    // This sorts a copy of play list
    void sortPlayList(PlayList p) 
    {        
        // 1. Use p.trackIndexes to create an `ArrayList<IndexedTracks> indexedTracks`
        ArrayList<IndexedTrack> indexedTracks = new ArrayList<>();
        for (int trackIndex : p.trackIndexes) 
        {
            indexedTracks.add(new IndexedTrack(getTrack(trackIndex), trackIndex));
        }

        // 2. Use a comparator within `indexedTracks` to sort this ArrayList
        Collections.sort(indexedTracks, IndexedTrack.byName);

        // 3. Call `p.trackIndexes.clear();` to clear out the playlist entries, then
        p.trackIndexes.clear();             // now play list is empty, this is done because we need re-store the tracks based on sorted order

        //    use `indexedTracks` to repopulate the indexes.
        for (IndexedTrack indexedTrack : indexedTracks) 
        {
            p.trackIndexes.add(indexedTrack.index);
        }
    }

    @Override
    public PlayList listPodcasts() 
    {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) 
        {
            if (this.library.get(i) instanceof Podcast) 
            {
                libraryIndexes.add(i);
            }
        }
        return new PlayList("All podcasts", libraryIndexes);
    }

    @Override
    public PlayList listPodcasts(String host) 
    {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) 
        {
            AudioTrack t = this.library.get(i);
            if (t instanceof Podcast) 
            {
                Podcast p = (Podcast) t;
                if (p.host.equals(host)) 
                {
                    libraryIndexes.add(i);
                }
            }
        }
        return new PlayList("All podcasts by " + host, libraryIndexes);
    }

    @Override
    public PlayList listSongs() 
    {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) 
        {
            if (this.library.get(i) instanceof Song) 
            {
                libraryIndexes.add(i);
            }
        }
        return new PlayList("All songs", libraryIndexes);
    }

    @Override
    public PlayList listSongs(String artist) 
    {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) 
        {
            AudioTrack t = this.library.get(i);
            if (this.library.get(i) instanceof Song) 
            {
                Song s = (Song) t;
                if (s.artist.equals(artist)) 
                {
                    libraryIndexes.add(i);
                }
            }
        }
        return new PlayList("All songs by " + artist, libraryIndexes);
    }

    @Override
    public int createNewPlayList(String playlistName) 
    {
        this.userPlayLists.add(new PlayList(playlistName, new ArrayList<>()));
        // return the length of the playlists list - 1, which is the ID (index with in list) of the new playlist
        return this.userPlayLists.size() - 1;           
    }

    @Override
    public void removePlaylist(int playlistID) 
    {
        if (playlistID < 0 || playlistID >= this.userPlayLists.size()) {
            System.out.println("Invalid playlist ID");
            return; // This returns early this from method
        }

        this.userPlayLists.remove(playlistID);
    }

    @Override
    public List<PlayList> getAllUserPlayLists() 
    {
        return new ArrayList<>(this.userPlayLists);
    }

    @Override
    public PlayList generateMusicPlayList(int numberOfTracks) 
    {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < this.library.size(); i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return new PlayList("ramdom", list.subList(0, numberOfTracks));
    }

    @Override
    public void listenToPlayList(PlayList playList) 
    {
        ArrayList<Integer> listCopy = new ArrayList<>(playList.trackIndexes);
        if (this.currentPlayMode == PlayMode.LINEAR) 
        {
            for (Integer i : listCopy) 
            {
                this.library.get(i).play();
            }
        } 
        else if (this.currentPlayMode == PlayMode.REPEAT) 
        {
            while (true) {
                for (Integer i : listCopy) 
                {
                    this.library.get(i).play();
                }
                System.out.println("Would you like to continue (y/n)?");
                if (In.nextChar() == 'y') 
                {
                    break;
                }
            }
        } 
        else 
        {
            Collections.shuffle(listCopy);
            for (Integer i : listCopy) 
            {
                this.library.get(i).play();
            }
        }

    }

    @Override
    public void displayPlayList(PlayList playList) 
    {
        for (int i = 0; i < playList.trackIndexes.size(); i++) 
        {
            System.out.println("  " + i + ". " + this.library.get(playList.trackIndexes.get(i)));
        }
    }

    @Override
    public PlayList getPlayList(int playListID) 
    {
        return this.userPlayLists.get(playListID);
    }

    public AudioTrack getTrack(int trackIndex) 
    {
        return this.library.get(trackIndex);
    }

    @Override
    public PlayList listSongs(MusicGenre genre) 
    {
        PlayList playList = new PlayList("Play list of genre " + genre);
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i) instanceof Song && ((Song) library.get(i)).genre == genre)
            {
                playList.addTrack(i);
            }
        }
        return playList;
    }

    @Override
    public PlayList listSongs(int minimumDuration) 
    {
        PlayList playList = new PlayList("Play list of minimum duration " + minimumDuration);
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i) instanceof Song && ((Song) library.get(i)).durationInSeconds >= minimumDuration)
            {
                playList.addTrack(i);
            }
        }
        return playList;
    }

    public boolean isSongExists(Song song) 
    {
        for (AudioTrack audioTrack : library) 
        {
            if (audioTrack instanceof Song)
            {
                Song currentSong = (Song) audioTrack;
                if (currentSong.name.equalsIgnoreCase(song.name) && currentSong.artist.equalsIgnoreCase(song.artist))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void addSong(Song song) 
    {
        library.add(song);
    }

    void listMostPlayedTracks() {
        // Make a copy of the library attribute
        ArrayList<AudioTrack> libraryCopy = new ArrayList<>(this.library);

        // Sort libraryCopy and report (print) the most frequently played songs.
        Collections.sort(libraryCopy, AudioTrack.COMP_PLAY_COUNT_DESC);

        for (int i = 0; i < libraryCopy.size(); i++) 
        {
            AudioTrack track = libraryCopy.get(i);
            if (track.playCount == 0)
            {
                System.out.println("\t\t\t" + track + " was never played !!");
            }
            else
            {
                System.out.println("\tRANK " + (i + 1) + " -- " + track + " played " + track.playCount + " times");
            }
        }
    }
}

enum PlayMode {
    // Plays tracks in order, first to last.
    LINEAR,
    // Plays tracks in order, repeating back to first after last track.
    REPEAT,
    // Plays tracks in random order.
    SHUFFLE,
}

enum ListeningDuration {
    YET_TO_LISTEN,
    // Listened for less than 1 minute
    UNDER_1_MINUTE,
    // Listened for more than a minute but up to a quarter of the track's duration
    ONE_QUARTER,
    // Listened for more than a quarter but up to half of the track's duration
    HALF,
    // Listened for more than a half but up to 3 quarters of the track's duration
    THREE_QUARTERS,
    // Listened for the whole duration of the track
    WHOLE_DURATION
}