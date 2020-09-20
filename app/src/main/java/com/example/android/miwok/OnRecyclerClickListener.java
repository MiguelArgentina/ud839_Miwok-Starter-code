package com.example.android.miwok;

public interface OnRecyclerClickListener {
    /**
     * Called when any item with in recyclerview or any item with in item
     * clicked
     *
     * @param position The position of the item
     * @param id       The id of the view which is clicked with in the item or
     *                 -1 if the item itself clicked
     */
    void onRecyclerViewItemClicked(int position, int id);
}
