import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

class MusicPlayer implements ListTracks, UserPlayLists, UsePlayList, ManageSongs {
    List<AudioTrack> library;
    PlayMode currentPlayMode;
    private List<PlayList> userPlayLists;

    public List<PlayList> getUserPlayLists() {
        return userPlayLists;
    }

    MusicPlayer(AudioTrack[] library, PlayMode playmode) {
        this.library = new ArrayList<>(Arrays.asList(library));;
        this.currentPlayMode = playmode;
        this.userPlayLists = new ArrayList<>();
    }

    @Override
    public PlayList listPodcasts() {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) {
            if (this.library.get(i) instanceof Podcast) {
                libraryIndexes.add(i);
            }
        }
        return new PlayList("All podcasts", libraryIndexes);
    }

    @Override
    public PlayList listPodcasts(String host) {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) {
            AudioTrack t = this.library.get(i);
            if (t instanceof Podcast) {
                Podcast p = (Podcast) t;
                if (p.host.equals(host)) {
                    libraryIndexes.add(i);
                }
            }
        }
        return new PlayList("All podcasts by " + host, libraryIndexes);
    }

    @Override
    public PlayList listSongs() {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) {
            if (this.library.get(i) instanceof Song) {
                libraryIndexes.add(i);
            }
        }
        return new PlayList("All songs", libraryIndexes);
    }

    @Override
    public PlayList listSongs(String artist) {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) {
            AudioTrack t = this.library.get(i);
            if (this.library.get(i) instanceof Song) {
                Song s = (Song) t;
                if (s.artist.equals(artist)) {
                    libraryIndexes.add(i);
                }
            }
        }
        return new PlayList("All songs by " + artist, libraryIndexes);
    }

    @Override
    public int createNewPlayList(String playlistName) {
        this.userPlayLists.add(new PlayList(playlistName, new ArrayList<>()));
        return this.userPlayLists.size() - 1;
    }

    @Override
    public void removePlaylist(int playlistID) {
        if (playlistID < 0 || playlistID >= this.userPlayLists.size()) {
            System.out.println("Invalid playlist ID");
            return; // This returns early this from method
        }

        this.userPlayLists.remove(playlistID);
    }

    @Override
    public List<PlayList> getAllUserPlayLists() {
        return new ArrayList<>(this.userPlayLists);
    }

    @Override
    public PlayList generateMusicPlayList(int numberOfTracks) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < this.library.size(); i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return new PlayList("ramdom", list.subList(0, numberOfTracks));
    }

    @Override
    public void listenToPlayList(PlayList playList) {
        ArrayList<Integer> listCopy = new ArrayList<>(playList.trackIndexes);
        if (this.currentPlayMode == PlayMode.LINEAR) {
            for (Integer i : listCopy) {
                this.library.get(i).play();
            }
        } else if (this.currentPlayMode == PlayMode.REPEAT) {
            while (true) {
                for (Integer i : listCopy) {
                    this.library.get(i).play();
                }
                System.out.println("Would you like to continue (y/n)?");
                if (In.nextChar() == 'y') {
                    break;
                }
            }
        } else {
            Collections.shuffle(listCopy);
            for (Integer i : listCopy) {
                this.library.get(i).play();
            }
        }

    }

    @Override
    public void displayPlayList(PlayList playList) {
        for (int i = 0; i < playList.trackIndexes.size(); i++) {
            System.out.println("  " + i + ". " + this.library.get(playList.trackIndexes.get(i)));
        }
    }

    @Override
    public PlayList getPlayList(int playListID) {
        return this.userPlayLists.get(playListID);
    }

    public AudioTrack getTrack(int trackIndex) {
        return this.library.get(trackIndex);
    }

    @Override
    public PlayList listSongs(MusicGenre genre) 
    {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) {
            AudioTrack t = this.library.get(i);
            if (t instanceof Song) {
                Song s = (Song) t;
                if (s.genre.equals(genre)) {
                    libraryIndexes.add(i);
                }
            }
        }
        return new PlayList("All songs by " + genre, libraryIndexes);
    }

    @Override
    public PlayList listSongs(int minimumDuration) 
    {
        ArrayList<Integer> libraryIndexes = new ArrayList<>();

        // Need indexes so will have to use a traditional for-loop
        for (int i = 0; i < this.library.size(); i++) {
            AudioTrack t = this.library.get(i);
            if (t instanceof Song) {
                Song s = (Song) t;
                if (s.durationInSeconds >= minimumDuration) {
                    libraryIndexes.add(i);
                }
            }
        }
        return new PlayList("All songs by with min duration " + minimumDuration, libraryIndexes);
    }

    @Override
    public void addSong(Song song) 
    {
        library.add(song);       
    }    


    void listMostPlayedTracks() 
    {
        // Make a copy of the library attribute
        ArrayList<AudioTrack> libraryCopy = new ArrayList<>(this.library);

        // Sort libraryCopy and report (print) the most frequently played songs.
        System.out.println("\nSong list - Ranked - Most Popular first");
        Collections.sort(libraryCopy, AudioTrack.PLAY_COUNT_COMPARATOR);
        // How can you filter out songs that were never played?
        ArrayList<AudioTrack> songsWithZeroPlayCount = new ArrayList<>();
        for (int i = 0; i < libraryCopy.size(); i++) 
        {
            AudioTrack track = libraryCopy.get(i);
            System.out.println("Rank " + (i + 1) + " - " + track + " , play count - " + track.playCount);

            if (track.getPlayCount() == 0)
                songsWithZeroPlayCount.add(track);
        }

        System.out.println("\nSong list - Never played");
        for (AudioTrack audioTrack : songsWithZeroPlayCount) 
        {
            System.out.println(audioTrack);
        }
    }


    void sortPlayList(PlayList p) {
         
        // 1. Use p.trackIndexes to create an `ArrayList<IndexedTracks> indexedTracks`
        ArrayList<IndexedTrack> indexedTracks = populateIndexedTracks(p);

        // 2. Use a comparator within `indexedTracks` to sort this ArrayList
        Collections.sort(indexedTracks, IndexedTrack.byDuration);
        System.out.println("\nSorted Track duration lowest to hightest");
        for (IndexedTrack indexedTrack : indexedTracks) 
        {
            System.out.println("\t" + indexedTrack.track.name + " - " + indexedTrack.track.durationInSeconds);
        }

        // 3. Call `p.trackIndexes.clear();` to clear out the playlist entries, then
        indexedTracks.clear();

        //    use `indexedTracks` to repopulate the indexes.
        indexedTracks = populateIndexedTracks(p);

        Collections.sort(indexedTracks, IndexedTrack.byName);
        System.out.println("\nSorted Track name ASC");
        for (IndexedTrack indexedTrack : indexedTracks) 
        {
            System.out.println("\t" + indexedTrack.track.name);
        }
    }

    private ArrayList<IndexedTrack> populateIndexedTracks(PlayList p) 
    {
        ArrayList<IndexedTrack> indexedTracks = new ArrayList<>();
        for (int indexedTrack : p.trackIndexes) 
        {
            indexedTracks.add(new IndexedTrack(library.get(indexedTrack), indexedTrack));
        }
        return indexedTracks;
    }
}