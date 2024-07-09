import java.util.ArrayList;
import java.util.Random;

abstract class AudioTrack 
{
    int durationInSeconds;
    String name;
    ListeningDuration listeningDuration;
    Random rand;

    AudioTrack(String name, int durationInSeconds) 
    {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
        this.listeningDuration = ListeningDuration.YET_TO_LISTEN;
        this.rand = new Random();
    }

    // Play the track for some random duration. Returns ListeningDuration
    // corresponding to how long the track was listened to.
    ListeningDuration play() {
        if (this.listeningDuration == ListeningDuration.YET_TO_LISTEN) 
        {
            System.out.println("Haven't starting playing " + this.name);
        }

        if (this.listeningDuration == ListeningDuration.WHOLE_DURATION) {
            System.out.println(this.name + " is already over");
        }
        int choice = rand.nextInt(5);
        if (choice == 0) {
            this.listeningDuration = ListeningDuration.UNDER_1_MINUTE;
        } else if (choice == 1) {
            this.listeningDuration = ListeningDuration.ONE_QUARTER;
        } else if (choice == 2) {
            this.listeningDuration = ListeningDuration.HALF;
        } else if (choice == 3) {
            this.listeningDuration = ListeningDuration.THREE_QUARTERS;
        } else if (choice == 4) {
            this.listeningDuration = ListeningDuration.WHOLE_DURATION;
        } else {
            System.out.println("Unreachable code");
        }
        return this.listeningDuration;
    }

    @Override
    public String toString() 
    {
        return "duration In Seconds = " + durationInSeconds + ", name = " + name 
            + ", listening Duration = " + listeningDuration;
    }
}

class Podcast extends AudioTrack 
{
    // Podcasts are created by 'hosts'
    String host;
    PodcastGenre genre;
    int episodeNumber;

    Podcast(String name, int durationInSeconds, String host, PodcastGenre genre, int episodeNumber) 
    {
        super(name, durationInSeconds);
        this.host = host;
        this.genre = genre;
        this.episodeNumber = episodeNumber;
    }

    @Override
    ListeningDuration play() 
    {
        System.out.println("Starting podcast '" + this.host + "', episide #" + this.episodeNumber);
        return super.play();
    }

    @Override
    public String toString() 
    {
        return "Podcast host=" + host + ", genre=" + genre + ", episodeNumber=" + episodeNumber + " " + super.toString();
    }    
}

class Song extends AudioTrack 
{
    String artist;
    MusicGenre genre;

