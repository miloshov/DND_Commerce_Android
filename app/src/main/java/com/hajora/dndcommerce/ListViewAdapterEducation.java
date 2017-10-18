package com.hajora.dndcommerce;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapterEducation extends BaseAdapter {

    // Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public ListViewAdapterEducation(Context context,
                                    ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);

	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables
		TextView name;
		TextView date;
		TextView description;
		ImageView image;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflater.inflate(R.layout.listview_item, parent, false);
		// Get the position
		resultp = data.get(position);

		// Locate the TextViews in listview_item.xml
		name = (TextView) itemView.findViewById(R.id.name);
		/*date = (TextView) itemView.findViewById(R.id.date);*/
		description = (TextView) itemView.findViewById(R.id.description);
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/poppins.ttf");
        name.setTypeface(font);
        description.setTypeface(font);
		// Locate the ImageView in listview_item.xml
		image = (ImageView) itemView.findViewById(R.id.image);

		// Capture position and set results to the TextViews
		name.setText(resultp.get(Education.NAME));
		/*date.setText(resultp.get(Education.DATE));*/
		description.setText(resultp.get(Education.DESCRIPTION));
		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(resultp.get(Education.IMAGE), image);
		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);
				Intent intent = new Intent(context, SingleItemViewEducation.class);
				// Pass all data rank
				intent.putExtra("name", resultp.get(Education.NAME));
				// Pass all data country
				intent.putExtra("date", resultp.get(Education.DATE));
				// Pass all data population
				intent.putExtra("description",resultp.get(Education.DESCRIPTION));
				// Pass all data flag
				intent.putExtra("image", resultp.get(Education.IMAGE));
				// Pass all data flag
				intent.putExtra("address", resultp.get(Education.ADDRESS));
                // Pass all data flag
                intent.putExtra("city", resultp.get(Education.CITY));
				// Pass all data flag
				intent.putExtra("lat", resultp.get(Education.LAT));
				// Pass all data flag
				intent.putExtra("lon", resultp.get(Education.LON));
				// Start SingleItemView Class
				context.startActivity(intent);

			}
		});


		return itemView;
	}
}
