package com.visitor.petsdetail;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.visitor.petsdetail.data.PetContract.PetEntry;

public class PetCursorAdapter extends CursorAdapter {
    /**
     * Recommended constructor.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c,0 /* flags */);
    }

    /**
     * Makes a new view to hold the data pointed to by cursor.
     *
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // inflate the list view
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    /**
     * Bind an existing view to the data pointed to by cursor
     *
     * @param view    Existing view, returned earlier by newView
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Finding the individual text view for reference
        TextView nameText = view.findViewById(R.id.name);
        TextView summaryText = view.findViewById(R.id.summary);

        // find the column index that pet that we are interested in
        int nameColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME);
        int breedColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED);

        // Getting the string at particular column index
        String currentName = cursor.getString(nameColumnIndex);
        String currentBreed = cursor.getString(breedColumnIndex);

        // Setting up the string to the textView.
        nameText.setText(currentName);
        summaryText.setText(currentBreed);



    }
}
