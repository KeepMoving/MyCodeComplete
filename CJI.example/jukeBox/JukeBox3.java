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

public class JukeBox3 
{
	ArrayList<Song> songList = new ArrayList<Song>();
	int count = 0;
	
	public static void main(String[] args) 
	{
		new JukeBox3().go();
	}
	
	public void go()
	{
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
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
				count++;
			}
			System.out.println("count = " + count);
		} catch (UnsupportedEncodingException uee) {
			// TODO Auto-generated catch block
			System.out.println("UnsupportedEncodingException:" + uee.getMessage());
		} catch (FileNotFoundException fnfe) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:" + fnfe.getMessage());
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + ioe.getMessage());
		}
	}
	
	void addSong(String lineToParse)
	{
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}
}

