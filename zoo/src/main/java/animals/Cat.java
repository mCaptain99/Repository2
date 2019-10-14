package animals;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Path;

public class Cat extends Animal{

	@Override
	public void voice() {
		File f = new File("C:\\Users\\Maciej Kapitan\\Documents\\workspace\\zoo\\src\\main\\java\\cat.mp3");
		Media audio;
		System.out.println(f);
		try {
			audio = new Media(f.toURI().toURL().toString());
			System.out.println(audio);
			MediaPlayer mp = new MediaPlayer(audio);
			mp.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}