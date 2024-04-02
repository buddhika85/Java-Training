public class App 
{
    MusicPlayer musicPlayer;

    App() {
        AudioTrack[] library = Library.LIBRARY;
        this.musicPlayer = new MusicPlayer(library, PlayMode.LINEAR);
    }

    public static void main(String[] args) {
        App app = new App();
        app.runMainMenu();
    }

    void runMainMenu() {
        System.out.println("-----------------------------------");
        System.out.println("MUSIC PLAYER");
        System.out.println("-----------------------------------");

        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. List songs");
            System.out.println("  2. Your playlists");
            System.out.println("  3. Add song to Library");
            System.out.println("  4. Display play count statistics");
            System.out.println("  5. Sort tracks by duration and name ASC");
            System.out.println("  6. Exit");
            int choice = In.nextInt();
            if (choice == 1) 
            {
                listSongsMenu();
            } 
            else if (choice == 2) 
            {
                userPlayListsMenu();
            } 
            else if (choice == 3) 
            {
                addSongMenu();
            }
            else if (choice == 4) 
            {
                playCountStatsReportMenu();
            } 
            else if (choice == 5) 
            {
                sortDisplayMenu();
            } 
            else if (choice == 6) 
            {
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2, or 3");
            }
        }

    }

    private void playCountStatsReportMenu() 
    {
        System.out.println("PLAY COUNT STATS-------------------");
        musicPlayer.listMostPlayedTracks();
    }

    private void sortDisplayMenu() 
    {
        System.out.println("SORTED PLAYLIST-------------------");
        if (this.musicPlayer.getUserPlayLists().isEmpty()) {
            System.out.println("No playlists...");
            return;
        }

        int numPlaylists = this.musicPlayer.getUserPlayLists().size();
        for (int i = 0; i < numPlaylists; i++) {
            System.out.println("  " + (i + 1) + ". " + this.musicPlayer.getUserPlayLists().get(i).name);
        }
        System.out.print("Select a playlist (1 - " + numPlaylists + "): ");
        int choice = In.nextInt();
        if (choice >= 1 && choice <= numPlaylists) {
            PlayList p = this.musicPlayer.getPlayList(choice - 1);
            //this.musicPlayer.listenToPlayList(p);
            musicPlayer.sortPlayList(p);
        }
        
    }

    private void addSongMenu() 
    {
        System.out.println("ADD A SONG -----------------");
        String name = readString("Please enter song name?");
        String artist = readString("Please enter artist name?");
        int duration = readInt("Please enter duration in seconds?");
        MusicGenre genre = readGenre();
        Song song  = new Song(name, duration, artist, genre);
        musicPlayer.addSong(song);
        System.out.println("SUCCESS : song added - " + song);
    }

    void listSongsMenu() {
        System.out.println("LIST SONGS -----------------");
        System.out.println("Are you looking for a particular artist? (y/n)");
        if (In.nextChar() == 'y') {
            System.out.print("Give the name of the artist: ");
            String artist = In.nextLine();
            PlayList songs = this.musicPlayer.listSongs(artist);
            this.musicPlayer.displayPlayList(songs);
        } else {
            System.out.println("LISTING ALL SONGS...");
            PlayList songs = this.musicPlayer.listSongs();
            this.musicPlayer.displayPlayList(songs);
        }
    }

    void userPlayListsMenu() {
        System.out.println("YOUR PLAYLISTS -----------------");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Create a new playlist");
            System.out.println("  2. Listen to a playlist");
            System.out.println("  3. Back to main-menu");
            System.out.println();
            int choice = In.nextInt();
            if (choice == 1) {
                createPlayListMenu();
            } else if (choice == 2) {
                listenPlayListMenu();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Pick an option 1, 2, or 3");
            }
        }

    }

    void createPlayListMenu() {
        System.out.println();
        System.out.println("CREATE PLAYLIST -----------------");
        System.out.print("Name of your playlist: ");
        String name = In.nextLine();
        int playListID = this.musicPlayer.createNewPlayList(name);
        PlayList p = this.musicPlayer.getPlayList(playListID);
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("  1. Add a single song");
            System.out.println("  2. Add all songs by artist");
            System.out.println("  3. Save the playlist");
            System.out.println();
            int choice = In.nextInt();
            if (choice == 1) {
                System.out.print("Do you have an artist in mind? (y/n): ");
                if (In.nextChar() == 'y') {
                    System.out.print("Give the name of the artist: ");
                    String artist = In.nextLine();
                    PlayList songs = this.musicPlayer.listSongs(artist);
                    if (!songs.trackIndexes.isEmpty()) {
                        System.out.print("Select a song (1-" + songs.trackIndexes.size() + "): ");
                        this.musicPlayer.displayPlayList(songs);
                        int songChoice = In.nextInt();
                        if (songChoice >= 1 && songChoice <= songs.trackIndexes.size()) {
                            // Note that the 'trackIndexes' attribute in the PlayList field
                            // are integer values, which themselves represent INDEXES into the
                            // library. See the diagram of page 2 of pre-tutorial.
                            int trackIndex = songs.trackIndexes.get(songChoice);
                            System.out.println(
                                    "Adding " + this.musicPlayer.getTrack(trackIndex)
                                            + " to playlist");
                            p.addTrack(trackIndex);
                        }
                    } else {
                        System.out.println("No songs by " + artist);
                    }
                } else {
                    PlayList songs = this.musicPlayer.listSongs();
                    System.out.print("Select a song (1-" + songs.trackIndexes.size() + "): ");
                    this.musicPlayer.displayPlayList(songs);
                    int songChoice = In.nextInt();
                    if (songChoice >= 1 && songChoice <= songs.trackIndexes.size()) {
                        System.out.println("Adding " + this.musicPlayer.getTrack(songChoice) + " to playlist");
                        p.addTrack(songChoice);
                        break;
                    }
                }
            } else if (choice == 2) {
                while (true) {
                    System.out.print("Give the name of the artist: ");
                    String artist = In.nextLine();
                    PlayList songs = this.musicPlayer.listSongs(artist);
                    if (!songs.trackIndexes.isEmpty()) {
                        for (Integer trackIndex : songs.trackIndexes) {
                            p.trackIndexes.add(trackIndex);
                        }
                        System.out.println("Added " + songs.trackIndexes.size() + " tracks to playlist");
                        break;
                    } else {
                        System.out.println("No songs by " + artist);
                    }
                }
            } else if (choice == 3) {
                System.out.println("Added " + p.name + " playlist");
                break;
            } else {
                System.out.println("Pick an option 1, 2 or 3");
            }
        }
    }

    void listenPlayListMenu() {
        System.out.println();
        System.out.println("LISTEN TO PLAYLIST -----------------");
        if (this.musicPlayer.getUserPlayLists().isEmpty()) {
            System.out.println("No playlists...");
            return;
        }

        int numPlaylists = this.musicPlayer.getUserPlayLists().size();
        for (int i = 0; i < numPlaylists; i++) {
            System.out.println("  " + (i + 1) + ". " + this.musicPlayer.getUserPlayLists().get(i).name);
        }
        System.out.print("Select a playlist (1 - " + numPlaylists + "): ");
        int choice = In.nextInt();
        if (choice >= 1 && choice <= numPlaylists) {
            PlayList p = this.musicPlayer.getPlayList(choice - 1);
            this.musicPlayer.listenToPlayList(p);
        }

    }



    private MusicGenre readGenre()
    {
        MusicGenre musicGenre = null;
        while(musicGenre == null)
        {
            displayMusicGenres();
            int genreNumber = readInt("Please enter a genre number?");
            musicGenre =  findGenre(genreNumber);            
        }
        return musicGenre;
    }

    private MusicGenre findGenre(int genreNumber) 
    {
        MusicGenre[] allGenres = MusicGenre.values();
        if (genreNumber <= allGenres.length && genreNumber > 0)
        {
            return allGenres[genreNumber - 1];
        }

        return null;        // invalid input
    }

    private int readInt(String question) 
    {
        System.out.println("\t" + question);
        return In.nextInt();
    }

    private void displayMusicGenres() 
    {        
        MusicGenre[] allGenres = MusicGenre.values();
        System.out.println("All Music Genres- Select a number from 1 to " + allGenres.length);
        for (int i = 0; i < allGenres.length; i++) 
        {
            System.out.println((i + 1) + " - "  + allGenres[i]);
        }
    }

    private String readString(String question) 
    {
        System.out.println("\t" + question);
        return In.nextLine();
    }

}