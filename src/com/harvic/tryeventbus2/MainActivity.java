package com.harvic.tryeventbus2;

import com.harvic.other.FirstEvent;
import com.harvic.other.SecondEvent;
import com.harvic.other.ThirdEvent;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btn;
	TextView tv;
	EventBus eventBus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EventBus.getDefault().register(this);

		btn = (Button) findViewById(R.id.btn_try);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						SecondActivity.class);
				startActivity(intent);
			}
		});
	}

	public void onEventMainThread(FirstEvent event) {

		Log.d("harvic", "onEventMainThread�յ�����Ϣ��" + event.getMsg());
	}

	//SecondEvent���պ���һ
	public void onEventMainThread(SecondEvent event) {

		Log.d("harvic", "onEventMainThread�յ�����Ϣ��" + event.getMsg());
	}
	//SecondEvent���պ�����
	public void onEventBackgroundThread(SecondEvent event){
		Log.d("harvic", "onEventBackground�յ�����Ϣ��" + event.getMsg());
	}
	//SecondEvent���պ�����
	public void onEventAsync(SecondEvent event){
		Log.d("harvic", "onEventAsync�յ�����Ϣ��" + event.getMsg());
	}

	public void onEvent(ThirdEvent event) {
		Log.d("harvic", "OnEvent�յ�����Ϣ��" + event.getMsg());
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
}
