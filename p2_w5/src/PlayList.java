import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PlayList 
{
    List<Integer> list;

    public PlayList(List<Integer> list) 
    {
        this.list = list;
    }    

    public static PlayList generateRandomPlayList(int numberOfTracksInLibrary, int playListSize)
    {
        List<Integer> listIndexes = new ArrayList<>();
        for (int i = 0; i < numberOfTracksInLibrary; i++) 
        {
            listIndexes.add(i);
        }
        Collections.shuffle(listIndexes);
        return new PlayList(listIndexes.subList(0, playListSize));
    }

    @Override
    public String toString() 
    {
        String str = "";
        for (Integer integer : list) 
        {
            if (!str.equals(""))
                str += ", " ;
            str += integer ;
        }
        return "PlayList [" + str + "]";
    }
}