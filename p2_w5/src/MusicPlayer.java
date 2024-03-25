import java.util.ArrayList;
import java.util.Random;

class MusicPlayer implements ListPodcasts, ListSongs, PlaySongs {
    AudioTrack[] library;
    PlayMode currentPlayMode;

    MusicPlayer(AudioTrack[] library, PlayMode playmode) {
        this.library = library;
        this.currentPlayMode = playmode;
    }

    @Override
    public ArrayList<Podcast> listPodcasts() {
        ArrayList<Podcast> podcasts = new ArrayList<>();
        for (AudioTrack t : this.library) {
            if (t instanceof Podcast) {
                podcasts.add((Podcast) t);
            }
        }
        return podcasts;
    }

    @Override
    public ArrayList<Song> listSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        for (AudioTrack t : this.library) {
            if (t instanceof Song) {
                songs.add((Song) t);
            }
        }
        return songs;
    }

    @Override
    public ArrayList<Song> listSongs(String artist) {
        ArrayList<Song> songs = new ArrayList<>();
        for (AudioTrack t : this.library) {
            if (t instanceof Song) {
                // Need to access 'artist' attribute, so a type-cast is needed
                Song song = (Song) t;
                if (song.artist.equals(artist)) {
                    songs.add((Song) t);
                }
            }
        }
        return songs;
    }

    @Override
    public void playSongs(ArrayList<Song> songs) {
        if (this.currentPlayMode == PlayMode.LINEAR) {
            for (Song s : songs) {
                s.play();
            }
        } else if (this.currentPlayMode == PlayMode.REPEAT) {
            while (true) {
                for (Song s : songs) {
                    s.play();
                }
                System.out.println("Would you like to continue (y/n)?");
                if (In.nextChar() == 'n') {
                    break;
                }
            }
        } else {
            // Randomised playback. There are a couple of ways to do this.
            // We'll randomly pick a song out of the ArrayList, then remove it.
            while (!songs.isEmpty()) {
                Random rand = new Random();
                int choice = rand.nextInt(songs.size());
                songs.get(choice).play();
                songs.remove(choice);
            }
        }
    }

}