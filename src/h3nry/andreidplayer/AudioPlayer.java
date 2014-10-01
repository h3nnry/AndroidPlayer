package h3nry.andreidplayer;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	private MediaPlayer mPlayer;
	private int length;
	
	public void stop() {
		if(mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void play(Context c) {
		stop();
		
		mPlayer = MediaPlayer.create(c, R.raw.dorn);
		
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				stop();
				
			}
		});
		mPlayer.start();
	}
	
	public void pause(Context c) {
		if(mPlayer.isPlaying()) {
			mPlayer.pause();
			length = mPlayer.getCurrentPosition();
		}
		else {
			mPlayer.seekTo(length);
			mPlayer.start();
		}
	}
}
