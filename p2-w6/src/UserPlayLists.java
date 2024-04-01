import java.util.List;

interface UserPlayLists {
    int createNewPlayList(String playlistName);

    void removePlaylist(int playlistID);

    List<PlayList> getAllUserPlayLists();

    PlayList generateMusicPlayList(int size);

}