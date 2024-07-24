import java.util.ArrayList;

public class App 
{
    MusicPlayer musicPlayer;

    App() 
    {
        AudioTrack[] library = Library.LIBRARY;
        this.musicPlayer = new MusicPlayer(library, PlayMode.LINEAR);

        // Test Data - custom play list for testing purposes
        PlayList customPlayList = new PlayList("Custom");
        customPlayList.addTrack(1);
        customPlayList.addTrack(3);
        customPlayList.addTrack(5);
        customPlayList.addTrack(7);
        this.musicPlayer.userPlayLists.add(customPlayList);
    }

    public static void main(String[] args) 
    {
        App app = new App();
        app.runMainMenu();
    }

    void runMainMenu() 
    {
        System.out.println("-----------------------------------");
        System.out.println("MUSIC PLAYER");
        System.out.println("-----------------------------------");

        while (true) 
        {
            System.out.println("Select an option:");
            System.out.println("  1. List songs");
            System.out.println("  2. Your playlists");
            System.out.println("  3. List songs by genre");
            System.out.println("  4. List songs by min duration");
            System.out.println("  5. Add song");
            System.out.println("  6. List Most Popular Tracks");
            System.out.println("  7. Exit");
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
                listSongsByGenre();
            } 
            else if (choice == 4) 
            {
                listSongsByMinDuration();
            } 
            else if (choice == 5) 
            {
                addSong();
            } 
            else if (choice == 6) 
            {
                displayPopularity();
            } 
            else if (choice == 7) 
            {
                System.out.println("Exiting -  bye...");
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2, or 3");
            }
        }

    }

    private void displayPopularity() 
    {
        System.out.println("MOST POPULAR SONGS-----------------");
        musicPlayer.listMostPlayedTracks();
    }

    private void addSong() 
    {
        System.out.println("ADD SONG-----------------");
        Song song = readSongInputs();
        if (musicPlayer.isSongExists(song))
        {
            System.out.println("Error - song already exists with music player library");
        }
        else
        {
            musicPlayer.addSong(song);
            System.out.println("Success - song added : " + song);
        }
    }

    private Song readSongInputs() 
    {
        //return new Song(readString("Name of Song? "), readInt("Duration in seconds? "), readString("Artist ? "), readGenre());

        String name = readString("Name of Song? ");
        int duration = readInt("Duration in seconds? ");
        String artist = readString("Artist ? ");
        MusicGenre genre = readGenre();
        return new Song(name, duration, artist, genre);
    }

    private void listSongsByMinDuration() 
    {
        System.out.println("LIST SONGS BY MIN DURATION-----------------");
        int minDuration = readInt("Min duration?");
        PlayList playList = musicPlayer.listSongs(minDuration);

        System.out.println("Songs with min duration " + minDuration);
        musicPlayer.displayPlayList(playList);
    }

    private int readInt(String question) 
    {
        System.out.println(question);
        return In.nextInt();
    }

    private String readString(String question) 
    {
        System.out.println(question);
        return In.nextLine();
    }

    private void listSongsByGenre() 
    {
        System.out.println("LIST SONGS BY GENRE-----------------");
        MusicGenre genre = readGenre();
        PlayList playList = musicPlayer.listSongs(genre);

        System.out.println("Songs on Genre " + genre);
        musicPlayer.displayPlayList(playList);
    }

    private MusicGenre readGenre() 
    {
        MusicGenre[] genres = MusicGenre.values();
        MusicGenre selectedGenre = null;
        while(selectedGenre == null)
        {
            System.out.println("Select a genre (1-" + genres.length + "): ");
            for (int i = 0; i < genres.length; i++) 
            {
                System.out.println("\t" + (i + 1) + " for " + genres[i]);    
            }

            int input = In.nextInt();
            if (input <= 0 || input > genres.length)
            {
                System.out.println("Error - invalid input");
            }
            else
            {
                selectedGenre = genres[input - 1]; // convert to index
            }
        }
        return selectedGenre;
    }

    void listSongsMenu() 
    {
        System.out.println("LIST SONGS -----------------");
        System.out.println("Are you looking for a particular artist? (y/n)");
        if (In.nextChar() == 'y') 
        {
            System.out.print("Give the name of the artist: ");
            String artist = In.nextLine();
            PlayList songs = this.musicPlayer.listSongs(artist);
            this.musicPlayer.displayPlayList(songs);
        } 
        else 
        {
            System.out.println("LISTING ALL SONGS...");
            PlayList songs = this.musicPlayer.listSongs();
            this.musicPlayer.displayPlayList(songs);
        }
    }

    void userPlayListsMenu() 
    {
        System.out.println("YOUR PLAYLISTS -----------------");
        while (true) 
        {
            System.out.println("Select an option:");
            System.out.println("  1. Create a new playlist");
            System.out.println("  2. Listen to a playlist");
            System.out.println("  3. View a playlist");
            System.out.println("  4. Sort and view a playlist");
            System.out.println("  5. Back to main-menu");
            System.out.println();
            int choice = In.nextInt();
            if (choice == 1) 
            {
                createPlayListMenu();
            } 
            else if (choice == 2) 
            {
                listenPlayListMenu();
            } 
            else if (choice == 3) 
            {
                viewPlayList();
            } 
            else if (choice == 4) 
            {
                sortAndViewPlayList();
            } 
            else if (choice == 5) 
            {
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2, 3, 4 or 5");
            }
        }

    }

    private void sortAndViewPlayList() 
    {
        System.out.println();
        System.out.println("SORT AND VIEW A PLAYLIST -----------------");
        if (this.musicPlayer.userPlayLists.isEmpty()) 
        {
            System.out.println("No playlists...");
            return;
        }

        int numPlaylists = this.musicPlayer.userPlayLists.size();
        for (int i = 0; i < numPlaylists; i++) 
        {
            System.out.println("  " + (i + 1) + ". " + this.musicPlayer.userPlayLists.get(i).name);
        }
        System.out.print("Select a playlist to sort (1 - " + numPlaylists + "): ");
        int choice = In.nextInt();
        if (choice >= 1 && choice <= numPlaylists) 
        {
            PlayList p = this.musicPlayer.getPlayList(choice - 1);
            PlayList copy = new PlayList(p.name, new ArrayList<>(p.trackIndexes));
            this.musicPlayer.sortPlayList(copy);
            this.musicPlayer.displayPlayList(copy);
        }
    }

    private void viewPlayList() 
    {
        System.out.println();
        System.out.println("VIEW A PLAYLIST -----------------");
        if (this.musicPlayer.userPlayLists.isEmpty()) 
        {
            System.out.println("No playlists...");
            return;
        }

        int numPlaylists = this.musicPlayer.userPlayLists.size();
        for (int i = 0; i < numPlaylists; i++) 
        {
            System.out.println("  " + (i + 1) + ". " + this.musicPlayer.userPlayLists.get(i).name);
        }
        System.out.print("Select a playlist (1 - " + numPlaylists + "): ");
        int choice = In.nextInt();
        if (choice >= 1 && choice <= numPlaylists) 
        {
            PlayList p = this.musicPlayer.getPlayList(choice - 1);
            this.musicPlayer.displayPlayList(p);
        }
    }

    void createPlayListMenu() 
    {
        System.out.println();
        System.out.println("CREATE PLAYLIST -----------------");
        System.out.print("Name of your playlist: ");
        String name = In.nextLine();

        // returns index of the newly created playlist object, within playlists ArrayList
        int playListID = this.musicPlayer.createNewPlayList(name);

        // get object by index from list
        PlayList p = this.musicPlayer.getPlayList(playListID);

        while (true) 
        {
            System.out.println("What would you like to do?");
            System.out.println("  1. Add a single song");
            System.out.println("  2. Add all songs by artist");
            System.out.println("  3. Save the playlist");
            System.out.println();
            int choice = In.nextInt();
            if (choice == 1) 
            {
                System.out.print("Do you have an artist in mind? (y/n): ");
                if (In.nextChar() == 'y') 
                {
                    System.out.print("Give the name of the artist: ");
                    String artist = In.nextLine();
                    PlayList songs = this.musicPlayer.listSongs(artist);
                    if (!songs.trackIndexes.isEmpty()) 
                    {
                        System.out.print("Select a song (1-" + songs.trackIndexes.size() + "): ");
                        this.musicPlayer.displayPlayList(songs);
                        int songChoice = In.nextInt();
                        if (songChoice >= 1 && songChoice <= songs.trackIndexes.size()) 
                        {
                            // Note that the 'trackIndexes' attribute in the PlayList field
                            // are integer values, which themselves represent INDEXES into the
                            // library. See the diagram of page 2 of pre-tutorial.
                            int trackIndex = songs.trackIndexes.get(songChoice);
                            System.out.println(
                                    "Adding " + this.musicPlayer.getTrack(trackIndex)
                                            + " to playlist");
                            p.addTrack(trackIndex);
                        }
                    } 
                    else 
                    {
                        System.out.println("No songs by " + artist);
                    }
                } 
                else 
                {
                    PlayList songs = this.musicPlayer.listSongs();
                    System.out.print("Select a song (1-" + songs.trackIndexes.size() + "): ");
                    this.musicPlayer.displayPlayList(songs);
                    int songChoice = In.nextInt();
                    if (songChoice >= 1 && songChoice <= songs.trackIndexes.size()) 
                    {
                        System.out.println("Adding " + this.musicPlayer.getTrack(songChoice) + " to playlist");
                        p.addTrack(songChoice);
                        break;
                    }
                }
            } 
            else if (choice == 2) 
            {
                while (true)
                {
                    System.out.print("Give the name of the artist: ");
                    String artist = In.nextLine();
                    PlayList songs = this.musicPlayer.listSongs(artist);
                    if (!songs.trackIndexes.isEmpty()) 
                    {
                        for (Integer trackIndex : songs.trackIndexes) 
                        {
                            p.trackIndexes.add(trackIndex);
                        }
                        System.out.println("Added " + songs.trackIndexes.size() + " tracks to playlist");
                        break;
                    } 
                    else 
                    {
                        System.out.println("No songs by " + artist);
                    }
                }
            } 
            else if (choice == 3) 
            {
                System.out.println("Added " + p.name + " playlist");
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2 or 3");
            }
        }
    }

    void listenPlayListMenu() 
    {
        System.out.println();
        System.out.println("LISTEN TO PLAYLIST -----------------");
        if (this.musicPlayer.userPlayLists.isEmpty()) 
        {
            System.out.println("No playlists...");
            return;
        }

        int numPlaylists = this.musicPlayer.userPlayLists.size();
        for (int i = 0; i < numPlaylists; i++) 
        {
            System.out.println("  " + (i + 1) + ". " + this.musicPlayer.userPlayLists.get(i).name);
        }
        System.out.print("Select a playlist (1 - " + numPlaylists + "): ");
        int choice = In.nextInt();
        if (choice >= 1 && choice <= numPlaylists) 
        {
            PlayList p = this.musicPlayer.getPlayList(choice - 1);
            this.musicPlayer.listenToPlayList(p);
        }

    }

}

