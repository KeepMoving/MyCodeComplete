package jukeBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JukeBox5 
{
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static void main(String[] args) 
	{
		new JukeBox5().go();
	}
	
	class ArtistCompare implements Comparator<Song>
	{
		public int compare(Song one, Song two) 
		{
			return one.getArtist().compareTo(two.getArtist());
		}
	}
	
	public void go()
	{
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList,artistCompare);
		
		System.out.println(songList);
	}
	
	void getSongs()
	{
		try {
			File file = new File("D:\\我的项目\\MyCodeComplete\\com.corejava.example\\jukeBox\\SongList.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line = null;
			while((line = reader.readLine()) != null)
			{
				addSong(line);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void addSong(String lineToParse)
	{
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}
}
