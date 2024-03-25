import java.util.ArrayList;

interface ListSongs {
    // List all songs
    ArrayList<Song> listSongs();

    // List songs by artist
    ArrayList<Song> listSongs(String artist);
}