class Library 
{
    static AudioTrack[] LIBRARY = 
    { 
        new Song("Gangnam Style", 219, "Psy", MusicGenre.POP),
            new Song("Enter Sandman", 331, "Metallica", MusicGenre.METAL),
            new Song("Sad But True", 324, "Metallica", MusicGenre.METAL),
            new Song("Holier Than Thou", 227, "Metallica", MusicGenre.METAL),
            new Song("The Unforgiven", 390, "Metallica", MusicGenre.METAL),
            new Song("Wherever I May Roam", 403, "Metallica", MusicGenre.METAL),
            new Song("Don't Tread on Me", 240, "Metallica", MusicGenre.METAL),
            new Song("Through the Never", 244, "Metallica", MusicGenre.METAL),
            new Song("Nothing Else Matters", 388, "Metallica", MusicGenre.METAL),
            new Song("Of Wolf and Man", 256, "Metallica", MusicGenre.METAL),
            new Song("My Friend of Misery", 409, "Metallica", MusicGenre.METAL),
            new Song("The Struggle Within", 231, "Metallica", MusicGenre.METAL),
            new Podcast("The Joe Rogan Experience: Robert Kennedy, Jr", 10800, "Joe Rogan", PodcastGenre.COMEDY,
                    1999),
            new Song("Aces High", 271, "Iron Maiden", MusicGenre.METAL),
            new Song("2 Minutes to Midnight", 360, "Iron Maiden", MusicGenre.METAL),
            new Song("Losfer Words (Big 'Orra)", 263, "Iron Maiden", MusicGenre.METAL),
            new Song("Flash of the Blade", 256, "Iron Maiden", MusicGenre.METAL),
            new Song("The Duellists", 376, "Iron Maiden", MusicGenre.METAL),
            new Song("Back in the Village", 305, "Iron Maiden", MusicGenre.METAL),
            new Song("Powerslave", 423, "Iron Maiden", MusicGenre.METAL),
            new Song("Rime of the Ancient Mariner", 816, "Iron Maiden", MusicGenre.METAL),
            new Podcast("The Joe Rogan Experience: Mike Tyson", 9000, "Joe Rogan", PodcastGenre.COMEDY,
                    1532),
            new Song("Moonshield", 301, "In Flames", MusicGenre.METAL),
            new Song("The Jester's Dance", 202, "In Flames", MusicGenre.METAL),
            new Song("Artifacts of the Black Rain", 198, "In Flames", MusicGenre.METAL),
            new Song("Graveland", 203, "In Flames", MusicGenre.METAL),
            new Song("Lord Hypnos", 244, "In Flames", MusicGenre.METAL),
            new Song("Dead Eternity", 307, "In Flames", MusicGenre.METAL),
            new Song("The Jester Race", 274, "In Flames", MusicGenre.METAL),
            new Song("December Flower", 252, "In Flames", MusicGenre.METAL),
            new Song("Wayfaerer", 260, "In Flames", MusicGenre.METAL),
            new Song("No Gods But Our Flesh", 289, "Inferi", MusicGenre.METAL),
            new Song("Maelstrom Prison", 324, "Inferi", MusicGenre.METAL),
            new Song("Simian Hive", 305, "Inferi", MusicGenre.METAL),
            new Song("From Exile to Exaltation", 282, "Inferi", MusicGenre.METAL),
            new Song("Vile Genesis", 344, "Inferi", MusicGenre.METAL),
            new Song("Mesmeric Horror", 314, "Inferi", MusicGenre.METAL),
            new Song("Eye of the Tiger", 245, "Survivor", MusicGenre.ROCK),
            new Song("Feels Like Love", 270, "Survivor", MusicGenre.ROCK),
            new Song("Hesitation Dance", 235, "Survivor", MusicGenre.ROCK),
            new Song("The One That Really Matters", 221, "Survivor", MusicGenre.ROCK),
            new Song("I'm Not That Man Anymore", 280, "Survivor", MusicGenre.ROCK),
            new Song("Children of the Night", 297, "Survivor", MusicGenre.ROCK),
            new Song("Ever Since the World Began", 234, "Survivor", MusicGenre.ROCK),
            new Song("American Heartbeat", 240, "Survivor", MusicGenre.ROCK),
            new Song("Silver Girl", 269, "Survivor", MusicGenre.ROCK),
            new Song("Beat It", 258, "Michael Jackson", MusicGenre.POP),
            new Song("Ode To Joy", 660, "Ludwig van Beethoven", MusicGenre.CLASSICAL),
            new Podcast("Lex Fridman Podcast: Mark Zuckerberg", 3840, "Lex Fridman", PodcastGenre.TECHNOLOGY,
                    398),
            new Podcast("Lex Fridman Podcast: Elon Musk on SpaceX", 7200, "Lex Fridman", PodcastGenre.TECHNOLOGY,
                    420),
            new Podcast("Lex Fridman Podcast: Jordan Peterson on Life", 5400, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 421),
            new Podcast("Lex Fridman Podcast: Joe Rogan on Podcasting", 4800, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 422),
            new Podcast("Lex Fridman Podcast: Tim Ferriss on Self-Optimization", 3600, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 423),
            new Podcast("Lex Fridman Podcast: Andrew Ng on Artificial Intelligence", 3900, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 424),
            new Podcast("Lex Fridman Podcast: Vitalik Buterin on Ethereum", 4300, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 425),
            new Podcast("Lex Fridman Podcast: Garry Kasparov on Chess and AI", 3100, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 426),
            new Podcast("Lex Fridman Podcast: Robert Sapolsky on Biology", 5000, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 427),
            new Podcast("Lex Fridman Podcast: Sam Harris on Consciousness", 3800, "Lex Fridman",
                    PodcastGenre.TECHNOLOGY, 428)
    };
}