package jukeBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class JukeBox8 
{
	ArrayList<Song> songList = new ArrayList<Song>();
	int val;
	
	public static void main(String[] args) 
	{
		new JukeBox8().go();
	}
	
	public void go()
	{
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		TreeSet<Song> songSet = new TreeSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
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
