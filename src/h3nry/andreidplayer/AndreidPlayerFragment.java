package h3nry.andreidplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AndreidPlayerFragment extends Fragment{
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mStopButton;
	private Button mPauseButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_andreid_player, parent, false);
		
		mPlayButton = (Button)v.findViewById(R.id.andreidplayer_playButton);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());
				
			}
		});
		mStopButton = (Button)v.findViewById(R.id.andreidplayer_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.stop();
				
			}
		});
		mPauseButton = (Button)v.findViewById(R.id.andreidplayer_pauseButton);
		mPauseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.pause(getActivity());
				
			}
		});
		
		
		return v;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}
}

