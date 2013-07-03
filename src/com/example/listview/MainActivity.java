package com.example.listview;

import java.util.HashMap;
import java.util.Vector;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ListView list;
	ListAdapter listAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		
		//Bind List view to MainActivity
		list = (ListView) findViewById(R.id.listView);
		
		//Declare Vector variable and HashMap variable inside
		Vector<HashMap<String, String>> vData = new Vector<HashMap<String, String>>();
		
		//Simulate list data by for loop
		for(int i = 0; i < 500; i++){
			HashMap<String, String> hData = new HashMap<String, String>();
			String id = "ID "+ (i+1);
			String name = "Name user "+ (i+1);
			
			//Put data to HashMap key id and name
			hData.put("id", id);
			hData.put("name", name);
			
			//Add element to Vector
			vData.addElement(hData);
		}
		
		//Adapt Vector variables to be List
		listAdapter = new ListAdapter(vData);
		
		//Bind adapted data to List View
		list.setAdapter(listAdapter);
	}

	public class ListAdapter extends BaseAdapter{
		
		Vector<HashMap<String, String>> vData;
		
		ListAdapter(Vector<HashMap<String, String>> vData){
			this.vData = vData;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return vData.size();
		}

		@Override
		public Object getItem(int index) {
			// TODO Auto-generated method stub
			return vData.elementAt(index);
		}

		@Override
		public long getItemId(int index) {
			// TODO Auto-generated method stub
			return index;
		}

		@Override
		public View getView(int index, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			HashMap<String, String> hData = vData.elementAt(index);
			View v;
			
			//Just in case in the first time, there is null view (not loading yet)
			if( convertView == null ){
				v = getLayoutInflater().inflate(R.layout.embed_layout, parent, false);
			}else{
				v = convertView;
			}
			
			TextView txtID = (TextView) v.findViewById(R.id.txtID);
			TextView txtName = (TextView) v.findViewById(R.id.txtName);
			
			//Set text back to embed layout text view elements
			txtID.setText(hData.get("id"));
			txtName.setText(hData.get("name"));
			
			//Zebra effect
			if( index % 2 == 0 )
				v.setBackgroundColor(Color.GRAY);
			else
				v.setBackgroundColor(Color.WHITE);
				
			
			return v;
		}
		
	}
	

}
