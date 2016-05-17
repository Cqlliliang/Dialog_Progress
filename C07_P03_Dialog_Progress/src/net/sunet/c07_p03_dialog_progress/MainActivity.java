package net.sunet.c07_p03_dialog_progress;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final int	MAX_PROGRESS	= 100;
	private Button				ringBtn			= null;
	private Button				horizonBtn		= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);

		this.ringBtn = (Button) super.findViewById(R.id.ringBtn);
		this.horizonBtn = (Button) super.findViewById(R.id.horizonBtn);

		this.ringBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.this.showRingProgress();
			}
		});

		this.horizonBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.this.showHorizonProgress();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void showRingProgress() {
		final ProgressDialog dlg = ProgressDialog.show(MainActivity.this,
				"搜素网络", "请耐心等待...");

		new Thread() {
			public void run() {
				try {
					Thread.sleep(4000);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					dlg.dismiss();
				}
			}
		}.start();
		dlg.show();
	}

	@SuppressWarnings("deprecation")
	private void showHorizonProgress() {
		final ProgressDialog dlg = new ProgressDialog(MainActivity.this);
		dlg.setTitle("搜素网路");
		dlg.setMessage("请耐心等待...");
		dlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dlg.setMax(MainActivity.this.MAX_PROGRESS);
		dlg.setProgress(0);
		dlg.setButton("后台处理", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dlg.dismiss();
			}
		});
		dlg.setButton2("详细信息", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		new Thread() {
			public void run() {
				for (int i = 0; i < MainActivity.this.MAX_PROGRESS; ++i) {
					try {
						Thread.sleep(200);
					}
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {

					}
					dlg.incrementProgressBy(1);
				}
				dlg.dismiss();
			}
		}.start();
		dlg.show();
	}
}
