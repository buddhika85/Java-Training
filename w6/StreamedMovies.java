package w6;

import utilities.In;

public class StreamedMovies extends Records {
    @Override
    public StreamedMovie find(int id)
    {
        return (StreamedMovie)super.find(id);
    }
    
    public void add()
    {
        System.out.println("Add a video");
        StreamedMovie movie = new StreamedMovie(++id, In.readName("Movie"), 
            In.readDouble("Please enter Movie price : "), 
            In.readInt("Please enter movie rental period: "));
        super.add(movie);
        System.out.println("\t\t" + movie + " added");
    }

    @Override
    public String toString(){
        return "Streamed movies\n" + super.toString();
    }
}
