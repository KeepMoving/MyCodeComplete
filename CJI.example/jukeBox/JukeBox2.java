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

public class JukeBox2 
{
	ArrayList<String> songList2 = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		new JukeBox2().go();
	}
	
	public void go()
	{
		getSongs();
		System.out.println(songList2);
		Collections.sort(songList2);
		System.out.println(songList2);
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
		String[] token = lineToParse.split("/");
		songList2.add(token[0]);
	}
}

