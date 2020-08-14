package o1310.rx1310.app.a2iga;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends Activity implements View.OnClickListener {
	
	EditText inputAssistantPackageName;
	Button applyChanges;
	SharedPreferences sharedPrefs;
	SharedPreferences.Editor sharedPrefsEditor;
	
	final String PREF_ASSISTANT_PACKAGE_NAME = "assistantPackageName";
	
	@Override
    protected void onCreate(Bundle sIS) {
        super.onCreate(sIS);
		
        setContentView(R.layout.activity_settings);
		
		sharedPrefs = getSharedPreferences("a2iga_settings", MODE_PRIVATE);
		
		inputAssistantPackageName = findViewById(R.id.inputAssistantPackageName);
		
		applyChanges = findViewById(R.id.applyChanges);
		applyChanges.setOnClickListener(this);
		
		loadAssistantPackageName();
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
			
			case R.id.applyChanges:
				saveAssistantPackageName();
				break;
				
			case R.id.runAssistantApp:
				runAssistantApp();
				break;
			
			default: break;
			
		}
		
	}
	
	private void saveAssistantPackageName() {
		
		sharedPrefsEditor = sharedPrefs.edit();
		sharedPrefsEditor.putString(PREF_ASSISTANT_PACKAGE_NAME, inputAssistantPackageName.getText().toString());
		sharedPrefsEditor.commit();
		
	}
	
	private void loadAssistantPackageName() {
		
		String assistantPackageName = sharedPrefs.getString(PREF_ASSISTANT_PACKAGE_NAME, "");
		
		inputAssistantPackageName.setText(assistantPackageName);
		
	}
	
	private void runAssistantApp() {
		
		//
		
	}

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        saveAssistantPackageName();
		Toast.makeText(this, "A2IGA: Changes saved!", Toast.LENGTH_LONG).show();
    }*/
	
}
