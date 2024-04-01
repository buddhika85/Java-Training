
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