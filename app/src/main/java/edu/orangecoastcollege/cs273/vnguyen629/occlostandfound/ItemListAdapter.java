package edu.orangecoastcollege.cs273.vnguyen629.occlostandfound;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to provide a custom adapter for the lost <code>Item</code> list.
 *
 * @author Vincent Nguyen
 */
public class ItemListAdapter extends ArrayAdapter<Item> {
    private int mResourceId;
    private Context mContext;
    private List<Item> mLostItemsList = new ArrayList<>();

    private LinearLayout itemListLinearLayout;
    private TextView itemListNameTextView;
    private TextView itemListDescriptionTextView;
    private TextView itemListDateLostTextView;
    private TextView itemListLastLocationTextView;
    private TextView itemListStatusTextView;
    private ImageView itemListImageView;

    /**
     * Creates a new <code>ItemListAdapter</code> given a mContext, resource id
     * and list of lost items.
     *
     * @param c The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param lostItems The list of items to display
     */
    public ItemListAdapter(Context c, int rId, List<Item> lostItems) {
        super(c, rId, lostItems);
        this.mContext = c;
        this.mResourceId = rId;
        this.mLostItemsList = lostItems;
    }

    /**
     * Gets the view associated with the layout.
     * @param pos The position of the <code>Item</code> selected in the list.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater =
                (LayoutInflater) this.mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(this.mResourceId, null);

        /*
        itemListLinearLayout = (LinearLayout) view.findViewById(R.id.itemListLinearLayout);
        itemListNameTextView = (TextView) view.findViewById(R.id.itemListNameTextView);
        itemListDescriptionTextView = (TextView) view.findViewById(R.id.itemListDescriptionTextView);
        itemListDateLostTextView = (TextView) view.findViewById(R.id.itemListDateLostTextView);
        itemListLastLocationTextView = (TextView) view.findViewById(R.id.itemListLastLocationTextView);
        itemListStatusTextView = (TextView) view.findViewById(R.id.itemListStatusTextView);
        itemListImageView = (ImageView) view.findViewById(R.id.itemListImageView);
*/
        final Item item = this.mLostItemsList.get(pos);
        itemListLinearLayout.setTag(item);

        String name = item.getName();
        String description = item.getDescription();
        String dateLost = item.getDateLost();
        String lastKnownLocation = item.getLastLocation();
        String status = ((item.getStatus())? "Found" : "Missing");
        Uri imageURI = item.getImageUri();
/*
        itemListNameTextView.setText(name);
        itemListDescriptionTextView.setText(description);
        itemListDateLostTextView.setText(dateLost);
        itemListLastLocationTextView.setText(lastKnownLocation);
        itemListStatusTextView.setText(status);
        itemListImageView.setImageURI(imageURI);
*/
        return view;
    }
}