import java.util.List;

interface ListSongs {
    // List all songs
    List<Song> listSongs();

    // List songs by artist
    List<Song> listSongs(String artist);
}