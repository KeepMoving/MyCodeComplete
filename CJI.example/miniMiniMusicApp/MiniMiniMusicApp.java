package miniMiniMusicApp;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;

public class MiniMiniMusicApp 
{
	static //在加载类的时候指定jre中javax.sound.midi.Sequencer为com.sun.media.sound.RealTimeSequencerProvider
	{
		System.setProperty("javax.sound.midi.Sequencer","com.sun.media.sound.RealTimeSequencerProvider");		
	}
	public static void main(String[] args) 
	{
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	
	public void play()
	{
		try {
			Sequencer player = MidiSystem.getSequencer();
			MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
			for(MidiDevice.Info info : infos)
			{
				System.out.println(info);
				MidiDevice device = MidiSystem.getMidiDevice(info);
				System.out.println("device+" + device);
				System.out.println("is Sequencer?" + (device instanceof Sequencer));
				System.out.println("is Synthesizer?" + (device instanceof Synthesizer));
				System.out.println("info.name=" + info.getName());
				System.out.println("info.vendor=" + info.getVendor());
				System.out.println("info.description=" + info.getDescription());
				System.out.println("info.toString=" + info.toString());
				System.out.println("------------------------------------------------");
			}
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,44,100);
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteOff = new MidiEvent(b,16);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
		} catch (MidiUnavailableException mue) {
			// TODO Auto-generated catch block
			System.out.println("MidiUnavailableException:" + mue.getMessage());
			mue.printStackTrace();
		} catch (InvalidMidiDataException imde) {
			// TODO Auto-generated catch block
			System.out.println("InvalidMidiDataException:" + imde.getMessage());
			imde.printStackTrace();
		}
	}
}
