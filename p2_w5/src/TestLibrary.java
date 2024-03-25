import java.util.ArrayList;

class TestLibrary {
    public static void main(String[] args) {
        AudioTrack[] library = { new Song("Gangnam Style", 219, "Psy", MusicGenre.POP),
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
                        398) };

        MusicPlayer mp = new MusicPlayer(library, PlayMode.SHUFFLE);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add((Song) library[3]);
        songs.add((Song) library[5]);
        songs.add((Song) library[6]);
        mp.playSongs(songs);
    }
}