import java.util.ArrayList;
import java.util.Collections;

class MusicPlayer implements ListPodcasts, ListSongs, PlaySongs, ListenPlayList 
{
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
            Collections.shuffle(songs);
            for (Song s : songs) 
            {
                s.play();
            }
        }
    }

    @Override
    public void listenToPlayList(PlayList playList) 
    {
        System.out.println("Playing - " + playList);
        for (int index : playList.list) 
        {
            library[index].play();
        }
    }
}