    Song(String name, int durationInSeconds, String artist, MusicGenre genre) 
    {
        // Write code
        super(name, durationInSeconds);
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    ListeningDuration play() 
    {
        // Write code
        System.out.println("Starting song '" + this.artist + ", with genre : " + this.genre);
        return super.play();
    }

    @Override
    public String toString() {
        return "Song artist = " + artist + ", genre = " + genre + " " + super.toString();
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
    ArrayList<Integer> tracks;
}

interface ListPodcasts {
    ArrayList<Podcast> listPodcasts();
}

interface ListSongs {
    // List all songs
    ArrayList<Song> listSongs();

    // List songs by artist
    ArrayList<Song> listSongs(String artist);
}

interface PlaySongs { 
    void playSongs(ArrayList<Song> songs);
}

class MusicPlayer implements ListPodcasts, ListSongs, PlaySongs
{     
    AudioTrack[] library;
    PlayMode currentPlayMode;
    Random random = new Random();       // for shuffling songs

    public MusicPlayer(AudioTrack[] library, PlayMode currentPlayMode) {
        this.library = library;
        this.currentPlayMode = currentPlayMode;
    }

    @Override
    public ArrayList<Song> listSongs() 
    {
        ArrayList<Song> songs = new ArrayList<>();
        for (AudioTrack audioTrack : library) 
        {
            if (audioTrack instanceof Song)
            {
                songs.add(((Song)audioTrack));
            }
        }
        return songs;
    }

    @Override
    public ArrayList<Song> listSongs(String artist) 
    {
        ArrayList<Song> songsByArtist = new ArrayList<>();
        for (AudioTrack audioTrack : library) 
        {
            if (audioTrack instanceof Song)
            {
                Song song = (Song)audioTrack;
                if (song.artist.equals(artist))
                {
                    songsByArtist.add(song);
                }
            }
        }
        return songsByArtist;
    }

    @Override
    public ArrayList<Podcast> listPodcasts() 
    {
        ArrayList<Podcast> podcasts = new ArrayList<>();
        for (AudioTrack audioTrack : library) 
        {
            if (audioTrack instanceof Podcast)
            {
                podcasts.add(((Podcast)audioTrack));
            }
        }
        return podcasts;
    }

    @Override
    public void playSongs(ArrayList<Song> songs) 
    {
        if (currentPlayMode == PlayMode.LINEAR)
        {
            playSongsLinear(songs);
            return;
        }
        
        if (currentPlayMode == PlayMode.REPEAT)
        {
            boolean isRepeat = true;
            while(isRepeat)
            {
                playSongsLinear(songs);
                isRepeat = promptForNextRepeat();
            }
            return;
        }

        // shuffle
        // rand.nextInt(10); -- Randomly picks an integer from 0 to 9.
        while(!songs.isEmpty())
        {
            int randomIndex = random.nextInt(songs.size());            
            songs.get(randomIndex).play();
            songs.remove(randomIndex);
        }
    }

    private boolean promptForNextRepeat() {
        System.out.println("Do you want to repeat another round: [y] Yes, [n] No");
        return In.nextChar() == 'y';
    }

    private void playSongsLinear(ArrayList<Song> songs) {
        for (Song song : songs) {
            song.play();
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

class TestLibrary 
{
    public static void main(String[] args) 
    {
        AudioTrack[] library = { 
            new Song("Gangnam Style", 219, "Psy", MusicGenre.POP),
                new Song("Enter Sandman", 331, "Metallica", MusicGenre.METAL),
                new Podcast("The Joe Rogan Experience: Robert Kennedy, Jr", 10800, "Joe Rogan", PodcastGenre.COMEDY,
                        1999),
                new Song("Aces High", 271, "Iron Maiden", MusicGenre.METAL),
                new Podcast("The Joe Rogan Experience: Mike Tyson", 9000, "Joe Rogan", PodcastGenre.COMEDY,
                        1532),
                new Song("Moonshield", 301, "In Flames", MusicGenre.METAL),
                new Song("Mesmeric Horror", 314, "Inferi ", MusicGenre.METAL),
                new Song("Eye of the Tiger", 245, "Survivor", MusicGenre.ROCK),
                new Song("Beat It", 258, "Michael Jackson", MusicGenre.POP),
                new Song("Ode To Joy", 660, "Ludwig van Beethoven", MusicGenre.CLASSICAL),
                new Podcast("Lex Fridman Podcast: Mark Zuckerberg", 3840, "Lex Fridman", PodcastGenre.TECHNOLOGY,
                        398) ,
                
                // more songs added for testing purposes
                new Song("Heal the world", 300, "Michael Jackson", MusicGenre.POP),
                new Song("Billie Jean", 400, "Michael Jackson", MusicGenre.POP)
        };

        MusicPlayer musicPlayer = new MusicPlayer(library, PlayMode.LINEAR);
        
        // display all songs
        System.out.println("\n-------- All songs");
        ArrayList<Song> allSongs = musicPlayer.listSongs();
        for (Song song : allSongs) 
        {
            System.out.println(song);
        }

        // display all songs by artist
        System.out.println("\n-------- All songs of artist Michael Jackson");
        ArrayList<Song> allSongsByArtist = musicPlayer.listSongs("Michael Jackson");
        for (Song song : allSongsByArtist) 
        {
            System.out.println(song);
        }

        // display all podcasts
        System.out.println("\n-------- All podcasts");
        ArrayList<Podcast> podcasts = musicPlayer.listPodcasts();
        for (Podcast podcast : podcasts) 
        {
            System.out.println(podcast);
        }


        // test songs playing
        System.out.println("\n-------- LINEAR");
        musicPlayer.playSongs(allSongsByArtist);

        System.out.println("\n-------- REPEAT");
        musicPlayer.currentPlayMode = PlayMode.REPEAT;
        musicPlayer.playSongs(allSongsByArtist);

        System.out.println("\n-------- SHUFFLE");
        musicPlayer.currentPlayMode = PlayMode.SHUFFLE;
        musicPlayer.playSongs(allSongsByArtist);
    }
}